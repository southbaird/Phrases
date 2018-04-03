package com.lt.phrases.contract.detail;

import com.lt.phrases.model.bean.zhihu.ZhihuDailyDetailBean;
import com.lt.phrases.presenter.detail.BaseWebViewLoadPresenter;

import io.reactivex.Observable;

/**
 * Created by nq on 2018/1/27.
 * email : 1172921726@qq.com
 */

public interface ZhihuDetailContract {
    abstract class ZhihuDetailPresenter extends BaseWebViewLoadPresenter<IZhihuDetailModel, IZhihuDetailView> {
        /**
         * 加载日报详情
         */
        public abstract void loadDailyDetail(String id);
    }

    interface IZhihuDetailModel extends BaseWebViewLoadContract.IBaseWebViewLoadModel {
        /**
         * 获取日报详情
         *
         * @param id 日报id
         * @return Observable
         */
        Observable<ZhihuDailyDetailBean> getDailyDetail(String id);
    }

    interface IZhihuDetailView extends BaseWebViewLoadContract.IBaseWebViewLoadView {
        /**
         * 显示日报详细内容
         *
         * @param bean ZhihuDailyDetailBean
         */
        void showDailyDetail(ZhihuDailyDetailBean bean);
    }
}
