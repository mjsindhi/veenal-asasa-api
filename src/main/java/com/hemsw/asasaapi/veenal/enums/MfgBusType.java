package com.hemsw.asasaapi.veenal.enums;

public enum MfgBusType
{
	GARMENTS(1, "Garments");
	//GENERAL(2, "General");

	private final int id;
	private final String name;

	MfgBusType(final int id, final String nameString)
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
