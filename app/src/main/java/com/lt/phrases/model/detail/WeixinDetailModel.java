package com.lt.phrases.model.detail;

import android.support.annotation.NonNull;

import com.lt.library.base.BaseModel;
import com.lt.phrases.contract.detail.WeixinDetailContract;

/**
 * Created by nq on 2018/3/10.
 * email : 1172921726@qq.com
 */

public class WeixinDetailModel extends BaseModel implements WeixinDetailContract.IWeixinDetailModel{

    @NonNull
    public static WeixinDetailModel newInstance() {
        return new WeixinDetailModel();
    }
}
