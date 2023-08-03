package com.hemsw.asasaapi.veenal.enums;

public enum OpeningBalanceType
{
	RECIEVABLE(1, "Recievable / Dr / Paid"),
	PAYABLE(2, "Payable / Cr / Recieved");

	private final int id;
	private final String name;

	OpeningBalanceType(final int newValue, final String nameString)
	{
		id = newValue;
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

	public static OpeningBalanceType getById(int id)
	{
		for (OpeningBalanceType openingBalanceType : OpeningBalanceType.values())
		{
			if (openingBalanceType.getId() == id)
			{
				return openingBalanceType;
			}
		}

		return null;
	}

}
