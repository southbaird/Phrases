package com.lt.phrases.contract.home.tabs;

import com.lt.phrases.model.bean.wangyi.WangyiNewsItemBean;
import com.lt.phrases.model.bean.wangyi.WangyiNewsListBean;

import io.reactivex.Observable;

/**
 * Created by nq on 2018/3/10.
 * email : 1172921726@qq.com
 */

public interface WangyiContract {

    abstract class WangyiPresenter extends BaseTabsContract.BaseTabsPresenter<IWangyiModel,
            IWangyiView, WangyiNewsItemBean> {

    }

    interface IWangyiModel extends BaseTabsContract.IBaseTabsModel {
        /**
         * 获取网易新闻list
         *
         * @param id id
         * @return Observable
         */
        Observable<WangyiNewsListBean> getNewsList(int id);
    }

    interface IWangyiView extends BaseTabsContract.IBaseTabsView<WangyiNewsItemBean> {

    }
}
