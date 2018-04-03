package com.lt.phrases.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lt.phrases.ui.widgets.RvLoadMoreView;

import java.util.List;

/**
 * Created by nq on 2018/1/27.
 * email : 1172921726@qq.com
 */

public abstract class BaseCompatAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T,
        K> {


    public BaseCompatAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
        init();
    }

    public BaseCompatAdapter(@Nullable List<T> data) {
        super(data);
    }

    public BaseCompatAdapter(int layoutResId) {
        super(layoutResId);
    }

    private void init(){
        setLoadMoreView(new RvLoadMoreView());
        setEnableLoadMore(true);
        openLoadAnimation();//开启默认动画载入（仅开启加载新item时开启动画）
    }
}
