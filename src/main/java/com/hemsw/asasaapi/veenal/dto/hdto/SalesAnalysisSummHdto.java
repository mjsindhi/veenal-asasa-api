package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class SalesAnalysisSummHdto
{

	@Column(name = "cnt")
	private int cnt;

	@Column(name = "sum_sum_item_taxable_amt")
	private BigDecimal sumSumItemTaxableAmt;

	@Column(name = "sum_cgst_a")
	private BigDecimal sumCgstA;

	@Column(name = "sum_sgst_a")
	private BigDecimal sumSgstA;

	@Column(name = "sum_igst_a")
	private BigDecimal sumIgstA;

	@Column(name = "sum_amt_payable")
	private BigDecimal sumAmtPayable;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "city")
	private String city;

	@Column(name = "state_name")
	private String stateName;

	@Column(name = "date")
	private Date date;

	@Column(name = "month")
	private String month;

	@Column(name = "year")
	private Integer year;

	@Column(name = "prod_name")
	private String prodName;

	@Column(name = "cat_name")
	private String catName;

	@Column(name = "sum_prod_qty")
	private BigDecimal sumProdQty;

	@Column(name = "sum_prod_val")
	private BigDecimal sumProdVal;

	public int getCnt()
	{
		return cnt;
	}

	public BigDecimal getSumSumItemTaxableAmt()
	{
		return sumSumItemTaxableAmt;
	}

	public BigDecimal getSumCgstA()
	{
		return sumCgstA;
	}

	public BigDecimal getSumSgstA()
	{
		return sumSgstA;
	}

	public BigDecimal getSumIgstA()
	{
		return sumIgstA;
	}

	public BigDecimal getSumAmtPayable()
	{
		return sumAmtPayable;
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

	public String getCatName()
	{
		return catName;
	}

	public BigDecimal getSumProdQty()
	{
		return sumProdQty;
	}

	public BigDecimal getSumProdVal()
	{
		return sumProdVal;
	}

}
