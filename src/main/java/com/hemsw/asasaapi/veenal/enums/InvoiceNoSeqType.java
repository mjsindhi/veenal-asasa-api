package com.hemsw.asasaapi.veenal.enums;

public enum InvoiceNoSeqType
{
	INCREMENTAL(1, "Incremental"),
	FILL_BLANK(2, "Fill Blanks");

	private final int id;
	private final String name;

	InvoiceNoSeqType(final int id, final String nameString)
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

}
