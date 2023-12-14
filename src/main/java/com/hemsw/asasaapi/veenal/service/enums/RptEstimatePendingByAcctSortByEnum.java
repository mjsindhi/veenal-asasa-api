package com.hemsw.asasaapi.veenal.service.enums;

import java.util.ArrayList;
import java.util.List;

public enum RptEstimatePendingByAcctSortByEnum
{
	NAME("acct_name", "Name"),
	CNT_ESTIMATE("cnt_estimate", "Estimate Count"),
	CNT_PROD("cnt_prod", "Product Count");

	private final String key;
	private final String name;

	RptEstimatePendingByAcctSortByEnum(final String key, final String name)
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

	public static RptEstimatePendingByAcctSortByEnum getByName(String name)
	{
		for (RptEstimatePendingByAcctSortByEnum value : values())
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
		for (RptEstimatePendingByAcctSortByEnum value : values())
		{
			strings.add(value.getName());
		}
		return strings;
	}

}
