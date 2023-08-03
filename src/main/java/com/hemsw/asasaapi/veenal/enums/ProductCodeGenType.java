package com.hemsw.asasaapi.veenal.enums;

public enum ProductCodeGenType
{
	AUTO(1, "Auto"),
	MANUAL(2, "Manual");

	private final int id;
	private final String name;

	ProductCodeGenType(final int id, final String nameString)
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
