package com.sxhalo.lmb.domain;

import java.math.BigDecimal;
import java.util.Date;

public class CoalGoodsHis {
    /**
     * 商品发布编号：编号规则（商品id+时间字符串（当前时间转整型））
     */
    private String goodsReleaseNum;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 发布人
     */
    private Long publishUser;

    /**
     * 煤炭商品编号
     */
    private String goodsId;

    /**
     * 信息部id
     */
    private Integer coalSalesId;

    /**
     * 矿口id
     */
    private Integer mineMouthId;

    /**
     * 煤种编码
     */
    private String coalCategoryId;

    /**
     * 煤炭名称
     */
    private String coalName;

    /**
     * 商品图图片代码
     */
    private String coalPicCode;

    /**
     * 煤炭照片
     */
    private String coalPic;

    /**
     * 资讯费，单位：分
     */
    private Integer consultingFee;

    /**
     * 存煤量
     */
    private BigDecimal quantity;

    /**
     * 裸煤价
     */
    private BigDecimal quote;

    /**
     * 一票价
     */
    private BigDecimal oneQuote;

    /**
     * 是否显示一票价
     */
    private Integer isShowOne;

    /**
     * 二票价
     */
    private BigDecimal twoQuote;

    /**
     * 是否显示二票价
     */
    private Integer isShowTwo;

    /**
     * 装车费用
     */
    private BigDecimal loadingExpense;

    /**
     * 报价说明
     */
    private String description;

    /**
     * 加工工艺：炮采、机采、综采、掘进、分选、水洗、过筛等（字典表）
     */
    private String technology;

    /**
     * 发热量
     */
    private Integer calorificValue;

    /**
     * 全水份
     */
    private BigDecimal totalMoisture;

    /**
     * 全硫份
     */
    private BigDecimal totalSulfur;

    /**
     * 挥发份
     */
    private BigDecimal volatileValue;

    /**
     * 固定碳
     */
    private BigDecimal fixedCarbon;

    /**
     * 粒度
     */
    private String grainSize;

    /**
     * 灰分
     */
    private BigDecimal ashValue;

    /**
     * 化验单照片代码
     */
    private String coalReportPicCode;

    /**
     * 化验单照片
     */
    private String coalReportPic;

    /**
     * 化验单位
     */
    private String coalReportInstitution;

    /**
     * 化验时间
     */
    private Date coalReportTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 数据来源; 0默认，1数据平台
     */
    private Integer dataSource;
    
    private CoalGoods coalGoods;

    public String getGoodsReleaseNum() {
        return goodsReleaseNum;
    }

