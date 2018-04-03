package com.lt.phrases.model.gankio.tabs;

import android.support.annotation.NonNull;

import com.lt.library.base.BaseModel;
import com.lt.library.helper.RetrofitCreateHelper;
import com.lt.library.helper.RxHelper;
import com.lt.phrases.api.GankioApi;
import com.lt.phrases.contract.gankio.tabs.GankIoWelfareContract;
import com.lt.phrases.model.bean.gankio.GankIoWelfareListBean;

import io.reactivex.Observable;

/**
 * Created by nq on 2018/3/17.
 * email : 1172921726@qq.com
 */

public class GankIoWelfareModel extends BaseModel implements GankIoWelfareContract
        .IGankIoWelfareModel {

    @NonNull
    public static GankIoWelfareModel newInstance() {
        return new GankIoWelfareModel();
    }

    @Override
    public Observable<GankIoWelfareListBean> getWelfareList(int pre_page, int page) {
        return RetrofitCreateHelper.createApi(GankioApi.class, GankioApi.HOST)
                .getGankIoWelfareList(pre_page, page).compose(RxHelper
                        .<GankIoWelfareListBean>rxSchedulerHelper());
    }

    @Override
    public Observable<Boolean> recordItemIsRead(String key) {
        //不记录
        return null;
    }
}
