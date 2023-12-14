package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class RptIoSummByMonthHdto
{

	@Column(name = "yr_month")
	private int yrMonth;

	@Column(name = "month")
	private int month;

	@Column(name = "yr")
	private int yr;

	@Column(name = "qty_in")
	private BigDecimal qtyIn;

	@Column(name = "qty_out")
	private BigDecimal qtyOut;

	public int getYrMonth()
	{
		return yrMonth;
	}

	public void setYrMonth(int yrMonth)
	{
		this.yrMonth = yrMonth;
	}

	public int getMonth()
	{
		return month;
	}

	public void setMonth(int month)
	{
		this.month = month;
	}

	public int getYr()
	{
		return yr;
	}

	public void setYr(int yr)
	{
		this.yr = yr;
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
