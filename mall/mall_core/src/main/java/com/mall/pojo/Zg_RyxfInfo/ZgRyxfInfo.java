package com.mall.pojo.Zg_RyxfInfo;

import java.io.Serializable;
import java.util.Date;

public class ZgRyxfInfo implements Serializable {
    private String ryxfid;

    private String ryzh;

    private String bmid;

    private String stid;

    private String grpid;

    private String bzid;

    private String ckjid;

    private String zflb;

    private String cbid;

    private String keyh;

    private String cmc;

    private String xfje;

    private String dj;

    private String sl;

    private String ye;

    private String xfrq;

    private String xfsj;

    private String bj;

    private String czybh;

    private Date czsj;

    private String chjcbz;

    private String jqm;

    private String zkl;

    private String sjxfje;

    private static final long serialVersionUID = 1L;

    public String getRyxfid() {
        return ryxfid;
    }

    public void setRyxfid(String ryxfid) {
        this.ryxfid = ryxfid == null ? null : ryxfid.trim();
    }

    public String getRyzh() {
        return ryzh;
    }

    public void setRyzh(String ryzh) {
        this.ryzh = ryzh == null ? null : ryzh.trim();
    }

    public String getBmid() {
        return bmid;
    }

    public void setBmid(String bmid) {
        this.bmid = bmid == null ? null : bmid.trim();
    }

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid == null ? null : stid.trim();
    }

    public String getGrpid() {
        return grpid;
    }

    public void setGrpid(String grpid) {
        this.grpid = grpid == null ? null : grpid.trim();
    }

    public String getBzid() {
        return bzid;
    }

    public void setBzid(String bzid) {
        this.bzid = bzid == null ? null : bzid.trim();
    }

    public String getCkjid() {
        return ckjid;
    }

    public void setCkjid(String ckjid) {
        this.ckjid = ckjid == null ? null : ckjid.trim();
    }

    public String getZflb() {
        return zflb;
    }

    public void setZflb(String zflb) {
        this.zflb = zflb == null ? null : zflb.trim();
    }

    public String getCbid() {
        return cbid;
    }

    public void setCbid(String cbid) {
        this.cbid = cbid == null ? null : cbid.trim();
    }

    public String getKeyh() {
        return keyh;
    }

    public void setKeyh(String keyh) {
        this.keyh = keyh == null ? null : keyh.trim();
    }

    public String getCmc() {
        return cmc;
    }

    public void setCmc(String cmc) {
        this.cmc = cmc == null ? null : cmc.trim();
    }

    public String getXfje() {
        return xfje;
    }

    public void setXfje(String xfje) {
        this.xfje = xfje == null ? null : xfje.trim();
    }

    public String getDj() {
        return dj;
    }

    public void setDj(String dj) {
        this.dj = dj == null ? null : dj.trim();
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl == null ? null : sl.trim();
    }

    public String getYe() {
        return ye;
    }

    public void setYe(String ye) {
        this.ye = ye == null ? null : ye.trim();
    }

    public String getXfrq() {
        return xfrq;
    }

    public void setXfrq(String xfrq) {
        this.xfrq = xfrq == null ? null : xfrq.trim();
    }

    public String getXfsj() {
        return xfsj;
    }

    public void setXfsj(String xfsj) {
        this.xfsj = xfsj == null ? null : xfsj.trim();
    }

    public String getBj() {
        return bj;
    }

    public void setBj(String bj) {
        this.bj = bj == null ? null : bj.trim();
    }

    public String getCzybh() {
        return czybh;
    }

    public void setCzybh(String czybh) {
        this.czybh = czybh == null ? null : czybh.trim();
    }

    public Date getCzsj() {
        return czsj;
    }

    public void setCzsj(Date czsj) {
        this.czsj = czsj;
    }

    public String getChjcbz() {
        return chjcbz;
    }

    public void setChjcbz(String chjcbz) {
        this.chjcbz = chjcbz == null ? null : chjcbz.trim();
    }

    public String getJqm() {
        return jqm;
    }

    public void setJqm(String jqm) {
        this.jqm = jqm == null ? null : jqm.trim();
    }

    public String getZkl() {
        return zkl;
    }

    public void setZkl(String zkl) {
        this.zkl = zkl == null ? null : zkl.trim();
    }

    public String getSjxfje() {
        return sjxfje;
    }

    public void setSjxfje(String sjxfje) {
        this.sjxfje = sjxfje == null ? null : sjxfje.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ryxfid=").append(ryxfid);
        sb.append(", ryzh=").append(ryzh);
        sb.append(", bmid=").append(bmid);
        sb.append(", stid=").append(stid);
        sb.append(", grpid=").append(grpid);
        sb.append(", bzid=").append(bzid);
        sb.append(", ckjid=").append(ckjid);
        sb.append(", zflb=").append(zflb);
        sb.append(", cbid=").append(cbid);
        sb.append(", keyh=").append(keyh);
        sb.append(", cmc=").append(cmc);
        sb.append(", xfje=").append(xfje);
        sb.append(", dj=").append(dj);
        sb.append(", sl=").append(sl);
        sb.append(", ye=").append(ye);
        sb.append(", xfrq=").append(xfrq);
        sb.append(", xfsj=").append(xfsj);
        sb.append(", bj=").append(bj);
        sb.append(", czybh=").append(czybh);
        sb.append(", czsj=").append(czsj);
        sb.append(", chjcbz=").append(chjcbz);
        sb.append(", jqm=").append(jqm);
        sb.append(", zkl=").append(zkl);
        sb.append(", sjxfje=").append(sjxfje);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}