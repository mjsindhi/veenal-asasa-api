package com.hemsw.asasaapi.veenal.enums;

public enum ColorClassEnum
{
	BLUE("bg-blue", "bg-blue-light"),
	BROWN("bg-brown", "bg-brown-light"),
	TEAL("bg-teal", "bg-teal-light"),
	PIN("bg-pink", "bg-pink-light"),
	PURPLE("bg-purple", "bg-purple-light");

	private final String name;
	private final String nameLight;

	ColorClassEnum(final String name, final String nameLight)
	{
		this.name = name;
		this.nameLight = nameLight;
	}

	public String getName()
	{
		return name;
	}

	public String getNameLight()
	{
		return nameLight;
	}

}
