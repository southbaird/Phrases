package com.lt.phrases.contract.detail;

import com.lt.phrases.presenter.detail.BaseWebViewLoadPresenter;


/**
 * Created by nq on 2018/3/10.
 * email : 1172921726@qq.com
 * 微信精选详情页接口
 */

public interface WeixinDetailContract {

    abstract class WeixinDetailPresenter extends BaseWebViewLoadPresenter<IWeixinDetailModel,
                IWeixinDetailView> {
        /**
         * 加载微信精选详情
         *
         * @param url url
         */
        public abstract void loadWeixinChoiceDetail(String url);
    }

    interface IWeixinDetailModel extends BaseWebViewLoadContract.IBaseWebViewLoadModel {
    }

    interface IWeixinDetailView extends BaseWebViewLoadContract.IBaseWebViewLoadView {
        /**
         * 显示微信精选详细内容
         *
         * @param url url
         */
        void showWeixinChoiceDetail(String url);
    }
}