    public void setGoodsReleaseNum(String goodsReleaseNum) {
        this.goodsReleaseNum = goodsReleaseNum == null ? null : goodsReleaseNum.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Long getPublishUser() {
        return publishUser;
    }

    public void setPublishUser(Long publishUser) {
        this.publishUser = publishUser;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public Integer getCoalSalesId() {
        return coalSalesId;
    }

    public void setCoalSalesId(Integer coalSalesId) {
        this.coalSalesId = coalSalesId;
    }

    public Integer getMineMouthId() {
        return mineMouthId;
    }

    public void setMineMouthId(Integer mineMouthId) {
        this.mineMouthId = mineMouthId;
    }

    public String getCoalCategoryId() {
        return coalCategoryId;
    }

    public void setCoalCategoryId(String coalCategoryId) {
        this.coalCategoryId = coalCategoryId == null ? null : coalCategoryId.trim();
    }

    public String getCoalName() {
        return coalName;
    }

    public void setCoalName(String coalName) {
        this.coalName = coalName == null ? null : coalName.trim();
    }

    public String getCoalPicCode() {
        return coalPicCode;
    }

    public void setCoalPicCode(String coalPicCode) {
        this.coalPicCode = coalPicCode == null ? null : coalPicCode.trim();
    }

    public String getCoalPic() {
        return coalPic;
    }

    public void setCoalPic(String coalPic) {
        this.coalPic = coalPic == null ? null : coalPic.trim();
    }

    public Integer getConsultingFee() {
        return consultingFee;
    }

    public void setConsultingFee(Integer consultingFee) {
        this.consultingFee = consultingFee;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getQuote() {
        return quote;
    }

    public void setQuote(BigDecimal quote) {
        this.quote = quote;
    }

    public BigDecimal getOneQuote() {
        return oneQuote;
    }

    public void setOneQuote(BigDecimal oneQuote) {
        this.oneQuote = oneQuote;
    }

    public Integer getIsShowOne() {
        return isShowOne;
    }

    public void setIsShowOne(Integer isShowOne) {
        this.isShowOne = isShowOne;
    }

    public BigDecimal getTwoQuote() {
        return twoQuote;
    }

    public void setTwoQuote(BigDecimal twoQuote) {
        this.twoQuote = twoQuote;
    }

    public Integer getIsShowTwo() {
        return isShowTwo;
    }

    public void setIsShowTwo(Integer isShowTwo) {
        this.isShowTwo = isShowTwo;
    }

    public BigDecimal getLoadingExpense() {
        return loadingExpense;
    }

    public void setLoadingExpense(BigDecimal loadingExpense) {
        this.loadingExpense = loadingExpense;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology == null ? null : technology.trim();
    }

    public Integer getCalorificValue() {
        return calorificValue;
    }

    public void setCalorificValue(Integer calorificValue) {
        this.calorificValue = calorificValue;
    }

    public BigDecimal getTotalMoisture() {
        return totalMoisture;
    }

    public void setTotalMoisture(BigDecimal totalMoisture) {
        this.totalMoisture = totalMoisture;
    }

    public BigDecimal getTotalSulfur() {
        return totalSulfur;
    }

    public void setTotalSulfur(BigDecimal totalSulfur) {
        this.totalSulfur = totalSulfur;
    }

    public BigDecimal getVolatileValue() {
        return volatileValue;
    }

    public void setVolatileValue(BigDecimal volatileValue) {
        this.volatileValue = volatileValue;
    }

    public BigDecimal getFixedCarbon() {
        return fixedCarbon;
    }

    public void setFixedCarbon(BigDecimal fixedCarbon) {
        this.fixedCarbon = fixedCarbon;
    }

    public String getGrainSize() {
        return grainSize;
    }

    public void setGrainSize(String grainSize) {
        this.grainSize = grainSize == null ? null : grainSize.trim();
    }

    public BigDecimal getAshValue() {
        return ashValue;
    }

    public void setAshValue(BigDecimal ashValue) {
        this.ashValue = ashValue;
    }

    public String getCoalReportPicCode() {
        return coalReportPicCode;
    }

    public void setCoalReportPicCode(String coalReportPicCode) {
        this.coalReportPicCode = coalReportPicCode == null ? null : coalReportPicCode.trim();
    }

    public String getCoalReportPic() {
        return coalReportPic;
    }

    public void setCoalReportPic(String coalReportPic) {
        this.coalReportPic = coalReportPic == null ? null : coalReportPic.trim();
    }

    public String getCoalReportInstitution() {
        return coalReportInstitution;
    }

    public void setCoalReportInstitution(String coalReportInstitution) {
        this.coalReportInstitution = coalReportInstitution == null ? null : coalReportInstitution.trim();
    }

    public Date getCoalReportTime() {
        return coalReportTime;
    }

    public void setCoalReportTime(Date coalReportTime) {
        this.coalReportTime = coalReportTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getDataSource() {
        return dataSource;
    }

    public void setDataSource(Integer dataSource) {
        this.dataSource = dataSource;
    }

	public CoalGoods getCoalGoods() {
		return coalGoods;
	}

	public void setCoalGoods(CoalGoods coalGoods) {
		this.coalGoods = coalGoods;
	}
    
}