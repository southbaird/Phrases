package com.lt.phrases.model.gankio;

import android.support.annotation.NonNull;

import com.lt.phrases.contract.gankio.GankIoMainContract;

/**
 * Created by nq on 2018/3/17.
 * email : 1172921726@qq.com
 */

public class GankIoMainModel implements GankIoMainContract.IGankIoMainModel{

    @NonNull
    public static GankIoMainModel newInstance() {
        return new GankIoMainModel();
    }

    @Override
    public String[] getTabs() {
        return new String[]{"每日推荐", "干货定制", "福利"};
    }
}
