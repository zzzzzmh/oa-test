package com.lashou.oa.cs.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity /*(dynamicUpdate=true)*/
@Table(name="orders")
public class Orders implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;
	
	@Column(name="parent_id")
	private Long parentId;
	
	@Column(name="buyer_id")
	private Integer buyerId;
	
	@Column(name="seller_id")
	private Integer sellerId;
	
	@Column(name="total_fee")
	private BigDecimal totalFee;
	
	@Column(name="payed")
	private BigDecimal payed;
	
	@Column(name="epurse_payed")
	private BigDecimal epursePayed;
	
	@Column(name="free_money")
	private BigDecimal freeMoney;
	
	@Column(name="convey_fee")
	private BigDecimal conveyFee;
	
	@Column(name="free_convey_fee")
	private BigDecimal freeConveyFee;
	
	@Column(name="status")
	private Short status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="buy_time")
	private Date buyTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="pay_time")
	private Date payTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="invalid_time")
	private Date invalidTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	@Column(name="city_id")
	private Integer cityId;
	
	@Column(name="pay_type")
	private Short payType;
	
	@Column(name="source")
	private Short source;
	
	@Column(name="serial_number")
	private String serialNumber;
	
	@Column(name="address_id")
	private Integer addressId;
	
	@Column(name="reject_reason")
	private String rejectReason;
	
	@Column(name="del")
	private Short del;
	

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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

	public BigDecimal getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}

	public BigDecimal getPayed() {
		return payed;
	}

	public void setPayed(BigDecimal payed) {
		this.payed = payed;
	}

	public BigDecimal getEpursePayed() {
		return epursePayed;
	}

	public void setEpursePayed(BigDecimal epursePayed) {
		this.epursePayed = epursePayed;
	}

	public BigDecimal getFreeMoney() {
		return freeMoney;
	}

	public void setFreeMoney(BigDecimal freeMoney) {
		this.freeMoney = freeMoney;
	}

	public BigDecimal getConveyFee() {
		return conveyFee;
	}

	public void setConveyFee(BigDecimal conveyFee) {
		this.conveyFee = conveyFee;
	}

	public BigDecimal getFreeConveyFee() {
		return freeConveyFee;
	}

	public void setFreeConveyFee(BigDecimal freeConveyFee) {
		this.freeConveyFee = freeConveyFee;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Date getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Date getInvalidTime() {
		return invalidTime;
	}

	public void setInvalidTime(Date invalidTime) {
		this.invalidTime = invalidTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Short getPayType() {
		return payType;
	}

	public void setPayType(Short payType) {
		this.payType = payType;
	}

	public Short getSource() {
		return source;
	}

	public void setSource(Short source) {
		this.source = source;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public Short getDel() {
		return del;
	}

	public void setDel(Short del) {
		this.del = del;
	}
}
