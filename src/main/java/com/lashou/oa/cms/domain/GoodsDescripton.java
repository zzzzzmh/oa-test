package com.lashou.oa.cms.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.CascadeType;
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
	@GenericGenerator(name ="pkGenerator",strategy="foreign" ,parameters={@Parameter(name="property",value="goods")})
    @GeneratedValue(generator="pkGenerator")
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

	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this); 
	}
	
}
