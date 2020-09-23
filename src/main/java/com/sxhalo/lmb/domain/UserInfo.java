package com.sxhalo.lmb.domain;

import java.math.BigDecimal;
import java.util.Date;

public class UserInfo {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 密码:6~18位
     */
    private String userPwd;

    /**
     * 头像照片代码
     */
    private String headPicCode;

    /**
     * 头像
     */
    private Integer headPortrait;

    /**
     * 移动电话
     */
    private String userMobile;

    /**
     * 机器码
     */
    private String machineCode;

    /**
     * 行政区划代码
     */
    private Integer regionCode;

    /**
     * 余额，单位：分
     */
    private Integer money;

    /**
     * 拉煤宝账户余额，单位：分
     */
    private Integer moneyLmb;

    /**
     * 总积分
     */
    private Integer totalPoints;

    /**
     * 剩余积分
     */
    private Integer remainingPoints;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 信用等级
     */
    private Integer creditRating;

    /**
     * 信息部认证状态：0、未认证；1、已认证；
     */
    private Integer coalSalesAuthState;

    /**
     * 信息部认证通过
     */
    private Date coalSalesAuthPassTime;

    /**
     * 所属信息部编号
     */
    private Integer coalSalesId;

    /**
     * 实名认证状态：0，未认证；1，已认证
     */
    private Integer realnameAuthState;

    /**
     * 实名认证通过时间
     */
    private Date realnameAuthPassTime;

    /**
     * 身份证号码
     */
    private String identitycardId;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 出生年月
     */
    private Date userBirth;

    /**
     * 身份证正面照片代码
     */
    private String identitycardFrontPicCode;

    /**
     * 身份证正面照片
     */
    private Integer identitycardFront;

    /**
     * 身份证反面照片代码
     */
    private String identitycardBackPicCode;

    /**
     * 身份证反面照片
     */
    private Integer identitycardBack;

    /**
     * 司机身份认证状态：0、未认证，1、登记，2、认证成功 
     */
    private Integer driverAuthState;

    /**
     * 司机信息登记时间
     */
    private Date driverAuthRegistTime;

    /**
     * 司机认证通过时间
     */
    private Date driverAuthPassTime;

    /**
     * 司机登记姓名
     */
    private String driverRegisterName;

    /**
     * 驾驶证号
     */
    private String driverLicenseId;

    /**
     * 驾驶证正面照片代码
     */
    private String driverLicensePicCode;

    /**
     * 驾驶证正面照片
     */
    private Integer driverLicensePic;

    /**
     * 驾驶证初次领证时间
     */
    private Date driverLicenseInitialTime;

    /**
     * 驾驶证发证日期
     */
    private Date driverLicenseIssueDate;

    /**
     * 驾驶证类型：A1，A2等
     */
    private String driverLicenseType;

    /**
     * 是否专线司机： 0、否；1、是
     */
    private Integer specialLine;

    /**
     * 专线起始地
     */
    private Integer startRegion;

    /**
     * 专线结束地
     */
    private Integer endRegion;

    /**
     * 司机身份信息是否公开：0、不公开；1、公开
     */
    private Integer isShow;

    /**
     * 司机接单状态更新时间：根据司机货运单状态变化而更新
     */
    private Date driverStateUpdateTime;

    /**
     * 司机接单状态：0，未知（登记司机均为未知）；1，空闲；2，忙碌(有进行中的货运单，即为忙碌，用户状态根据货运单状态联动)
     */
    private Integer driverState;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 推荐人手机号码
     */
    private String recommend;

    /**
     * 最新一次使用时间：最新一次启动app的时间
     */
    private Date latestUseTime;

    /**
     * 启用状态：0、禁用；1、启用；100、未激活（后台注册用户，当用户首次登录后自动激活）
     */
    private Integer userState;

    /**
     * 创建时间：用户注册时间
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
     * 接收消息推送：0、否；1、是
     */
    private Integer messagePush;

    /**
     * 备注
     */
    private String remark;

    /**
     * QQ
     */
    private String userQq;

    /**
     * qq登陆授权证书号
     */
    private String qqCredential;

    /**
     * 微博
     */
    private String weibo;

    /**
     * 微博登陆授权证书号
     */
    private String weiboCredential;

    /**
     * 微信号
     */
    private String userWechat;

    /**
     * 用户微信在公众号内的openid
     */
    private String wxOpenid;

    /**
     * 快煤宝微信昵称，在快煤宝商户平台绑定的用户微信昵称
     */
    private String wxNicknameKmb;

    /**
     * 用户微信在拉煤包商户平台绑定的openid
     */
    private String wxOpenidLmb;

