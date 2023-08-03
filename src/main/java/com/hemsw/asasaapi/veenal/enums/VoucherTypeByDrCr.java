package com.hemsw.asasaapi.veenal.enums;

public enum VoucherTypeByDrCr
{
	DR(1, "Cleared"),
	CR(2, "Cleared"),
	DR_CR(3, "Cleared");

	private final int id;
	private final String name;

	VoucherTypeByDrCr(final int id, final String nameString)
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
