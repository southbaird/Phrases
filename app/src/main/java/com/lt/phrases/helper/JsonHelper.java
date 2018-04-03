package com.lt.phrases.helper;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lt.library.utils.JsonUtils;
import com.lt.phrases.model.bean.wangyi.WangyiNewsDetailBean;
import com.lt.phrases.model.bean.wangyi.WangyiNewsItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nq on 2018/3/10.
 * email : 1172921726@qq.com
 */

public class JsonHelper {
    /**
     * 将获取到的json转换为新闻列表对象
     * @param res
     * @param value
     * @return
     */
    public static List<WangyiNewsItemBean> readJsonNewsBeans(String res, String value) {
        List<WangyiNewsItemBean> beans = new ArrayList<WangyiNewsItemBean>();
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObj = parser.parse(res).getAsJsonObject();
            JsonElement jsonElement = jsonObj.get(value);
            if(jsonElement == null) {
                return null;
            }
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (int i = 1; i < jsonArray.size(); i++) {
                JsonObject jo = jsonArray.get(i).getAsJsonObject();
                if (jo.has("skipType") && "special".equals(jo.get("skipType").getAsString())) {
                    continue;
                }
                if (jo.has("TAGS") && !jo.has("TAG")) {
                    continue;
                }

                if (!jo.has("imgextra")) {
                    WangyiNewsItemBean news = JsonUtils.deserialize(jo, WangyiNewsItemBean.class);
                    beans.add(news);
                }
            }
        } catch (Exception e) {
        }
        return beans;
    }

    public static WangyiNewsDetailBean getNewsDetailBeans(String res, String docId) {
        WangyiNewsDetailBean newsDetailBean = null;
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObj = parser.parse(res).getAsJsonObject();
            JsonElement jsonElement = jsonObj.get(docId);
            if(jsonElement == null) {
                return null;
            }
            newsDetailBean = JsonUtils.deserialize(jsonElement.getAsJsonObject(), WangyiNewsDetailBean.class);
        } catch (Exception e) {
        }
        return newsDetailBean;
    }
}
