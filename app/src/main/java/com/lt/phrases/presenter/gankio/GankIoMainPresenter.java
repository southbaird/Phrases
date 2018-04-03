package com.lt.phrases.presenter.gankio;

import android.support.annotation.NonNull;

import com.lt.phrases.contract.gankio.GankIoMainContract;
import com.lt.phrases.model.gankio.GankIoMainModel;


/**
 * Created by nq on 2018/3/17.
 * email : 1172921726@qq.com
 */

public class GankIoMainPresenter extends GankIoMainContract.GankIoMainPresenter{

    @NonNull
    public static GankIoMainPresenter newInstance() {
        return new GankIoMainPresenter();
    }

    @Override
    public void getTabList() {
        if (mIView == null || mIModel == null)
            return;

        mIView.showTabList(mIModel.getTabs());
    }

    @Override
    public GankIoMainContract.IGankIoMainModel getModel() {
        return GankIoMainModel.newInstance();
    }

    @Override
    public void onStart() {
        //getTabList();
    }
}
