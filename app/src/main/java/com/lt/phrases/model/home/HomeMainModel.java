package com.lt.phrases.model.home;

import android.support.annotation.NonNull;

import com.lt.library.base.BaseModel;
import com.lt.phrases.contract.home.HomeMainContract;

/**
 * Created by nq on 2018/1/27.
 * email : 1172921726@qq.com
 */

public class HomeMainModel extends BaseModel implements HomeMainContract.IHomeMainModel {

    @NonNull
    public static HomeMainModel newInstance() {
        return new HomeMainModel();
    }

    @Override
    public String[] getTabs() {
        return new String[]{"知乎日报", "热点新闻", "微信精选"};
    }
}
