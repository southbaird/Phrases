package com.lt.phrases.presenter.detail;

import android.support.annotation.NonNull;

import com.lt.phrases.contract.detail.WangyiDetailContract;
import com.lt.phrases.helper.JsonHelper;
import com.lt.phrases.model.bean.wangyi.WangyiNewsDetailBean;
import com.lt.phrases.model.detail.WangyiDetailModel;

import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;

/**
 * Created by nq on 2018/3/17.
 * email : 1172921726@qq.com
 */

public class WangyiDetailPresenter extends WangyiDetailContract.WangyiDetailPresenter {
    @NonNull
    public static WangyiDetailPresenter newInstance() {
        return new WangyiDetailPresenter();
    }

    @Override
    public void loadNewsDetailWithUrl(String url) {
        if (mIView == null)
            return;

        try {
            mIView.showNewsDetail(url);
        } catch (Exception e) {
            mIView.showNetworkError();
            e.printStackTrace();
        }
    }

    @Override
    public void loadNewsDetailWithId(final String id) {
        mRxManager.register(mIModel.getNewsDetail(id).subscribe(new Consumer<ResponseBody>() {
            @Override
            public void accept(ResponseBody responseBody) throws Exception {
                if (mIView == null)
                    return;
                //新闻的Json数据比较特殊，返回的json key不固定，需要手动的获取json数据，然后再用gson解析
                WangyiNewsDetailBean bean = JsonHelper.getNewsDetailBeans(responseBody.string(),
                        id);
                mIView.showNewsDetail(bean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (mIView == null)
                    return;
                mIView.showNetworkError();
            }
        }));
    }

    @Override
    public WangyiDetailContract.IWangyiDetailModel getModel() {
        return WangyiDetailModel.newInstance();
    }

    @Override
    public void onStart() {
    }
}