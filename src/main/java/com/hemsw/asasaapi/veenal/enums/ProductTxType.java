package com.hemsw.asasaapi.veenal.enums;

public enum ProductTxType
{
	OPENING_STOCK(1),
	PURCHASE(2),
	SALES_RETURN(3),
	SALES(4),;

	private final int number;

	private ProductTxType(int number)
	{
		this.number = number;
	}

	public int getNo()
	{
		return number;
	}
}
