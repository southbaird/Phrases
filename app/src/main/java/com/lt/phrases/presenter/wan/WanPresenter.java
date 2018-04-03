package com.lt.phrases.presenter.wan;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.lt.phrases.constant.BundleKeyConstant;
import com.lt.phrases.contract.wan.WanContract;
import com.lt.phrases.model.bean.wan.WanBannerBean;
import com.lt.phrases.model.bean.wan.WanItemBean;
import com.lt.phrases.model.bean.wan.WanListBean;
import com.lt.phrases.model.wan.WanModel;
import com.lt.phrases.ui.activity.detail.WanDailyDetailActivity;
import com.lt.phrases.ui.activity.detail.WebViewLoadActivity;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import io.reactivex.functions.Consumer;

/**
 * Created by nq on 2018/3/30.
 * email : 1172921726@qq.com
 */

public class WanPresenter extends WanContract.WanPresenter {

    private int mCurrentIndex;
    private boolean isLoading;

    @NonNull
    public static WanPresenter newInstance() {
        return new WanPresenter();
    }

    @NonNull
    public WanContract.IWanModel getModel() {
        return WanModel.newInstance();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void loadLatestList() {
        mCurrentIndex = 0;
        mRxManager.register(mIModel.getWanList(mCurrentIndex).subscribe(new Consumer<WanListBean>() {
            @Override
            public void accept(WanListBean wanListBean) throws Exception {
                if (mIView != null) {
                    WanItemBean list = wanListBean.getData();
//                    Logger.e(String.valueOf(list));
                    mCurrentIndex += 1;
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
            mRxManager.register(mIModel.getWanList(mCurrentIndex).subscribe(new Consumer<WanListBean>() {
                @Override
                public void accept(WanListBean wanListBean) throws Exception {
                    isLoading = false;
                    if (mIView != null) {
                        WanItemBean list = wanListBean.getData();
//                        Logger.e(String.valueOf(list));
                        if (list.getDatas().size() > 0) {
                            Logger.e(String.valueOf(mCurrentIndex));
                            mCurrentIndex += 1;
                            mIView.updateContentList(list);
                        } else {
                            mIView.showNoMoreData();
                        }
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
    }

    @Override
    public void loadWanBanner() {
        mRxManager.register(mIModel.getWanBanner().subscribe(new Consumer<WanBannerBean>() {
            @Override
            public void accept(WanBannerBean wanBannerBean) throws Exception {
                if (mIView != null) {
                    ArrayList<WanBannerBean.WanBItemBean> list = wanBannerBean.getmData();
//                    Logger.e(String.valueOf(list));
                    mIView.showWanBanner(list);
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
    public void onItemClick(final int position, WanItemBean.DatasBean item) {
        mRxManager.register(mIModel.recordItemIsRead(item.getId()).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if (mIView == null)
                    return;

                if (aBoolean) {
                    mIView.itemNotifyChanged(position + 1);
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
        bundle.putString(BundleKeyConstant.ARG_KEY_WEB_VIEW_LOAD_URL, item.getLink());
        bundle.putString(BundleKeyConstant.ARG_KEY_WEB_VIEW_LOAD_TITLE, item.getTitle());
        mIView.startNewActivity(WebViewLoadActivity.class, bundle);

    }

    @Override
    public void onBannerItemClick(WanBannerBean.WanBItemBean item) {
        Bundle bundle = new Bundle();
        bundle.putString(BundleKeyConstant.ARG_KEY_WAN_DETAIL_URL, item.getmUrl());
        bundle.putString(BundleKeyConstant.ARG_KEY_WAN_DETAIL_IMAGE_URL, item.getmImagePath());
        bundle.putString(BundleKeyConstant.ARG_KEY_WAN_DETAIL_TITLE, item.getmTitle());
        mIView.startNewActivity(WanDailyDetailActivity.class, bundle);
    }
}
