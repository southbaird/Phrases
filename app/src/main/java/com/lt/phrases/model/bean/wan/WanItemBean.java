package com.lt.phrases.model.bean.wan;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by nq on 2018/3/30.
 * email : 1172921726@qq.com
 */

public class WanItemBean implements Serializable {

    @SerializedName("offset")
    private int offset;
    @SerializedName("size")
    private int size;
    @SerializedName("total")
    private int total;
    @SerializedName("pageCount")
    private int pageCount;
    @SerializedName("curPage")
    private int curPage;
    @SerializedName("over")
    private boolean over;
    @SerializedName("datas")
    private List<WanItemBean.DatasBean> datas;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public List<WanItemBean.DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<WanItemBean.DatasBean> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "WanItemBean{" +
                "offset=" + offset +
                ", size=" + size +
                ", total=" + total +
                ", pageCount=" + pageCount +
                ", curPage=" + curPage +
                ", over=" + over +
                ", datas=" + datas +
                '}';
    }

    public static class DatasBean implements Serializable {
        /**
         * id : 1578
         * title : 这些 Drawable 的小技巧，你都了解吗？
         * chapterId : 168
         * chapterName : Drawable
         * envelopePic : null
         * link : https://juejin.im/post/5a28b2d0f265da431c703153
         * author :  承香墨影
         * origin : null
         * publishTime : 1512660849000
         * zan : null
         * desc : null
         * visible : 1
         * niceDate : 2017-12-07
         * courseId : 13
         * collect : false
         */
        @SerializedName("id")
        private String id;
        @SerializedName("title")
        private String title;
        @SerializedName("chapterId")
        private int chapterId;
        @SerializedName("chapterName")
        private String chapterName;
        @SerializedName("envelopePic")
        private String envelopePic;
        @SerializedName("link")
        private String link;
        @SerializedName("author")
        private String author;
        @SerializedName("origin")
        private String origin;
        @SerializedName("publishTime")
        private long publishTime;
        @SerializedName("zan")
        private String zan;
        @SerializedName("desc")
        private String desc;
        @SerializedName("visible")
        private int visible;
        @SerializedName("niceDate")
        private String niceDate;
        @SerializedName("courseId")
        private int courseId;
        @SerializedName("collect")
        private boolean collect;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public String getZan() {
            return zan;
        }

        public void setZan(String zan) {
            this.zan = zan;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public boolean isCollect() {
            return collect;
        }

        public void setCollect(boolean collect) {
            this.collect = collect;
        }

        @Override
        public String toString() {
            return "DatasBean{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", chapterId=" + chapterId +
                    ", chapterName='" + chapterName + '\'' +
                    ", envelopePic='" + envelopePic + '\'' +
                    ", link='" + link + '\'' +
                    ", author='" + author + '\'' +
                    ", origin='" + origin + '\'' +
                    ", publishTime=" + publishTime +
                    ", zan='" + zan + '\'' +
                    ", desc='" + desc + '\'' +
                    ", visible=" + visible +
                    ", niceDate='" + niceDate + '\'' +
                    ", courseId=" + courseId +
                    ", collect=" + collect +
                    '}';
        }
    }
}
