package com.lt.phrases.ui.fragment.gankio.child.tabs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lt.library.base.BasePresenter;
import com.lt.library.base.fragment.BaseRecycleFragment;
import com.lt.library.rxbus.RxBus;
import com.lt.phrases.R;
import com.lt.phrases.adapter.GankIoDayAdapter;
import com.lt.phrases.contract.gankio.tabs.GankIoDayContract;
import com.lt.phrases.model.bean.gankio.GankIoDayItemBean;
import com.lt.phrases.presenter.gankio.tabs.GankIoDayPresenter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by nq on 2018/3/29.
 * email : 1172921726@qq.com
 */

public class GankIoDayFragment extends BaseRecycleFragment<GankIoDayContract
        .GankIoDayPresenter> implements GankIoDayContract.IGankIoDayView {

    @BindView(R.id.rv_gankio_day)
    RecyclerView rvGankIoDay;

    GankIoDayAdapter mGankIoDayAdapter;

    public static GankIoDayFragment newInstance() {
        Bundle args = new Bundle();
        GankIoDayFragment fragment = new GankIoDayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        super.initData();
        //        Logger.e("RxBus.get().register(this)");
        RxBus.get().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //        Logger.e("RxBus.get().unRegister(this)");
        RxBus.get().unRegister(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_gank_io_day;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        //初始化一个空list的adapter，网络错误时使用，第一次加载到数据时重新初始化adapter并绑定recycleview
        mGankIoDayAdapter = new GankIoDayAdapter(null);
        rvGankIoDay.setAdapter(mGankIoDayAdapter);
        rvGankIoDay.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.loadLatestList();//第一次显示时请求最新的list
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return GankIoDayPresenter.newInstance();
    }

    @Override
    public void updateContentList(List<GankIoDayItemBean> list) {
        // Logger.e(list.toString());
        if (mGankIoDayAdapter.getData().size() == 0) {
            initRecycleView(list);
        } else {
            mGankIoDayAdapter.addData(list);
        }
    }

    @Override
    public void itemNotifyChanged(int position, GankIoDayItemBean bean) {
        mGankIoDayAdapter.refeshItem(position, bean);
    }

    @Override
    public void itemNotifyChanged(int position) {
    }

    @Override
    public void showNetworkError() {
        mGankIoDayAdapter.setEmptyView(errorView);
    }

    @Override
    public void showLoadMoreError() {
    }

    @Override
    public void showNoMoreData() {
    }

    private void initRecycleView(List<GankIoDayItemBean> list) {
        mGankIoDayAdapter = new GankIoDayAdapter(list);
        mGankIoDayAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.onItemClick(position, (GankIoDayItemBean) adapter.getItem(position));
            }
        });
        mGankIoDayAdapter.setOnItemChildClickListener(new BaseQuickAdapter
                .OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.ll_more:
                        mPresenter.onMoreClick(position, (GankIoDayItemBean) adapter.getItem
                                (position));
                        break;
                    case R.id.ll_refesh:
                        mPresenter.onRefeshClick(position, (GankIoDayItemBean) adapter.getItem
                                (position));
                        break;
                }
            }
        });
        rvGankIoDay.setAdapter(mGankIoDayAdapter);
    }

    @Override
    protected void onErrorViewClick(View view) {
        mPresenter.loadLatestList();
    }

    @Override
    protected void showLoading() {
        mGankIoDayAdapter.setEmptyView(loadingView);
    }
}
