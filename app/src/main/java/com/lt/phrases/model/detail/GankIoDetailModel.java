package com.lt.phrases.model.detail;

import android.support.annotation.NonNull;

import com.lt.library.base.BaseModel;
import com.lt.phrases.contract.detail.GankIoDetailContract;

/**
 * Created by nq on 2018/3/10.
 * email : 1172921726@qq.com
 */

public class GankIoDetailModel extends BaseModel implements GankIoDetailContract
        .IGankIoDetailModel {

    @NonNull
    public static GankIoDetailModel newInstance() {
        return new GankIoDetailModel();
    }
}