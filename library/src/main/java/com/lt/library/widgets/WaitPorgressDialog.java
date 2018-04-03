package com.lt.library.widgets;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by nq on 2018/1/20.
 * email : 1172921726@qq.com
 * 等待提示dialog
 */

public class WaitPorgressDialog extends ProgressDialog{

    public WaitPorgressDialog(Context context) {
        super(context, 0);
    }

    public WaitPorgressDialog(Context context, int theme) {
        super(context, theme);
        setCanceledOnTouchOutside(false);
    }
}
