package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class AcctMonthlySummaryHdto
{

	@Column(name = "month_yr")
	private int monthYr;

	@Column(name = "yr")
	private int yr;

	@Column(name = "month")
	private int month;

	@Column(name = "dr")
	private BigDecimal dr;

	@Column(name = "cr")
	private BigDecimal cr;

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

	public BigDecimal getDr()
	{
		return dr;
	}

	public BigDecimal getCr()
	{
		return cr;
	}

}
