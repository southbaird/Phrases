package com.lt.phrases.presenter.detail;

import android.support.annotation.NonNull;


import com.lt.phrases.contract.detail.WeixinDetailContract;
import com.lt.phrases.model.detail.WeixinDetailModel;

/**
 * Created by nq on 2018/3/17.
 * email : 1172921726@qq.com
 */

public class WeixinDetailPresenter extends WeixinDetailContract.WeixinDetailPresenter{

    @NonNull
    public static WeixinDetailPresenter newInstance() {
        return new WeixinDetailPresenter();
    }

    @Override
    public void loadWeixinChoiceDetail(String url) {
        if (mIView == null)
            return;

        try {
            mIView.showWeixinChoiceDetail(url);
        } catch (Exception e) {
            mIView.showNetworkError();
            e.printStackTrace();
        }
    }

    @Override
    public WeixinDetailContract.IWeixinDetailModel getModel() {
        return WeixinDetailModel.newInstance();
    }

    @Override
    public void onStart() {
    }
}
