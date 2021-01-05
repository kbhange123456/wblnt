package com.weighBridge.consumer.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "weight_bridge_master_1")
@SequenceGenerator(name="seq", initialValue=10000, allocationSize=1)
public class WeighBridgeObj {
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Id private Long Id;
	private String vnum;
	private String ttype;
	private String vempty;
	private BigDecimal gweight;
	private BigDecimal tweight;
	private BigDecimal pweightpq;
	private BigDecimal pweight;
	private BigDecimal lweight;
	private BigDecimal nweight;
	private String pname;
	private String addr;
	private String city;
	private Integer mno;
	private String mat;
	private String vtype;
	private BigDecimal chgs;
	private String ulb;
	private BigDecimal ulbchgs;
	private BigDecimal qty;
	private BigDecimal rate;
	private BigDecimal amt;
	private LocalDateTime entryTime;
	private LocalDateTime exitTime;
	private Boolean pending;
	private String range;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getVnum() {
		return vnum;
	}
	public void setVnum(String vnum) {
		this.vnum = vnum;
	}
	public String getTtype() {
		return ttype;
	}
	public void setTtype(String ttype) {
		this.ttype = ttype;
	}
	public String getVempty() {
		return vempty;
	}
	public void setVempty(String vempty) {
		this.vempty = vempty;
	}
	public BigDecimal getGweight() {
		return gweight;
	}
	public void setGweight(BigDecimal gweight) {
		this.gweight = gweight;
	}
	public BigDecimal getTweight() {
		return tweight;
	}
	public void setTweight(BigDecimal tweight) {
		this.tweight = tweight;
	}
	public BigDecimal getPweightpq() {
		return pweightpq;
	}
	public void setPweightpq(BigDecimal pweightpq) {
		this.pweightpq = pweightpq;
	}
	public BigDecimal getPweight() {
		return pweight;
	}
	public void setPweight(BigDecimal pweight) {
		this.pweight = pweight;
	}
	public BigDecimal getLweight() {
		return lweight;
	}
	public void setLweight(BigDecimal lweight) {
		this.lweight = lweight;
	}
	public BigDecimal getNweight() {
		return nweight;
	}
	public void setNweight(BigDecimal nweight) {
		this.nweight = nweight;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getMno() {
		return mno;
	}
	public void setMno(Integer mno) {
		this.mno = mno;
	}
	public String getMat() {
		return mat;
	}
	public void setMat(String mat) {
		this.mat = mat;
	}
	public String getVtype() {
		return vtype;
	}
	public void setVtype(String vtype) {
		this.vtype = vtype;
	}
	public BigDecimal getChgs() {
		return chgs;
	}
	public void setChgs(BigDecimal chgs) {
		this.chgs = chgs;
	}
	public String getUlb() {
		return ulb;
	}
	public void setUlb(String ulb) {
		this.ulb = ulb;
	}
	public BigDecimal getUlbchgs() {
		return ulbchgs;
	}
	public void setUlbchgs(BigDecimal ulbchgs) {
		this.ulbchgs = ulbchgs;
	}
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public BigDecimal getAmt() {
		return amt;
	}
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}
	public LocalDateTime getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}
	public LocalDateTime getExitTime() {
		return exitTime;
	}
	public void setExitTime(LocalDateTime exitTime) {
		this.exitTime = exitTime;
	}
	public Boolean getPending() {
		return pending;
	}
	public void setPending(Boolean pending) {
		this.pending = pending;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}

}
