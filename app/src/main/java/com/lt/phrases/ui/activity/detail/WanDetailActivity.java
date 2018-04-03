package com.lt.phrases.ui.activity.detail;

import com.lt.phrases.contract.detail.WanDetailContract;

/**
 * Created by nq on 2018/3/31.
 * email : 1172921726@qq.com
 */

public class WanDetailActivity extends BaseWebViewLoadActivity<WanDetailContract.WanDetailPresenter>
        implements WanDetailContract.IWanDetailView{


    @Override
    public void showNewsDetail(String url) {

    }

    @Override
    protected void loadDetail() {

    }

    @Override
    protected String getToolbarTitle() {
        return null;
    }
}
