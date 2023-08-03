package com.hemsw.asasaapi.veenal.enums;

public enum AppStatus
{
	UNREGISTERED(1, "Unregistered"),
	REGISTERED(2, "Registered");

	private final int id;
	private final String name;

	AppStatus(final int id, final String nameString)
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
