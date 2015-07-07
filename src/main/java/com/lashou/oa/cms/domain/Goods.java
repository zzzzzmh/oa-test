package com.lashou.oa.cms.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="think_goods")
public class Goods implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer goodsId;
	private String title;
	private String product;
	private BigDecimal price;
	private BigDecimal costPrice;
	private Integer spId;
	private Date addTime;
	
	private GoodsDescripton desc;
	
	@Transient 
	private Integer cityId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="goods_id")
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	
	@Column(name="title")
	@NotNull(message="{title.not.empty}")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="product",length=50)
	@NotNull(message="product.not.empty")
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	@Column(name="price",precision=10,scale=2)
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Column(name="cost_price",precision=10,scale=2)
	public BigDecimal getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
	
	@Column(name="sp_id")
	public Integer getSpId() {
		return spId;
	}
	public void setSpId(Integer spId) {
		this.spId = spId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	@OneToOne(cascade={CascadeType.ALL},fetch=FetchType.LAZY,optional=false)
	@PrimaryKeyJoinColumn
	public GoodsDescripton getDesc() {
		return desc;
	}
	
	public void setDesc(GoodsDescripton desc) {
		this.desc = desc;
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this); 
	}
}
