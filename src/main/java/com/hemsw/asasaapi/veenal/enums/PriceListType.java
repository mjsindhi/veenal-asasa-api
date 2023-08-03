package com.hemsw.asasaapi.veenal.enums;

import java.util.ArrayList;
import java.util.List;

public enum PriceListType
{
	A(1, "A"),
	B(2, "B"),;

	private final int id;
	private final String name;

	PriceListType(final int id, final String name)
	{
		this.id = id;
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public static PriceListType getById(int id)
	{
		for (PriceListType priceListType : PriceListType.values())
		{
			if (priceListType.id == id)
			{
				return priceListType;
			}
		}
		return null;
	}

	public static PriceListType getByName(String name)
	{
		for (PriceListType priceListType : PriceListType.values())
		{
			if (priceListType.name.equals(name))
			{
				return priceListType;
			}
		}
		return null;
	}

	public static List<String> getNames()
	{
		List<String> strings = new ArrayList<>();
		for (PriceListType value : PriceListType.values())
		{
			strings.add(value.getName());
		}
		return strings;
	}

}
