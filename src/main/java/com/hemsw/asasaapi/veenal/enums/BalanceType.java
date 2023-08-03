package com.hemsw.asasaapi.veenal.enums;

public enum BalanceType
{
	RECIEVABLE_DR_PAID(1, "Recievable / Dr / Paid", "Dr"),
	PAYABLE_CR_RCVD(2, "Payable / Cr / Recieved", "Cr");

	private final int id;
	private final String name;
	private final String nameInCrDr;

	BalanceType(final int newValue, final String nameString, final String nameInCrDr)
	{
		id = newValue;
		name = nameString;
		this.nameInCrDr = nameInCrDr;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getNameInCrDr()
	{
		return nameInCrDr;
	}

	public static BalanceType getByName(String name)
	{
		for (BalanceType balanceType : BalanceType.values())
		{
			if (balanceType.name.equals(name))
			{
				return balanceType;
			}
		}
		return null;
	}

}
