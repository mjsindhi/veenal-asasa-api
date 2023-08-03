package com.hemsw.asasaapi.veenal.enums;

public enum DeductRawMaterialBy
{
	AUTO(1, "Auto"),
	ASSIGNMENT(2, "Assignment");

	private final int id;
	private final String name;

	DeductRawMaterialBy(final int id, final String nameString)
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
