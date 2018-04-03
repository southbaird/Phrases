package com.lt.phrases.model.bean.rxbus;

import android.net.Uri;

/**
 * Created by nq on 2018/1/27.
 * email : 1172921726@qq.com
 * RxBus传递头像uri bean
 */

public class RxEventHeadBean {
    private Uri uri;

    public RxEventHeadBean(Uri uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "RxEventHeadBean{" +
                "uri=" + uri +
                '}';
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}
