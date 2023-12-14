package com.hemsw.asasaapi.veenal.service.enums;

import java.util.ArrayList;
import java.util.List;

public enum RptPurchaseReturnDetailedByVoucherSortByEnum
{
	DATE("date", "Date"),
	COUNT("purchase_return_cnt", "Count"),
	AMT("sum_item_val", "Amount");

	private final String key;
	private final String name;

	RptPurchaseReturnDetailedByVoucherSortByEnum(final String key, final String name)
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

	public static RptPurchaseReturnDetailedByVoucherSortByEnum getByName(String name)
	{
		for (RptPurchaseReturnDetailedByVoucherSortByEnum value : values())
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
		for (RptPurchaseReturnDetailedByVoucherSortByEnum value : values())
		{
			strings.add(value.getName());
		}
		return strings;
	}

}
