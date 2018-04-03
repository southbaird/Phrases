package com.lt.phrases.presenter.detail;

import android.support.annotation.NonNull;

import com.lt.phrases.contract.detail.WanDetailContract;
import com.lt.phrases.model.detail.WanDetailModel;

/**
 * Created by nq on 2018/3/31.
 * email : 1172921726@qq.com
 */

public class WanDetailPresenter extends WanDetailContract.WanDetailPresenter {
    @NonNull
    public static WanDetailPresenter newInstance() {
        return new WanDetailPresenter();
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
    public WanDetailContract.IWanDetailModel getModel() {
        return WanDetailModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
