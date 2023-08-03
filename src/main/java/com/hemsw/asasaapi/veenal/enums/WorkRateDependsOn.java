package com.hemsw.asasaapi.veenal.enums;

public enum WorkRateDependsOn
{
	PRODUCT(1, "Product"),
	PRODUCT_AND_WORKER(2, "Product and Worker");

	private final int id;
	private final String name;

	WorkRateDependsOn(final int id, final String nameString)
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
