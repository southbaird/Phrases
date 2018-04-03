package com.lt.phrases.contract.gankio.tabs;

import com.lt.phrases.contract.home.tabs.BaseTabsContract;
import com.lt.phrases.model.bean.gankio.GankIoWelfareItemBean;
import com.lt.phrases.model.bean.gankio.GankIoWelfareListBean;

import io.reactivex.Observable;

/**
 * Created by nq on 2018/3/10.
 * email : 1172921726@qq.com
 */

public interface GankIoWelfareContract {
    abstract class GankIoWelfarePresenter extends BaseTabsContract
            .BaseTabsPresenter<IGankIoWelfareModel, IGankIoWelfareView, GankIoWelfareItemBean> {

    }

    interface IGankIoWelfareModel extends BaseTabsContract.IBaseTabsModel {
        /**
         * 获取福利list
         *
         * @param pre_page 每页条数
         * @param page     当前页
         * @return Observable
         */
        Observable<GankIoWelfareListBean> getWelfareList(int pre_page, int page);
    }

    interface IGankIoWelfareView extends BaseTabsContract.IBaseTabsView<GankIoWelfareItemBean> {
    }
}
