package com.lt.phrases.model.gankio.tabs;

import android.support.annotation.NonNull;

import com.lt.library.base.BaseModel;
import com.lt.library.config.DBConfig;
import com.lt.library.config.ItemState;
import com.lt.library.helper.RetrofitCreateHelper;
import com.lt.library.helper.RxHelper;
import com.lt.library.utils.AppUtils;
import com.lt.library.utils.DBUtils;
import com.lt.phrases.api.GankioApi;
import com.lt.phrases.contract.gankio.tabs.GankIoDayContract;
import com.lt.phrases.model.bean.gankio.GankIoDayBean;
import com.lt.phrases.model.bean.gankio.GankIoDayItemBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;

/**
 * Created by nq on 2018/3/17.
 * email : 1172921726@qq.com
 */

public class GankIoDayModel extends BaseModel implements GankIoDayContract.IGankIoDayModel{
    private GankIoDayBean mGankIoDayBean;

    @NonNull
    public static GankIoDayModel newInstance() {
        return new GankIoDayModel();
    }

    public Observable<List<GankIoDayItemBean>> getGankIoDayList(String year, String month, String
            day) {
        return RetrofitCreateHelper.createApi(GankioApi.class, GankioApi.HOST).getGankIoDay(year,
                month, day).map(new Function<GankIoDayBean, List<GankIoDayItemBean>>() {
            @Override
            public List<GankIoDayItemBean> apply(GankIoDayBean gankIoDayBean) throws Exception {
                mGankIoDayBean = gankIoDayBean;
                List<GankIoDayItemBean> list = new ArrayList<>();
                //增加item类型
                GankIoDayItemBean itemAndroidBean = gankIoDayBean.getResults().getAndroid().get(0);
                GankIoDayItemBean itemIOSBean = gankIoDayBean.getResults().getiOS().get(0);
                GankIoDayItemBean itemFrontBean = gankIoDayBean.getResults().getFront().get(0);
                GankIoDayItemBean itemWelfareBean = gankIoDayBean.getResults().getWelfare().get(0);
                GankIoDayItemBean itemRestMovieBean = gankIoDayBean.getResults().getRestMovie()
                        .get(0);
                itemAndroidBean.itemType = GankIoDayItemBean.GANK_IO_DAY_ITEM_DAY_REFESH;
                itemIOSBean.itemType = GankIoDayItemBean.GANK_IO_DAY_ITEM_DAY_REFESH;
                itemFrontBean.itemType = GankIoDayItemBean.GANK_IO_DAY_ITEM_DAY_NORMAL;
                itemWelfareBean.itemType = GankIoDayItemBean.GANK_IO_DAY_ITEM_DAY_NORMAL;
                itemRestMovieBean.itemType = GankIoDayItemBean.GANK_IO_DAY_ITEM_DAY_NORMAL;
                list.add(itemAndroidBean);
                list.add(itemIOSBean);
                list.add(itemFrontBean);
                list.add(itemWelfareBean);
                list.add(itemRestMovieBean);
                return list;
            }
        }).compose(RxHelper.<List<GankIoDayItemBean>>rxSchedulerHelper());
    }

    @Override
    public GankIoDayItemBean getGankIoDayAndroid(int page) {
        if (mGankIoDayBean == null)
            return null;
        GankIoDayItemBean bean = mGankIoDayBean.getResults().getAndroid().get(page);
        bean.itemType = GankIoDayItemBean.GANK_IO_DAY_ITEM_DAY_REFESH;
        return bean;
    }

    @Override
    public GankIoDayItemBean getGankIoDayIOS(int page) {
        if (mGankIoDayBean == null)
            return null;
        GankIoDayItemBean bean = mGankIoDayBean.getResults().getiOS().get(page);
        bean.itemType = GankIoDayItemBean.GANK_IO_DAY_ITEM_DAY_REFESH;
        return bean;
    }

    @Override
    public Observable<Boolean> recordItemIsRead(final String key) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                emitter.onNext(DBUtils.getDB(AppUtils.getContext()).insertRead(DBConfig
                        .TABLE_GANKIO_DAY, key, ItemState.STATE_IS_READ));
                emitter.onComplete();
            }
        }).compose(RxHelper.<Boolean>rxSchedulerHelper());
    }
}
