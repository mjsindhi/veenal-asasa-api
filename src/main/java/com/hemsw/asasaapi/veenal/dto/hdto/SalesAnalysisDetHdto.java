package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class SalesAnalysisDetHdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "no")
	private String no;

	@Column(name = "sum_item_taxable_amt")
	private BigDecimal sumItemTaxableAmt;

	@Column(name = "cgst_a")
	private BigDecimal cgstA;

	@Column(name = "sgst_a")
	private BigDecimal sgstA;

	@Column(name = "igst_a")
	private BigDecimal igstA;

	@Column(name = "amt_payable")
	private BigDecimal amtPayable;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "city")
	private String city;

	@Column(name = "state_name")
	private String stateName;

	@Column(name = "cat_name")
	private String catName;

	@Column(name = "prod_name")
	private String prodName;

	@Column(name = "sum_prod_qty")
	private BigDecimal sumProdQty;

	@Column(name = "sum_prod_val")
	private BigDecimal sumProdVal;

	@Column(name = "date")
	private Date date;

	@Column(name = "month")
	private String month;

	@Column(name = "year")
	private Integer year;

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

	public Date getDate()
	{
		return date;
	}

	public String getMonth()
	{
		return month;
	}

	public Integer getYear()
	{
		return year;
	}

	public String getProdName()
	{
		return prodName;
	}

	public BigDecimal getSumProdQty()
	{
		return sumProdQty;
	}

	public BigDecimal getSumProdVal()
	{
		return sumProdVal;
	}

	public String getCatName()
	{
		return catName;
	}

	public int getId()
	{
		return id;
	}

	public String getNo()
	{
		return no;
	}

	public BigDecimal getSumItemTaxableAmt()
	{
		return sumItemTaxableAmt;
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

	public BigDecimal getAmtPayable()
	{
		return amtPayable;
	}

}
