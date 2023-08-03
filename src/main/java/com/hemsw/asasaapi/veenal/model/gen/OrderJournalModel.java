package com.hemsw.asasaapi.veenal.model.gen;

import com.hemsw.asasaapi.veenal.enums.OrderType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "order_journal")
public class OrderJournalModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "date")
	private Date date;

	@Column(name = "product_id")
	private int productId;

	@Column(name = "acct_id")
	private int acctId;

	@Column(name = "order_type_id")
	private int orderTypeId;

	@Column(name = "order_qty")
	private BigDecimal orderQty;

	@Column(name = "pusa_qty")
	private BigDecimal pusaQty;

	@Column(name = "voucher_id")
	private Integer voucherId;

	@Column(name = "voucher_item_id")
	private int voucherItemId;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
	}

	public int getAcctId()
	{
		return acctId;
	}

	public void setAcctId(int acctId)
	{
		this.acctId = acctId;
	}

	public int getOrderTypeId()
	{
		return orderTypeId;
	}

	public void setOrderTypeId(int orderTypeId)
	{
		this.orderTypeId = orderTypeId;
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

	public Integer getVoucherId()
	{
		return voucherId;
	}

	public void setVoucherId(Integer voucherId)
	{
		this.voucherId = voucherId;
	}

	public int getVoucherItemId()
	{
		return voucherItemId;
	}

	public void setVoucherItemId(int voucherItemId)
	{
		this.voucherItemId = voucherItemId;
	}

	//
	public OrderType getOrderType()
	{
		for (OrderType orderType : OrderType.values())
		{
			if (orderType.getId() == orderTypeId)
			{
				return orderType;
			}
		}
		return null;
	}

	public void setOrderType(OrderType orderType)
	{
		orderTypeId = orderType.getId();
	}

}
