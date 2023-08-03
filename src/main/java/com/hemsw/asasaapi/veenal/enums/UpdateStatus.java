package com.hemsw.asasaapi.veenal.enums;

public enum UpdateStatus
{

	INSTALLED(1),
	INSTALLING(2),
	DOWNLOADED(3),
	EXTRACTED(4),
	LISTED(5);

	private final int id;

	private UpdateStatus(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

}
