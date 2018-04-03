package com.lt.phrases.contract.detail;

import com.lt.phrases.presenter.detail.BaseWebViewLoadPresenter;

/**
 * Created by nq on 2018/4/3.
 */

public interface WebViewLoadConaract {

    abstract class WebViewLoadPresenter extends BaseWebViewLoadPresenter<IWebViewLoadModel,
            IWebViewLoadView> {
        /**
         * 加载url
         *
         * @param url url
         */
        public abstract void loadUrl(String url);
    }

    interface IWebViewLoadModel extends BaseWebViewLoadContract.IBaseWebViewLoadModel {

    }

    interface IWebViewLoadView extends BaseWebViewLoadContract.IBaseWebViewLoadView {
        /**
         * 显示url详情
         *
         * @param url url
         */
        void showUrlDetail(String url);
    }
}
