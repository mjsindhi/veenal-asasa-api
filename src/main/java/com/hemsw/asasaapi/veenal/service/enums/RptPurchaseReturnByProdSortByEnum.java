package com.hemsw.asasaapi.veenal.service.enums;

import java.util.ArrayList;
import java.util.List;

public enum RptPurchaseReturnByProdSortByEnum
{
	NAME("prod_name", "Product Name"),
	SUPPLIER_CNT("supplier_cnt", "Supplier Count"),
	CITY_CNT("city_cnt", "City Count"),
	STATE_CNT("state_cnt", "State Count"),
	MONTH_CNT("month_cnt", "Month Count"),
	DAY_CNT("day_cnt", "Day Count"),
	PURCHASE_CNT("purchase_return_cnt", "Purchase Count"),
	PRODUCT_CNT("prod_cnt", "Product Count"),
	QUANTITY("sum_qty", "Quantity"),
	ITEM_VAL("sum_item_val", "Item Value"),
	AMT_PAYABLE("sum_amt_payable", "Amount Payable");

	private final String key;
	private final String name;

	RptPurchaseReturnByProdSortByEnum(final String key, final String name)
	{
		this.key = key;
		this.name = name;
	}

	public String getKey()
	{
		return key;
	}

	public String getName()
	{
		return name;
	}

	public static RptPurchaseReturnByProdSortByEnum getByName(String name)
	{
		for (RptPurchaseReturnByProdSortByEnum value : values())
		{
			if (value.name.equals(name))
			{
				return value;
			}
		}
		return null;
	}

	public static List<String> getNames()
	{
		List<String> strings = new ArrayList<>();
		for (RptPurchaseReturnByProdSortByEnum value : values())
		{
			strings.add(value.getName());
		}
		return strings;
	}

}
