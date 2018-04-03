package com.lt.phrases.ui.fragment.home.child.tabs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lt.library.base.BasePresenter;
import com.lt.library.base.fragment.BaseRecycleFragment;
import com.lt.phrases.R;
import com.lt.phrases.adapter.WangyiAdapter;
import com.lt.phrases.contract.home.tabs.WangyiContract;
import com.lt.phrases.model.bean.wangyi.WangyiNewsItemBean;
import com.lt.phrases.presenter.home.tabs.WangyiPresenter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by nq on 2018/3/10.
 * email : 1172921726@qq.com
 */

public class WangyiFragment extends BaseRecycleFragment<WangyiContract.WangyiPresenter>
        implements WangyiContract.IWangyiView, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_wangyi)
    RecyclerView rvWangyi;

    private WangyiAdapter mWangyiAdapter;

    public static WangyiFragment newInstance() {
        Bundle args = new Bundle();
        WangyiFragment fragment = new WangyiFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_wangyi;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        //初始化一个空list的adapter，网络错误时使用，第一次加载到数据时重新初始化adapter并绑定recycleview
        mWangyiAdapter = new WangyiAdapter(R.layout.item_recycle_home);
        rvWangyi.setAdapter(mWangyiAdapter);
        rvWangyi.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.loadLatestList(); // 第一次显示时请求最新的list

    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return WangyiPresenter.newInstance();
    }

    @Override
    public void updateContentList(List<WangyiNewsItemBean> list) {
        //Logger.e(list.toString());
        if (mWangyiAdapter.getData().size() == 0) {
            initRecycleView(list);
        } else {
            mWangyiAdapter.addData(list);
        }
    }

    @Override
    public void itemNotifyChanged(int position) {
        mWangyiAdapter.notifyItemChanged(position);
    }

    @Override
    public void showNetworkError() {
        mWangyiAdapter.setEmptyView(errorView);
    }

    @Override
    public void showLoadMoreError() {
        mWangyiAdapter.loadMoreFail();
    }

    @Override
    public void showNoMoreData() {
        mWangyiAdapter.loadMoreEnd(false);
    }

    @Override
    public void onLoadMoreRequested() {
        //这里loadMoreComplete要放在前面，避免在Presenter.loadMoreNewsList处理中直接showNoMoreData，出现无限显示加载item
        mWangyiAdapter.loadMoreComplete();
        mPresenter.loadMoreList();
    }

    private void initRecycleView(List<WangyiNewsItemBean> list) {
        mWangyiAdapter = new WangyiAdapter(R.layout.item_recycle_home, list);
        mWangyiAdapter.setOnLoadMoreListener(this, rvWangyi);
        mWangyiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.onItemClick(position, (WangyiNewsItemBean) adapter.getItem(position));
            }
        });
        rvWangyi.setAdapter(mWangyiAdapter);
    }

    @Override
    protected void onErrorViewClick(View view) {
        mPresenter.loadLatestList();
    }

    @Override
    protected void showLoading() {
        mWangyiAdapter.setEmptyView(loadingView);
    }
}
