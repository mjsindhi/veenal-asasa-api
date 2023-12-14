package com.hemsw.asasaapi.veenal.service.enums;

import java.util.ArrayList;
import java.util.List;

public enum RptIoDetSortByEnum
{
	DATE("date", "Date"),
	IN_OUT("voucher_type_id", "In/Out"),
	ACCT("acct_name", "Account"),
	PROD("prod_name", "Product"),
	QTY_IN("qty_in", "Quantity Inward"),
	QTY_OUT("qty_out", "Quantity Outward");

	private final String key;
	private final String name;

	RptIoDetSortByEnum(final String key, final String name)
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

	public static RptIoDetSortByEnum getByName(String name)
	{
		for (RptIoDetSortByEnum value : values())
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
		for (RptIoDetSortByEnum value : values())
		{
			strings.add(value.getName());
		}
		return strings;
	}

}
