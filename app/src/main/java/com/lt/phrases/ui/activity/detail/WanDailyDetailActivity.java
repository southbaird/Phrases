package com.lt.phrases.ui.activity.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.bumptech.glide.Glide;
import com.lt.library.base.BasePresenter;
import com.lt.library.utils.ResourcesUtils;
import com.lt.phrases.R;
import com.lt.phrases.constant.BundleKeyConstant;
import com.lt.phrases.contract.detail.WanDetailContract;
import com.lt.phrases.presenter.detail.WanDetailPresenter;

/**
 * Created by nq on 2018/4/1.
 */

public class WanDailyDetailActivity extends BaseWebViewLoadActivity<WanDetailContract
        .WanDetailPresenter> implements WanDetailContract.IWanDetailView  {

    private String mTitle, mUrl, mImageUrl;

    @Override
    protected void initData() {
        super.initData();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mUrl = bundle.getString(BundleKeyConstant.ARG_KEY_WAN_DETAIL_URL);
            mTitle = bundle.getString(BundleKeyConstant.ARG_KEY_WAN_DETAIL_TITLE);
            mImageUrl = bundle.getString(BundleKeyConstant.ARG_KEY_WAN_DETAIL_IMAGE_URL);
        }
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        tvDetailTitle.setText(mTitle);
        Glide.with(mContext).load(mImageUrl).crossFade().into(ivDetail);
    }

    @Override
    protected void loadDetail() {
        mPresenter.loadNewsDetailWithUrl(mUrl);
    }

    @Override
    protected String getToolbarTitle() {
        return ResourcesUtils.getString(R.string.wan_detail_title);
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return WanDetailPresenter.newInstance();
    }

    @Override
    public void showNewsDetail(String url) {
        flNetView.setVisibility(View.GONE);
        nswvDetailContent.loadUrl(url);
    }
}