    /**
     * 微信登陆授权证书号
     */
    private String wechatCredential;

    /**
     * Email
     */
    private String userEmail;

    /**
     * 获取途径
     */
    private String obtainApproach;

    /**
     * 微信同步 0关闭，1打开
     */
    private Integer wechatSync;

    /**
     * 拉煤宝同步 0关闭，1打开
     */
    private Integer lmbSync;

    /**
     * 身份标识;1买家，2卖家，3司机，4其他
     */
    private Integer identityFlag;

    /**
     * 数据来源; 0默认，1数据平台
     */
    private Integer dataSource;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getHeadPicCode() {
        return headPicCode;
    }

    public void setHeadPicCode(String headPicCode) {
        this.headPicCode = headPicCode == null ? null : headPicCode.trim();
    }

    public Integer getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(Integer headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode == null ? null : machineCode.trim();
    }

    public Integer getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getMoneyLmb() {
        return moneyLmb;
    }

    public void setMoneyLmb(Integer moneyLmb) {
        this.moneyLmb = moneyLmb;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Integer getRemainingPoints() {
        return remainingPoints;
    }

    public void setRemainingPoints(Integer remainingPoints) {
        this.remainingPoints = remainingPoints;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(Integer creditRating) {
        this.creditRating = creditRating;
    }

    public Integer getCoalSalesAuthState() {
        return coalSalesAuthState;
    }

    public void setCoalSalesAuthState(Integer coalSalesAuthState) {
        this.coalSalesAuthState = coalSalesAuthState;
    }

    public Date getCoalSalesAuthPassTime() {
        return coalSalesAuthPassTime;
    }

    public void setCoalSalesAuthPassTime(Date coalSalesAuthPassTime) {
        this.coalSalesAuthPassTime = coalSalesAuthPassTime;
    }

    public Integer getCoalSalesId() {
        return coalSalesId;
    }

    public void setCoalSalesId(Integer coalSalesId) {
        this.coalSalesId = coalSalesId;
    }

    public Integer getRealnameAuthState() {
        return realnameAuthState;
    }

    public void setRealnameAuthState(Integer realnameAuthState) {
        this.realnameAuthState = realnameAuthState;
    }

    public Date getRealnameAuthPassTime() {
        return realnameAuthPassTime;
    }

    public void setRealnameAuthPassTime(Date realnameAuthPassTime) {
        this.realnameAuthPassTime = realnameAuthPassTime;
    }

    public String getIdentitycardId() {
        return identitycardId;
    }

    public void setIdentitycardId(String identitycardId) {
        this.identitycardId = identitycardId == null ? null : identitycardId.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public String getIdentitycardFrontPicCode() {
        return identitycardFrontPicCode;
    }

    public void setIdentitycardFrontPicCode(String identitycardFrontPicCode) {
        this.identitycardFrontPicCode = identitycardFrontPicCode == null ? null : identitycardFrontPicCode.trim();
    }

    public Integer getIdentitycardFront() {
        return identitycardFront;
    }

    public void setIdentitycardFront(Integer identitycardFront) {
        this.identitycardFront = identitycardFront;
    }

    public String getIdentitycardBackPicCode() {
        return identitycardBackPicCode;
    }

    public void setIdentitycardBackPicCode(String identitycardBackPicCode) {
        this.identitycardBackPicCode = identitycardBackPicCode == null ? null : identitycardBackPicCode.trim();
    }

    public Integer getIdentitycardBack() {
        return identitycardBack;
    }

    public void setIdentitycardBack(Integer identitycardBack) {
        this.identitycardBack = identitycardBack;
    }

    public Integer getDriverAuthState() {
        return driverAuthState;
    }

    public void setDriverAuthState(Integer driverAuthState) {
        this.driverAuthState = driverAuthState;
    }

    public Date getDriverAuthRegistTime() {
        return driverAuthRegistTime;
    }

    public void setDriverAuthRegistTime(Date driverAuthRegistTime) {
        this.driverAuthRegistTime = driverAuthRegistTime;
    }

    public Date getDriverAuthPassTime() {
        return driverAuthPassTime;
    }

    public void setDriverAuthPassTime(Date driverAuthPassTime) {
        this.driverAuthPassTime = driverAuthPassTime;
    }

    public String getDriverRegisterName() {
        return driverRegisterName;
    }

    public void setDriverRegisterName(String driverRegisterName) {
        this.driverRegisterName = driverRegisterName == null ? null : driverRegisterName.trim();
    }

    public String getDriverLicenseId() {
        return driverLicenseId;
    }

    public void setDriverLicenseId(String driverLicenseId) {
        this.driverLicenseId = driverLicenseId == null ? null : driverLicenseId.trim();
    }

    public String getDriverLicensePicCode() {
        return driverLicensePicCode;
    }

    public void setDriverLicensePicCode(String driverLicensePicCode) {
        this.driverLicensePicCode = driverLicensePicCode == null ? null : driverLicensePicCode.trim();
    }

    public Integer getDriverLicensePic() {
        return driverLicensePic;
    }

    public void setDriverLicensePic(Integer driverLicensePic) {
        this.driverLicensePic = driverLicensePic;
    }

    public Date getDriverLicenseInitialTime() {
        return driverLicenseInitialTime;
    }

    public void setDriverLicenseInitialTime(Date driverLicenseInitialTime) {
        this.driverLicenseInitialTime = driverLicenseInitialTime;
    }

    public Date getDriverLicenseIssueDate() {
        return driverLicenseIssueDate;
    }

    public void setDriverLicenseIssueDate(Date driverLicenseIssueDate) {
        this.driverLicenseIssueDate = driverLicenseIssueDate;
    }

    public String getDriverLicenseType() {
        return driverLicenseType;
    }

    public void setDriverLicenseType(String driverLicenseType) {
        this.driverLicenseType = driverLicenseType == null ? null : driverLicenseType.trim();
    }

    public Integer getSpecialLine() {
        return specialLine;
    }

    public void setSpecialLine(Integer specialLine) {
        this.specialLine = specialLine;
    }

    public Integer getStartRegion() {
        return startRegion;
    }

    public void setStartRegion(Integer startRegion) {
        this.startRegion = startRegion;
    }

    public Integer getEndRegion() {
        return endRegion;
    }

    public void setEndRegion(Integer endRegion) {
        this.endRegion = endRegion;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Date getDriverStateUpdateTime() {
        return driverStateUpdateTime;
    }

    public void setDriverStateUpdateTime(Date driverStateUpdateTime) {
        this.driverStateUpdateTime = driverStateUpdateTime;
    }

    public Integer getDriverState() {
        return driverState;
    }

    public void setDriverState(Integer driverState) {
        this.driverState = driverState;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend == null ? null : recommend.trim();
    }

    public Date getLatestUseTime() {
        return latestUseTime;
    }

    public void setLatestUseTime(Date latestUseTime) {
        this.latestUseTime = latestUseTime;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
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

    public Integer getMessagePush() {
        return messagePush;
    }

    public void setMessagePush(Integer messagePush) {
        this.messagePush = messagePush;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq == null ? null : userQq.trim();
    }

    public String getQqCredential() {
        return qqCredential;
    }

    public void setQqCredential(String qqCredential) {
        this.qqCredential = qqCredential == null ? null : qqCredential.trim();
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo == null ? null : weibo.trim();
    }

    public String getWeiboCredential() {
        return weiboCredential;
    }

    public void setWeiboCredential(String weiboCredential) {
        this.weiboCredential = weiboCredential == null ? null : weiboCredential.trim();
    }

    public String getUserWechat() {
        return userWechat;
    }

    public void setUserWechat(String userWechat) {
        this.userWechat = userWechat == null ? null : userWechat.trim();
    }

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid == null ? null : wxOpenid.trim();
    }

    public String getWxNicknameKmb() {
        return wxNicknameKmb;
    }

    public void setWxNicknameKmb(String wxNicknameKmb) {
        this.wxNicknameKmb = wxNicknameKmb == null ? null : wxNicknameKmb.trim();
    }

    public String getWxOpenidLmb() {
        return wxOpenidLmb;
    }

    public void setWxOpenidLmb(String wxOpenidLmb) {
        this.wxOpenidLmb = wxOpenidLmb == null ? null : wxOpenidLmb.trim();
    }

    public String getWechatCredential() {
        return wechatCredential;
    }

    public void setWechatCredential(String wechatCredential) {
        this.wechatCredential = wechatCredential == null ? null : wechatCredential.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getObtainApproach() {
        return obtainApproach;
    }

    public void setObtainApproach(String obtainApproach) {
        this.obtainApproach = obtainApproach == null ? null : obtainApproach.trim();
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

    public Integer getIdentityFlag() {
        return identityFlag;
    }

    public void setIdentityFlag(Integer identityFlag) {
        this.identityFlag = identityFlag;
    }

    public Integer getDataSource() {
        return dataSource;
    }

    public void setDataSource(Integer dataSource) {
        this.dataSource = dataSource;
    }
}