package com.lt.phrases.model.bean.wan;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nq on 2018/3/31.
 * email : 1172921726@qq.com
 */

public class WanBannerBean implements Serializable {

    @SerializedName("data")
    private ArrayList<WanBItemBean> mData;
    @SerializedName("errorCode")
    private int mErrorCode;
    @SerializedName("errorMsg")
    private String mErrorMsg;

    public ArrayList<WanBItemBean> getmData() {
        return mData;
    }

    public void setmData(ArrayList<WanBItemBean> mData) {
        this.mData = mData;
    }

    public int getmErrorCode() {
        return mErrorCode;
    }

    public void setmErrorCode(int mErrorCode) {
        this.mErrorCode = mErrorCode;
    }

    public String getmErrorMsg() {
        return mErrorMsg;
    }

    public void setmErrorMsg(String mErrorMsg) {
        this.mErrorMsg = mErrorMsg;
    }

    public class WanBItemBean implements Serializable {

        @SerializedName("desc")
        private String mDesc;
        @SerializedName("id")
        private int mId;
        @SerializedName("imagePath")
        private String mImagePath;
        @SerializedName("isVisible")
        private int mIsVisible;
        @SerializedName("order")
        private int mOrder;
        @SerializedName("title")
        private String mTitle;
        @SerializedName("type")
        private int mType;
        @SerializedName("url")
        private String mUrl;

        public String getmDesc() {
            return mDesc;
        }

        public void setmDesc(String mDesc) {
            this.mDesc = mDesc;
        }

        public int getmId() {
            return mId;
        }

        public void setmId(int mId) {
            this.mId = mId;
        }

        public String getmImagePath() {
            return mImagePath;
        }

        public void setmImagePath(String mImagePath) {
            this.mImagePath = mImagePath;
        }

        public int getmIsVisible() {
            return mIsVisible;
        }

        public void setmIsVisible(int mIsVisible) {
            this.mIsVisible = mIsVisible;
        }

        public int getmOrder() {
            return mOrder;
        }

        public void setmOrder(int mOrder) {
            this.mOrder = mOrder;
        }

        public String getmTitle() {
            return mTitle;
        }

        public void setmTitle(String mTitle) {
            this.mTitle = mTitle;
        }

        public int getmType() {
            return mType;
        }

        public void setmType(int mType) {
            this.mType = mType;
        }

        public String getmUrl() {
            return mUrl;
        }

        public void setmUrl(String mUrl) {
            this.mUrl = mUrl;
        }

        @Override
        public String toString() {
            return "WanBItemBean{" +
                    "mDesc='" + mDesc + '\'' +
                    ", mId=" + mId +
                    ", mImagePath='" + mImagePath + '\'' +
                    ", mIsVisible=" + mIsVisible +
                    ", mOrder=" + mOrder +
                    ", mTitle='" + mTitle + '\'' +
                    ", mType=" + mType +
                    ", mUrl='" + mUrl + '\'' +
                    '}';
        }
    }
}
