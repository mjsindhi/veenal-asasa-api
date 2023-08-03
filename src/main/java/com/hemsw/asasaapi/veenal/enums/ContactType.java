package com.hemsw.asasaapi.veenal.enums;

public enum ContactType
{
	CUSTOMER(AccountType.CUSTOMER),
	SUPPLIER(AccountType.SUPPLIER),
	WORKER(AccountType.WORKER),
	AGENT(AccountType.AGENT);

	private AccountType accountType;

	private ContactType(AccountType accountType)
	{
		this.accountType = accountType;
	}

	public AccountType getAccountType()
	{
		return accountType;
	}

}
