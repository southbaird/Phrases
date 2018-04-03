package com.lt.phrases.ui.fragment.gankio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lt.library.base.fragment.BaseCompatFragment;
import com.lt.phrases.R;
import com.lt.phrases.ui.fragment.gankio.child.GankIoFragment;

/**
 * Created by nq on 2018/1/20.
 * email : 1172921726@qq.com
 */

public class GankIoRootFragment extends BaseCompatFragment {

    public static GankIoRootFragment newInstance() {
        Bundle args = new Bundle();
        GankIoRootFragment fragment = new GankIoRootFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_gank_io;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        if (findChildFragment(GankIoFragment.class) == null) {
            loadRootFragment(R.id.fl_container, GankIoFragment.newInstance());
        }
    }
}
