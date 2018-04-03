package com.lt.phrases.api;

import com.lt.phrases.model.bean.weixin.WeixinChoiceListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nq on 2018/1/27.
 * email : 1172921726@qq.com
 */

public interface WeixinApi {
    String HOST = "http://v.juhe.cn";

    @GET("/weixin/query")
    Observable<WeixinChoiceListBean> getWeixinChoiceList(@Query("pno") int page, @Query("ps") int
            ps, @Query("dtype") String dttype, @Query("key") String key);
}
