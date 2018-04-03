package com.lt.phrases.api;

import com.lt.phrases.model.bean.wan.WanBannerBean;
import com.lt.phrases.model.bean.wan.WanListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by nq on 2018/3/30.
 * email : 1172921726@qq.com
 */

public interface WanApi {
    String HOST = "http://www.wanandroid.com";

    @GET("/article/list/{page}/json")
    Observable<WanListBean> getWanList(@Path("page") int page);

    @GET("/banner/json")
    Observable<WanBannerBean> getWanBanner();
}
