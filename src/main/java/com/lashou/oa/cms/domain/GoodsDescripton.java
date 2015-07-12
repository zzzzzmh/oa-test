package com.lashou.oa.cms.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="think_goods_description")
public class GoodsDescripton implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer goodsId;
	private String description;
	private Goods goods;
	
	@Id
	@Column(name="goods_id")
	@GeneratedValue(generator="foreignKey")
	@GenericGenerator(name="foreignKey", strategy="foreign", parameters=@Parameter(name="property", value="goods"))  
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	
	@Lob
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "desc")
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	/*
	public String toString() {
		return ReflectionToStringBuilder.toString(this); 
	}
	*/
}
