package com.hemsw.asasaapi.veenal.enums;

public enum BarcodeContainsType
{
	TX_CODE(1, "Transaction Code"),
	PRODUCT_CODE(2, "Product Code");

	private final int id;
	private final String name;

	BarcodeContainsType(final int id, final String nameString)
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
