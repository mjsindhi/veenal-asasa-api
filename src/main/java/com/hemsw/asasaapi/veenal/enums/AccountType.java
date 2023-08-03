package com.hemsw.asasaapi.veenal.enums;

public enum AccountType
{
	ASSET(1, "Asset"),
	LIABILITY(2, "Liability"),
	EXPENSE(3, "Expense"),
	INCOME(4, "Income "),
	CURRENT_ASSETS(5, "Current Assets"),
	FIXED_ASSETS(6, "Fixed Assets"),
	INVESTMENTS(7, "Investments"),
	CURRENT_LIABILITIES(8, "Current Liabilities"),
	LOANS(9, "Loans"),
	CAPITAL_ACCOUNT(10, "Capital Account"),
	DIRECT_EXPENSE(11, "Direct Expense"),
	INDIRECT_EXPENSE(12, "Indirect Expense"),
	PURCHASE_ACCOUNT(13, "Purchase Account"),
	DIRECT_INCOME(14, "Direct Income"),
	INDIRECT_INCOME(15, "Indirect Income"),
	SALES_ACCOUNT(16, "Sales Account"),
	BANK_ACCOUNT(17, "Bank Account"),
	CASH_ACCOUNT(18, "Cash Account"),
	ADVANCE_PAYMENT(19, "Advance Payment"),
	LOAN_GIVEN(20, "Loan Given"),
	CUSTOMER(21, "Customer"),
	ACCOUNTS_RECEIVABLE(22, "Accounts Receivable"),
	TAXES(23, "Taxes"),
	SUPPLIER(24, "Supplier"),
	WORKER(25, "Worker"),
	AGENT(26, "Agent"),
	ACCOUNTS_PAYABLE(27, "Accounts Payable"),
	SECURED_LOANS(28, "Secured Loans"),
	UNSECURED_LOANS(29, "Unsecured Loans");

	private final int id;
	private final String name;

	AccountType(final int id, final String nameString)
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
