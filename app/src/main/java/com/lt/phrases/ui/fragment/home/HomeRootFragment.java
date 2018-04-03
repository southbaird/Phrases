package com.lt.phrases.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lt.library.base.fragment.BaseCompatFragment;
import com.lt.phrases.R;
import com.lt.phrases.ui.fragment.home.child.HomeFragment;

/**
 * Created by nq on 2018/1/20.
 * email : 1172921726@qq.com
 */

public class HomeRootFragment extends BaseCompatFragment{

    public static HomeRootFragment newInstance() {
        Bundle args = new Bundle();
        HomeRootFragment fragment = new HomeRootFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        if (findChildFragment(HomeFragment.class) == null) {
            loadRootFragment(R.id.fl_container, HomeFragment.newInstance());
        }
    }
}
