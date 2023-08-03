package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class CashDiscVouLdto
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

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "receipt_no")
	private String receiptNo;

	@Column(name = "receipt_date")
	private Date receiptDate;

	@Column(name = "receipt_amt")
	private BigDecimal receiptAmt;

	@Column(name = "amt_item_val")
	private BigDecimal amtItemVal;

	@Column(name = "amt_sales")
	private BigDecimal amtSales;

	@Column(name = "amt_rcvd")
	private BigDecimal amtRcvd;

	@Column(name = "days")
	private int days;

	@Column(name = "rate")
	private BigDecimal rate;

	@Column(name = "amt_disc")
	private BigDecimal amtDisc;

	@Column(name = "disc_given")
	private BigDecimal discGiven;

	@Column(name = "disc_pending")
	private BigDecimal discPending;

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

	public String getCustomerName()
	{
		return customerName;
	}

	public String getReceiptNo()
	{
		return receiptNo;
	}

	public Date getReceiptDate()
	{
		return receiptDate;
	}

	public BigDecimal getReceiptAmt()
	{
		return receiptAmt;
	}

	public BigDecimal getAmtItemVal()
	{
		return amtItemVal;
	}

	public BigDecimal getAmtSales()
	{
		return amtSales;
	}

	public BigDecimal getAmtRcvd()
	{
		return amtRcvd;
	}

	public int getDays()
	{
		return days;
	}

	public BigDecimal getRate()
	{
		return rate;
	}

	public BigDecimal getAmtDisc()
	{
		return amtDisc;
	}

	public BigDecimal getDiscGiven()
	{
		return discGiven;
	}

	public BigDecimal getDiscPending()
	{
		return discPending;
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
