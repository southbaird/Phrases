package com.lt.phrases.contract.wan;

import com.lt.phrases.model.bean.wan.WanBannerBean;
import com.lt.phrases.model.bean.wan.WanItemBean;
import com.lt.phrases.model.bean.wan.WanListBean;

import io.reactivex.Observable;

/**
 * Created by nq on 2018/3/30.
 * email : 1172921726@qq.com
 */

public interface WanContract {

    abstract class WanPresenter extends BaseTabsWanContract.BaseTabsPresenter<IWanModel,
            IWanView, WanItemBean> {

    }

    interface IWanModel extends BaseTabsWanContract.IBaseTabsModel {
        /**
         * 获取wanandroid list
         *
         * @param page page
         * @return Observable
         */
        Observable<WanListBean> getWanList(int page);

        /**
         * 获取wanandroid banner
         *
         * @return Observable
         */
        Observable<WanBannerBean> getWanBanner();
    }

    interface IWanView extends BaseTabsWanContract.IBaseTabsView {

    }
}
