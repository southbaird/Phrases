package com.lt.phrases.ui.fragment.home.child;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.lt.library.adapter.FragmentAdapter;
import com.lt.library.anim.ToolbarAnimManager;
import com.lt.library.base.BasePresenter;
import com.lt.library.base.activity.BaseCompatActivity;
import com.lt.library.base.fragment.BaseMVPCompatFragment;
import com.lt.library.utils.SpUtils;
import com.lt.phrases.R;
import com.lt.phrases.constant.BundleKeyConstant;
import com.lt.phrases.constant.TabFragmentIndex;
import com.lt.phrases.contract.home.HomeMainContract;
import com.lt.phrases.presenter.home.HomeMainPresenter;
import com.lt.phrases.ui.activity.detail.WebViewLoadActivity;
import com.lt.phrases.ui.fragment.home.child.tabs.WangyiFragment;
import com.lt.phrases.ui.fragment.home.child.tabs.WeixinFragment;
import com.lt.phrases.ui.fragment.home.child.tabs.ZhihuFragment;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * Created by nq on 2018/2/27.
 * email : 1172921726@qq.com
 */

public class HomeFragment extends BaseMVPCompatFragment<HomeMainContract.HomeMainPresenter>
        implements HomeMainContract.IHomeMainView {

    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tl_tabs)
    TabLayout tlTabs;
    @BindView(R.id.vp_fragment)
    ViewPager vpFragment;
    @BindView(R.id.fab_download)
    FloatingActionButton fabDownload;

    protected OnOpenDrawerLayoutListener onOpenDrawerLayoutListener;
    private List<Fragment> fragments;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnOpenDrawerLayoutListener) {
            onOpenDrawerLayoutListener = (OnOpenDrawerLayoutListener) context;
        }
        fragments = new ArrayList<>();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onOpenDrawerLayoutListener = null;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.getTabList();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        toolbar.setTitle("首页");
        toolbar.setNavigationIcon(R.mipmap.ic_drawer_home);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onOpenDrawerLayoutListener != null) {
                    onOpenDrawerLayoutListener.onOpen();
                }
            }
        });

        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    fabDownload.show();
                } else {
                    fabDownload.hide();
                }
            }
        });

        fabDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(BundleKeyConstant.ARG_KEY_WEB_VIEW_LOAD_TITLE, "Lt");
                bundle.putString(BundleKeyConstant.ARG_KEY_WEB_VIEW_LOAD_URL,
                        "https://github.com/nq117/Phrases");
                startNewActivity(WebViewLoadActivity.class, bundle);
            }
        });

        toolbar.inflateMenu(R.menu.toolbar_menu);
        toolbar.getMenu().findItem(R.id.night).setChecked(SpUtils.getNightModel(mContext));
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.night:
                        item.setChecked(!item.isChecked());
                        SpUtils.setNightModel(mContext, item.isChecked());
                        ((BaseCompatActivity)mActivity).reload();
                        break;
                }
                return false;
            }
        });

        ToolbarAnimManager.animIn(mContext, toolbar);
    }

    @Override
    public BasePresenter initPresenter() {
        return HomeMainPresenter.newInstance();
    }

    @Override
    public void showTabList(String[] tabs) {
        Logger.e(Arrays.toString(tabs));
        for (int i = 0; i < tabs.length; i++) {
            tlTabs.addTab(tlTabs.newTab().setText(tabs[i]));
            switch (i) {
                case TabFragmentIndex.TAB_ZHIHU_INDEX:
                    fragments.add(ZhihuFragment.newInstance());
                    break;
                case TabFragmentIndex.TAB_WANGYI_INDEX:
                    fragments.add(WangyiFragment.newInstance());
                    break;
                case TabFragmentIndex.TAB_WEIXIN_INDEX:
                    fragments.add(WeixinFragment.newInstance());
                    break;
                default:
                    fragments.add(ZhihuFragment.newInstance());
                    break;
            }
        }
        vpFragment.setAdapter(new FragmentAdapter(getChildFragmentManager(), fragments));
        vpFragment.setCurrentItem(TabFragmentIndex.TAB_ZHIHU_INDEX);//要设置到viewpager.setAdapter后才起作用
        tlTabs.setupWithViewPager(vpFragment);
        tlTabs.setVerticalScrollbarPosition(TabFragmentIndex.TAB_ZHIHU_INDEX);
        //tlTabs.setupWithViewPager方法内部会remove所有的tabs，这里重新设置一遍tabs的text，否则tabs的text不显示
        for (int i = 0; i < tabs.length; i++) {
            tlTabs.getTabAt(i).setText(tabs[i]);
        }
    }

    /**
     * fragment打开DrawerLayout监听
     */
    public interface OnOpenDrawerLayoutListener {
        void onOpen();
    }
}
