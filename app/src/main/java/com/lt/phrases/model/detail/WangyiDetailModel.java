package com.lt.phrases.model.detail;

import android.support.annotation.NonNull;

import com.lt.library.base.BaseModel;
import com.lt.library.helper.RetrofitCreateHelper;
import com.lt.library.helper.RxHelper;
import com.lt.phrases.api.WangyiApi;
import com.lt.phrases.contract.detail.WangyiDetailContract;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by nq on 2018/3/10.
 * email : 1172921726@qq.com
 */

public class WangyiDetailModel extends BaseModel implements WangyiDetailContract
        .IWangyiDetailModel {

    @NonNull
    public static WangyiDetailModel newInstance() {
        return new WangyiDetailModel();
    }

    @Override
    public Observable<ResponseBody> getNewsDetail(String id) {
        return RetrofitCreateHelper.createApi(WangyiApi.class, WangyiApi.HOST).getNewsDetail(id)
                .compose(RxHelper.<ResponseBody>rxSchedulerHelper());
    }
}