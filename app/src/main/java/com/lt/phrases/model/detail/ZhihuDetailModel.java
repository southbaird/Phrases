package com.lt.phrases.model.detail;

import android.support.annotation.NonNull;

import com.lt.library.base.BaseModel;
import com.lt.library.helper.RetrofitCreateHelper;
import com.lt.library.helper.RxHelper;
import com.lt.phrases.api.ZhihuApi;
import com.lt.phrases.contract.detail.ZhihuDetailContract;
import com.lt.phrases.model.bean.zhihu.ZhihuDailyDetailBean;

import io.reactivex.Observable;

/**
 * Created by nq on 2018/2/10.
 * email : 1172921726@qq.com
 */

public class ZhihuDetailModel extends BaseModel implements ZhihuDetailContract.IZhihuDetailModel {

    @NonNull
    public static ZhihuDetailModel newInstance() {
        return new ZhihuDetailModel();
    }

    @Override
    public Observable<ZhihuDailyDetailBean> getDailyDetail(String id) {
        return RetrofitCreateHelper.createApi(ZhihuApi.class, ZhihuApi.HOST).getZhihuDailyDetail
                (id).compose(RxHelper.<ZhihuDailyDetailBean>rxSchedulerHelper());
    }
}
