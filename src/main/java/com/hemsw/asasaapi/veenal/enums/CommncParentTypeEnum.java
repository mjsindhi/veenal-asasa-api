package com.hemsw.asasaapi.veenal.enums;

import java.util.ArrayList;
import java.util.List;

public enum CommncParentTypeEnum
{
	LEAD("Lead", 1),
	ACCT("Account", 2);

	private final String name;
	private final int id;

	CommncParentTypeEnum(final String name, final int id)
	{
		this.name = name;
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public int getId()
	{
		return id;
	}

	public static CommncParentTypeEnum getByVal(int id)
	{
		for (CommncParentTypeEnum commncLogParentEnum : CommncParentTypeEnum.values())
		{
			if (commncLogParentEnum.id == id)
			{
				return commncLogParentEnum;
			}
		}
		return null;
	}

	public static CommncParentTypeEnum getByName(String name)
	{
		for (CommncParentTypeEnum commncLogParentEnum : CommncParentTypeEnum.values())
		{
			if (commncLogParentEnum.name.equals(name))
			{
				return commncLogParentEnum;
			}
		}
		return null;
	}

	public static List<String> getStrVal()
	{
		List<String> strings = new ArrayList<>();
		for (CommncParentTypeEnum value : CommncParentTypeEnum.values())
		{
			strings.add(value.getName());
		}
		return strings;
	}

}
