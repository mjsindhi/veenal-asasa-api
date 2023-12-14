package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class ProductMonthlySummaryHdto
{

	@Column(name = "month_yr")
	private int monthYr;

	@Column(name = "yr")
	private int yr;

	@Column(name = "month")
	private int month;

	@Column(name = "qty_in")
	private BigDecimal qtyIn;

	@Column(name = "qty_out")
	private BigDecimal qtyOut;

	public int getMonthYr()
	{
		return monthYr;
	}

	public int getYr()
	{
		return yr;
	}

	public int getMonth()
	{
		return month;
	}

	public BigDecimal getQtyIn()
	{
		return qtyIn;
	}

	public void setQtyIn(BigDecimal qtyIn)
	{
		this.qtyIn = qtyIn;
	}

	public BigDecimal getQtyOut()
	{
		return qtyOut;
	}

	public void setQtyOut(BigDecimal qtyOut)
	{
		this.qtyOut = qtyOut;
	}

}
