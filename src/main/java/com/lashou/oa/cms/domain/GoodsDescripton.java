package com.lashou.oa.cms.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="think_goods_description")
public class GoodsDescripton implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer goodsId;
	private String description;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="goods_id")
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	
	@Lob
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
