package com.lt.phrases.model.home.tabs;

import android.support.annotation.NonNull;

import com.lt.library.base.BaseModel;
import com.lt.library.config.DBConfig;
import com.lt.library.config.ItemState;
import com.lt.library.helper.RetrofitCreateHelper;
import com.lt.library.helper.RxHelper;
import com.lt.library.utils.AppUtils;
import com.lt.library.utils.DBUtils;
import com.lt.phrases.api.ZhihuApi;
import com.lt.phrases.contract.home.tabs.ZhihuContract;
import com.lt.phrases.model.bean.zhihu.ZhihuDailyListBean;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by nq on 2018/2/10.
 * email : 1172921726@qq.com
 */

public class ZhihuModel extends BaseModel implements ZhihuContract.IZhihuModel{

    @NonNull
    public static ZhihuModel newInstance() {
        return new ZhihuModel();
    }

    @Override
    public Observable<ZhihuDailyListBean> getDailyList(String date) {
        return RetrofitCreateHelper.createApi(ZhihuApi.class, ZhihuApi.HOST).getDailyListWithDate
                (date).compose(RxHelper.<ZhihuDailyListBean>rxSchedulerHelper());
    }

    @Override
    public Observable<ZhihuDailyListBean> getDailyList() {
        return RetrofitCreateHelper.createApi(ZhihuApi.class, ZhihuApi.HOST).getLastDailyList()
                .compose(RxHelper.<ZhihuDailyListBean>rxSchedulerHelper());
    }

    @Override
    public Observable<Boolean> recordItemIsRead(final String key) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                emitter.onNext(DBUtils.getDB(AppUtils.getContext()).insertRead(DBConfig
                        .TABLE_ZHIHU, key, ItemState.STATE_IS_READ));
                emitter.onComplete();
            }
        }).compose(RxHelper.<Boolean>rxSchedulerHelper());
    }
}
