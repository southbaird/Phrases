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
import com.lt.phrases.model.bean.weixin.WeixinChoiceItemBean;

import java.util.List;

/**
 * Created by nq on 2018/2/10.
 * email : 1172921726@qq.com
 */

public class WeixinAdapter extends BaseCompatAdapter<WeixinChoiceItemBean, BaseViewHolder>{

    public WeixinAdapter(int layoutResId, @Nullable List<WeixinChoiceItemBean> data) {
        super(layoutResId, data);
    }

    public WeixinAdapter(@Nullable List<WeixinChoiceItemBean> data) {
        super(data);
    }

    public WeixinAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, WeixinChoiceItemBean item) {
        if (DBUtils.getDB(mContext).isRead(DBConfig.TABLE_WEIXIN, item.getId(), ItemState
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
        helper.setText(R.id.tv_item_who, item.getSource());
        Glide.with(mContext).load(item.getFirstImg()).crossFade().into((ImageView) helper.getView(R
                .id.iv_item_image));
    }
}
