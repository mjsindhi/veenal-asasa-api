package com.hemsw.asasaapi.veenal.service.enums;

import java.util.ArrayList;
import java.util.List;

public enum RptSalesDetailedByProdSortByEnum
{
	DATE("date", "Date"),
	COUNT("sales_cnt", "Count"),
	AMT("sum_item_val", "Amount");

	private final String key;
	private final String name;

	RptSalesDetailedByProdSortByEnum(final String key, final String name)
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

	public static RptSalesDetailedByProdSortByEnum getByName(String name)
	{
		for (RptSalesDetailedByProdSortByEnum value : values())
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
		for (RptSalesDetailedByProdSortByEnum value : values())
		{
			strings.add(value.getName());
		}
		return strings;
	}

}
