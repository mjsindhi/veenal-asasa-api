package com.hemsw.asasaapi.veenal.service.enums;

import java.util.ArrayList;
import java.util.List;

public enum RptEstimatePendingByProdSortByEnum
{
	NAME("product_name", "Name"),
	CNT_ESTIMATE("cnt_estimate", "Estimate Count"),
	CNT_CUSTOMER("cnt_customer", "Customer Count"),
	SUM_QTY("sum_qty", "Quantity Sum");

	private final String key;
	private final String name;

	RptEstimatePendingByProdSortByEnum(final String key, final String name)
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

	public static RptEstimatePendingByProdSortByEnum getByName(String name)
	{
		for (RptEstimatePendingByProdSortByEnum value : values())
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
		for (RptEstimatePendingByProdSortByEnum value : values())
		{
			strings.add(value.getName());
		}
		return strings;
	}

}
