package com.lt.phrases.model.bean.wan;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nq on 2018/3/30.
 * email : 1172921726@qq.com
 */

public class WanListBean {

    @SerializedName("errorCode")
    private int errorCode;
    @SerializedName("errorMsg")
    private Object errorMsg;
    @SerializedName("data")
    private WanItemBean data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Object errorMsg) {
        this.errorMsg = errorMsg;
    }

    public WanItemBean getData() {
        return data;
    }

    public void setData(WanItemBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WanListBean{" +
                "errorCode=" + errorCode +
                ", errorMsg=" + errorMsg +
                ", data=" + data +
                '}';
    }
}
