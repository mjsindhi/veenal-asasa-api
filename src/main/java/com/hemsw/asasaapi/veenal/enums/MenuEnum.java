package com.hemsw.asasaapi.veenal.enums;

public enum MenuEnum
{
	COMMNC_BOOK("commnc_book", "Communication Book"),
	REMINDER("reminder", "Reminder"),
	COMMNC("commnc", "Communication"),
	LEAD("lead", "Lead"),
	ACCT_BOOK("acct_book", "Account Book"),
	DAY_BOOK("day_book", "Day Book"),
	CDP_JOURNAL_VOU("cdp_journal_vou", "Cash Discount / Penalty"),
	JOURNAL("journal", "Journal"),
	CONTRA("contra", "Contra"),
	RECEIPT("receipt", "Receipt"),
	PAYMENT("payment", "Payment"),
	SALES_RETURN("sales_return", "Sales Return"),
	SALES("sales", "Sales"),
	PI("pi", "Proforma Invoice"),
	SALES_ORDER("sales_order", "Sales Order"),
	ESTIMATE("estimate", "Estimate"),
	PURCHASE_RETURN("purchase_return", "Purchase Return"),
	PURCHASE("purchase", "Purchase"),
	PURCHASE_ORDER("purchase_order", "Purchase Order"),
	COMM_VOU("comm_vou", "Commission Voucher"),
	CDP_VOU("cdp_vou", "Cash Discount Voucher"),
	ORDER_ADJUST("order_adjust", "Order Adjust"),
	BANK("bank", "Bank"),
	CUSTOMER("customer", "Customer"),
	SUPPLIER("supplier", "Supplier"),
	AGENT("agent", "Agent"),
	ACCT("acct", "Account"),
	ACCT_TYPE("acct_type", "Account Type"),
	INV_ADJUST("inv_adjust", "Inventory Adjust"),
	COMM_LIST("comm_list", "Commission List"),
	PURCHASE_PRICE_LIST("purchase_price_list", "Purchase Price List"),
	SALES_PRICE_LIST("sales_price_list", "Sales Price List"),
	SERVICE("service", "Service"),
	PROD("prod", "Product"),
	PROD_OTH_CH("prod_oth_ch", "Product Other Charge"),
	TAX_CAT("tax_category", "Tax Category"),
	CAT("cat", "Category"),
	UNIT("unit", "Unit"),
	RPT_SALES_RETURN_BY_MONTH("rpt_sales_return_by_month", "By Month"),
	RPT_SALES_RETURN_BY_DAY("rpt_sales_return_by_day", "By Day"),
	RPT_SALES_RETURN_BY_CUSTOMER("rpt_sales_return_by_customer", "By Customer"),
	RPT_SALES_RETURN_BY_CATEGORY("rpt_sales_return_by_category", "By Category"),
	RPT_SALES_RETURN_BY_PRODUCT("rpt_sales_return_by_product", "By Product"),
	RPT_SALES_RETURN_BY_CITY("rpt_sales_return_by_city", "By City"),
	RPT_SALES_RETURN_BY_STATE("rpt_sales_return_by_state", "By State"),
	RPT_SALES_RETURN_BY_AGENT("rpt_sales_return_by_agent", "By Agent"),
	RPT_SALES_RETURN_DETAILED_BY_VOUCHER("rpt_sales_return_detailed_by_voucher", "Detailed By Voucher"),
	RPT_SALES_RETURN_DETAILED_BY_PROD("rpt_sales_return_detailed_by_prod", "Detailed By Product"),
	RPT_SALES_BY_MONTH("rpt_sales_by_month", "By Month"),
	RPT_SALES_BY_DAY("rpt_sales_by_day", "By Day"),
	RPT_SALES_BY_CUSTOMER("rpt_sales_by_customer", "By Customer"),
	RPT_SALES_BY_CATEGORY("rpt_sales_by_category", "By Category"),
	RPT_SALES_BY_PRODUCT("rpt_sales_by_product", "By Product"),
	RPT_SALES_BY_CITY("rpt_sales_by_city", "By City"),
	RPT_SALES_BY_STATE("rpt_sales_by_state", "By State"),
	RPT_SALES_BY_AGENT("rpt_sales_by_agent", "By Agent"),
	RPT_SALES_DETAILED_BY_VOUCHER("rpt_sales_detailed_by_voucher", "Detailed By Voucher"),
	RPT_SALES_DETAILED_BY_PROD("rpt_sales_detailed_by_prod", "Detailed By Product"),
	SALES_ANALYSIS("sales_analysis", "Sales Analysis"),
	RPT_SALES_PROFIT_BY_CUSTOMER("rpt_sales_profit_by_customer", "By Customer"),
	RPT_SALES_PROFIT_BY_PROD("rpt_sales_profit_by_prod", "By Product"),
	RPT_SALES_PROFIT_BY_SALES_VOUCHER("rpt_sales_profit_by_sales_voucher", "By Sales Voucher"),
	RPT_SALES_PROFIT_BY_SALES_ITEM("rpt_sales_profit_by_sales_item", "By Sales Item"),
	RPT_PURCHASE_RETURN_BY_MONTH("rpt_purchase_return_by_month", "By Month"),
	RPT_PURCHASE_RETURN_BY_DAY("rpt_purchase_return_by_day", "By Day"),
	RPT_PURCHASE_RETURN_BY_SUPPLIER("rpt_purchase_return_by_supplier", "By Supplier"),
	RPT_PURCHASE_RETURN_BY_CATEGORY("rpt_purchase_return_by_category", "By Category"),
	RPT_PURCHASE_RETURN_BY_PRODUCT("rpt_purchase_return_by_product", "By Product"),
	RPT_PURCHASE_RETURN_BY_CITY("rpt_purchase_return_by_city", "By City"),
	RPT_PURCHASE_RETURN_BY_STATE("rpt_purchase_return_by_state", "By State"),
	RPT_PURCHASE_RETURN_DETAILED_BY_VOUCHER("rpt_purchase_return_detailed_by_voucher", "Detailed By Voucher"),
	RPT_PURCHASE_RETURN_DETAILED_BY_PROD("rpt_purchase_return_detailed_by_prod", "Detailed By Product"),
	RPT_PURCHASE_BY_MONTH("rpt_purchase_by_month", "By Month"),
	RPT_PURCHASE_BY_DAY("rpt_purchase_by_day", "By Day"),
	RPT_PURCHASE_BY_SUPPLIER("rpt_purchase_by_supplier", "By Supplier"),
	RPT_PURCHASE_BY_CATEGORY("rpt_purchase_by_category", "By Category"),
	RPT_PURCHASE_BY_PRODUCT("rpt_purchase_by_product", "By Product"),
	RPT_PURCHASE_BY_CITY("rpt_purchase_by_city", "By City"),
	RPT_PURCHASE_BY_STATE("rpt_purchase_by_state", "By State"),
	RPT_PURCHASE_DETAILED_BY_VOUCHER("rpt_purchase_detailed_by_voucher", "Detailed By Voucher"),
	RPT_PURCHASE_DETAILED_BY_PROD("rpt_purchase_detailed_by_prod", "Detailed By Product"),
	RPT_ESTIMATE_PENDING_BY_PROD("rpt_estimate_pending_by_prod", "By Product"),
	RPT_ESTIMATE_PENDING_BY_ACCT("rpt_estimate_pending_by_acct", "By Customer"),
	RPT_ESTIMATE_PENDING_PRODUCTS("rpt_estimate_pending_products", "Pending Products"),
	DUE_RCVABLE_BY_CUSTOMER("due_rcvable_by_customer", "By Customer"),
	DUE_RCVABLE_BY_SALES("due_rcvable_by_sales", "By Sales"),
	RPT_IO_SUMM_BY_PROD_CAT("rpt_io_summ_by_prod_cat", "By Category"),
	RPT_IO_SUMM_BY_MONTH("rpt_io_summ_by_month", "By Month"),
	RPT_IO_SUMM_BY_PROD("rpt_io_summ_by_prod", "By Product"),
	RPT_IO_DET("rpt_io_det", "In/Out Detailed"),
	LEDGER("ledger", "Ledger"),
	ACCT_SUMM_BY_ACCT_TYPE("acct_summ_by_acct_type", "Account Summary"),
	TRIAL_BAL("trial_bal", "Trial Balance"),
	TRADING_ACCT("trading_acct", "Trading Account"),
	PL_ACCT("pl_acct", "PL Account"),
	BALANCE_SHEET("balance_sheet", "Balance Sheet"),
	GSTR3B("gstr3b", "GSTR3B"),
	INVENTORY_LEDGER("inventory_ledger", "Inventory Ledger"),
	CURRENT_STOCK("current_stock", "Current Stock"),
	CURRENT_STOCK_VAL("current_stock_val", "Current Stock Value"),
	LOW_STOCK("low_stock", "Low Stock"),
	CDP_VOU_LEDGER("cdp_vou_ledger", "Cash Discount Voucher Ledger"),
	CDP_VOU_LEDGER_2("cdp_vou_ledger_2", "Cash Discount Voucher Ledger 2"),
	COMM_VOU_LEDGER("comm_vou_ledger", "Commission Voucher Ledger"),
	SALES_ORDER_PENDING("sales_order_pending", "Sales Order Pending"),
	PURCHASE_ORDER_PENDING("purchase_order_pending", "Purchase Order Pending"),
	MSG_QUEUE("msg_queue", "Message Queue"),
	SCHEME("scheme", "Scheme"),
	TRANSPORTER("transporter", "Transporter"),
	TAX_CAL_RATE("tax_cal_rate", "Tax Calculation Rate"),
	TAX("tax", "Tax"),
	MSG_TEMPLATE("msg_template", "Message Template"),
	BROWSER("browser", "Browser"),
	COMPANY_INFO("company_info", "Company Information"),
	COMPANY_PROFILE("company_profile", "Company Profile"),
	VOU_OTH_CH("vou_oth_ch", "Voucher Other Charge"),
	LEAD_SRC("lead_src", "Lead Source"),
	LEAD_STATUS("lead_status", "Lead Status"),
	IMPORT_DATA("import_data", "Import Data"),
	MENU_CONFIG("menu_config", "Menu Config"),;

	private final String key;
	private final String displayName;

	private MenuEnum(String key, String displayName)
	{
		this.key = key;
		this.displayName = displayName;
	}

	public String getKey()
	{
		return key;
	}

	public String getDisplayName()
	{
		return displayName;
	}

	public static MenuEnum getMenuByDisplayName(String displayName)
	{
		for (MenuEnum menu : MenuEnum.values())
		{
			if (menu.displayName.equals(displayName))
			{
				return menu;
			}
		}
		return null;
	}

}
