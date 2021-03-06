package com.ltvs.pojo;

import java.util.Date;

/**
 * 用电客户
 * 
 * @Description
 * @date 2019年4月10日 下午5:09:38
 */
public class ElectricityConsumer {
    // 用户编号
    private String yhbh;

    // 用户名称
    private String yhmc;

    // 用电地址
    private String yddz;

    // 小区标识
    private String xqbs;

    // 用电类别代码:100大工业用电;110工商业及其它用电;200普通工业;260非工业;300商业………
    private Integer ydlbdm;

    // 电压等级代码:01交流110V;02交流220V;03交流380V;04交流660V;05交流1000V……
    private Integer dydjdm;

    // 行业分类代码:Z0全社会用电；A00一、农、林、牧、渔业；A0100 1.农业 A0200 2.林业；A0300 3.畜牧业……
    private String hyfldm;

    // 计量方式代码:1高供高计;2高供低计3低供低计
    private Integer jlfsdm;

    // 用户类别代码:10公线专变客户；11专线专变客户；20公变客户；30趸售关口户……
    private Integer yhlbdm;

    // 供电单位编码
    private String gddwbm;

    // 负荷性质代码
    private Integer fhxzdm;

    // 高耗能行业类别代码:101钢铁；102电解铝；103铁合金；104水泥；105电石……
    private Integer ghnhylbdm;

    // 电源类型代码:10 单电源；11 单回路；12 双回路；13 多回路（单电源下的多回路）；20 双电源；21 同站双回路；22 异站双回路；30
    // 多电源；31 同站多回路；32 异站多回路
    private String dylxdm;

    // 销户日期
    private Date xhrq;

    // 用户状态代码:1运行；2销户；3新装；4业务变更；5暂停……
    private Integer yhztdm;

    // 预付费类型代码:0非预付；1预售电；2预付费；3预收
    private Integer yfflxdm;

    // 费控模式代码:1远程；2本地；3卡表；4量控
    private Integer fkmsdm;

    // 付费模式代码:1后付；2预付
    private Integer ffmsdm;

    // 客户分群标志代码:1重要客户；2大客户；3重点关注客户；4居民客户；5其它客户
    private Integer khfqbzdm;

    // 创建时间
    private Date cjsj;

    // 操作时间
    private Date czsj;

    // 三项
    private Integer threeCircuits;

    // 层级
    private Integer hierarchy;

    public Integer getThreeCircuits() {
        return threeCircuits;
    }

    public void setThreeCircuits(Integer threeCircuits) {
        this.threeCircuits = threeCircuits;
    }

    public Integer getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Integer hierarchy) {
        this.hierarchy = hierarchy;
    }

    public String getYhbh() {
        return yhbh;
    }

    public void setYhbh(String yhbh) {
        this.yhbh = yhbh == null ? null : yhbh.trim();
    }

    public String getYhmc() {
        return yhmc;
    }

    public void setYhmc(String yhmc) {
        this.yhmc = yhmc == null ? null : yhmc.trim();
    }

    public String getYddz() {
        return yddz;
    }

    public void setYddz(String yddz) {
        this.yddz = yddz == null ? null : yddz.trim();
    }

    public String getXqbs() {
        return xqbs;
    }

    public void setXqbs(String xqbs) {
        this.xqbs = xqbs == null ? null : xqbs.trim();
    }

    public Integer getYdlbdm() {
        return ydlbdm;
    }

    public void setYdlbdm(Integer ydlbdm) {
        this.ydlbdm = ydlbdm;
    }

    public Integer getDydjdm() {
        return dydjdm;
    }

    public void setDydjdm(Integer dydjdm) {
        this.dydjdm = dydjdm;
    }

    public String getHyfldm() {
        return hyfldm;
    }

    public void setHyfldm(String hyfldm) {
        this.hyfldm = hyfldm == null ? null : hyfldm.trim();
    }

    public Integer getJlfsdm() {
        return jlfsdm;
    }

    public void setJlfsdm(Integer jlfsdm) {
        this.jlfsdm = jlfsdm;
    }

    public Integer getYhlbdm() {
        return yhlbdm;
    }

    public void setYhlbdm(Integer yhlbdm) {
        this.yhlbdm = yhlbdm;
    }

    public String getGddwbm() {
        return gddwbm;
    }

    public void setGddwbm(String gddwbm) {
        this.gddwbm = gddwbm == null ? null : gddwbm.trim();
    }

    public Integer getFhxzdm() {
        return fhxzdm;
    }

    public void setFhxzdm(Integer fhxzdm) {
        this.fhxzdm = fhxzdm;
    }

    public Integer getGhnhylbdm() {
        return ghnhylbdm;
    }

    public void setGhnhylbdm(Integer ghnhylbdm) {
        this.ghnhylbdm = ghnhylbdm;
    }

    public String getDylxdm() {
        return dylxdm;
    }

    public void setDylxdm(String dylxdm) {
        this.dylxdm = dylxdm == null ? null : dylxdm.trim();
    }

    public Date getXhrq() {
        return xhrq;
    }

    public void setXhrq(Date xhrq) {
        this.xhrq = xhrq;
    }

    public Integer getYhztdm() {
        return yhztdm;
    }

    public void setYhztdm(Integer yhztdm) {
        this.yhztdm = yhztdm;
    }

    public Integer getYfflxdm() {
        return yfflxdm;
    }

    public void setYfflxdm(Integer yfflxdm) {
        this.yfflxdm = yfflxdm;
    }

    public Integer getFkmsdm() {
        return fkmsdm;
    }

    public void setFkmsdm(Integer fkmsdm) {
        this.fkmsdm = fkmsdm;
    }

    public Integer getFfmsdm() {
        return ffmsdm;
    }

    public void setFfmsdm(Integer ffmsdm) {
        this.ffmsdm = ffmsdm;
    }

    public Integer getKhfqbzdm() {
        return khfqbzdm;
    }

    public void setKhfqbzdm(Integer khfqbzdm) {
        this.khfqbzdm = khfqbzdm;
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public Date getCzsj() {
        return czsj;
    }

    public void setCzsj(Date czsj) {
        this.czsj = czsj;
    }
}