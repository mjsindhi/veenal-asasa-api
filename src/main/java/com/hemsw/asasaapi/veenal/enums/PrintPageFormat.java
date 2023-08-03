package com.hemsw.asasaapi.veenal.enums;

public enum PrintPageFormat
{
	A4(1, "A4", "a4"),
	A5(3, "A5", "a5_on_a4");

	private final int id;
	private final String name;
	private final String fileNamePart;

	PrintPageFormat(final int id, final String nameString, final String fileName)
	{
		this.id = id;
		name = nameString;
		this.fileNamePart = fileName;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getFileNamePart()
	{
		return fileNamePart;
	}

	public static PrintPageFormat getByName(String name)
	{
		for (PrintPageFormat printPageFormat : PrintPageFormat.values())
		{
			if (printPageFormat.getName().equals(name))
			{
				return printPageFormat;
			}
		}
		return null;
	}

}
