package com.lt.library.global;

import android.content.Context;
import android.os.Handler;

import com.lt.library.BuildConfig;
import com.mob.MobApplication;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import static android.os.Process.myTid;

/**
 * Created by nq on 2018/1/20.
 * email : 1172921726@qq.com
 * 全局Application
 */

public class GlobalApplication extends MobApplication {
    private static final String LOG_TAG = "LT_LOGGER";
    protected static Context context;
    protected static Handler handler;
    protected static int mainThreadId;
    private static GlobalApplication mApp;

    public static synchronized GlobalApplication getInstance() {return mApp;}

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
        mainThreadId = myTid();
        Logger.init(LOG_TAG).logLevel(BuildConfig.IS_SHOW_LOG ? LogLevel.FULL : LogLevel.NONE);
    }

    /**
     * 获取上下文对象
     *
     * @return context
     */
    public static Context getContext() {
        return context;
    }

    /**
     * 获取全局handler
     *
     * @return 全局handler
     */
    public static Handler getHandler() {
        return handler;
    }

    /**
     * 获取主线程id
     *
     * @return 主线程id
     */
    public static int getMainThreadId() {
        return mainThreadId;
    }
}
