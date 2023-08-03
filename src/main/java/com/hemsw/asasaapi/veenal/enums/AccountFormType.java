package com.hemsw.asasaapi.veenal.enums;

public enum AccountFormType
{
	ACCT(null),
	SUPPLIER(AccountType.SUPPLIER),
	AGENT(AccountType.AGENT),
	CUSTOMER(AccountType.CUSTOMER),
	BANK(AccountType.BANK_ACCOUNT),;

	private AccountType accountType;

	private AccountFormType(AccountType accountType)
	{
		this.accountType = accountType;
	}

	public AccountType getAccountType()
	{
		return accountType;
	}

}
