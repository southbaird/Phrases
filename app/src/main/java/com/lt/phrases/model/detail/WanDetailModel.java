package com.lt.phrases.model.detail;

import android.support.annotation.NonNull;

import com.lt.library.base.BaseModel;
import com.lt.phrases.contract.detail.WanDetailContract;

/**
 * Created by nq on 2018/3/31.
 * email : 1172921726@qq.com
 */

public class WanDetailModel extends BaseModel implements WanDetailContract.IWanDetailModel{

    @NonNull
    public static WanDetailModel newInstance() {
        return new WanDetailModel();
    }
}
