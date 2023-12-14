package com.hemsw.asasaapi.veenal.service.enums;

import java.util.ArrayList;
import java.util.List;

public enum RptPurchaseDetailedByProdSortByEnum
{
	DATE("date", "Date"),
	COUNT("purchase_cnt", "Count"),
	AMT("sum_item_val", "Amount");

	private final String key;
	private final String name;

	RptPurchaseDetailedByProdSortByEnum(final String key, final String name)
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

	public static RptPurchaseDetailedByProdSortByEnum getByName(String name)
	{
		for (RptPurchaseDetailedByProdSortByEnum value : values())
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
		for (RptPurchaseDetailedByProdSortByEnum value : values())
		{
			strings.add(value.getName());
		}
		return strings;
	}

}
