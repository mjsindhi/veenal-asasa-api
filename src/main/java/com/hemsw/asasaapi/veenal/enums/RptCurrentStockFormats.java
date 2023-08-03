package com.hemsw.asasaapi.veenal.enums;

public enum RptCurrentStockFormats
{
	CURRENT_STOCK(1, "Current Stock"),
	CURRENT_STOCK_WI_VALUE(2, "Stock with Value"),
	LOW_STOCK(3, "Low Stock"),
	CUSTOM(4, "Custom"),;

	private final int id;
	private final String name;

	RptCurrentStockFormats(final int id, final String nameString)
	{
		this.id = id;
		name = nameString;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	@Override
	public String toString()
	{
		return name;
	}

}
