package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class AcctSummaryHdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "dr")
	private BigDecimal dr;

	@Column(name = "cr")
	private BigDecimal cr;

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public BigDecimal getDr()
	{
		return dr;
	}

	public void setDr(BigDecimal dr)
	{
		this.dr = dr;
	}

	public BigDecimal getCr()
	{
		return cr;
	}

	public void setCr(BigDecimal cr)
	{
		this.cr = cr;
	}

}
