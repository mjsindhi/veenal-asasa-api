package com.hemsw.asasaapi.veenal.enums;

public enum VoucherTypeByClear
{
	CLRD(1, "Cleared"),
	NOT_CLRD(2, "Not Cleared");

	private final int id;
	private final String name;

	VoucherTypeByClear(final int id, final String nameString)
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
