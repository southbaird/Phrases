package com.lt.phrases.ui.widgets;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.lt.phrases.R;

/**
 * Created by nq on 2018/1/27.
 * email : 1172921726@qq.com
 * 加载更多item view
 */

public class RvLoadMoreView extends LoadMoreView{
    @Override
    public int getLayoutId() {
        return R.layout.item_load_more;
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.load_more_loading_view;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.id.load_more_load_fail_view;
    }

    @Override
    protected int getLoadEndViewId() {
        return R.id.load_more_load_fail_view;
    }
}
