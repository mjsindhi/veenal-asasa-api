package com.hemsw.asasaapi.veenal.model.gen;

import com.hemsw.asasaapi.veenal.enums.OrderType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_adjust")
public class OrderAdjustModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "order_type_id")
	private int orderTypeId;

	@Column(name = "acct_id")
	private int acctId;

	@Column(name = "note")
	private String note;

	public OrderAdjustModel()
	{
		note = "";
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getOrderTypeId()
	{
		return orderTypeId;
	}

	public void setOrderTypeId(int orderTypeId)
	{
		this.orderTypeId = orderTypeId;
	}

	public int getAcctId()
	{
		return acctId;
	}

	public void setAcctId(int acctId)
	{
		this.acctId = acctId;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
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
