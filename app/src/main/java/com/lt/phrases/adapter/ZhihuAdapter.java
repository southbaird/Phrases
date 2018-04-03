package com.lt.phrases.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lt.library.config.DBConfig;
import com.lt.library.config.ItemState;
import com.lt.library.utils.DBUtils;
import com.lt.library.utils.SpUtils;
import com.lt.phrases.R;
import com.lt.phrases.model.bean.zhihu.ZhihuDailyItemBean;

import java.util.List;

/**
 * Created by nq on 2018/1/27.
 * email : 1172921726@qq.com
 */

public class ZhihuAdapter extends BaseCompatAdapter<ZhihuDailyItemBean, BaseViewHolder>{

    public ZhihuAdapter(int layoutResId, @Nullable List<ZhihuDailyItemBean> data) {
        super(layoutResId, data);
    }

    public ZhihuAdapter(@Nullable List<ZhihuDailyItemBean> data) {
        super(data);
    }

    public ZhihuAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhihuDailyItemBean item) {
        if (DBUtils.getDB(mContext).isRead(DBConfig.TABLE_ZHIHU, item.getId(), ItemState
                .STATE_IS_READ)) {
            helper.setTextColor(R.id.tv_item_title, Color.GRAY);
        } else {
            if (SpUtils.getNightModel(mContext)) {
                helper.setTextColor(R.id.tv_item_title, Color.WHITE);
            } else {
                helper.setTextColor(R.id.tv_item_title, Color.BLACK);
            }
        }
        helper.setText(R.id.tv_item_title, item.getTitle());
        Glide.with(mContext).load(item.getImages()[0]).crossFade().into((ImageView) helper.getView(R
                .id.iv_item_image));
    }
}
