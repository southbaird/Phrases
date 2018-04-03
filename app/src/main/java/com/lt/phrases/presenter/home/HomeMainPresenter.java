package com.lt.phrases.presenter.home;

import android.support.annotation.NonNull;

import com.lt.phrases.contract.home.HomeMainContract;
import com.lt.phrases.model.home.HomeMainModel;

/**
 * Created by nq on 2018/1/27.
 * email : 1172921726@qq.com
 */

public class HomeMainPresenter extends HomeMainContract.HomeMainPresenter{

    @NonNull
    public static HomeMainPresenter newInstance() {
        return new HomeMainPresenter();
    }

    @Override
    public void getTabList() {
        if (mIView == null || mIModel == null)
            return;

        mIView.showTabList(mIModel.getTabs());
    }

    @Override
    public HomeMainContract.IHomeMainModel getModel() {
        return HomeMainModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
