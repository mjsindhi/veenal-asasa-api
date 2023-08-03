package com.hemsw.asasaapi.veenal.enums;

public enum RateType
{
	PERCENT(1, "%"),
	FLAT(2, "Rs");

	private final int id;
	private final String name;

	RateType(final int id, final String nameString)
	{
		this.id = id;
		name = nameString;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public static RateType getById(int id)
	{
		for (RateType rateType : RateType.values())
		{
			if (rateType.id == id)
			{
				return rateType;
			}
		}
		return null;
	}

	public static RateType getByName(String name)
	{
		for (RateType rateType : RateType.values())
		{
			if (rateType.name.equals(name))
			{
				return rateType;
			}
		}
		return null;
	}

}
