package com.sxhalo.lmb.domain;

import java.util.Date;

public class OperateArticle {
    /**
     * 文章编号
     */
    private Integer articleId;

    /**
     * 栏目编号
     */
    private Integer categoryId;

    /**
     * 标题
     */
    private String title;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 文章来源
     */
    private String source;

    /**
     * 作者
     */
    private String author;

    /**
     * 编辑人
     */
    private String editor;

    /**
     * 发布地址
     */
    private String publishUrl;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 发布状态：0、未发布 ；1、已发布 
     */
    private Integer publishState;

    /**
     * 内容列表缩略图
     */
    private String tumbPicCode;

    /**
     * 内容列表缩略图
     */
    private String tumbPicCode2;

    /**
     * 内容列表缩略图
     */
    private String tumbPicCode3;

    /**
     * 缩略图
     */
    private String tumb;

    /**
     * 视频地址
     */
    private String videoAddress;

    /**
     * 点击量
     */
    private Integer clickNum;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否头条：1是0不是
     */
    private Integer isSpecial;

    /**
     * 是否推送消息
     */
    private Integer isSend;

    /**
     * 是否图文
     */
    private Integer isPicture;

    /**
     * 附件
     */
    private String enclosure;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标记：0，未删除；1、已删除
     */
    private Integer deleteFlag;

    /**
     * 文章内容
     */
    private String content;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor == null ? null : editor.trim();
    }

    public String getPublishUrl() {
        return publishUrl;
    }

    public void setPublishUrl(String publishUrl) {
        this.publishUrl = publishUrl == null ? null : publishUrl.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getPublishState() {
        return publishState;
    }

    public void setPublishState(Integer publishState) {
        this.publishState = publishState;
    }

    public String getTumbPicCode() {
        return tumbPicCode;
    }

    public void setTumbPicCode(String tumbPicCode) {
        this.tumbPicCode = tumbPicCode == null ? null : tumbPicCode.trim();
    }

    public String getTumbPicCode2() {
        return tumbPicCode2;
    }

    public void setTumbPicCode2(String tumbPicCode2) {
        this.tumbPicCode2 = tumbPicCode2 == null ? null : tumbPicCode2.trim();
    }

    public String getTumbPicCode3() {
        return tumbPicCode3;
    }

    public void setTumbPicCode3(String tumbPicCode3) {
        this.tumbPicCode3 = tumbPicCode3 == null ? null : tumbPicCode3.trim();
    }

    public String getTumb() {
        return tumb;
    }

    public void setTumb(String tumb) {
        this.tumb = tumb == null ? null : tumb.trim();
    }

    public String getVideoAddress() {
        return videoAddress;
    }

    public void setVideoAddress(String videoAddress) {
        this.videoAddress = videoAddress == null ? null : videoAddress.trim();
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(Integer isSpecial) {
        this.isSpecial = isSpecial;
    }

    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    public Integer getIsPicture() {
        return isPicture;
    }

    public void setIsPicture(Integer isPicture) {
        this.isPicture = isPicture;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure == null ? null : enclosure.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}