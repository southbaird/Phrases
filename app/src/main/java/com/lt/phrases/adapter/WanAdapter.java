package com.lt.phrases.adapter;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseViewHolder;
import com.lt.library.config.DBConfig;
import com.lt.library.config.ItemState;
import com.lt.library.utils.DBUtils;
import com.lt.library.utils.SpUtils;
import com.lt.phrases.R;
import com.lt.phrases.model.bean.wan.WanItemBean;

import java.util.List;

/**
 * Created by nq on 2018/3/30.
 * email : 1172921726@qq.com
 */

public class WanAdapter extends BaseCompatAdapter<WanItemBean.DatasBean, BaseViewHolder> {

    public WanAdapter(@LayoutRes int layoutResId, @NonNull List<WanItemBean.DatasBean> data) {
        super(layoutResId, data);
    }

    public WanAdapter(@NonNull List<WanItemBean.DatasBean> data) {
        super(data);
    }

    public WanAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, WanItemBean.DatasBean item) {
        if (DBUtils.getDB(mContext).isRead(DBConfig.TABLE_WAN, item.getId(), ItemState.STATE_IS_READ)) {
            helper.setTextColor(R.id.tv_item_title, Color.GRAY);
        } else {
            if (SpUtils.getNightModel(mContext)) {
                helper.setTextColor(R.id.tv_item_title, Color.WHITE);
            } else {
                helper.setTextColor(R.id.tv_item_title, Color.BLACK);
            }
        }
        helper.setText(R.id.tv_item_title, item.getTitle());
        helper.setText(R.id.tv_item_who, item.getAuthor());
        helper.setText(R.id.tv_item_type, item.getChapterName());
        helper.setText(R.id.tv_item_time, item.getNiceDate());
    }
}
