package com.hemsw.asasaapi.veenal.service.enums;

import java.util.ArrayList;
import java.util.List;

public enum RptIoSummByMonthSortByEnum
{
	MONTH("yr_month", "Year Month"),
	QTY_IN("qty_in", "Quantity Inward"),
	QTY_OUT("qty_out", "Quantity Outward");

	private final String key;
	private final String name;

	RptIoSummByMonthSortByEnum(final String key, final String name)
	{
		this.key = key;
		this.name = name;
	}

	public String getKey()
	{
		return key;
	}

	public String getName()
	{
		return name;
	}

	public static RptIoSummByMonthSortByEnum getByName(String name)
	{
		for (RptIoSummByMonthSortByEnum value : values())
		{
			if (value.name.equals(name))
			{
				return value;
			}
		}
		return null;
	}

	public static List<String> getNames()
	{
		List<String> strings = new ArrayList<>();
		for (RptIoSummByMonthSortByEnum value : values())
		{
			strings.add(value.getName());
		}
		return strings;
	}

}
