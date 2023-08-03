package com.hemsw.asasaapi.veenal.dto.ldto;

import com.hemsw.asasaapi.veenal.model.gen.InvAdjustModel.AdjustType;
import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class InvAdjustLdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "no")
	private String no;

	@Column(name = "date")
	private Date date;

	@Column(name = "adjust_type_id")
	private int adjustTypeId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "qty")
	private BigDecimal qty;

	@Column(name = "in_amt")
	private BigDecimal inAmt;

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

	public int getAdjustTypeId()
	{
		return adjustTypeId;
	}

	public String getProductName()
	{
		return productName;
	}

	public BigDecimal getQty()
	{
		return qty;
	}

	public BigDecimal getInAmt()
	{
		return inAmt;
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
	public AdjustType getAdjustType()
	{
		for (AdjustType adjustType : AdjustType.values())
		{
			if (adjustType.getId() == adjustTypeId)
			{
				return adjustType;
			}
		}
		return null;
	}

}
