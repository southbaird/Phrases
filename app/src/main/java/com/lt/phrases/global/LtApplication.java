package com.lt.phrases.global;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.lt.library.global.GlobalApplication;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by nq on 2018/1/20.
 * email : 1172921726@qq.com
 */

public class LtApplication extends GlobalApplication {

    public static final String JU_HE_APP_KEY = "799b785ba7b97223be80534651dd0d63";
    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;
    public static LtApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        // 初始化屏幕宽高
        getScreenSize();

        // 腾讯 Bugly
        CrashReport.initCrashReport(getApplicationContext(), "d99d6b6451", false);
    }

    public void getScreenSize() {
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if (SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }
}
