package com.hemsw.asasaapi.veenal.enums;

public enum LabelSize
{
	SHEET_24("24"),
	SHEET_30("30"),
	SHEET_48("48");

	private final String fileNamePart;

	private LabelSize(String fileNamePart)
	{
		this.fileNamePart = fileNamePart;
	}

	public String getFileNamePart()
	{
		return fileNamePart;
	}
}
