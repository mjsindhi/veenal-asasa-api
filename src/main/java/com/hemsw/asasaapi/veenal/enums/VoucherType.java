package com.hemsw.asasaapi.veenal.enums;

import java.util.ArrayList;
import java.util.List;

public enum VoucherType
{
	PURCHASE(1, "Purchase", VoucherTypeByDrCr.DR),
	SALES(2, "Sales", VoucherTypeByDrCr.CR),
	PURCHASE_RETURN(3, "Purchase Return", VoucherTypeByDrCr.CR),
	SALES_RETURN(4, "Sales Return", VoucherTypeByDrCr.DR),
	PAYMENT(5, "Payment", VoucherTypeByDrCr.CR),
	RECEIPT(6, "Receipt", VoucherTypeByDrCr.DR),
	CONTRA(15, "Contra", null),
	JOURNAL(16, "Journal", VoucherTypeByDrCr.DR_CR),
	COMM_VOU(22, "Commission Voucher", null),
	COMM_VOU_PAYABLE(23, "Commission Voucher Payable", VoucherTypeByDrCr.DR),
	CASH_DISC_VOU(24, "Cash Discount Voucher", null),
	SALES_ORDER(26, "Sales Order", null),
	PURCHASE_ORDER(27, "Purchase Order", null),
	PI(28, "Proforma Invoice", null),
	INV_ADJUST(29, "Inventory Adjust", null),
	JOURNAL_ITEM(30, "Journal", VoucherTypeByDrCr.DR_CR),
	OPENING_BALANCE(31, "Opening Balance", VoucherTypeByDrCr.DR_CR),
	CDP_JOURNAL_VOU(32, "Cash Discount / Penalty", VoucherTypeByDrCr.DR_CR),
	ORDER_ADJUST(33, "Order Adjust", VoucherTypeByDrCr.DR_CR),
	ESTIMATE(34, "Estimate", null),;

	private final int id;
	private final String name;
	private final VoucherTypeByDrCr voucherTypeByDrCr;

	VoucherType(final int id, final String nameString, VoucherTypeByDrCr voucherTypeByDrCr)
	{
		this.id = id;
		name = nameString;
		this.voucherTypeByDrCr = voucherTypeByDrCr;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public static List<VoucherType> get(VoucherTypeByDrCr voucherTypeByDrCr)
	{
		List<VoucherType> voucherTypes = new ArrayList<>();
		for (VoucherType voucherType : VoucherType.values())
		{
			if (voucherType.voucherTypeByDrCr != null
					&& voucherType.voucherTypeByDrCr == voucherTypeByDrCr)
			{
				voucherTypes.add(voucherType);
			}
		}
		return voucherTypes;
	}

	public static List<Integer> getIds(VoucherTypeByDrCr voucherTypeByDrCr)
	{
		List<Integer> voucherTypeIds = new ArrayList<>();
		for (VoucherType voucherType : VoucherType.values())
		{
			if (voucherType.voucherTypeByDrCr != null
					&& voucherType.voucherTypeByDrCr == voucherTypeByDrCr)
			{
				voucherTypeIds.add(voucherType.getId());
			}
		}
		return voucherTypeIds;
	}

	public static VoucherType getById(int id)
	{
		for (VoucherType voucherType : VoucherType.values())
		{
			if (voucherType.getId() == id)
			{
				return voucherType;
			}
		}
		return null;
	}

}
