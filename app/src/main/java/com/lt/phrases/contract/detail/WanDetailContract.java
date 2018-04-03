package com.lt.phrases.contract.detail;

import com.lt.phrases.presenter.detail.BaseWebViewLoadPresenter;

/**
 * Created by nq on 2018/3/31.
 * email : 1172921726@qq.com
 */

public interface WanDetailContract {

    abstract class WanDetailPresenter extends BaseWebViewLoadPresenter<IWanDetailModel, IWanDetailView> {
        /**
         * 加载新闻详情
         *
         * @param url url
         */
        public abstract void loadNewsDetailWithUrl(String url);
    }

    interface IWanDetailModel extends BaseWebViewLoadContract.IBaseWebViewLoadModel {

    }

    interface IWanDetailView extends BaseWebViewLoadContract.IBaseWebViewLoadView {
        /**
         * 显示新闻详细内容
         *
         * @param url url
         */
        void showNewsDetail(String url);
    }
}
