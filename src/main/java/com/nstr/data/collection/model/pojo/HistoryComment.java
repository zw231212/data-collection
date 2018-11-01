/*
*
* HistoryComment.java
* Copyright(C) 2017-2020 http://www.escience.org.cn
* @date 2018-11-01
*/
package com.nstr.data.collection.model.pojo;

import java.util.Date;

public class HistoryComment {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String account;

    /**
     * 
     */
    private String browser;

    /**
     * 
     */
    private String browserType;

    /**
     * 
     */
    private String browserVersion;

    /**
     * 
     */
    private String contact;

    /**
     * 
     */
    private Long createTime;

    /**
     * 
     */
    private String ipaddr;

    /**
     * 
     */
    private Double lat;

    /**
     * 
     */
    private Double lng;

    /**
     * 
     */
    private String os;

    /**
     * 
     */
    private String osType;

    /**
     * 
     */
    private String osVersion;

    /**
     * 国家或者地区
     */
    private String area;

    /**
     * 省份或者州
     */
    private String province;

    /**
     * 县市或者城市
     */
    private String region;

    /**
     * 
     */
    private String referrer;

    /**
     * 
     */
    private String resourceid;

    /**
     * 
     */
    private Float score;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private String url;

    /**
     * 
     */
    private String userid;

    /**
     * 
     */
    private String userAgent;

    /**
     * 
     */
    private String clientLang;

    /**
     * 备份表生成时间
     */
    private Date generationTime;

    /**
     * 备份表名称
     */
    private String tableName;

    /**
     * 全局id，根据表名+每个表里面的id生成
     */
    private String gid;

    /**
     * 
     */
    private String content;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return account 
     */
    public String getAccount() {
        return account;
    }

    /**
     * 
     * @param account 
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 
     * @return browser 
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * 
     * @param browser 
     */
    public void setBrowser(String browser) {
        this.browser = browser == null ? null : browser.trim();
    }

    /**
     * 
     * @return browser_type 
     */
    public String getBrowserType() {
        return browserType;
    }

    /**
     * 
     * @param browserType 
     */
    public void setBrowserType(String browserType) {
        this.browserType = browserType == null ? null : browserType.trim();
    }

    /**
     * 
     * @return browser_version 
     */
    public String getBrowserVersion() {
        return browserVersion;
    }

    /**
     * 
     * @param browserVersion 
     */
    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion == null ? null : browserVersion.trim();
    }

    /**
     * 
     * @return contact 
     */
    public String getContact() {
        return contact;
    }

    /**
     * 
     * @param contact 
     */
    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    /**
     * 
     * @return create_time 
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return ipaddr 
     */
    public String getIpaddr() {
        return ipaddr;
    }

    /**
     * 
     * @param ipaddr 
     */
    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr == null ? null : ipaddr.trim();
    }

    /**
     * 
     * @return lat 
     */
    public Double getLat() {
        return lat;
    }

    /**
     * 
     * @param lat 
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * 
     * @return lng 
     */
    public Double getLng() {
        return lng;
    }

    /**
     * 
     * @param lng 
     */
    public void setLng(Double lng) {
        this.lng = lng;
    }

    /**
     * 
     * @return os 
     */
    public String getOs() {
        return os;
    }

    /**
     * 
     * @param os 
     */
    public void setOs(String os) {
        this.os = os == null ? null : os.trim();
    }

    /**
     * 
     * @return os_type 
     */
    public String getOsType() {
        return osType;
    }

    /**
     * 
     * @param osType 
     */
    public void setOsType(String osType) {
        this.osType = osType == null ? null : osType.trim();
    }

    /**
     * 
     * @return os_version 
     */
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * 
     * @param osVersion 
     */
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion == null ? null : osVersion.trim();
    }

    /**
     * 国家或者地区
     * @return area 国家或者地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 国家或者地区
     * @param area 国家或者地区
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 省份或者州
     * @return province 省份或者州
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省份或者州
     * @param province 省份或者州
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 县市或者城市
     * @return region 县市或者城市
     */
    public String getRegion() {
        return region;
    }

    /**
     * 县市或者城市
     * @param region 县市或者城市
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * 
     * @return referrer 
     */
    public String getReferrer() {
        return referrer;
    }

    /**
     * 
     * @param referrer 
     */
    public void setReferrer(String referrer) {
        this.referrer = referrer == null ? null : referrer.trim();
    }

    /**
     * 
     * @return resourceid 
     */
    public String getResourceid() {
        return resourceid;
    }

    /**
     * 
     * @param resourceid 
     */
    public void setResourceid(String resourceid) {
        this.resourceid = resourceid == null ? null : resourceid.trim();
    }

    /**
     * 
     * @return score 
     */
    public Float getScore() {
        return score;
    }

    /**
     * 
     * @param score 
     */
    public void setScore(Float score) {
        this.score = score;
    }

    /**
     * 
     * @return title 
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 
     * @return url 
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url 
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 
     * @return userid 
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 
     * @param userid 
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * 
     * @return user_agent 
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * 
     * @param userAgent 
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }

    /**
     * 
     * @return client_lang 
     */
    public String getClientLang() {
        return clientLang;
    }

    /**
     * 
     * @param clientLang 
     */
    public void setClientLang(String clientLang) {
        this.clientLang = clientLang == null ? null : clientLang.trim();
    }

    /**
     * 备份表生成时间
     * @return generation_time 备份表生成时间
     */
    public Date getGenerationTime() {
        return generationTime;
    }

    /**
     * 备份表生成时间
     * @param generationTime 备份表生成时间
     */
    public void setGenerationTime(Date generationTime) {
        this.generationTime = generationTime;
    }

    /**
     * 备份表名称
     * @return table_name 备份表名称
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 备份表名称
     * @param tableName 备份表名称
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * 全局id，根据表名+每个表里面的id生成
     * @return gid 全局id，根据表名+每个表里面的id生成
     */
    public String getGid() {
        return gid;
    }

    /**
     * 全局id，根据表名+每个表里面的id生成
     * @param gid 全局id，根据表名+每个表里面的id生成
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * 
     * @return content 
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content 
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}