package com.hemsw.asasaapi.veenal.enums;

public enum OrderReportByType
{
	ACCT(1, "Customer / Supplier"),
	PRODUCT(2, "Product");

	private final int id;
	private final String name;

	OrderReportByType(final int id, final String nameString)
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

	public static OrderReportByType getByName(String name)
	{
		for (OrderReportByType summaryBy : OrderReportByType.values())
		{
			if (summaryBy.getName().equals(name))
			{
				return summaryBy;
			}
		}
		return null;
	}
}
