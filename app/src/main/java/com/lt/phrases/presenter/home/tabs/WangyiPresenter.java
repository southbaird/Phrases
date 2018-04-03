package com.lt.phrases.presenter.home.tabs;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.lt.library.utils.StringUtils;
import com.lt.phrases.constant.BundleKeyConstant;
import com.lt.phrases.contract.home.tabs.WangyiContract;
import com.lt.phrases.model.bean.wangyi.WangyiNewsItemBean;
import com.lt.phrases.model.bean.wangyi.WangyiNewsListBean;
import com.lt.phrases.model.home.tabs.WangyiModel;
import com.lt.phrases.ui.activity.detail.WangyiDailyDetailActivity;
import com.orhanobut.logger.Logger;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by nq on 2018/3/17.
 * email : 1172921726@qq.com
 */

public class WangyiPresenter extends WangyiContract.WangyiPresenter {

    private int mCurrentIndex;
    private boolean isLoading;

    @NonNull
    public static WangyiPresenter newInstance() {
        return new WangyiPresenter();
    }

    @Override
    public WangyiContract.IWangyiModel getModel() {
        return WangyiModel.newInstance();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void loadLatestList() {
        mCurrentIndex = 0;
        mRxManager.register(mIModel.getNewsList(mCurrentIndex).subscribe(new Consumer<WangyiNewsListBean>() {
            @Override
            public void accept(WangyiNewsListBean wangyiNewsListBean) throws Exception {
                if (mIView != null) {
                    List<WangyiNewsItemBean> list = wangyiNewsListBean.getNewsList();
                    for (int i = 0; i < list.size(); i++) {
                        // 过滤掉无效的新闻
                        if (StringUtils.isEmpty(list.get(i).getUrl()))
                            list.remove(i);
                    }
                    mCurrentIndex += 20;
                    mIView.updateContentList(list);
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (mIView != null) {
                    if (mIView.isVisiable())
                        mIView.showToast("Network error.");
                    mIView.showNetworkError();
                }
            }
        }));
    }

    @Override
    public void loadMoreList() {
        if (!isLoading) {
            isLoading = true;
            mRxManager.register(mIModel.getNewsList(mCurrentIndex).subscribe(new Consumer<WangyiNewsListBean>() {
                @Override
                public void accept(WangyiNewsListBean wangyiNewsListBean) throws Exception {
                    isLoading = false;
                    if (mIView == null)
                        return;
                    if (wangyiNewsListBean.getNewsList().size() > 0) {
                        mCurrentIndex += 20;
                        mIView.updateContentList(wangyiNewsListBean.getNewsList());
                    } else {
                        mIView.showNoMoreData();
                    }
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {
                    isLoading = false;
                    if (mIView == null)
                        return;
                    mIView.showNetworkError();
                }
            }));
        }
    }

    @Override
    public void onItemClick(final int position, WangyiNewsItemBean item) {
        mRxManager.register(mIModel.recordItemIsRead(item.getDocid()).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if (mIView == null)
                    return;

                if (aBoolean) {
                    mIView.itemNotifyChanged(position);
                } else {
                    Logger.e("写入点击状态值失败");
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        }));

        if (mIView == null)
            return;

        Bundle bundle = new Bundle();
        bundle.putString(BundleKeyConstant.ARG_KEY_WANGYI_DETAIL_ID, item.getDocid());
        bundle.putString(BundleKeyConstant.ARG_KEY_WANGYI_DETAIL_URL, item.getUrl());
        bundle.putString(BundleKeyConstant.ARG_KEY_WANGYI_DETAIL_TITLE, item.getTitle());
        bundle.putString(BundleKeyConstant.ARG_KEY_WANGYI_DETAIL_IMAGE_URL, item.getImgsrc());
        bundle.putString(BundleKeyConstant.ARG_KEY_WANGYI_DETAIL_COPYRIGHT, item.getSource());
        mIView.startNewActivity(WangyiDailyDetailActivity.class, bundle);
    }
}
