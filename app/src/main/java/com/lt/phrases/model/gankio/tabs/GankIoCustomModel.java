package com.lt.phrases.model.gankio.tabs;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.lt.library.base.BaseModel;
import com.lt.library.config.DBConfig;
import com.lt.library.config.ItemState;
import com.lt.library.helper.RetrofitCreateHelper;
import com.lt.library.helper.RxHelper;
import com.lt.library.utils.AppUtils;
import com.lt.library.utils.DBUtils;
import com.lt.phrases.api.GankioApi;
import com.lt.phrases.contract.gankio.tabs.GankIoCustomContract;
import com.lt.phrases.model.bean.gankio.GankIoCustomItemBean;
import com.lt.phrases.model.bean.gankio.GankIoCustomListBean;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

/**
 * Created by nq on 2018/3/17.
 * email : 1172921726@qq.com
 */

public class GankIoCustomModel extends BaseModel implements GankIoCustomContract.IGankIoCustomModel {

    @NonNull
    public static GankIoCustomModel newInstance() {
        return new GankIoCustomModel();
    }

    @Override
    public Observable<GankIoCustomListBean> getCustomGankIoList(String type, int prePage, int page) {
        return RetrofitCreateHelper.createApi(GankioApi.class, GankioApi.HOST)
                .getGankIoCustomList(type, prePage, page)
                .map(new Function<GankIoCustomListBean, GankIoCustomListBean>() {
                    @Override
                    public GankIoCustomListBean apply(GankIoCustomListBean gankIoCustomListBean) throws Exception {
                        for (GankIoCustomItemBean bean : gankIoCustomListBean.getResults()) {
                            if (bean.getType().equals("福利")) {
                                bean.itemType = GankIoCustomItemBean.GANK_IO_DAY_ITEM_CUSTOM_IMAGE;
                            } else if (bean.getImages() != null) {
                                if (bean.getImages().size() > 0 && !TextUtils.isEmpty(bean.getImages().get(0)))
                                    bean.itemType = GankIoCustomItemBean.GANK_IO_DAY_ITEM_CUSTOM_NORMAL;
                            } else {
                                bean.itemType = GankIoCustomItemBean.GANK_IO_DAY_ITEM_CUSTOM_NO_IMAGE;
                            }
                        }
                        return gankIoCustomListBean;
                    }
                })
                .compose(RxHelper.<GankIoCustomListBean>rxSchedulerHelper());
    }

    @Override
    public Observable<Boolean> recordItemIsRead(final String key) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                emitter.onNext(DBUtils.getDB(AppUtils.getContext()).insertRead(DBConfig
                        .TABLE_GANKIO_CUSTOM, key, ItemState.STATE_IS_READ));
                emitter.onComplete();
            }
        }).compose(RxHelper.<Boolean>rxSchedulerHelper());
    }
}
