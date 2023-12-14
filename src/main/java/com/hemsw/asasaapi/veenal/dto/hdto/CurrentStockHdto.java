package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class CurrentStockHdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "unit")
	private String unit;

	@Column(name = "hsn")
	private Integer hsn;

	@Column(name = "qty")
	private BigDecimal qty;

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getUnit()
	{
		return unit;
	}

	public Integer getHsn()
	{
		return hsn;
	}

	public BigDecimal getQty()
	{
		return qty;
	}

}
