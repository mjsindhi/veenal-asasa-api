package com.hemsw.asasaapi.veenal.enums;

public enum GetAcctsObjectType
{
	ACCT(1, ""),
	ACCT_LIST_FOR_CUSTOMER_HDTO(2, ""),;

	private final int id;
	private final String name;

	GetAcctsObjectType(final int id, final String nameString)
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
