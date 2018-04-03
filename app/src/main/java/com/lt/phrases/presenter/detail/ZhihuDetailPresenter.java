package com.lt.phrases.presenter.detail;

import android.support.annotation.NonNull;

import com.lt.phrases.contract.detail.ZhihuDetailContract;
import com.lt.phrases.model.bean.zhihu.ZhihuDailyDetailBean;
import com.lt.phrases.model.detail.ZhihuDetailModel;

import io.reactivex.functions.Consumer;

/**
 * Created by nq on 2018/1/27.
 * email : 1172921726@qq.com
 */

public class ZhihuDetailPresenter extends ZhihuDetailContract.ZhihuDetailPresenter {

    @NonNull
    public static ZhihuDetailPresenter newInstance() {
        return new ZhihuDetailPresenter();
    }

    @Override
    public void loadDailyDetail(String id) {
        if (mIModel == null)
            return;
        mRxManager.register(mIModel.getDailyDetail(id).subscribe(new Consumer<ZhihuDailyDetailBean>() {
            @Override
            public void accept(ZhihuDailyDetailBean zhihuDailyDetailBean) throws Exception {
                if (mIView != null)
                    mIView.showDailyDetail(zhihuDailyDetailBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (mIView != null) {
                    mIView.showToast("网络异常");
                    mIView.showNetworkError();
                }
            }
        }));
    }

    @Override
    public ZhihuDetailContract.IZhihuDetailModel getModel() {
        return ZhihuDetailModel.newInstance();
    }

    @Override
    public void onStart() {
    }
}
