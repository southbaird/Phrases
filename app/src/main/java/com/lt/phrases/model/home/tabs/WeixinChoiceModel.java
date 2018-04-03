package com.lt.phrases.model.home.tabs;

import android.support.annotation.NonNull;

import com.lt.library.base.BaseModel;
import com.lt.library.config.DBConfig;
import com.lt.library.config.ItemState;
import com.lt.library.helper.RetrofitCreateHelper;
import com.lt.library.helper.RxHelper;
import com.lt.library.utils.AppUtils;
import com.lt.library.utils.DBUtils;
import com.lt.phrases.api.WeixinApi;
import com.lt.phrases.contract.home.tabs.WeixinContract;
import com.lt.phrases.model.bean.weixin.WeixinChoiceListBean;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by nq on 2018/3/17.
 * email : 1172921726@qq.com
 */

public class WeixinChoiceModel extends BaseModel implements WeixinContract.IWeixinModel{

    @NonNull
    public static WeixinChoiceModel newInstance() {
        return new WeixinChoiceModel();
    }

    @Override
    public Observable<Boolean> recordItemIsRead(final String key) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> e) throws Exception {
                e.onNext(DBUtils.getDB(AppUtils.getContext()).insertRead(DBConfig
                        .TABLE_WEIXIN, key, ItemState.STATE_IS_READ));
                e.onComplete();
            }
        }).compose(RxHelper.<Boolean>rxSchedulerHelper());
    }

    @Override
    public Observable<WeixinChoiceListBean> getWeixinChoiceList(int page, int pageStrip, String dttype, String key) {
        return RetrofitCreateHelper.createApi(WeixinApi.class, WeixinApi.HOST).getWeixinChoiceList
                (page, pageStrip, dttype, key).compose(RxHelper
                .<WeixinChoiceListBean>rxSchedulerHelper());
    }
}
