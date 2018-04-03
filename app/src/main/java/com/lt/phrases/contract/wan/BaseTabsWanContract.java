package com.lt.phrases.contract.wan;

import com.lt.library.base.BasePresenter;
import com.lt.library.base.IBaseFragment;
import com.lt.library.base.IBaseModel;
import com.lt.phrases.model.bean.wan.WanBannerBean;
import com.lt.phrases.model.bean.wan.WanItemBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by nq on 2018/3/30.
 * email : 1172921726@qq.com
 */

public interface BaseTabsWanContract {

    abstract class BaseTabsPresenter<M extends BaseTabsWanContract.IBaseTabsModel, V extends BaseTabsWanContract.IBaseTabsView, T>
            extends BasePresenter<M, V> {
        /**
         * 加载最新的list
         */
        public abstract void loadLatestList();

        /**
         * 加载更多list
         */
        public abstract void loadMoreList();

        /**
         * item点击事件
         *
         * @param position position
         * @param item     item
         */
        public abstract void onItemClick(int position, WanItemBean.DatasBean item);

        /**
         * banner点击事件
         *
         * @param item item
         */
        public abstract void onBannerItemClick(WanBannerBean.WanBItemBean item);

        /**
         * 加载更多Banner
         */
        public abstract void loadWanBanner();
    }

    interface IBaseTabsModel extends IBaseModel {
        /**
         * 记录item已阅到数据库
         *
         * @param key key(item.id值作为key)
         */
        Observable<Boolean> recordItemIsRead(String key);
    }

    interface IBaseTabsView extends IBaseFragment {
        /**
         * 更新界面list
         *
         * @param list list
         */
        void updateContentList(WanItemBean list);

        /**
         * 点击事件后，刷新item
         *
         * @param position position
         */
        void itemNotifyChanged(int position);

        /**
         * 显示网络错误
         */
        void showNetworkError();

        /**
         * 显示加载更多错误
         */
        void showLoadMoreError();

        /**
         * 显示没有更多数据
         */
        void showNoMoreData();

        /**
         * 显示Banner
         */
        void showWanBanner(List<WanBannerBean.WanBItemBean> list);
    }
}
