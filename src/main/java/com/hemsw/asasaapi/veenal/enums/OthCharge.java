package com.hemsw.asasaapi.veenal.enums;

public enum OthCharge
{
	CASH_DISCOUNT(1),
	PENALTY(2),;

	private final int id;

	OthCharge(final int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

}
