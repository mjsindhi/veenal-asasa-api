package com.hemsw.asasaapi.veenal.enums;

public enum TxType
{
	DR(1, "Dr"),
	CR(2, "Cr");

	private final int id;
	private final String name;

	TxType(final int id, final String nameString)
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

	public static TxType getByName(String name)
	{
		for (TxType txType : TxType.values())
		{
			if (txType.name.equals(name))
			{
				return txType;
			}
		}

		return null;
	}

}
