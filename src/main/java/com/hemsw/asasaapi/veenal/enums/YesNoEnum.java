package com.hemsw.asasaapi.veenal.enums;

import java.util.ArrayList;
import java.util.List;

public enum YesNoEnum
{
	YES("Yes", true),
	NO("No", false);

	private final String name;
	private final boolean val;

	YesNoEnum(final String name, final boolean val)
	{
		this.name = name;
		this.val = val;
	}

	public String getName()
	{
		return name;
	}

	public boolean isVal()
	{
		return val;
	}

	public static YesNoEnum getByVal(boolean val)
	{
		for (YesNoEnum yesNoEnum : YesNoEnum.values())
		{
			if (yesNoEnum.val == val)
			{
				return yesNoEnum;
			}
		}
		return null;
	}

	public static YesNoEnum getByName(String name)
	{
		for (YesNoEnum yesNoEnum : YesNoEnum.values())
		{
			if (yesNoEnum.name.equals(name))
			{
				return yesNoEnum;
			}
		}
		return null;
	}

	public static List<String> getStrVal()
	{
		List<String> strings = new ArrayList<>();
		for (YesNoEnum value : YesNoEnum.values())
		{
			strings.add(value.getName());
		}
		return strings;
	}

}
