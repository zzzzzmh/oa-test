package com.lashou.oa.cs.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//import org.hibernate.annotations.Entity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name="order_details")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="detail_id")
	private Long detailId;
	
	@Column(name="buyer_id")
	private Integer buyerId;
	
	@Column(name="seller_id")
	private Integer sellerId;
	
	@Column(name="goods_id")
	private Integer goodsId;
	
	@Column(name="amount")
	private Integer amount;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="cost_price")
	private BigDecimal costPrice;
	
	@Column(name="total_fee")
	private BigDecimal totalFee;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="pay_time")
	private Date payTime;
	
	@ManyToOne(targetEntity=Orders.class, optional=true, fetch=FetchType.LAZY) //cascade={CascadeType.ALL},
	@JoinColumn(name="order_id")
	@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Orders orders;
	
	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
}
