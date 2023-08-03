package com.hemsw.asasaapi.veenal.enums;

public enum OthCompanyNames
{
	ANIL_G(1, "anil_g_amt"),
	SD(2, "sd_amt"),;

	private final int id;
	private final String msgKey;

	OthCompanyNames(final int id, final String nameString)
	{
		this.id = id;
		msgKey = nameString;
	}

	public int getId()
	{
		return id;
	}

	public String getMsgKey()
	{
		return msgKey;
	}

}
