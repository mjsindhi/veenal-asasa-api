package com.hemsw.asasaapi.veenal.enums;

public enum SalesType
{
	CREDIT(1, "Credit"),
	CASH(2, "Cash");

	private final int id;
	private final String name;

	SalesType(final int id, final String nameString)
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

}
