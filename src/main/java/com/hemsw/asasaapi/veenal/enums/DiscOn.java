package com.hemsw.asasaapi.veenal.enums;

public enum DiscOn
{
	ITEM(1, "Item"),
	VOUCHER(2, "Voucher"),
	BOTH(3, "Both");

	private final int id;
	private final String name;

	DiscOn(final int id, final String nameString)
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
