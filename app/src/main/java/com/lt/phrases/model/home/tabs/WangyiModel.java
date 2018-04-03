package com.lt.phrases.model.home.tabs;

import android.support.annotation.NonNull;

import com.lt.library.config.DBConfig;
import com.lt.library.config.ItemState;
import com.lt.library.helper.RetrofitCreateHelper;
import com.lt.library.helper.RxHelper;
import com.lt.library.utils.AppUtils;
import com.lt.library.utils.DBUtils;
import com.lt.phrases.api.WangyiApi;
import com.lt.phrases.contract.home.tabs.WangyiContract;
import com.lt.phrases.model.bean.wangyi.WangyiNewsListBean;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by nq on 2018/3/17.
 * email : 1172921726@qq.com
 */

public class WangyiModel implements WangyiContract.IWangyiModel{

    @NonNull
    public static WangyiModel newInstance() {
        return new WangyiModel();
    }

    @Override
    public Observable<WangyiNewsListBean> getNewsList(int id) {
        return RetrofitCreateHelper.createApi(WangyiApi.class, WangyiApi.HOST).getNewsList(id)
                .compose(RxHelper.<WangyiNewsListBean>rxSchedulerHelper());
    }

    @Override
    public Observable<Boolean> recordItemIsRead(final String key) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> e) throws Exception {
                e.onNext(DBUtils.getDB(AppUtils.getContext()).insertRead(DBConfig
                        .TABLE_WANGYI, key, ItemState.STATE_IS_READ));
                e.onComplete();
            }
        }).compose(RxHelper.<Boolean>rxSchedulerHelper());
    }
}
