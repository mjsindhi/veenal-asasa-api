package com.hemsw.asasaapi.veenal.enums;

public enum Account
{
	CASH_IN_HAND(1, "Cash In Hand"),
	ACCOUNTS_RECEIVABLE(2, "Accounts Receivable"),
	CGST(3, "CGST"),
	SGST(4, "SGST"),
	IGST(5, "IGST"),
//	CGST_PAID(6, "CGST - Paid"),
//	SGST_PAID(7, "SGST - Paid"),
//	IGST_PAID(8, "IGST - Paid"),
	ACCOUNTS_PAYABLE(9, "Accounts Payable"),
	ROUND_OFF(10, "Round Off"),
	COMMISSION(11, "Commission"),
	PURCHASE(12, "Purchase"),
	PURCHASE_JOB(13, "Purchase - Job"),
	PURCHASE_RETURN(14, "Purchase Return"),
	SALES_CREDIT(15, "Sales - Credit"),
	SALES_RETURN_CREDIT(16, "Sales Return - Credit"),
	SALES_CASH(17, "Sales - Cash"),
	SALES_RETURN_CASH(18, "Sales Return - Cash"),
	DISCOUNT_GIVEN(19, "Discount Given"),
	DISCOUNT_RECEIVED(20, "Discount Received"),
	CASH_DISCOUNT(21, "Cash Discount"),
	LATE_PAYMENT_PENALTY(22, "Late Payment Penalty");

	private final int id;
	private final String name;

	Account(final int id, final String nameString)
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
