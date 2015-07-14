package com.lashou.oa.cms.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="think_category")
public class Category implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Category(String name) {
		this.category = name;
	}
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="level")
	private Integer level=0;
	
	@Column(name="category")
	private String category;
	
	@Column(name="status")
	private Byte status=0;
	
	@ManyToOne(targetEntity=Category.class, optional=true, fetch=FetchType.LAZY)
	@JoinColumn(name="fid")
	@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Category parent;
	
	@OneToMany(mappedBy="parent",targetEntity=Category.class,fetch=FetchType.LAZY)
	@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Set<Category> child = new HashSet<Category>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}
	
	public Set<Category> getChild() {
		return child;
	}
	
	public void setChild(Set<Category> child) {
		this.child = child;
	}
	
	public void addChild(Category c) {
		if(c == null) {
			throw new IllegalArgumentException("can not add a null category as child");
		}
		if(c.getParent() != null) {
			c.getParent().getChild().remove(c);
		}
		c.setParent(this);
		this.getChild().add(c);
	}
	
}
