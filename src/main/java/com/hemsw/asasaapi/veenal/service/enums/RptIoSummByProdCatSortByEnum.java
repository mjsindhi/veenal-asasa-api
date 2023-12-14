package com.hemsw.asasaapi.veenal.service.enums;

import java.util.ArrayList;
import java.util.List;

public enum RptIoSummByProdCatSortByEnum
{
	NAME("prod_cat_name", "Name"),
	QTY_IN("qty_in", "Quantity Inward"),
	QTY_OUT("qty_out", "Quantity Outward");

	private final String key;
	private final String name;

	RptIoSummByProdCatSortByEnum(final String key, final String name)
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

	public static RptIoSummByProdCatSortByEnum getByName(String name)
	{
		for (RptIoSummByProdCatSortByEnum value : values())
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
		for (RptIoSummByProdCatSortByEnum value : values())
		{
			strings.add(value.getName());
		}
		return strings;
	}

}
