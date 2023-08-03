package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class SalesOrderLdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "no")
	private String no;

	@Column(name = "date")
	private Date date;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "city")
	private String city;

	@Column(name = "state_name")
	private String stateName;

	@Column(name = "sum_qty")
	private String sumQty;

	@Column(name = "amt_payable")
	private BigDecimal amtPayable;

	@Column(name = "note")
	private String note;

	@Column(name = "company_profile_name")
	private String companyProfileName;

	@Column(name = "sales_no")
	private String salesNo;

	@Column(name = "completed")
	private Boolean completed;

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

	public String getCustomerName()
	{
		return customerName;
	}

	public String getCity()
	{
		return city;
	}

	public String getStateName()
	{
		return stateName;
	}

	public String getSumQty()
	{
		return sumQty;
	}

	public BigDecimal getAmtPayable()
	{
		return amtPayable;
	}

	public String getNote()
	{
		return note;
	}

	public String getCompanyProfileName()
	{
		return companyProfileName;
	}

	public String getSalesNo()
	{
		return salesNo;
	}

	public Boolean getCompleted()
	{
		return completed;
	}

	public String getCreatedByUserName()
	{
		return createdByUserName;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

}
