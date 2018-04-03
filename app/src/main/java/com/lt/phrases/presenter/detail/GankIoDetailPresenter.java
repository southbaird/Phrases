package com.lt.phrases.presenter.detail;

import android.support.annotation.NonNull;

import com.lt.phrases.contract.detail.GankIoDetailContract;
import com.lt.phrases.model.detail.GankIoDetailModel;

/**
 * Created by nq on 2018/3/17.
 * email : 1172921726@qq.com
 */

public class GankIoDetailPresenter extends GankIoDetailContract.GankIoDetailPresenter{
    @NonNull
    public static GankIoDetailPresenter newInstance() {
        return new GankIoDetailPresenter();
    }

    @Override
    public void loadGankIoDetail(String url) {
        if (mIView == null)
            return;

        try {
            mIView.showGankIoDetail(url);
        } catch (Exception e) {
            mIView.showNetworkError();
            e.printStackTrace();
        }
    }

    @Override
    public GankIoDetailContract.IGankIoDetailModel getModel() {
        return GankIoDetailModel.newInstance();
    }

    @Override
    public void onStart() {
    }
}
