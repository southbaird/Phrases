package com.lt.phrases.contract.home.tabs;

import com.lt.phrases.model.bean.zhihu.ZhihuDailyItemBean;
import com.lt.phrases.model.bean.zhihu.ZhihuDailyListBean;

import io.reactivex.Observable;

/**
 * Created by nq on 2018/2/10.
 * email : 1172921726@qq.com
 */

public interface ZhihuContract {

    abstract class ZhihuPresenter extends BaseTabsContract.BaseTabsPresenter<IZhihuModel,
            IZhihuView, ZhihuDailyItemBean> {

    }

    interface IZhihuModel extends BaseTabsContract.IBaseTabsModel {

        /**
         * 根据日期获取日报list --> 20180323
         *
         * @param date 日期
         * @return Observable
         */
        Observable<ZhihuDailyListBean> getDailyList(String date);

        /**
         * 获取日报list
         *
         * @return Observable
         */
        Observable<ZhihuDailyListBean> getDailyList();
    }

    interface IZhihuView extends BaseTabsContract.IBaseTabsView<ZhihuDailyItemBean> {

    }
}
