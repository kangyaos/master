package com.jiaoda.edu.domain;

import java.util.Date;

public class OperateArticle {
    private Integer articleId;

    private Integer categoryId;
    private String categoryName;
    private String title;

    private String summary;

    private String source;

    private String author;

    private String editor;

    private String publishUrl;

    private Date publishTime;

    private Integer publishState;

    private String tumbPicCode;

    private String tumbPicCode2;

    private String tumbPicCode3;

    private String tumb;

    private String videoAddress;

    private Integer clickNum;

    private Integer sort;



    private Integer isSend;

    private Integer isPicture;

    private String enclosure;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private String content;
   private Integer indexShow;
    
    public Integer getIndexShow() {
		return indexShow;
	}

	public void setIndexShow(Integer indexShow) {
		this.indexShow = indexShow;
	}
    public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

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