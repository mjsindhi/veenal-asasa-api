package com.hemsw.asasaapi.veenal.enums;

public enum GetVouOthChObjectType
{
	VOU_OTH_CH(1, ""),
	VOU_OTH_CH_FOR_ESTIMATE(2, "");

	private final int id;
	private final String name;

	GetVouOthChObjectType(final int id, final String nameString)
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
