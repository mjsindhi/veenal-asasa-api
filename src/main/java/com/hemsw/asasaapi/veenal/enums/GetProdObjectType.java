package com.hemsw.asasaapi.veenal.enums;

public enum GetProdObjectType
{
	PROD(1, ""),
	PROD_FOR_ESTIMATE(2, ""),;

	private final int id;
	private final String name;

	GetProdObjectType(final int id, final String nameString)
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
