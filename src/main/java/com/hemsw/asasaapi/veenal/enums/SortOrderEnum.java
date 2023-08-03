package com.hemsw.asasaapi.veenal.enums;

import java.util.ArrayList;
import java.util.List;

public enum SortOrderEnum
{
	ASC(1, "Ascending", "ASC"),
	DESC(2, "Descending", "DESC");

	private final int id;
	private final String name;
	private final String sqlName;

	SortOrderEnum(final int id, final String nameString, final String sqlName)
	{
		this.id = id;
		name = nameString;
		this.sqlName = sqlName;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getSqlName()
	{
		return sqlName;
	}

	public static SortOrderEnum getByName(String name)
	{
		for (SortOrderEnum value : values())
		{
			if (value.getName().equals(name))
			{
				return value;
			}
		}
		return null;
	}

	public static List<String> getNames()
	{
		List<String> strings = new ArrayList<>();
		for (SortOrderEnum value : values())
		{
			strings.add(value.getName());
		}
		return strings;
	}
}
