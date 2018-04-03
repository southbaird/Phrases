package com.lt.phrases.model.personal;

import android.support.annotation.NonNull;

import com.lt.phrases.contract.personal.PersonalContract;

/**
 * Created by nq on 2018/1/27.
 * email : 1172921726@qq.com
 */

public class PersonalUpperModel implements PersonalContract.IPersonalUpperModel {

    @NonNull
    public static PersonalUpperModel newInstance() {
        return new PersonalUpperModel();
    }
}
