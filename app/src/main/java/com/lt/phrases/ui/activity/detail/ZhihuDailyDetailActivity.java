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
import com.lt.phrases.contract.detail.ZhihuDetailContract;
import com.lt.phrases.model.bean.zhihu.ZhihuDailyDetailBean;
import com.lt.phrases.presenter.detail.ZhihuDetailPresenter;

/**
 * Created by nq on 2018/1/27.
 * email : 1172921726@qq.com
 */

public class ZhihuDailyDetailActivity extends BaseWebViewLoadActivity<ZhihuDetailContract
        .ZhihuDetailPresenter> implements ZhihuDetailContract.IZhihuDetailView{

    private String mId, mTitle;

    @Override
    protected void initData() {
        super.initData();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mId = bundle.getString(BundleKeyConstant.ARG_KEY_ZHIHU_DETAIL_ID);
            mTitle = bundle.getString(BundleKeyConstant.ARG_KEY_ZHIHU_DETAIL_TITLE);
        }
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        tvDetailTitle.setText(mTitle);
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return ZhihuDetailPresenter.newInstance();
    }

    @Override
    public void showDailyDetail(ZhihuDailyDetailBean bean) {
        flNetView.setVisibility(View.GONE);
        Glide.with(mContext).load(bean.getImage()).crossFade().into(ivDetail);
        tvDetailTitle.setText(bean.getTitle());
        tvDetailcopyright.setText(bean.getImage_source());
        String htmlData = HtmlUtils.createHtmlData(bean.getBody(), bean.getCss(), bean.getJs());
        nswvDetailContent.loadData(htmlData, HtmlUtils.MIME_TYPE, HtmlUtils.ENCODING);
    }

    @Override
    protected void loadDetail() {
        mPresenter.loadDailyDetail(mId);
    }

    @Override
    protected String getToolbarTitle() {
        return ResourcesUtils.getString(R.string.zhihu_detail_title);
    }
}
