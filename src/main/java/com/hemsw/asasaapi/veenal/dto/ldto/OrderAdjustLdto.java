package com.hemsw.asasaapi.veenal.dto.ldto;

import com.hemsw.asasaapi.veenal.enums.OrderType;
import jakarta.persistence.Column;
import java.util.Date;

public class OrderAdjustLdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "no")
	private String no;

	@Column(name = "date")
	private Date date;

	@Column(name = "order_type_id")
	private int orderTypeId;

	@Column(name = "acct_name")
	private String acctName;

	@Column(name = "note")
	private String note;

	@Column(name = "created_by_user_name")
	private String createdByUserName;

	@Column(name = "created_at")
	private Date createdAt;

	public int getId()
	{
		return id;
	}

	public String getNo()
	{
		return no;
	}

	public Date getDate()
	{
		return date;
	}

	public int getOrderTypeId()
	{
		return orderTypeId;
	}

	public String getAcctName()
	{
		return acctName;
	}

	public String getNote()
	{
		return note;
	}

	public String getCreatedByUserName()
	{
		return createdByUserName;
	}

	public Date getCreatedAt()
	{
		return createdAt;
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

}
