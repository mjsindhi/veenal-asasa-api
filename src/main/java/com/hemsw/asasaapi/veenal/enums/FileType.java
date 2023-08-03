package com.hemsw.asasaapi.veenal.enums;

public enum FileType
{
	PDF(1, "PDF"),
	JPG(2, "JPG");

	private final int id;
	private final String name;

	FileType(final int newValue, final String nameString)
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

	public static FileType getByName(String name)
	{
		for (FileType balanceType : FileType.values())
		{
			if (balanceType.name.equals(name))
			{
				return balanceType;
			}
		}
		return null;
	}

}
