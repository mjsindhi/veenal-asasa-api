package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class CommVouLdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "no")
	private String no;

	@Column(name = "date")
	private Date date;

	@Column(name = "sales_no")
	private String salesNo;

	@Column(name = "sales_date")
	private Date salesDate;

	@Column(name = "sales_amt")
	private BigDecimal salesAmt;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "agent_name")
	private String agentName;

	@Column(name = "estimated_comm")
	private BigDecimal estimatedComm;

	@Column(name = "payable_comm")
	private BigDecimal payableComm;

	@Column(name = "due_comm")
	private BigDecimal dueComm;

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

	public String getSalesNo()
	{
		return salesNo;
	}

	public Date getSalesDate()
	{
		return salesDate;
	}

	public BigDecimal getSalesAmt()
	{
		return salesAmt;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public String getAgentName()
	{
		return agentName;
	}

	public BigDecimal getEstimatedComm()
	{
		return estimatedComm;
	}

	public BigDecimal getPayableComm()
	{
		return payableComm;
	}

	public BigDecimal getDueComm()
	{
		return dueComm;
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
