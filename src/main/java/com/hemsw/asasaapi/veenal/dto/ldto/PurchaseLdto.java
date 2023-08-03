package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class PurchaseLdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "no")
	private String no;

	@Column(name = "purchase_ledger")
	private String purchaseLedger;

	@Column(name = "date")
	private Date date;

	//Customer Details
	@Column(name = "supplier_name")
	private String supplierName;

	@Column(name = "city")
	private String city;

	@Column(name = "state_name")
	private String stateName;

	//Order Details
	@Column(name = "order_no")
	private String orderNo;

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "sum_amt_after_disc")
	private BigDecimal sumAmtAfterDisc;

	@Column(name = "sum_qty")
	private BigDecimal sumQty;

	@Column(name = "cgst_a")
	private BigDecimal cgstA;

	@Column(name = "sgst_a")
	private BigDecimal sgstA;

	@Column(name = "igst_a")
	private BigDecimal igstA;

	@Column(name = "sum_amt_after_tax")
	private BigDecimal sumAmtAfterTax;

	@Column(name = "total_amt")
	private BigDecimal totalAmt;

	@Column(name = "round_off")
	private BigDecimal roundOff;

	@Column(name = "amt_payable")
	private BigDecimal amtPayable;

	@Column(name = "amt_clrd")
	private BigDecimal amtClrd;

	@Column(name = "amt_unclrd")
	private BigDecimal amtUnclrd;

	@Column(name = "days_cnt")
	private int daysCnt;

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

	public String getPurchaseLedger()
	{
		return purchaseLedger;
	}

	public Date getDate()
	{
		return date;
	}

	public String getSupplierName()
	{
		return supplierName;
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

	public BigDecimal getSumAmtAfterDisc()
	{
		return sumAmtAfterDisc;
	}

	public BigDecimal getSumQty()
	{
		return sumQty;
	}

	public BigDecimal getCgstA()
	{
		return cgstA;
	}

	public BigDecimal getSgstA()
	{
		return sgstA;
	}

	public BigDecimal getIgstA()
	{
		return igstA;
	}

	public BigDecimal getSumAmtAfterTax()
	{
		return sumAmtAfterTax;
	}

	public BigDecimal getTotalAmt()
	{
		return totalAmt;
	}

	public BigDecimal getRoundOff()
	{
		return roundOff;
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

	public int getDaysCnt()
	{
		return daysCnt;
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

}
