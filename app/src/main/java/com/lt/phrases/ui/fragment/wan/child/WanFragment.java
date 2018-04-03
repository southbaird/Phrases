package com.lt.phrases.ui.fragment.wan.child;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lt.library.base.BasePresenter;
import com.lt.library.base.fragment.BaseRecycleFragment;
import com.lt.library.utils.ResourcesUtils;
import com.lt.phrases.R;
import com.lt.phrases.adapter.WanAdapter;
import com.lt.phrases.contract.wan.WanContract;
import com.lt.phrases.model.bean.wan.WanBannerBean;
import com.lt.phrases.model.bean.wan.WanItemBean;
import com.lt.phrases.presenter.wan.WanPresenter;
import com.lt.phrases.ui.widgets.GlideImageLoader;
import com.orhanobut.logger.Logger;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by nq on 2018/3/30.
 * email : 1172921726@qq.com
 */

public class WanFragment extends BaseRecycleFragment<WanContract.WanPresenter>
        implements WanContract.IWanView, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_wan_android)
    RecyclerView rvWan;

    private WanAdapter mWanAdapter;
    private View headView;
    private Banner mBannerAds;
    private List<WanBannerBean.WanBItemBean> banner;

    public static WanFragment newInstance() {
        Bundle args = new Bundle();
        WanFragment fragment = new WanFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_wan_android;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        //初始化一个空list的adapter，网络错误时使用，第一次加载到数据时重新初始化adapter并绑定recycleview
        mWanAdapter = new WanAdapter(R.layout.item_recycle_wan);
        rvWan.setAdapter(mWanAdapter);
        rvWan.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.loadWanBanner();
        mPresenter.loadLatestList();//第一次显示时请求最新的list
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return WanPresenter.newInstance();
    }

    @Override
    public void updateContentList(WanItemBean list) {
        Logger.e(list.toString());
        if (mWanAdapter.getData().size() == 0) {
            initRecycleView(list);
        } else {
            mWanAdapter.addData(list.getDatas());
        }
    }

    @Override
    public void itemNotifyChanged(int position) {
        mWanAdapter.notifyItemChanged(position);
    }

    @Override
    public void showNetworkError() {
        mWanAdapter.setEmptyView(errorView);
    }

    @Override
    public void showLoadMoreError() {
        mWanAdapter.loadMoreFail();
    }

    @Override
    public void showNoMoreData() {
        mWanAdapter.loadMoreEnd(false);
    }

    @Override
    public void onLoadMoreRequested() {
        //这里loadMoreComplete要放在前面，避免在Presenter.loadMoreNewsList处理中直接showNoMoreData，出现无限显示加载item
        mWanAdapter.loadMoreComplete();
        mPresenter.loadMoreList();
    }

    private void initRecycleView(WanItemBean list) {
        mWanAdapter = new WanAdapter(R.layout.item_recycle_wan, list.getDatas());
        mWanAdapter.setOnLoadMoreListener(this, rvWan);
        mWanAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.onItemClick(position, (WanItemBean.DatasBean) adapter.getItem(position));
            }
        });
        initHeadView(banner);
        mWanAdapter.addHeaderView(headView);
        rvWan.setAdapter(mWanAdapter);
    }

    private void initHeadView(List<WanBannerBean.WanBItemBean> list) {
        if (headView == null) {
            headView = ResourcesUtils.inflate(R.layout.sub_wan_android_head);
        }
        mBannerAds = (Banner) headView.findViewById(R.id.banner_ads);
        List<String> images = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (WanBannerBean.WanBItemBean banne : list) {
            images.add(banne.getmImagePath());
            titles.add(banne.getmTitle());
        }
        mBannerAds.setImages(images)
                .setBannerTitles(titles)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setImageLoader(new GlideImageLoader())
                .start();

        mBannerAds.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Logger.e(String.valueOf(position));
                mPresenter.onBannerItemClick(banner.get(position));
            }
        });
    }

    @Override
    public void showWanBanner(List<WanBannerBean.WanBItemBean> list) {
        banner = list;
    }

    @Override
    protected void onErrorViewClick(View view) {
        mPresenter.loadLatestList();
    }

    @Override
    protected void showLoading() {
        mWanAdapter.setEmptyView(loadingView);
    }
}
