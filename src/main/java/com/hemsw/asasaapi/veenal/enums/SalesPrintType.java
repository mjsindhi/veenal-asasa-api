package com.hemsw.asasaapi.veenal.enums;

public enum SalesPrintType
{
	TYPE_A("typea"),
	TYPE_B("typec"),
	TYPE_C("typec");

	private String fileNamePart;

	private SalesPrintType(String fileNamePart)
	{
		this.fileNamePart = fileNamePart;
	}

	public String getFileNamePart()
	{
		return fileNamePart;
	}

}
