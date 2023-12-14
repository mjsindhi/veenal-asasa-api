package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class DueRcvableBySalesHdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "no")
	private String no;

	@Column(name = "date")
	private Date date;

	//Customer Details
	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "city")
	private String city;

	@Column(name = "state_name")
	private String stateName;

	//Order Details
	@Column(name = "order_no")
	private String orderNo;

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "agent_name")
	private String agentName;

	//Transport Details
	@Column(name = "lr_no")
	private String lrNo;

	@Column(name = "lr_date")
	private Date lrDate;

	@Column(name = "transporter_name")
	private String transporterName;

	@Column(name = "amt_payable")
	private BigDecimal amtPayable;

	@Column(name = "amt_clrd")
	private BigDecimal amtClrd;

	@Column(name = "amt_unclrd")
	private BigDecimal amtUnclrd;

	@Column(name = "credit_days")
	private Integer creditDays;

	@Column(name = "age_days")
	private int ageDays;

	@Column(name = "overdue_days")
	private int overdueDays;

	@Column(name = "due_date")
	private Date dueDate;

	@Column(name = "note")
	private String note;

	@Column(name = "company_profile_name")
	private String companyProfileName;

	@Column(name = "final_invoice_no")
	private String finalInvoiceNo;

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

	public String getOrderNo()
	{
		return orderNo;
	}

	public Date getOrderDate()
	{
		return orderDate;
	}

	public String getAgentName()
	{
		return agentName;
	}

	public String getLrNo()
	{
		return lrNo;
	}

	public Date getLrDate()
	{
		return lrDate;
	}

	public String getTransporterName()
	{
		return transporterName;
	}

	public BigDecimal getAmtPayable()
	{
		return amtPayable;
	}

	public BigDecimal getAmtClrd()
	{
		return amtClrd;
	}

	public BigDecimal getAmtUnclrd()
	{
		return amtUnclrd;
	}

	public Integer getCreditDays()
	{
		return creditDays;
	}

	public int getAgeDays()
	{
		return ageDays;
	}

	public int getOverdueDays()
	{
		return overdueDays;
	}

	public Date getDueDate()
	{
		return dueDate;
	}

	public String getNote()
	{
		return note;
	}

	public String getCompanyProfileName()
	{
		return companyProfileName;
	}

	public String getFinalInvoiceNo()
	{
		return finalInvoiceNo;
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
