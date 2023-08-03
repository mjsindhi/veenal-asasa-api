package com.hemsw.asasaapi.veenal.enums;

public enum RptSalesAnalysisGroupBy
{
	CUSTOMER("Customer"),
	CITY("City"),
	STATE("State"),
	CATEGORY("Category"),
	PRODUCT("Product"),
	DAY("Day"),
	MONTH("Month"),
	YEAR("Year"),;

	private final String name;

	private RptSalesAnalysisGroupBy(String name)
	{
		this.name = name;
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
