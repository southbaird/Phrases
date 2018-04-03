package com.lt.phrases.ui.activity.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.bumptech.glide.Glide;
import com.lt.library.base.BasePresenter;
import com.lt.library.utils.HtmlUtils;
import com.lt.library.utils.ResourcesUtils;
import com.lt.phrases.R;
import com.lt.phrases.constant.BundleKeyConstant;
import com.lt.phrases.contract.detail.WangyiDetailContract;
import com.lt.phrases.model.bean.wangyi.WangyiNewsDetailBean;
import com.lt.phrases.presenter.detail.WangyiDetailPresenter;

/**
 * Created by nq on 2018/3/17.
 * email : 1172921726@qq.com
 */

public class WangyiDailyDetailActivity extends BaseWebViewLoadActivity<WangyiDetailContract
        .WangyiDetailPresenter> implements WangyiDetailContract.IWangyiDetailView {

    private String mTitle, mUrl, mId, mImageUrl, mCopyright;

    @Override
    protected void initData() {
        super.initData();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mId = bundle.getString(BundleKeyConstant.ARG_KEY_WANGYI_DETAIL_ID);
            mUrl = bundle.getString(BundleKeyConstant.ARG_KEY_WANGYI_DETAIL_URL);
            mTitle = bundle.getString(BundleKeyConstant.ARG_KEY_WANGYI_DETAIL_TITLE);
            mImageUrl = bundle.getString(BundleKeyConstant.ARG_KEY_WANGYI_DETAIL_IMAGE_URL);
            mCopyright = bundle.getString(BundleKeyConstant.ARG_KEY_WANGYI_DETAIL_COPYRIGHT);
        }
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        tvDetailTitle.setText(mTitle);
        tvDetailcopyright.setText(mCopyright);
        Glide.with(mContext).load(mImageUrl).crossFade().into(ivDetail);
    }

    @Override
    protected void loadDetail() {
        mPresenter.loadNewsDetailWithUrl(mUrl);
        //mPresenter.loadNewsDetailWithId(mId);
    }

    @Override
    protected String getToolbarTitle() {
        return ResourcesUtils.getString(R.string.wangyi_detail_title);
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return WangyiDetailPresenter.newInstance();
    }

    @Override
    public void showNewsDetail(WangyiNewsDetailBean bean) {
        flNetView.setVisibility(View.GONE);
        //tvDetailTitle.setText(bean.getTitle());
        nswvDetailContent.loadData(bean.getBody(), HtmlUtils.MIME_TYPE, HtmlUtils.ENCODING);
    }

    @Override
    public void showNewsDetail(String url) {
        flNetView.setVisibility(View.GONE);
        nswvDetailContent.loadUrl(url);
    }
}
