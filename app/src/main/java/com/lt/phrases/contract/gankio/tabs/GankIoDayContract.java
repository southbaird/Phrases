package com.lt.phrases.contract.gankio.tabs;

import com.lt.phrases.contract.home.tabs.BaseTabsContract;
import com.lt.phrases.model.bean.gankio.GankIoDayItemBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by nq on 2018/3/10.
 * email : 1172921726@qq.com
 */

public interface GankIoDayContract {
    abstract class GankIoDayPresenter extends BaseTabsContract.BaseTabsPresenter<IGankIoDayModel,
            IGankIoDayView, GankIoDayItemBean> {
        /**
         * “更多”按钮点击事件
         *
         * @param position position
         * @param item     item
         */
        public abstract void onMoreClick(int position, GankIoDayItemBean item);

        /**
         * “刷新”按钮点击事件
         *
         * @param position position
         * @param item     item
         */
        public abstract void onRefeshClick(int position, GankIoDayItemBean item);
    }

    interface IGankIoDayModel extends BaseTabsContract.IBaseTabsModel {
        /**
         * 请求GankIo每日数据list
         *
         * @param year  年
         * @param month 月
         * @param day   日
         * @return Observable
         */
        Observable<List<GankIoDayItemBean>> getGankIoDayList(String year, String month, String day);

        /**
         * 获取指定page Android数据
         *
         * @param page page
         * @return Android item数据
         */
        GankIoDayItemBean getGankIoDayAndroid(int page);

        /**
         * 获取指定page IOS数据
         *
         * @param page page
         * @return IOS item数据
         */
        GankIoDayItemBean getGankIoDayIOS(int page);
    }

    interface IGankIoDayView extends BaseTabsContract.IBaseTabsView<GankIoDayItemBean> {
        /**
         * 点击事件后，刷新item
         *
         * @param bean     GankIoDayItemBean
         * @param position position
         */
        void itemNotifyChanged(int position, GankIoDayItemBean bean);
    }

}
