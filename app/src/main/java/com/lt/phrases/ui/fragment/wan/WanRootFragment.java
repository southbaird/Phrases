package com.lt.phrases.ui.fragment.wan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lt.library.base.fragment.BaseCompatFragment;
import com.lt.phrases.R;
import com.lt.phrases.ui.fragment.wan.child.WanFragment;

/**
 * Created by nq on 2018/1/20.
 * email : 1172921726@qq.com
 */

public class WanRootFragment extends BaseCompatFragment {

    public static WanRootFragment newInstance() {
        Bundle args = new Bundle();
        WanRootFragment fragment = new WanRootFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_movie;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        //Logger.e("onLazyInitView");
        //加载子fragment
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_container, WanFragment.newInstance());
        } else {  // 这里可能会出现该Fragment没被初始化时,就被强杀导致的没有load子Fragment
            if (findChildFragment(WanFragment.class) == null) {
                loadRootFragment(R.id.fl_container, WanFragment.newInstance());
            }
        }
    }
}
