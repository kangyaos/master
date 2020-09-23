package com.sxhalo.lmb.domain;

import java.math.BigDecimal;
import java.util.Date;

public class CoalGoods {
    /**
     * 商品id：编码规则（信息部编号+矿口编号+煤种编号+四位顺序号）
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
     * 商品发布编号：编号规则（商品id+时间字符串（当前时间转整型））
     */
    private String goodsReleaseNum;

    /**
     * 商品名称
     */
    private String coalName;

    /**
     * 商品图图片代码
     */
    private String coalPicCode;

    /**
     * 商品图:弃用
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
     * 是否显示裸煤价  0否 1是
     */
    private Integer isShowOne;

    /**
     * 二票价
     */
    private BigDecimal twoQuote;

    /**
     * 是否显示二票价  0否 1是
     */
    private Integer isShowTwo;

    /**
     * 装车费用
     */
    private BigDecimal loadingExpense;

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
     * 发布人
     */
    private String publishUser;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 发布状态：0 未发布; 1 已发布 
     */
    private Integer publishState;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标记
     */
    private Integer deleteFlag;

    /**
     * 微信同步 0关闭，1打开
     */
    private Integer wechatSync;

    /**
     * 拉煤宝同步 0关闭，1打开
     */
    private Integer lmbSync;

    /**
     * 数据来源; 0默认，1数据平台
     */
    private Integer dataSource;
    
	private String technologyName;
	
	private String  reportTime;
	
	private CoalCompanies companies;
	
	private CoalSales sales;
	
	private UserInfo userInfo;

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

    public String getGoodsReleaseNum() {
        return goodsReleaseNum;
    }

    public void setGoodsReleaseNum(String goodsReleaseNum) {
        this.goodsReleaseNum = goodsReleaseNum == null ? null : goodsReleaseNum.trim();
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

    public String getPublishUser() {
        return publishUser;
    }

    public void setPublishUser(String publishUser) {
        this.publishUser = publishUser == null ? null : publishUser.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Integer getWechatSync() {
        return wechatSync;
    }

    public void setWechatSync(Integer wechatSync) {
        this.wechatSync = wechatSync;
    }

    public Integer getLmbSync() {
        return lmbSync;
    }

    public void setLmbSync(Integer lmbSync) {
        this.lmbSync = lmbSync;
    }

    public Integer getDataSource() {
        return dataSource;
    }

    public void setDataSource(Integer dataSource) {
        this.dataSource = dataSource;
    }

	public String getMineMouthName() {
		return companies==null?"":companies.getMineMouthName();
	}

	public String getCompanyName() {
		return sales==null?"":sales.getCompanyName();
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public String getReportTime() {
		return reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}

	public CoalCompanies getCompanies() {
		return companies;
	}

	public void setCompanies(CoalCompanies companies) {
		this.companies = companies;
	}

	public CoalSales getSales() {
		return sales;
	}

	public void setSales(CoalSales sales) {
		this.sales = sales;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
    
}