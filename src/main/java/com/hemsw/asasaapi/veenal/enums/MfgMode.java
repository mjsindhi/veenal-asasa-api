package com.hemsw.asasaapi.veenal.enums;

public enum MfgMode
{
	JOB(1, "Job"),
	FACTORY(2, "Factory");

	private final int id;
	private final String name;

	MfgMode(final int id, final String nameString)
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
