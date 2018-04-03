package com.lt.phrases.contract.detail;

import com.lt.phrases.presenter.detail.BaseWebViewLoadPresenter;

/**
 * Created by nq on 2018/3/10.
 * email : 1172921726@qq.com
 */

public interface GankIoDetailContract {
    abstract class GankIoDetailPresenter extends BaseWebViewLoadPresenter<IGankIoDetailModel,
                IGankIoDetailView> {
        /**
         * 加载GankIo详情
         *
         * @param url url
         */
        public abstract void loadGankIoDetail(String url);
    }

    interface IGankIoDetailModel extends BaseWebViewLoadContract.IBaseWebViewLoadModel {
    }

    interface IGankIoDetailView extends BaseWebViewLoadContract.IBaseWebViewLoadView {
        /**
         * 显示GankIo详细内容
         *
         * @param url url
         */
        void showGankIoDetail(String url);
    }
}
