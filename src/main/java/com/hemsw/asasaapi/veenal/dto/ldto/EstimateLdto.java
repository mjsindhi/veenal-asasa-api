package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import java.util.Date;

public class EstimateLdto
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

	@Column(name = "note")
	private String note;

	@Column(name = "sales_order_no")
	private String salesOrderNo;

	@Column(name = "status_name")
	private String statusName;

	@Column(name = "lock_stock_for_days")
	private Integer lockStatusForDays;

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

	public String getNote()
	{
		return note;
	}

	public String getSalesOrderNo()
	{
		return salesOrderNo;
	}

	public String getStatusName()
	{
		return statusName;
	}

	public void setStatusName(String statusName)
	{
		this.statusName = statusName;
	}

	public Integer getLockStatusForDays()
	{
		return lockStatusForDays;
	}

	public void setLockStatusForDays(Integer lockStatusForDays)
	{
		this.lockStatusForDays = lockStatusForDays;
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
