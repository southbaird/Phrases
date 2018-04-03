package com.lt.phrases.model.wan;

import android.support.annotation.NonNull;

import com.lt.library.config.DBConfig;
import com.lt.library.config.ItemState;
import com.lt.library.helper.RetrofitCreateHelper;
import com.lt.library.helper.RxHelper;
import com.lt.library.utils.AppUtils;
import com.lt.library.utils.DBUtils;
import com.lt.phrases.api.WanApi;
import com.lt.phrases.contract.wan.WanContract;
import com.lt.phrases.model.bean.wan.WanBannerBean;
import com.lt.phrases.model.bean.wan.WanListBean;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by nq on 2018/3/30.
 * email : 1172921726@qq.com
 */

public class WanModel implements WanContract.IWanModel{

    @NonNull
    public static WanModel newInstance() {
        return new WanModel();
    }

    @Override
    public Observable<WanListBean> getWanList(int page) {
        return RetrofitCreateHelper.createApi(WanApi.class, WanApi.HOST)
                .getWanList(page).compose(RxHelper.<WanListBean>rxSchedulerHelper());
    }

    @Override
    public Observable<WanBannerBean> getWanBanner() {
        return RetrofitCreateHelper.createApi(WanApi.class, WanApi.HOST)
                .getWanBanner().compose(RxHelper.<WanBannerBean>rxSchedulerHelper());
    }

    @Override
    public Observable<Boolean> recordItemIsRead(final String key) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> e) throws Exception {
                e.onNext(DBUtils.getDB(AppUtils.getContext()).insertRead(DBConfig.
                        TABLE_WAN, key, ItemState.STATE_IS_READ));
                e.onComplete();
            }
        }).compose(RxHelper.<Boolean>rxSchedulerHelper());
    }


}
