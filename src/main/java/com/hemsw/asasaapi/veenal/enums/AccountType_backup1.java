package com.hemsw.asasaapi.veenal.enums;

public enum AccountType_backup1
{
	CUSTOMER(1, "Customer"),
	SUPPLIER(2, "Supplier"),
	BANK(3, "Bank"),
	CASH(4, "Cash"),
	WORKER(5, "Worker"),
	SALES(6, "Sales"),
	PURCHASE(7, "Purchase"),
	ACCT_RCVABLE(8, "Accounts Recievables"),
	ACCT_PAYABLE(9, "Accounts Payable"),
	TAX(10, "Tax"),
	EXPENSE(11, "Expense"),
	AGENT(12, "Agent");

	private final int id;
	private final String name;

	AccountType_backup1(final int id, final String nameString)
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
