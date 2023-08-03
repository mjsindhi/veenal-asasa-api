package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "order_adjust_item")
public class OrderAdjustItemModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "seq_no")
	private int seqNo;

	@Column(name = "order_adjust_id")
	private int orderAdjustId;

	@Column(name = "prod_id")
	private int prodId;

	@Column(name = "order_qty")
	private BigDecimal orderQty;

	@Column(name = "pusa_qty")
	private BigDecimal pusaQty;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getSeqNo()
	{
		return seqNo;
	}

	public void setSeqNo(int seqNo)
	{
		this.seqNo = seqNo;
	}

	public int getOrderAdjustId()
	{
		return orderAdjustId;
	}

	public void setOrderAdjustId(int orderAdjustId)
	{
		this.orderAdjustId = orderAdjustId;
	}

	public int getProdId()
	{
		return prodId;
	}

	public void setProdId(int prodId)
	{
		this.prodId = prodId;
	}

	public BigDecimal getOrderQty()
	{
		return orderQty;
	}

	public void setOrderQty(BigDecimal orderQty)
	{
		this.orderQty = orderQty;
	}

	public BigDecimal getPusaQty()
	{
		return pusaQty;
	}

	public void setPusaQty(BigDecimal pusaQty)
	{
		this.pusaQty = pusaQty;
	}

}
