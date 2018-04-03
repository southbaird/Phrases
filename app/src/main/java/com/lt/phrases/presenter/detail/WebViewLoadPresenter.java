package com.lt.phrases.presenter.detail;

import android.support.annotation.NonNull;

import com.lt.phrases.contract.detail.WebViewLoadConaract;
import com.lt.phrases.model.detail.WebViewLoadModel;

/**
 * Created by nq on 2018/4/3.
 * email : 1172921726@qq.com
 */

public class WebViewLoadPresenter extends WebViewLoadConaract.WebViewLoadPresenter {

    @NonNull
    public static WebViewLoadPresenter newInstance() {
        return new WebViewLoadPresenter();
    }

    @Override
    public void loadUrl(String url) {
        if (mIView == null)
            return;

        try {
            mIView.showUrlDetail(url);
        } catch (Exception e) {
            mIView.showNetworkError();
            e.printStackTrace();
        }
    }

    @Override
    public WebViewLoadConaract.IWebViewLoadModel getModel() {
        return WebViewLoadModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
