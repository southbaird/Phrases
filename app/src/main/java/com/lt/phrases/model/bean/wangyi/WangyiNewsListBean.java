package com.lt.phrases.model.bean.wangyi;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nq on 2018/3/10.
 * email : 1172921726@qq.com
 */

public class WangyiNewsListBean {

    @SerializedName("T1348647909107")
    ArrayList<WangyiNewsItemBean> newsList;

    public ArrayList<WangyiNewsItemBean> getNewsList() {
        return newsList;
    }

    public void setNewsList(ArrayList<WangyiNewsItemBean> newsList) {
        this.newsList = newsList;
    }
}
