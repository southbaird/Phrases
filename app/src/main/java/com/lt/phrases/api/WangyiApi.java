package com.lt.phrases.api;

import com.lt.phrases.model.bean.wangyi.WangyiNewsListBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by nq on 2018/1/27.
 * email : 1172921726@qq.com
 */

public interface WangyiApi {
    String HOST = "http://c.m.163.com";

    @GET("/nc/article/headline/T1348647909107/{id}-20.html")
    Observable<WangyiNewsListBean> getNewsList(@Path("id") int id);

    @GET("/nc/article/{id}/full.html")
    Observable<ResponseBody> getNewsDetail(@Path("id") String id);
}
