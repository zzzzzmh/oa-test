package com.lashou.oa.cms.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="think_tags")
public class Tags implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Tags(String s, Goods g) {
		tag = s;
		this.goods.add(g);
	}
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="tag")
	private String tag;
	
	@ManyToMany(cascade={CascadeType.ALL},mappedBy="tags",fetch=FetchType.LAZY)
	@JoinTable(name="goods_tags",
	   joinColumns={@JoinColumn(name="tag_id")},
	   inverseJoinColumns={@JoinColumn(name="goods_id")}
	)
	private Set<Goods> goods = new HashSet<Goods>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}
}