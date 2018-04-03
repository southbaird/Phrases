package com.lt.phrases.model.detail;

import android.support.annotation.NonNull;

import com.lt.library.base.BaseModel;
import com.lt.phrases.contract.detail.WebViewLoadConaract;

/**
 * Created by nq on 2018/4/3.
 */

public class WebViewLoadModel extends BaseModel implements
        WebViewLoadConaract.IWebViewLoadModel {

    @NonNull
    public static WebViewLoadModel newInstance() {
        return new WebViewLoadModel();
    }
}
