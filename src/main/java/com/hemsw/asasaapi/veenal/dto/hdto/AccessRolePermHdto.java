package com.hemsw.asasaapi.veenal.dto.hdto;

import com.hemsw.asasaapi.veenal.model.app.AccessRolePermModel;
import java.util.ArrayList;
import java.util.List;

public class AccessRolePermHdto
{

	public enum Keys
	{
		MENU_CONFIG(1, "menu_config", "Menu Configure"),
		COMPANY_PROFILE_ADD(2, "company_profile_add", "Company Profile Add"),
		COMPANY_PROFILE_EDIT(3, "company_profile_edit", "Company Profile Edit"),
		COMPANY_PROFILE_DELETE(4, "company_profile_delete", "Company Profile Delete"),
		COMPANY_PROFILE_VIEW(5, "company_profile_view", "Company Profile View"),
		COMPANY_PROFILE_EXPORT(6, "company_profile_export", "Company Profile Export"),
		STATE_ADD(7, "state_add", "State Add"),
		STATE_EDIT(8, "state_edit", "State Edit"),
		STATE_DELETE(9, "state_delete", "State Delete"),
		STATE_VIEW(10, "state_view", "State View"),
		STATE_EXPORT(11, "state_export", "State Export"),
		VOU_OTH_CH_ADD(12, "vou_oth_ch_add", "Voucher Other Charge Add"),
		VOU_OTH_CH_EDIT(13, "vou_oth_ch_edit", "Voucher Other Charge Edit"),
		VOU_OTH_CH_DELETE(14, "vou_oth_ch_delete", "Voucher Other Charge Delete"),
		VOU_OTH_CH_VIEW(15, "vou_oth_ch_view", "Voucher Other Charge View"),
		VOU_OTH_CH_EXPORT(16, "vou_oth_ch_export", "Voucher Other Charge Export"),
		COMPANY_INFO(17, "company_info", "Update Company Information"),
		BROWSER(18, "browser", "Browser"),
		MSG_TEMPLATE_ADD(19, "msg_template_add", "Message Template Add"),
		MSG_TEMPLATE_EDIT(20, "msg_template_edit", "Message Template Edit"),
		MSG_TEMPLATE_DELETE(21, "msg_template_delete", "Message Template Delete"),
		MSG_TEMPLATE_VIEW(22, "msg_template_view", "Message Template View"),
		MSG_TEMPLATE_EXPORT(23, "msg_template_export", "Message Template Export"),
		TAX_ADD(24, "tax_add", "Tax Add"),
		TAX_EDIT(25, "tax_edit", "Tax Edit"),
		TAX_DELETE(26, "tax_delete", "Tax Delete"),
		TAX_VIEW(27, "tax_view", "Tax View"),
		TAX_EXPORT(28, "tax_export", "Tax Export"),
		TAX_CAL_RATE_ADD(29, "tax_cal_rate_add", "Tax Calculation Rate Add"),
		TAX_CAL_RATE_EDIT(30, "tax_cal_rate_edit", "Tax Calculation Rate Edit"),
		TAX_CAL_RATE_DELETE(31, "tax_cal_rate_delete", "Tax Calculation Rate Delete"),
		TAX_CAL_RATE_VIEW(32, "tax_cal_rate_view", "Tax Calculation Rate View"),
		TAX_CAL_RATE_EXPORT(33, "tax_cal_rate_export", "Tax Calculation Rate Export"),
		TRANSPORTER_ADD(34, "transporter_add", "Transporter Add"),
		TRANSPORTER_EDIT(35, "transporter_edit", "Transporter Edit"),
		TRANSPORTER_DELETE(36, "transporter_delete", "Transporter Delete"),
		TRANSPORTER_VIEW(37, "transporter_view", "Transporter View"),
		TRANSPORTER_EXPORT(38, "transporter_export", "Transporter Export"),
		SCHEME_ADD(39, "scheme_add", "Scheme Add"),
		SCHEME_EDIT(40, "scheme_edit", "Scheme Edit"),
		SCHEME_DELETE(41, "scheme_delete", "Scheme Delete"),
		SCHEME_VIEW(42, "scheme_view", "Scheme View"),
		SCHEME_EXPORT(43, "scheme_export", "Scheme Export"),
		UNIT_ADD(44, "unit_add", "Unit Add"),
		UNIT_EDIT(45, "unit_edit", "Unit Edit"),
		UNIT_DELETE(46, "unit_delete", "Unit Delete"),
		UNIT_VIEW(47, "unit_view", "Unit View"),
		UNIT_EXPORT(48, "unit_export", "Unit Export"),
		PROD_OTH_CH_ADD(49, "prod_oth_ch_add", "Product Other Charge Add"),
		PROD_OTH_CH_EDIT(50, "prod_oth_ch_edit", "Product Other Charge Edit"),
		PROD_OTH_CH_DELETE(51, "prod_oth_ch_delete", "Product Other Charge Delete"),
		PROD_OTH_CH_VIEW(52, "prod_oth_ch_view", "Product Other Charge View"),
		PROD_OTH_CH_EXPORT(53, "prod_oth_ch_export", "Product Other Charge Export"),
		CAT_ADD(54, "cat_add", "Category Add"),
		CAT_EDIT(55, "cat_edit", "Category Edit"),
		CAT_DELETE(56, "cat_delete", "Category Delete"),
		CAT_VIEW(57, "cat_view", "Category View"),
		CAT_EXPORT(58, "cat_export", "Category Export"),
		TAX_CAT_ADD(59, "tax_cat_add", "Tax Category Add"),
		TAX_CAT_EDIT(60, "tax_cat_edit", "Tax Category Edit"),
		TAX_CAT_DELETE(61, "tax_cat_delete", "Tax Category Delete"),
		TAX_CAT_VIEW(62, "tax_cat_view", "Tax Category View"),
		TAX_CAT_IMPORT(63, "tax_cat_import", "Tax Category Import"),
		TAX_CAT_EXPORT(64, "tax_cat_export", "Tax Category Export"),
		PROD_ADD(65, "prod_add", "Product Add"),
		PROD_EDIT(66, "prod_edit", "Product Edit"),
		PROD_DELETE(67, "prod_delete", "Product Delete"),
		PROD_VIEW(68, "prod_view", "Product View"),
		PROD_IMPORT(69, "prod_import", "Product Import"),
		PROD_EXPORT(70, "prod_export", "Product Export"),
		PROD_PRINT_BARCODE(71, "prod_print_barcode", "Product Print Barcode"),
		SERVICE_ADD(72, "service_add", "Service Add"),
		SERVICE_EDIT(73, "service_edit", "Service Edit"),
		SERVICE_DELETE(74, "service_delete", "Service Delete"),
		SERVICE_VIEW(75, "service_view", "Service View"),
		SERVICE_EXPORT(76, "service_export", "Service Export"),
		PRICE_LIST_ADD(77, "price_list_add", "Price List Add"),
		PRICE_LIST_EDIT(78, "price_list_edit", "Price List Edit"),
		PRICE_LIST_DELETE(79, "price_list_delete", "Price List Delete"),
		PRICE_LIST_VIEW(80, "price_list_view", "Price List View"),
		PRICE_LIST_IMPORT(81, "price_list_import", "Price List Import"),
		PRICE_LIST_EXPORT(82, "price_list_export", "Price List Export"),
		COMM_LIST_ADD(83, "comm_list_add", "Commission List Add"),
		COMM_LIST_EDIT(84, "comm_list_edit", "Commission List Edit"),
		COMM_LIST_DELETE(85, "comm_list_delete", "Commission List Delete"),
		COMM_LIST_VIEW(86, "comm_list_view", "Commission List View"),
		COMM_LIST_IMPORT(87, "comm_list_import", "Commission List Import"),
		COMM_LIST_EXPORT(88, "comm_list_export", "Commission List Export"),
		INV_ADJUST_ADD(89, "inv_adjust_add", "Inventory Adjust Add"),
		INV_ADJUST_EDIT(90, "inv_adjust_edit", "Inventory Adjust Edit"),
		INV_ADJUST_DELETE(91, "inv_adjust_delete", "Inventory Adjust Delete"),
		INV_ADJUST_VIEW(92, "inv_adjust_view", "Inventory Adjust View"),
		INV_ADJUST_EXPORT(93, "inv_adjust_export", "Inventory Adjust Export"),
		LEAD_ADD(94, "lead_add", "Lead Add"),
		LEAD_EDIT(95, "lead_edit", "Lead Edit"),
		LEAD_DELETE(96, "lead_delete", "Lead Delete"),
		LEAD_VIEW(97, "lead_view", "Lead View"),
		LEAD_IMPORT(98, "lead_import", "Lead Import"),
		LEAD_EXPORT(99, "lead_export", "Lead Export"),
		ACCT_TYPE_ADD(100, "acct_type_add", "Account Type Add"),
		ACCT_TYPE_EDIT(101, "acct_type_edit", "Account Type Edit"),
		ACCT_TYPE_DELETE(102, "acct_type_delete", "Account Type Delete"),
		ACCT_TYPE_VIEW(103, "acct_type_view", "Account Type View"),
		ACCT_TYPE_IMPORT(104, "acct_type_import", "Account Type Import"),
		ACCT_TYPE_EXPORT(105, "acct_type_export", "Account Type Export"),
		ACCT_ADD(106, "acct_add", "Account Add"),
		ACCT_EDIT(107, "acct_edit", "Account Edit"),
		ACCT_DELETE(108, "acct_delete", "Account Delete"),
		ACCT_VIEW(109, "acct_view", "Account View"),
		ACCT_IMPORT(110, "acct_import", "Account Import"),
		ACCT_EXPORT(111, "acct_export", "Account Export"),
		AGENT_ADD(112, "agent_add", "Agent Add"),
		AGENT_EDIT(113, "agent_edit", "Agent Edit"),
		AGENT_DELETE(114, "agent_delete", "Agent Delete"),
		AGENT_VIEW(115, "agent_view", "Agent View"),
		AGENT_EXPORT(116, "agent_export", "Agent Export"),
		SUPPLIER_ADD(117, "supplier_add", "Supplier Add"),
		SUPPLIER_EDIT(118, "supplier_edit", "Supplier Edit"),
		SUPPLIER_DELETE(119, "supplier_delete", "Supplier Delete"),
		SUPPLIER_VIEW(120, "supplier_view", "Supplier View"),
		SUPPLIER_EXPORT(121, "supplier_export", "Supplier Export"),
		SUPPLIER_PRINT_ENVELOPE(122, "supplier_print_envelope", "Supplier Print Envelope"),
		SUPPLIER_PRINT_LEDGER(123, "supplier_print_ledger", "Supplier Print Ledger"),
		CUSTOMER_ADD(124, "customer_add", "Customer Add"),
		CUSTOMER_EDIT(125, "customer_edit", "Customer Edit"),
		CUSTOMER_DELETE(126, "customer_delete", "Customer Delete"),
		CUSTOMER_VIEW(127, "customer_view", "Customer View"),
		CUSTOMER_EXPORT(128, "customer_export", "Customer Export"),
		CUSTOMER_PRINT_ENVELOPE(129, "customer_print_envelope", "Customer Print Envelope"),
		CUSTOMER_PRINT_LEDGER(130, "customer_print_ledger", "Customer Print Ledger"),
		BANK_ADD(131, "bank_add", "Bank Add"),
		BANK_EDIT(132, "bank_edit", "Bank Edit"),
		BANK_DELETE(133, "bank_delete", "Bank Delete"),
		BANK_VIEW(134, "bank_view", "Bank View"),
		BANK_EXPORT(135, "bank_export", "Bank Export"),
		ORDER_ADJUST_ADD(136, "order_adjust_add", "Order Adjust Add"),
		ORDER_ADJUST_EDIT(137, "order_adjust_edit", "Order Adjust Edit"),
		ORDER_ADJUST_DELETE(138, "order_adjust_delete", "Order Adjust Delete"),
		ORDER_ADJUST_VIEW_OWN(139, "order_adjust_view_own", "Order Adjust View Own"),
		ORDER_ADJUST_VIEW_ALL(140, "order_adjust_view_all", "Order Adjust View All"),
		ORDER_ADJUST_EXPORT(141, "order_adjust_export", "Order Adjust Export"),
		ORDER_ADJUST_SEND(142, "order_adjust_send", "Order Adjust Send"),
		CDP_VOU_ADD(143, "cdp_vou_add", "CD Penalty Voucher Add"),
		CDP_VOU_EDIT(144, "cdp_vou_edit", "CD Penalty Voucher Edit"),
		CDP_VOU_DELETE(145, "cdp_vou_delete", "CD Penalty Voucher Delete"),
		CDP_VOU_VIEW_OWN(146, "cdp_vou_view_own", "CD Penalty Voucher View Own"),
		CDP_VOU_VIEW_ALL(147, "cdp_vou_view_all", "CD Penalty Voucher View All"),
		CDP_VOU_EXPORT(148, "cdp_vou_export", "CD Penalty Voucher Export"),
		CDP_VOU_SEND(149, "cdp_vou_send", "CD Penalty Voucher Send"),
		CDP_JOURNAL_VOU_ADD(150, "cdp_journal_vou_add", "CD Penalty Journal Voucher Add"),
		CDP_JOURNAL_VOU_EDIT(151, "cdp_journal_vou_edit", "CD Penalty Journal Voucher Edit"),
		CDP_JOURNAL_VOU_DELETE(152, "cdp_journal_vou_delete", "CD Penalty Journal Voucher Delete"),
		CDP_JOURNAL_VOU_VIEW_OWN(153, "cdp_journal_vou_view_own", "CD Penalty Journal Voucher View Own"),
		CDP_JOURNAL_VOU_VIEW_ALL(154, "cdp_journal_vou_view_all", "CD Penalty Journal Voucher View All"),
		CDP_JOURNAL_VOU_EXPORT(155, "cdp_journal_vou_export", "CD Penalty Journal Voucher Export"),
		CDP_JOURNAL_VOU_PRINT(156, "cdp_journal_vou_print", "CD Penalty Journal Voucher Print"),
		CDP_JOURNAL_VOU_SEND(157, "cdp_journal_vou_send", "CD Penalty Journal Voucher Send"),
		COMM_VOU_ADD(158, "comm_vou_add", "Commission Voucher Add"),
		COMM_VOU_EDIT(159, "comm_vou_edit", "Commission Voucher Edit"),
		COMM_VOU_DELETE(160, "comm_vou_delete", "Commission Voucher Delete"),
		COMM_VOU_VIEW_OWN(161, "comm_vou_view_own", "Commission Voucher View Own"),
		COMM_VOU_VIEW_ALL(162, "comm_vou_view_all", "Commission Voucher View All"),
		COMM_VOU_EXPORT(163, "comm_vou_export", "Commission Voucher Export"),
		COMM_VOU_PRINT(164, "comm_vou_print", "Commission Voucher Print"),
		COMM_VOU_SEND(165, "comm_vou_send", "Commission Voucher Send"),
		PURCHASE_ORDER_ADD(166, "purchase_order_add", "Purchase Order Add"),
		PURCHASE_ORDER_EDIT(167, "purchase_order_edit", "Purchase Order Edit"),
		PURCHASE_ORDER_DELETE(168, "purchase_order_delete", "Purchase Order Delete"),
		PURCHASE_ORDER_VIEW_OWN(169, "purchase_order_view_own", "Purchase Order View Own"),
		PURCHASE_ORDER_VIEW_ALL(170, "purchase_order_view_all", "Purchase Order View All"),
		PURCHASE_ORDER_EXPORT(171, "purchase_order_export", "Purchase Order Export"),
		PURCHASE_ORDER_PRINT(172, "purchase_order_print", "Purchase Order Print"),
		PURCHASE_ORDER_PRINT_LIST(173, "purchase_order_print_list", "Purchase Order Print List"),
		PURCHASE_ORDER_SEND(174, "purchase_order_send", "Purchase Order Send"),
		ESTIMATE_ADD(175, "estimate_add", "Estimate Add"),
		ESTIMATE_EDIT(176, "estimate_edit", "Estimate Edit"),
		ESTIMATE_DELETE(177, "estimate_delete", "Estimate Delete"),
		ESTIMATE_VIEW_OWN(178, "estimate_view_own", "Estimate View Own"),
		ESTIMATE_VIEW_ALL(179, "estimate_view_all", "Estimate View All"),
		ESTIMATE_EXPORT(180, "estimate_export", "Estimate Export"),
		ESTIMATE_PRINT(181, "estimate_print", "Estimate Print"),
		ESTIMATE_PRINT_LIST(182, "estimate_print_list", "Estimate Print List"),
		ESTIMATE_SEND(183, "estimate_send", "Estimate Send"),
		SALES_ORDER_ADD(184, "sales_order_add", "Sales Order Add"),
		SALES_ORDER_EDIT(185, "sales_order_edit", "Sales Order Edit"),
		SALES_ORDER_DELETE(186, "sales_order_delete", "Sales Order Delete"),
		SALES_ORDER_VIEW_OWN(187, "sales_order_view_own", "Sales Order View Own"),
		SALES_ORDER_VIEW_ALL(188, "sales_order_view_all", "Sales Order View All"),
		SALES_ORDER_EXPORT(189, "sales_order_export", "Sales Order Export"),
		SALES_ORDER_PRINT(190, "sales_order_print", "Sales Order Print"),
		SALES_ORDER_PRINT_LIST(191, "sales_order_print_list", "Sales Order Print List"),
		SALES_ORDER_SEND(192, "sales_order_send", "sales Order Send"),
		PI_ADD(193, "pi_add", "Proforma Invoice Add"),
		PI_EDIT(194, "pi_edit", "Proforma Invoice Edit"),
		PI_DELETE(195, "pi_delete", "Proforma Invoice Delete"),
		PI_VIEW_OWN(196, "pi_view_own", "Proforma Invoice View Own"),
		PI_VIEW_ALL(197, "pi_view_all", "Proforma Invoice View All"),
		PI_EXPORT(198, "pi_export", "Proforma Invoice Export"),
		PI_PRINT(199, "pi_print", "Proforma Invoice Print"),
		PI_PRINT_CHALLAN(200, "pi_print_challan", "Proforma Invoice Print Challan"),
		PI_PRINT_LIST(201, "pi_print_list", "Proforma Invoice Print List"),
		PI_SEND(202, "pi_send", "Proforma Invoice Send"),
		PURCHASE_RETURN_ADD(203, "purchase_return_add", "Purchase Return Add"),
		PURCHASE_RETURN_EDIT(204, "purchase_return_edit", "Purchase Return Edit"),
		PURCHASE_RETURN_DELETE(205, "purchase_return_delete", "Purchase Return Delete"),
		PURCHASE_RETURN_VIEW_OWN(206, "purchase_return_view_own", "Purchase Return View Own"),
		PURCHASE_RETURN_VIEW_ALL(207, "purchase_return_view_all", "Purchase Return View All"),
		PURCHASE_RETURN_EXPORT(208, "purchase_return_export", "Purchase Return Export"),
		PURCHASE_RETURN_PRINT(209, "purchase_return_print", "Purchase Return Print"),
		PURCHASE_RETURN_PRINT_CHALLAN(210, "purchase_return_print_challan", "Purchase Return Print Challan"),
		PURCHASE_RETURN_PRINT_LIST(211, "purchase_return_print_list", "Purchase Return Print List"),
		PURCHASE_RETURN_SEND(212, "purchase_return_send", "Purchase Return Send"),
		PURCHASE_ADD(213, "purchase_add", "Purchase Add"),
		PURCHASE_EDIT(214, "purchase_edit", "Purchase Edit"),
		PURCHASE_DELETE(215, "purchase_delete", "Purchase Delete"),
		PURCHASE_VIEW_OWN(216, "purchase_view_own", "Purchase View Own"),
		PURCHASE_VIEW_ALL(217, "purchase_view_all", "Purchase View All"),
		PURCHASE_EXPORT(218, "purchase_export", "Purchase Export"),
		PURCHASE_PRINT(219, "purchase_print", "Purchase Print"),
		PURCHASE_PRINT_LIST(220, "purchase_print_list", "Purchase Print List"),
		PURCHASE_PRINT_BARCODE(221, "purchase_print_barcode", "Purchase Print Barcode"),
		PURCHASE_SEND(222, "purchase_send", "Purchase Send"),
		SALES_RETURN_ADD(223, "sales_return_add", "Sales Return Add"),
		SALES_RETURN_EDIT(224, "sales_return_edit", "Sales Return Edit"),
		SALES_RETURN_DELETE(225, "sales_return_delete", "Sales Return Delete"),
		SALES_RETURN_VIEW_OWN(226, "sales_return_view_own", "Sales Return View Own"),
		SALES_RETURN_VIEW_ALL(227, "sales_return_view_all", "Sales Return View All"),
		SALES_RETURN_EXPORT(228, "sales_return_export", "Sales Return Export"),
		SALES_RETURN_PRINT(229, "sales_return_print", "Sales Return Print"),
		SALES_RETURN_PRINT_BARCODE(230, "sales_return_print_barcode", "Sales Return Print Barcode"),
		SALES_RETURN_PRINT_LIST(231, "sales_return_print_list", "Sales Return Print List"),
		SALES_RETURN_SEND(232, "sales_return_send", "Sales Return Send"),
		SALES_ADD(233, "sales_add", "Sales Add"),
		SALES_EDIT(234, "sales_edit", "Sales Edit"),
		SALES_DELETE(235, "sales_delete", "Sales Delete"),
		SALES_VIEW_OWN(236, "sales_view_own", "Sales View Own"),
		SALES_VIEW_ALL(237, "sales_view_all", "Sales View All"),
		SALES_EXPORT(238, "sales_export", "Sales Export"),
		SALES_PRINT(239, "sales_print", "Sales Print"),
		SALES_PRINT_CHALLAN(240, "sales_print_challan", "Sales Print Challan"),
		SALES_PRINT_LIST(241, "sales_print_list", "Sales Print List"),
		SALES_SEND(242, "sales_send", "Sales Send"),
		PAYMENT_ADD(243, "payment_add", "Payment Add"),
		PAYMENT_EDIT(244, "payment_edit", "Payment Edit"),
		PAYMENT_DELETE(245, "payment_delete", "Payment Delete"),
		PAYMENT_VIEW_OWN(246, "payment_view_own", "Payment View Own"),
		PAYMENT_VIEW_ALL(247, "payment_view_all", "Payment View All"),
		PAYMENT_EXPORT(248, "payment_export", "Payment Export"),
		PAYMENT_PRINT(249, "payment_print", "Payment Print"),
		PAYMENT_SEND(250, "payment_send", "Payment Send"),
		RECEIPT_ADD(251, "receipt_add", "Receipt Add"),
		RECEIPT_EDIT(252, "receipt_edit", "Receipt Edit"),
		RECEIPT_DELETE(253, "receipt_delete", "Receipt Delete"),
		RECEIPT_VIEW_OWN(254, "receipt_view_own", "Receipt View Own"),
		RECEIPT_VIEW_ALL(255, "receipt_view_all", "Receipt View All"),
		RECEIPT_EXPORT(256, "receipt_export", "Receipt Export"),
		RECEIPT_PRINT(257, "receipt_print", "Receipt Print"),
		RECEIPT_SEND(258, "receipt_send", "Receipt Send"),
		CONTRA_ADD(259, "contra_add", "Contra Add"),
		CONTRA_EDIT(260, "contra_edit", "Contra Edit"),
		CONTRA_DELETE(261, "contra_delete", "Contra Delete"),
		CONTRA_VIEW_OWN(262, "contra_view_own", "Contra View Own"),
		CONTRA_VIEW_ALL(263, "contra_view_all", "Contra View All"),
		CONTRA_EXPORT(264, "contra_export", "Contra Export"),
		CONTRA_PRINT(265, "contra_print", "Contra Print"),
		CONTRA_SEND(266, "contra_send", "Contra Send"),
		JOURNAL_ADD(267, "journal_add", "Journal Add"),
		JOURNAL_EDIT(268, "journal_edit", "Journal Edit"),
		JOURNAL_DELETE(269, "journal_delete", "Journal Delete"),
		JOURNAL_VIEW_OWN(270, "journal_view_own", "Journal View Own"),
		JOURNAL_VIEW_ALL(271, "journal_view_all", "Journal View All"),
		JOURNAL_EXPORT(272, "journal_export", "Journal Export"),
		JOURNAL_PRINT(273, "journal_print", "Journal Print"),
		JOURNAL_SEND(274, "journal_send", "Journal Send"),
		TASK_ADD(275, "task_add", "Task Add"),
		TASK_EDIT(276, "task_edit", "Task Edit"),
		TASK_DELETE(277, "task_delete", "Task Delete"),
		TASK_VIEW_OWN(278, "task_view_own", "Task View Own"),
		TASK_VIEW_ALL(279, "task_view_all", "Task View All"),
		TASK_EXPORT(280, "task_export", "Task Export"),
		ACCT_BOOK_OPEN(281, "acct_book_open", "Account Book Open"),
		OPEN_SYSTEM_SETTINGS(282, "open_system_settings", "Open System Settings"),
		ACCESS_ROLE_ADD(283, "access_role_add", "Access Role Add"),
		ACCESS_ROLE_EDIT(284, "access_role_edit", "Access Role Edit"),
		ACCESS_ROLE_DELETE(285, "access_role_delete", "Access Role Delete"),
		ACCESS_ROLE_VIEW(286, "access_role_view", "Access Role View"),
		ACCESS_ROLE_EXPORT(287, "access_role_export", "Access Role Export"),
		USER_ADD(288, "user_add", "User Add"),
		USER_EDIT(289, "user_edit", "User Edit"),
		USER_DELETE(290, "user_delete", "User Delete"),
		USER_VIEW(291, "user_view", "User View"),
		USER_EXPORT(292, "user_export", "User Export"),
		OPEN_COMPANY_MANAGEMENT(293, "open_company_management", "Open Company Management"),
		COMPANY_ADD(294, "company_add", "Company Add"),
		COMPANY_EDIT(295, "company_edit", "Company Edit"),
		COMPANY_DELETE(296, "company_delete", "Company Delete"),
		FIN_YEAR_ADD(297, "fin_year_add", "Financial Year Add"),
		FIN_YEAR_EDIT(298, "fin_year_edit", "Financial Year Edit"),
		FIN_YEAR_DELETE(299, "fin_year_delete", "Financial Year Delete"),
		FIN_YEAR_OPEN(300, "fin_year_open", "Financial Year View"),
		FIN_YEAR_CHANGE_DEFAULT(301, "fin_year_change_default", "Financial Year Change Default"),
		BACKUP(302, "backup", "Backup"),
		RESTORE(303, "restore", "Restore"),
		IMPORT_UD(304, "import_ud", "Import"),
		RPT_DAY_BOOK_VIEW_OWN(305, "rpt_day_book_view_own", "Report Day Book View Own"),
		RPT_DAY_BOOK_VIEW_ALL(306, "rpt_day_book_view_all", "Report Day Book View All"),
		RPT_DAY_BOOK_EXPORT(307, "rpt_day_book_export", "Report Day Book Export"),
		RPT_DAY_BOOK_PRINT(308, "rpt_day_book_print", "Report Day Book Print"),
		RPT_SALES_RETURN_BY_MONTH_VIEW(309, "rpt_sales_return_by_month_view", "Report Sales Return By Month View"),
		RPT_SALES_RETURN_BY_MONTH_EXPORT(310, "rpt_sales_return_by_month_export", "Report Sales Return By Month Export"),
		RPT_SALES_RETURN_BY_DAY_VIEW(311, "rpt_sales_return_by_day_view", "Report Sales Return By Day View"),
		RPT_SALES_RETURN_BY_DAY_EXPORT(312, "rpt_sales_return_by_day_export", "Report Sales Return By Day Export"),
		RPT_SALES_RETURN_BY_CUSTOMER_VIEW(313, "rpt_sales_return_by_customer_view", "Report Sales Return By Customer View"),
		RPT_SALES_RETURN_BY_CUSTOMER_EXPORT(314, "rpt_sales_return_by_customer_export", "Report Sales Return By Customer Export"),
		RPT_SALES_RETURN_BY_PROD_CAT_VIEW(315, "rpt_sales_return_by_prod_cat_view", "Report Sales Return By Product Category View"),
		RPT_SALES_RETURN_BY_PROD_CAT_EXPORT(316, "rpt_sales_return_by_prod_cat_export", "Report Sales Return By Product Category Export"),
		RPT_SALES_RETURN_BY_PROD_VIEW(317, "rpt_sales_return_by_prod_view", "Report Sales Return By Product View"),
		RPT_SALES_RETURN_BY_PROD_EXPORT(318, "rpt_sales_return_by_prod_export", "Report Sales Return By Product Export"),
		RPT_SALES_RETURN_BY_CITY_VIEW(319, "rpt_sales_return_by_city_view", "Report Sales Return By City View"),
		RPT_SALES_RETURN_BY_CITY_EXPORT(320, "rpt_sales_return_by_city_export", "Report Sales Return By City Export"),
		RPT_SALES_RETURN_BY_STATE_VIEW(321, "rpt_sales_return_by_state_view", "Report Sales Return By State View"),
		RPT_SALES_RETURN_BY_STATE_EXPORT(322, "rpt_sales_return_by_state_export", "Report Sales Return By State Export"),
		RPT_SALES_RETURN_BY_AGENT_VIEW(323, "rpt_sales_return_by_agent_view", "Report Sales Return By Agent View"),
		RPT_SALES_RETURN_BY_AGENT_EXPORT(324, "rpt_sales_return_by_agent_export", "Report Sales Return By Agent Export"),
		RPT_SALES_BY_MONTH_VIEW(325, "rpt_sales_by_month_view", "Report Sales By Month View"),
		RPT_SALES_BY_MONTH_EXPORT(326, "rpt_sales_by_month_export", "Report Sales By Month Export"),
		RPT_SALES_BY_DAY_VIEW(327, "rpt_sales_by_day_view", "Report Sales By Day View"),
		RPT_SALES_BY_DAY_EXPORT(328, "rpt_sales_by_day_export", "Report Sales By Day Export"),
		RPT_SALES_BY_CUSTOMER_VIEW(329, "rpt_sales_by_customer_view", "Report Sales By Customer View"),
		RPT_SALES_BY_CUSTOMER_EXPORT(330, "rpt_sales_by_customer_export", "Report Sales By Customer Export"),
		RPT_SALES_BY_PROD_CAT_VIEW(331, "rpt_sales_by_prod_cat_view", "Report Sales By Product Category View"),
		RPT_SALES_BY_PROD_CAT_EXPORT(332, "rpt_sales_by_prod_cat_export", "Report Sales By Product Category Export"),
		RPT_SALES_BY_PROD_VIEW(333, "rpt_sales_by_prod_view", "Report Sales By Product View"),
		RPT_SALES_BY_PROD_EXPORT(334, "rpt_sales_by_prod_export", "Report Sales By Product Export"),
		RPT_SALES_BY_CITY_VIEW(335, "rpt_sales_by_city_view", "Report Sales By City View"),
		RPT_SALES_BY_CITY_EXPORT(336, "rpt_sales_by_city_export", "Report Sales By City Export"),
		RPT_SALES_BY_STATE_VIEW(337, "rpt_sales_by_state_view", "Report Sales By State View"),
		RPT_SALES_BY_STATE_EXPORT(338, "rpt_sales_by_state_export", "Report Sales By State Export"),
		RPT_SALES_BY_AGENT_VIEW(339, "rpt_sales_by_agent_view", "Report Sales By Agent View"),
		RPT_SALES_BY_AGENT_EXPORT(340, "rpt_sales_by_agent_export", "Report Sales By Agent Export"),
		RPT_SALES_PROFIT_BY_CUSTOMER_VIEW(341, "rpt_sales_profit_by_customer_view", "Report Sales Profit By Customer View"),
		RPT_SALES_PROFIT_BY_CUSTOMER_EXPORT(342, "rpt_sales_profit_by_customer_export", "Report Sales Profit By Customer Export"),
		RPT_SALES_PROFIT_BY_PROD_VIEW(343, "rpt_sales_profit_by_prod_view", "Report Sales Profit By Product View"),
		RPT_SALES_PROFIT_BY_PROD_EXPORT(344, "rpt_sales_profit_by_prod_export", "Report Sales Profit By Product Export"),
		RPT_SALES_PROFIT_BY_SALES_VOU_VIEW(345, "rpt_sales_profit_by_sales_vou_view", "Report Sales Profit By Sales Voucher View"),
		RPT_SALES_PROFIT_BY_SALES_VOU_EXPORT(346, "rpt_sales_profit_by_sales_vou_export", "Report Sales Profit By Sales Voucher Export"),
		RPT_SALES_PROFIT_BY_SALES_ITEM_VIEW(347, "rpt_sales_profit_by_sales_item_view", "Report Sales Profit By Sales Item View"),
		RPT_SALES_PROFIT_BY_SALES_ITEM_EXPORT(348, "rpt_sales_profit_by_sales_item_export", "Report Sales Profit By Sales Item Export"),
		RPT_PURCHASE_RETURN_BY_MONTH_VIEW(349, "rpt_purchase_return_by_month_view", "Report Purchase Return By Month View"),
		RPT_PURCHASE_RETURN_BY_MONTH_EXPORT(350, "rpt_purchase_return_by_month_export", "Report Purchase Return By Month Export"),
		RPT_PURCHASE_RETURN_BY_DAY_VIEW(351, "rpt_purchase_return_by_day_view", "Report Purchase Return By Day View"),
		RPT_PURCHASE_RETURN_BY_DAY_EXPORT(352, "rpt_purchase_return_by_day_export", "Report Purchase Return By Day Export"),
		RPT_PURCHASE_RETURN_BY_SUPPLIER_VIEW(353, "rpt_purchase_return_by_supplier_view", "Report Purchase Return By Supplier View"),
		RPT_PURCHASE_RETURN_BY_SUPPLIER_EXPORT(354, "rpt_purchase_return_by_supplier_export", "Report Purchase Return By Supplier Export"),
		RPT_PURCHASE_RETURN_BY_PROD_CAT_VIEW(355, "rpt_purchase_return_by_prod_cat_view", "Report Purchase Return By Product Category View"),
		RPT_PURCHASE_RETURN_BY_PROD_CAT_EXPORT(356, "rpt_purchase_return_by_prod_cat_export", "Report Purchase Return By Product Category Export"),
		RPT_PURCHASE_RETURN_BY_PROD_VIEW(357, "rpt_purchase_return_by_prod_view", "Report Purchase Return By Product View"),
		RPT_PURCHASE_RETURN_BY_PROD_EXPORT(358, "rpt_purchase_return_by_prod_export", "Report Purchase Return By Product Export"),
		RPT_PURCHASE_RETURN_BY_CITY_VIEW(359, "rpt_purchase_return_by_city_view", "Report Purchase Return By City View"),
		RPT_PURCHASE_RETURN_BY_CITY_EXPORT(360, "rpt_purchase_return_by_city_export", "Report Purchase Return By City Export"),
		RPT_PURCHASE_RETURN_BY_STATE_VIEW(361, "rpt_purchase_return_by_state_view", "Report Purchase Return By State View"),
		RPT_PURCHASE_RETURN_BY_STATE_EXPORT(362, "rpt_purchase_return_by_state_export", "Report Purchase Return By State Export"),
		RPT_PURCHASE_BY_MONTH_VIEW(363, "rpt_purchase_by_month_view", "Report Purchase By Month View"),
		RPT_PURCHASE_BY_MONTH_EXPORT(364, "rpt_purchase_by_month_export", "Report Purchase By Month Export"),
		RPT_PURCHASE_BY_DAY_VIEW(365, "rpt_purchase_by_day_view", "Report Purchase By Day View"),
		RPT_PURCHASE_BY_DAY_EXPORT(366, "rpt_purchase_by_day_export", "Report Purchase By Day Export"),
		RPT_PURCHASE_BY_SUPPLIER_VIEW(367, "rpt_purchase_by_supplier_view", "Report Purchase By Supplier View"),
		RPT_PURCHASE_BY_SUPPLIER_EXPORT(368, "rpt_purchase_by_supplier_export", "Report Purchase By Supplier Export"),
		RPT_PURCHASE_BY_PROD_CAT_VIEW(369, "rpt_purchase_by_prod_cat_view", "Report Purchase By Product Category View"),
		RPT_PURCHASE_BY_PROD_CAT_EXPORT(370, "rpt_purchase_by_prod_cat_export", "Report Purchase By Product Category Export"),
		RPT_PURCHASE_BY_PROD_VIEW(371, "rpt_purchase_by_prod_view", "Report Purchase By Product View"),
		RPT_PURCHASE_BY_PROD_EXPORT(372, "rpt_purchase_by_prod_export", "Report Purchase By Product Export"),
		RPT_PURCHASE_BY_CITY_VIEW(373, "rpt_purchase_by_city_view", "Report Purchase By City View"),
		RPT_PURCHASE_BY_CITY_EXPORT(374, "rpt_purchase_by_city_export", "Report Purchase By City Export"),
		RPT_PURCHASE_BY_STATE_VIEW(375, "rpt_purchase_by_state_view", "Report Purchase By State View"),
		RPT_PURCHASE_BY_STATE_EXPORT(376, "rpt_purchase_by_state_export", "Report Purchase By State Export"),
		RPT_ESTIMATE_PENDING_BY_PROD_VIEW(377, "rpt_estimate_pending_by_prod_view", "Report Estimate Pending By Product View"),
		RPT_ESTIMATE_PENDING_BY_PROD_EXPORT(378, "rpt_estimate_pending_by_prod_export", "Report Estimate Pending By Product Export"),
		RPT_ESTIMATE_PENDING_BY_CUSTOMER_VIEW(379, "rpt_estimate_pending_by_customer_view", "Report Estimate Pending By Customer View"),
		RPT_ESTIMATE_PENDING_BY_CUSTOMER_EXPORT(380, "rpt_estimate_pending_by_customer_export", "Report Estimate Pending By Customer Export"),
		RPT_ESTIMATE_PENDING_BY_PENDING_PROD_VIEW(381, "rpt_estimate_pending_by_pending_prod_view", "Report Estimate Pending By Pending Prod View"),
		RPT_ESTIMATE_PENDING_BY_PENDING_PROD_EXPORT(382, "rpt_estimate_pending_by_pending_prod_export", "Report Estimate Pending By Pending Prod Export"),
		RPT_DUE_RCVABLES_BY_CUSTOMER_VIEW(383, "rpt_due_rcvables_by_customer_view", "Report Due Receivable By Customer View"),
		RPT_DUE_RCVABLES_BY_CUSTOMER_EXPORT(384, "rpt_due_rcvables_by_customer_export", "Report Due Receivable By Customer Export"),
		RPT_DUE_RCVABLES_BY_SALES_VIEW(385, "rpt_due_rcvables_by_sales_view", "Report Due Receivable By Sales View"),
		RPT_DUE_RCVABLES_BY_SALES_EXPORT(386, "rpt_due_rcvables_by_sales_export", "Report Due Receivable By Sales Export"),
		RPT_IO_SUMM_BY_PROD_CAT_VIEW(387, "rpt_io_summ_by_prod_cat_view", "Report In/Out Summary By Product Category View"),
		RPT_IO_SUMM_BY_PROD_CAT_EXPORT(388, "rpt_io_summ_by_prod_cat_export", "Report In/Out Summary By Product Category Export"),
		RPT_IO_SUMM_BY_MONTH_VIEW(389, "rpt_io_summ_by_month_view", "Report In/Out Summary By Month View"),
		RPT_IO_SUMM_BY_MONTH_EXPORT(390, "rpt_io_summ_by_month_export", "Report In/Out Summary By Month Export"),
		RPT_IO_SUMM_BY_PROD_VIEW(391, "rpt_io_summ_by_prod_view", "Report In/Out Summary By Product View"),
		RPT_IO_SUMM_BY_PROD_EXPORT(392, "rpt_io_summ_by_prod_export", "Report In/Out Summary By Product Export"),
		RPT_IO_DETAILED(393, "rpt_io_detailed", "Report In/Out Detailed"),
		RPT_LEDGER_VIEW(394, "rpt_ledger_view", "Report Ledger View"),
		RPT_LEDGER_EXPORT(395, "rpt_ledger_export", "Report Ledger Export"),
		RPT_LEDGER_PRINT(396, "rpt_ledger_print", "Report Ledger Print"),
		RPT_LEDGER_SEND(397, "rpt_ledger_send", "Report Ledger Send"),
		RPT_ACCT_SUMM_VIEW(398, "rpt_acct_summ_view", "Report Account Summary View"),
		RPT_ACCT_SUMM_EXPORT(399, "rpt_acct_summ_export", "Report Account Summary Export"),
		RPT_TRIAL_BAL_VIEW(400, "rpt_trial_bal_view", "Report Trial Balance View"),
		RPT_TRIAL_BAL_EXPORT(401, "rpt_trial_bal_export", "Report Trial Balance Export"),
		RPT_TRIAL_BAL_PRINT(402, "rpt_trial_bal_print", "Report Trial Balance Print"),
		RPT_TRADING_ACCT_VIEW(403, "rpt_trading_acct_view", "Report Trading Account View"),
		RPT_TRADING_ACCT_EXPORT(404, "rpt_trading_acct_export", "Report Trading Account Export"),
		RPT_TRADING_ACCT_PRINT(405, "rpt_trading_acct_print", "Report Trading Account Print"),
		RPT_PL_ACCT_VIEW(406, "rpt_pl_acct_view", "Report Profit And Loss Account View"),
		RPT_PL_ACCT_EXPORT(407, "rpt_pl_acct_export", "Report Profit And Loss Account Export"),
		RPT_PL_ACCT_PRINT(408, "rpt_pl_acct_print", "Report Profit And Loss Account Print"),
		RPT_BALANCE_SHEET_VIEW(409, "rpt_balance_sheet_view", "Report Balance Sheet View"),
		RPT_BALANCE_SHEET_EXPORT(410, "rpt_balance_sheet_export", "Report Balance Sheet Export"),
		RPT_GSTR3B_VIEW(411, "rpt_gstr3b_view", "Report GST Ledger View"),
		RPT_GSTR3B_EXPORT(412, "rpt_gstr3b_export", "Report GST Ledger Export"),
		RPT_GSTR3B_PRINT(413, "rpt_gstr3b_print", "Report GST Ledger Print"),
		RPT_INVENTORY_LEDGER_VIEW(414, "rpt_inventory_ledger_view", "Report Inventory Ledger View"),
		RPT_INVENTORY_LEDGER_EXPORT(415, "rpt_inventory_ledger_export", "Report Inventory Ledger Export"),
		RPT_INVENTORY_LEDGER_PRINT(416, "rpt_inventory_ledger_print", "Report Inventory Ledger Print"),
		RPT_CURRENT_STOCK_VIEW(417, "rpt_current_stock_view", "Report Current Stock View"),
		RPT_CURRENT_STOCK_EXPORT(418, "rpt_current_stock_export", "Report Current Stock Export"),
		RPT_CURRENT_STOCK_PRINT(419, "rpt_current_stock_print", "Report Current Stock Print"),
		RPT_CURRENT_STOCK_VAL_VIEW(420, "rpt_current_stock_val_view", "Report Current Stock Value View"),
		RPT_CURRENT_STOCK_VAL_EXPORT(421, "rpt_current_stock_val_export", "Report Current Stock Value Export"),
		RPT_CURRENT_STOCK_VAL_PRINT(422, "rpt_current_stock_val_print", "Report Current Stock Value Print"),
		RPT_LOW_STOCK_VIEW(423, "rpt_low_stock_view", "Report Low Stock View"),
		RPT_LOW_STOCK_EXPORT(424, "rpt_low_stock_export", "Report Low Stock Export"),
		RPT_LOW_STOCK_PRINT(425, "rpt_low_stock_print", "Report Low Stock Print"),
		RPT_SALES_ANALYSIS_VIEW(426, "rpt_sales_analysis_view", "Report Sales Analysis View"),
		RPT_SALES_ANALYSIS_EXPORT(427, "rpt_sales_analysis_export", "Report Sales Analysis Export"),
		RPT_SALES_ANALYSIS_PRINT(428, "rpt_sales_analysis_print", "Report Sales Analysis Print"),
		RPT_CDP_VOU_LEDGER_VIEW(429, "rpt_cdp_vou_ledger_view", "Report Cash Discount Voucher Ledger View"),
		RPT_CDP_VOU_LEDGER_EXPORT(430, "rpt_cdp_vou_ledger_export", "Report Cash Discount Voucher Ledger Export"),
		RPT_CDP_VOU_LEDGER_PRINT(431, "rpt_cdp_vou_ledger_print", "Report Cash Discount Voucher Ledger Print"),
		RPT_COMM_VOU_LEDGER_VIEW(432, "rpt_comm_vou_ledger_view", "Report Commission Voucher Ledger View"),
		RPT_COMM_VOU_LEDGER_EXPORT(433, "rpt_comm_vou_ledger_export", "Report Commission Voucher Ledger Export"),
		RPT_COMM_VOU_LEDGER_PRINT(434, "rpt_comm_vou_ledger_print", "Report Commission Voucher Ledger Print"),
		RPT_SALES_ORDER_PENDING_VIEW(435, "rpt_sales_order_pending_view", "Report Sales Order Pending View"),
		RPT_SALES_ORDER_PENDING_EXPORT(436, "rpt_sales_order_pending_export", "Report Sales Order Pending Export"),
		RPT_SALES_ORDER_PENDING_PRINT(437, "rpt_sales_order_pending_print", "Report Sales Order Pending Print"),
		RPT_PURCHASE_ORDER_PENDING_VIEW(438, "rpt_purchase_order_pending_view", "Report Purchase Order Pending View"),
		RPT_PURCHASE_ORDER_PENDING_EXPORT(439, "rpt_purchase_order_pending_export", "Report Purchase Order Pending Export"),
		RPT_PURCHASE_ORDER_PENDING_PRINT(440, "rpt_purchase_order_pending_print", "Report Purchase Order Pending Print"),;

		private final int id;
		private final String key;
		private final String label;

		private Keys(int id, String key, String label)
		{
			this.id = id;
			this.key = key;
			this.label = label;
		}

		public int getId()
		{
			return id;
		}

		public String getKey()
		{
			return key;
		}

		public String getLabel()
		{
			return label;
		}

		public static Keys getById(int id)
		{
			for (Keys key : Keys.values())
			{
				if (key.getId() == id)
				{
					return key;
				}
			}
			return null;
		}

	}

	List<AccessRolePermModel> accessRolePermModels = new ArrayList<>();

	//
	private boolean menuConfig;
	private boolean companyProfileAdd;
	private boolean companyProfileEdit;
	private boolean companyProfileDelete;
	private boolean companyProfileView;
	private boolean companyProfileExport;
	private boolean stateAdd;
	private boolean stateEdit;
	private boolean stateDelete;
	private boolean stateView;
	private boolean stateExport;
	private boolean vouOthChAdd;
	private boolean vouOthChEdit;
	private boolean vouOthChDelete;
	private boolean vouOthChView;
	private boolean vouOthChExport;
	private boolean companyInfo;
	private boolean browser;
	private boolean msgTemplateAdd;
	private boolean msgTemplateEdit;
	private boolean msgTemplateDelete;
	private boolean msgTemplateView;
	private boolean msgTemplateExport;
	private boolean taxAdd;
	private boolean taxEdit;
	private boolean taxDelete;
	private boolean taxView;
	private boolean taxExport;
	private boolean taxCalRateAdd;
	private boolean taxCalRateEdit;
	private boolean taxCalRateDelete;
	private boolean taxCalRateView;
	private boolean taxCalRateExport;
	private boolean transporterAdd;
	private boolean transporterEdit;
	private boolean transporterDelete;
	private boolean transporterView;
	private boolean transporterExport;
	private boolean schemeAdd;
	private boolean schemeEdit;
	private boolean schemeDelete;
	private boolean schemeView;
	private boolean schemeExport;
	private boolean unitAdd;
	private boolean unitEdit;
	private boolean unitDelete;
	private boolean unitView;
	private boolean unitExport;
	private boolean prodOthChAdd;
	private boolean prodOthChEdit;
	private boolean prodOthChDelete;
	private boolean prodOthChView;
	private boolean prodOthChExport;
	private boolean catAdd;
	private boolean catEdit;
	private boolean catDelete;
	private boolean catView;
	private boolean catExport;
	private boolean taxCategoryAdd;
	private boolean taxCategoryEdit;
	private boolean taxCategoryDelete;
	private boolean taxCategoryView;
	private boolean taxCategoryImport;
	private boolean taxCategoryExport;
	private boolean prodAdd;
	private boolean prodEdit;
	private boolean prodDelete;
	private boolean prodView;
	private boolean prodImport;
	private boolean prodExport;
	private boolean prodPrintBarcode;
	private boolean serviceAdd;
	private boolean serviceEdit;
	private boolean serviceDelete;
	private boolean serviceView;
	private boolean serviceExport;
	private boolean priceListAdd;
	private boolean priceListEdit;
	private boolean priceListDelete;
	private boolean priceListView;
	private boolean priceListImport;
	private boolean priceListExport;
	private boolean commListAdd;
	private boolean commListEdit;
	private boolean commListDelete;
	private boolean commListView;
	private boolean commListImport;
	private boolean commListExport;
	private boolean invAdjustAdd;
	private boolean invAdjustEdit;
	private boolean invAdjustDelete;
	private boolean invAdjustView;
	private boolean invAdjustExport;
	private boolean leadAdd;
	private boolean leadEdit;
	private boolean leadDelete;
	private boolean leadView;
	private boolean leadImport;
	private boolean leadExport;
	private boolean acctTypeAdd;
	private boolean acctTypeEdit;
	private boolean acctTypeDelete;
	private boolean acctTypeView;
	private boolean acctTypeImport;
	private boolean acctTypeExport;
	private boolean acctAdd;
	private boolean acctEdit;
	private boolean acctDelete;
	private boolean acctView;
	private boolean acctImport;
	private boolean acctExport;
	private boolean agentAdd;
	private boolean agentEdit;
	private boolean agentDelete;
	private boolean agentView;
	private boolean agentExport;
	private boolean supplierAdd;
	private boolean supplierEdit;
	private boolean supplierDelete;
	private boolean supplierView;
	private boolean supplierExport;
	private boolean supplierPrintEnvelope;
	private boolean supplierPrintLedger;
	private boolean customerAdd;
	private boolean customerEdit;
	private boolean customerDelete;
	private boolean customerView;
	private boolean customerExport;
	private boolean customerPrintEnvelope;
	private boolean customerPrintLedger;
	private boolean bankAdd;
	private boolean bankEdit;
	private boolean bankDelete;
	private boolean bankView;
	private boolean bankExport;
	private boolean orderAdjustAdd;
	private boolean orderAdjustEdit;
	private boolean orderAdjustDelete;
	private boolean orderAdjustViewOwn;
	private boolean orderAdjustViewAll;
	private boolean orderAdjustExport;
	private boolean orderAdjustSend;
	private boolean cdpVouAdd;
	private boolean cdpVouEdit;
	private boolean cdpVouDelete;
	private boolean cdpVouViewOwn;
	private boolean cdpVouViewAll;
	private boolean cdpVouExport;
	private boolean cdpVouSend;
	private boolean cdpJournalVouAdd;
	private boolean cdpJournalVouEdit;
	private boolean cdpJournalVouDelete;
	private boolean cdpJournalVouViewOwn;
	private boolean cdpJournalVouViewAll;
	private boolean cdpJournalVouExport;
	private boolean cdpJournalVouPrint;
	private boolean cdpJournalVouSend;
	private boolean commVouAdd;
	private boolean commVouEdit;
	private boolean commVouDelete;
	private boolean commVouViewOwn;
	private boolean commVouViewAll;
	private boolean commVouExport;
	private boolean commVouPrint;
	private boolean commVouSend;
	private boolean purchaseOrderAdd;
	private boolean purchaseOrderEdit;
	private boolean purchaseOrderDelete;
	private boolean purchaseOrderViewOwn;
	private boolean purchaseOrderViewAll;
	private boolean purchaseOrderExport;
	private boolean purchaseOrderPrint;
	private boolean purchaseOrderPrintList;
	private boolean purchaseOrderSend;
	private boolean estimateAdd;
	private boolean estimateEdit;
	private boolean estimateDelete;
	private boolean estimateViewOwn;
	private boolean estimateViewAll;
	private boolean estimateExport;
	private boolean estimatePrint;
	private boolean estimatePrintList;
	private boolean estimateSend;
	private boolean salesOrderAdd;
	private boolean salesOrderEdit;
	private boolean salesOrderDelete;
	private boolean salesOrderViewOwn;
	private boolean salesOrderViewAll;
	private boolean salesOrderExport;
	private boolean salesOrderPrint;
	private boolean salesOrderPrintList;
	private boolean salesOrderSend;
	private boolean piAdd;
	private boolean piEdit;
	private boolean piDelete;
	private boolean piViewOwn;
	private boolean piViewAll;
	private boolean piExport;
	private boolean piPrint;
	private boolean piPrintChallan;
	private boolean piPrintList;
	private boolean piSend;
	private boolean purchaseReturnAdd;
	private boolean purchaseReturnEdit;
	private boolean purchaseReturnDelete;
	private boolean purchaseReturnViewOwn;
	private boolean purchaseReturnViewAll;
	private boolean purchaseReturnExport;
	private boolean purchaseReturnPrint;
	private boolean purchaseReturnPrintChallan;
	private boolean purchaseReturnPrintList;
	private boolean purchaseReturnSend;
	private boolean purchaseAdd;
	private boolean purchaseEdit;
	private boolean purchaseDelete;
	private boolean purchaseViewOwn;
	private boolean purchaseViewAll;
	private boolean purchaseExport;
	private boolean purchasePrint;
	private boolean purchasePrintList;
	private boolean purchasePrintBarcode;
	private boolean purchaseSend;
	private boolean salesReturnAdd;
	private boolean salesReturnEdit;
	private boolean salesReturnDelete;
	private boolean salesReturnViewOwn;
	private boolean salesReturnViewAll;
	private boolean salesReturnExport;
	private boolean salesReturnPrint;
	private boolean salesReturnPrintBarcode;
	private boolean salesReturnPrintList;
	private boolean salesReturnSend;
	private boolean salesAdd;
	private boolean salesEdit;
	private boolean salesDelete;
	private boolean salesViewOwn;
	private boolean salesViewAll;
	private boolean salesExport;
	private boolean salesPrint;
	private boolean salesPrintChallan;
	private boolean salesPrintList;
	private boolean salesSend;
	private boolean paymentAdd;
	private boolean paymentEdit;
	private boolean paymentDelete;
	private boolean paymentViewOwn;
	private boolean paymentViewAll;
	private boolean paymentExport;
	private boolean paymentPrint;
	private boolean paymentSend;
	private boolean receiptAdd;
	private boolean receiptEdit;
	private boolean receiptDelete;
	private boolean receiptViewOwn;
	private boolean receiptViewAll;
	private boolean receiptExport;
	private boolean receiptPrint;
	private boolean receiptSend;
	private boolean contraAdd;
	private boolean contraEdit;
	private boolean contraDelete;
	private boolean contraViewOwn;
	private boolean contraViewAll;
	private boolean contraExport;
	private boolean contraPrint;
	private boolean contraSend;
	private boolean journalAdd;
	private boolean journalEdit;
	private boolean journalDelete;
	private boolean journalViewOwn;
	private boolean journalViewAll;
	private boolean journalExport;
	private boolean journalPrint;
	private boolean journalSend;
	private boolean taskAdd;
	private boolean taskEdit;
	private boolean taskDelete;
	private boolean taskViewOwn;
	private boolean taskViewAll;
	private boolean taskExport;
	private boolean acctBookOpen;
	private boolean openSystemSettings;
	private boolean accessRoleAdd;
	private boolean accessRoleEdit;
	private boolean accessRoleDelete;
	private boolean accessRoleView;
	private boolean accessRoleExport;
	private boolean userAdd;
	private boolean userEdit;
	private boolean userDelete;
	private boolean userView;
	private boolean userExport;
	private boolean openCompanyManagement;
	private boolean companyAdd;
	private boolean companyEdit;
	private boolean companyDelete;
	private boolean finYearAdd;
	private boolean finYearEdit;
	private boolean finYearDelete;
	private boolean finYearOpen;
	private boolean finYearChangeDefault;
	private boolean backup;
	private boolean restore;
	private boolean importUd;
	private boolean rptDayBookViewOwn;
	private boolean rptDayBookViewAll;
	private boolean rptDayBookExport;
	private boolean rptDayBookPrint;
	private boolean rptSalesReturnByMonthView;
	private boolean rptSalesReturnByMonthExport;
	private boolean rptSalesReturnByDayView;
	private boolean rptSalesReturnByDayExport;
	private boolean rptSalesReturnByCustomerView;
	private boolean rptSalesReturnByCustomerExport;
	private boolean rptSalesReturnByProdCatView;
	private boolean rptSalesReturnByProdCatExport;
	private boolean rptSalesReturnByProdView;
	private boolean rptSalesReturnByProdExport;
	private boolean rptSalesReturnByCityView;
	private boolean rptSalesReturnByCityExport;
	private boolean rptSalesReturnByStateView;
	private boolean rptSalesReturnByStateExport;
	private boolean rptSalesReturnByAgentView;
	private boolean rptSalesReturnByAgentExport;
	private boolean rptSalesByMonthView;
	private boolean rptSalesByMonthExport;
	private boolean rptSalesByDayView;
	private boolean rptSalesByDayExport;
	private boolean rptSalesByCustomerView;
	private boolean rptSalesByCustomerExport;
	private boolean rptSalesByProdCatView;
	private boolean rptSalesByProdCatExport;
	private boolean rptSalesByProdView;
	private boolean rptSalesByProdExport;
	private boolean rptSalesByCityView;
	private boolean rptSalesByCityExport;
	private boolean rptSalesByStateView;
	private boolean rptSalesByStateExport;
	private boolean rptSalesByAgentView;
	private boolean rptSalesByAgentExport;
	private boolean rptSalesProfitByCustomerView;
	private boolean rptSalesProfitByCustomerExport;
	private boolean rptSalesProfitByProdView;
	private boolean rptSalesProfitByProdExport;
	private boolean rptSalesProfitBySalesVouView;
	private boolean rptSalesProfitBySalesVouExport;
	private boolean rptSalesProfitBySalesItemView;
	private boolean rptSalesProfitBySalesItemExport;
	private boolean rptPurchaseReturnByMonthView;
	private boolean rptPurchaseReturnByMonthExport;
	private boolean rptPurchaseReturnByDayView;
	private boolean rptPurchaseReturnByDayExport;
	private boolean rptPurchaseReturnBySupplierView;
	private boolean rptPurchaseReturnBySupplierExport;
	private boolean rptPurchaseReturnByProdCatView;
	private boolean rptPurchaseReturnByProdCatExport;
	private boolean rptPurchaseReturnByProdView;
	private boolean rptPurchaseReturnByProdExport;
	private boolean rptPurchaseReturnByCityView;
	private boolean rptPurchaseReturnByCityExport;
	private boolean rptPurchaseReturnByStateView;
	private boolean rptPurchaseReturnByStateExport;
	private boolean rptPurchaseByMonthView;
	private boolean rptPurchaseByMonthExport;
	private boolean rptPurchaseByDayView;
	private boolean rptPurchaseByDayExport;
	private boolean rptPurchaseBySupplierView;
	private boolean rptPurchaseBySupplierExport;
	private boolean rptPurchaseByProdCatView;
	private boolean rptPurchaseByProdCatExport;
	private boolean rptPurchaseByProdView;
	private boolean rptPurchaseByProdExport;
	private boolean rptPurchaseByCityView;
	private boolean rptPurchaseByCityExport;
	private boolean rptPurchaseByStateView;
	private boolean rptPurchaseByStateExport;
	private boolean rptEstimatePendingByProdView;
	private boolean rptEstimatePendingByProdExport;
	private boolean rptEstimatePendingByCustomerView;
	private boolean rptEstimatePendingByCustomerExport;
	private boolean rptEstimatePendingByPendingProdView;
	private boolean rptEstimatePendingByPendingProdExport;
	private boolean rptDueRcvablesByCustomerView;
	private boolean rptDueRcvablesByCustomerExport;
	private boolean rptDueRcvablesBySalesView;
	private boolean rptDueRcvablesBySalesExport;
	private boolean rptIoSummByProdCatView;
	private boolean rptIoSummByProdCatExport;
	private boolean rptIoSummByMonthView;
	private boolean rptIoSummByMonthExport;
	private boolean rptIoSummByProdView;
	private boolean rptIoSummByProdExport;
	private boolean rptIoDetailed;
	private boolean rptLedgerView;
	private boolean rptLedgerExport;
	private boolean rptLedgerPrint;
	private boolean rptLedgerSend;
	private boolean rptAcctSummView;
	private boolean rptAcctSummExport;
	private boolean rptTrialBalView;
	private boolean rptTrialBalExport;
	private boolean rptTrialBalPrint;
	private boolean rptTradingAcctView;
	private boolean rptTradingAcctExport;
	private boolean rptTradingAcctPrint;
	private boolean rptPlAcctView;
	private boolean rptPlAcctExport;
	private boolean rptPlAcctPrint;
	private boolean rptBalanceSheetView;
	private boolean rptBalanceSheetExport;
	private boolean rptGstr3BView;
	private boolean rptGstr3BExport;
	private boolean rptGstr3BPrint;
	private boolean rptInventoryLedgerView;
	private boolean rptInventoryLedgerExport;
	private boolean rptInventoryLedgerPrint;
	private boolean rptCurrentStockView;
	private boolean rptCurrentStockExport;
	private boolean rptCurrentStockPrint;
	private boolean rptCurrentStockValView;
	private boolean rptCurrentStockValExport;
	private boolean rptCurrentStockValPrint;
	private boolean rptLowStockView;
	private boolean rptLowStockExport;
	private boolean rptLowStockPrint;
	private boolean rptSalesAnalysisView;
	private boolean rptSalesAnalysisExport;
	private boolean rptSalesAnalysisPrint;
	private boolean rptCdpVouLedgerView;
	private boolean rptCdpVouLedgerExport;
	private boolean rptCdpVouLedgerPrint;
	private boolean rptCommVouLedgerView;
	private boolean rptCommVouLedgerExport;
	private boolean rptCommVouLedgerPrint;
	private boolean rptSalesOrderPendingView;
	private boolean rptSalesOrderPendingExport;
	private boolean rptSalesOrderPendingPrint;
	private boolean rptPurchaseOrderPendingView;
	private boolean rptPurchaseOrderPendingExport;
	private boolean rptPurchaseOrderPendingPrint;

	

	public AccessRolePermHdto(List<AccessRolePermModel> accessRolePermModels)
	{
		this.accessRolePermModels = accessRolePermModels;

		for (AccessRolePermModel accessRolePermModel : accessRolePermModels)
		{
			if (accessRolePermModel.getPermId() == Keys.MENU_CONFIG.id)
			{
				menuConfig = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMPANY_PROFILE_ADD.id)
			{
				companyProfileAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMPANY_PROFILE_EDIT.id)
			{
				companyProfileEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMPANY_PROFILE_DELETE.id)
			{
				companyProfileDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMPANY_PROFILE_VIEW.id)
			{
				companyProfileView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMPANY_PROFILE_EXPORT.id)
			{
				companyProfileExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.STATE_ADD.id)
			{
				stateAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.STATE_EDIT.id)
			{
				stateEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.STATE_DELETE.id)
			{
				stateDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.STATE_VIEW.id)
			{
				stateView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.STATE_EXPORT.id)
			{
				stateExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.VOU_OTH_CH_ADD.id)
			{
				vouOthChAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.VOU_OTH_CH_EDIT.id)
			{
				vouOthChEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.VOU_OTH_CH_DELETE.id)
			{
				vouOthChDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.VOU_OTH_CH_VIEW.id)
			{
				vouOthChView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.VOU_OTH_CH_EXPORT.id)
			{
				vouOthChExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMPANY_INFO.id)
			{
				companyInfo = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.BROWSER.id)
			{
				browser = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.MSG_TEMPLATE_ADD.id)
			{
				msgTemplateAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.MSG_TEMPLATE_EDIT.id)
			{
				msgTemplateEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.MSG_TEMPLATE_DELETE.id)
			{
				msgTemplateDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.MSG_TEMPLATE_VIEW.id)
			{
				msgTemplateView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.MSG_TEMPLATE_EXPORT.id)
			{
				msgTemplateExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TAX_ADD.id)
			{
				taxAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TAX_EDIT.id)
			{
				taxEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TAX_DELETE.id)
			{
				taxDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TAX_VIEW.id)
			{
				taxView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TAX_EXPORT.id)
			{
				taxExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TAX_CAL_RATE_ADD.id)
			{
				taxCalRateAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TAX_CAL_RATE_EDIT.id)
			{
				taxCalRateEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TAX_CAL_RATE_DELETE.id)
			{
				taxCalRateDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TAX_CAL_RATE_VIEW.id)
			{
				taxCalRateView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TAX_CAL_RATE_EXPORT.id)
			{
				taxCalRateExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TRANSPORTER_ADD.id)
			{
				transporterAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TRANSPORTER_EDIT.id)
			{
				transporterEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TRANSPORTER_DELETE.id)
			{
				transporterDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TRANSPORTER_VIEW.id)
			{
				transporterView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TRANSPORTER_EXPORT.id)
			{
				transporterExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SCHEME_ADD.id)
			{
				schemeAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SCHEME_EDIT.id)
			{
				schemeEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SCHEME_DELETE.id)
			{
				schemeDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SCHEME_VIEW.id)
			{
				schemeView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SCHEME_EXPORT.id)
			{
				schemeExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.UNIT_ADD.id)
			{
				unitAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.UNIT_EDIT.id)
			{
				unitEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.UNIT_DELETE.id)
			{
				unitDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.UNIT_VIEW.id)
			{
				unitView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.UNIT_EXPORT.id)
			{
				unitExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PROD_OTH_CH_ADD.id)
			{
				prodOthChAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PROD_OTH_CH_EDIT.id)
			{
				prodOthChEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PROD_OTH_CH_DELETE.id)
			{
				prodOthChDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PROD_OTH_CH_VIEW.id)
			{
				prodOthChView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PROD_OTH_CH_EXPORT.id)
			{
				prodOthChExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CAT_ADD.id)
			{
				catAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CAT_EDIT.id)
			{
				catEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CAT_DELETE.id)
			{
				catDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CAT_VIEW.id)
			{
				catView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CAT_EXPORT.id)
			{
				catExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TAX_CAT_ADD.id)
			{
				taxCategoryAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TAX_CAT_EDIT.id)
			{
				taxCategoryEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TAX_CAT_DELETE.id)
			{
				taxCategoryDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TAX_CAT_VIEW.id)
			{
				taxCategoryView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TAX_CAT_IMPORT.id)
			{
				taxCategoryImport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TAX_CAT_EXPORT.id)
			{
				taxCategoryExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PROD_ADD.id)
			{
				prodAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PROD_EDIT.id)
			{
				prodEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PROD_DELETE.id)
			{
				prodDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PROD_VIEW.id)
			{
				prodView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PROD_IMPORT.id)
			{
				prodImport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PROD_EXPORT.id)
			{
				prodExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PROD_PRINT_BARCODE.id)
			{
				prodPrintBarcode = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SERVICE_ADD.id)
			{
				serviceAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SERVICE_EDIT.id)
			{
				serviceEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SERVICE_DELETE.id)
			{
				serviceDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SERVICE_VIEW.id)
			{
				serviceView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SERVICE_EXPORT.id)
			{
				serviceExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PRICE_LIST_ADD.id)
			{
				priceListAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PRICE_LIST_EDIT.id)
			{
				priceListEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PRICE_LIST_DELETE.id)
			{
				priceListDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PRICE_LIST_VIEW.id)
			{
				priceListView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PRICE_LIST_IMPORT.id)
			{
				priceListImport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PRICE_LIST_EXPORT.id)
			{
				priceListExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMM_LIST_ADD.id)
			{
				commListAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMM_LIST_EDIT.id)
			{
				commListEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMM_LIST_DELETE.id)
			{
				commListDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMM_LIST_VIEW.id)
			{
				commListView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMM_LIST_IMPORT.id)
			{
				commListImport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMM_LIST_EXPORT.id)
			{
				commListExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.INV_ADJUST_ADD.id)
			{
				invAdjustAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.INV_ADJUST_EDIT.id)
			{
				invAdjustEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.INV_ADJUST_DELETE.id)
			{
				invAdjustDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.INV_ADJUST_VIEW.id)
			{
				invAdjustView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.INV_ADJUST_EXPORT.id)
			{
				invAdjustExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.LEAD_ADD.id)
			{
				leadAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.LEAD_EDIT.id)
			{
				leadEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.LEAD_DELETE.id)
			{
				leadDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.LEAD_VIEW.id)
			{
				leadView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.LEAD_IMPORT.id)
			{
				leadImport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.LEAD_EXPORT.id)
			{
				leadExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCT_TYPE_ADD.id)
			{
				acctTypeAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCT_TYPE_EDIT.id)
			{
				acctTypeEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCT_TYPE_DELETE.id)
			{
				acctTypeDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCT_TYPE_VIEW.id)
			{
				acctTypeView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCT_TYPE_IMPORT.id)
			{
				acctTypeImport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCT_TYPE_EXPORT.id)
			{
				acctTypeExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCT_ADD.id)
			{
				acctAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCT_EDIT.id)
			{
				acctEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCT_DELETE.id)
			{
				acctDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCT_VIEW.id)
			{
				acctView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCT_IMPORT.id)
			{
				acctImport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCT_EXPORT.id)
			{
				acctExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.AGENT_ADD.id)
			{
				agentAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.AGENT_EDIT.id)
			{
				agentEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.AGENT_DELETE.id)
			{
				agentDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.AGENT_VIEW.id)
			{
				agentView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.AGENT_EXPORT.id)
			{
				agentExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SUPPLIER_ADD.id)
			{
				supplierAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SUPPLIER_EDIT.id)
			{
				supplierEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SUPPLIER_DELETE.id)
			{
				supplierDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SUPPLIER_VIEW.id)
			{
				supplierView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SUPPLIER_EXPORT.id)
			{
				supplierExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SUPPLIER_PRINT_ENVELOPE.id)
			{
				supplierPrintEnvelope = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SUPPLIER_PRINT_LEDGER.id)
			{
				supplierPrintLedger = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CUSTOMER_ADD.id)
			{
				customerAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CUSTOMER_EDIT.id)
			{
				customerEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CUSTOMER_DELETE.id)
			{
				customerDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CUSTOMER_VIEW.id)
			{
				customerView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CUSTOMER_EXPORT.id)
			{
				customerExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CUSTOMER_PRINT_ENVELOPE.id)
			{
				customerPrintEnvelope = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CUSTOMER_PRINT_LEDGER.id)
			{
				customerPrintLedger = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.BANK_ADD.id)
			{
				bankAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.BANK_EDIT.id)
			{
				bankEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.BANK_DELETE.id)
			{
				bankDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.BANK_VIEW.id)
			{
				bankView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.BANK_EXPORT.id)
			{
				bankExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ORDER_ADJUST_ADD.id)
			{
				orderAdjustAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ORDER_ADJUST_EDIT.id)
			{
				orderAdjustEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ORDER_ADJUST_DELETE.id)
			{
				orderAdjustDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ORDER_ADJUST_VIEW_OWN.id)
			{
				orderAdjustViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ORDER_ADJUST_VIEW_ALL.id)
			{
				orderAdjustViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ORDER_ADJUST_EXPORT.id)
			{
				orderAdjustExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ORDER_ADJUST_SEND.id)
			{
				orderAdjustSend = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CDP_VOU_ADD.id)
			{
				cdpVouAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CDP_VOU_EDIT.id)
			{
				cdpVouEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CDP_VOU_DELETE.id)
			{
				cdpVouDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CDP_VOU_VIEW_OWN.id)
			{
				cdpVouViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CDP_VOU_VIEW_ALL.id)
			{
				cdpVouViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CDP_VOU_EXPORT.id)
			{
				cdpVouExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CDP_VOU_SEND.id)
			{
				cdpVouSend = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CDP_JOURNAL_VOU_ADD.id)
			{
				cdpJournalVouAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CDP_JOURNAL_VOU_EDIT.id)
			{
				cdpJournalVouEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CDP_JOURNAL_VOU_DELETE.id)
			{
				cdpJournalVouDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CDP_JOURNAL_VOU_VIEW_OWN.id)
			{
				cdpJournalVouViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CDP_JOURNAL_VOU_VIEW_ALL.id)
			{
				cdpJournalVouViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CDP_JOURNAL_VOU_EXPORT.id)
			{
				cdpJournalVouExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CDP_JOURNAL_VOU_PRINT.id)
			{
				cdpJournalVouPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CDP_JOURNAL_VOU_SEND.id)
			{
				cdpJournalVouSend = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMM_VOU_ADD.id)
			{
				commVouAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMM_VOU_EDIT.id)
			{
				commVouEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMM_VOU_DELETE.id)
			{
				commVouDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMM_VOU_VIEW_OWN.id)
			{
				commVouViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMM_VOU_VIEW_ALL.id)
			{
				commVouViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMM_VOU_EXPORT.id)
			{
				commVouExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMM_VOU_PRINT.id)
			{
				commVouPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMM_VOU_SEND.id)
			{
				commVouSend = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_ORDER_ADD.id)
			{
				purchaseOrderAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_ORDER_EDIT.id)
			{
				purchaseOrderEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_ORDER_DELETE.id)
			{
				purchaseOrderDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_ORDER_VIEW_OWN.id)
			{
				purchaseOrderViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_ORDER_VIEW_ALL.id)
			{
				purchaseOrderViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_ORDER_EXPORT.id)
			{
				purchaseOrderExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_ORDER_PRINT.id)
			{
				purchaseOrderPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_ORDER_PRINT_LIST.id)
			{
				purchaseOrderPrintList = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_ORDER_SEND.id)
			{
				purchaseOrderSend = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ESTIMATE_ADD.id)
			{
				estimateAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ESTIMATE_EDIT.id)
			{
				estimateEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ESTIMATE_DELETE.id)
			{
				estimateDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ESTIMATE_VIEW_OWN.id)
			{
				estimateViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ESTIMATE_VIEW_ALL.id)
			{
				estimateViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ESTIMATE_EXPORT.id)
			{
				estimateExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ESTIMATE_PRINT.id)
			{
				estimatePrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ESTIMATE_PRINT_LIST.id)
			{
				estimatePrintList = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ESTIMATE_SEND.id)
			{
				estimateSend = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_ORDER_ADD.id)
			{
				salesOrderAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_ORDER_EDIT.id)
			{
				salesOrderEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_ORDER_DELETE.id)
			{
				salesOrderDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_ORDER_VIEW_OWN.id)
			{
				salesOrderViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_ORDER_VIEW_ALL.id)
			{
				salesOrderViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_ORDER_EXPORT.id)
			{
				salesOrderExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_ORDER_PRINT.id)
			{
				salesOrderPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_ORDER_PRINT_LIST.id)
			{
				salesOrderPrintList = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_ORDER_SEND.id)
			{
				salesOrderSend = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PI_ADD.id)
			{
				piAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PI_EDIT.id)
			{
				piEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PI_DELETE.id)
			{
				piDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PI_VIEW_OWN.id)
			{
				piViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PI_VIEW_ALL.id)
			{
				piViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PI_EXPORT.id)
			{
				piExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PI_PRINT.id)
			{
				piPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PI_PRINT_CHALLAN.id)
			{
				piPrintChallan = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PI_PRINT_LIST.id)
			{
				piPrintList = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PI_SEND.id)
			{
				piSend = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_RETURN_ADD.id)
			{
				purchaseReturnAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_RETURN_EDIT.id)
			{
				purchaseReturnEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_RETURN_DELETE.id)
			{
				purchaseReturnDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_RETURN_VIEW_OWN.id)
			{
				purchaseReturnViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_RETURN_VIEW_ALL.id)
			{
				purchaseReturnViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_RETURN_EXPORT.id)
			{
				purchaseReturnExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_RETURN_PRINT.id)
			{
				purchaseReturnPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_RETURN_PRINT_CHALLAN.id)
			{
				purchaseReturnPrintChallan = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_RETURN_PRINT_LIST.id)
			{
				purchaseReturnPrintList = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_RETURN_SEND.id)
			{
				purchaseReturnSend = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_ADD.id)
			{
				purchaseAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_EDIT.id)
			{
				purchaseEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_DELETE.id)
			{
				purchaseDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_VIEW_OWN.id)
			{
				purchaseViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_VIEW_ALL.id)
			{
				purchaseViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_EXPORT.id)
			{
				purchaseExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_PRINT.id)
			{
				purchasePrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_PRINT_LIST.id)
			{
				purchasePrintList = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_PRINT_BARCODE.id)
			{
				purchasePrintBarcode = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PURCHASE_SEND.id)
			{
				purchaseSend = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_RETURN_ADD.id)
			{
				salesReturnAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_RETURN_EDIT.id)
			{
				salesReturnEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_RETURN_DELETE.id)
			{
				salesReturnDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_RETURN_VIEW_OWN.id)
			{
				salesReturnViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_RETURN_VIEW_ALL.id)
			{
				salesReturnViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_RETURN_EXPORT.id)
			{
				salesReturnExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_RETURN_PRINT.id)
			{
				salesReturnPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_RETURN_PRINT_BARCODE.id)
			{
				salesReturnPrintBarcode = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_RETURN_PRINT_LIST.id)
			{
				salesReturnPrintList = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_RETURN_SEND.id)
			{
				salesReturnSend = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_ADD.id)
			{
				salesAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_EDIT.id)
			{
				salesEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_DELETE.id)
			{
				salesDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_VIEW_OWN.id)
			{
				salesViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_VIEW_ALL.id)
			{
				salesViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_EXPORT.id)
			{
				salesExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_PRINT.id)
			{
				salesPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_PRINT_CHALLAN.id)
			{
				salesPrintChallan = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_PRINT_LIST.id)
			{
				salesPrintList = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.SALES_SEND.id)
			{
				salesSend = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PAYMENT_ADD.id)
			{
				paymentAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PAYMENT_EDIT.id)
			{
				paymentEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PAYMENT_DELETE.id)
			{
				paymentDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PAYMENT_VIEW_OWN.id)
			{
				paymentViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PAYMENT_VIEW_ALL.id)
			{
				paymentViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PAYMENT_EXPORT.id)
			{
				paymentExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PAYMENT_PRINT.id)
			{
				paymentPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.PAYMENT_SEND.id)
			{
				paymentSend = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RECEIPT_ADD.id)
			{
				receiptAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RECEIPT_EDIT.id)
			{
				receiptEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RECEIPT_DELETE.id)
			{
				receiptDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RECEIPT_VIEW_OWN.id)
			{
				receiptViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RECEIPT_VIEW_ALL.id)
			{
				receiptViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RECEIPT_EXPORT.id)
			{
				receiptExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RECEIPT_PRINT.id)
			{
				receiptPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RECEIPT_SEND.id)
			{
				receiptSend = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CONTRA_ADD.id)
			{
				contraAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CONTRA_EDIT.id)
			{
				contraEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CONTRA_DELETE.id)
			{
				contraDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CONTRA_VIEW_OWN.id)
			{
				contraViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CONTRA_VIEW_ALL.id)
			{
				contraViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CONTRA_EXPORT.id)
			{
				contraExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CONTRA_PRINT.id)
			{
				contraPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.CONTRA_SEND.id)
			{
				contraSend = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.JOURNAL_ADD.id)
			{
				journalAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.JOURNAL_EDIT.id)
			{
				journalEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.JOURNAL_DELETE.id)
			{
				journalDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.JOURNAL_VIEW_OWN.id)
			{
				journalViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.JOURNAL_VIEW_ALL.id)
			{
				journalViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.JOURNAL_EXPORT.id)
			{
				journalExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.JOURNAL_PRINT.id)
			{
				journalPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.JOURNAL_SEND.id)
			{
				journalSend = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TASK_ADD.id)
			{
				taskAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TASK_EDIT.id)
			{
				taskEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TASK_DELETE.id)
			{
				taskDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TASK_VIEW_OWN.id)
			{
				taskViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TASK_VIEW_ALL.id)
			{
				taskViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.TASK_EXPORT.id)
			{
				taskExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCT_BOOK_OPEN.id)
			{
				acctBookOpen = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.OPEN_SYSTEM_SETTINGS.id)
			{
				openSystemSettings = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCESS_ROLE_ADD.id)
			{
				accessRoleAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCESS_ROLE_EDIT.id)
			{
				accessRoleEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCESS_ROLE_DELETE.id)
			{
				accessRoleDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCESS_ROLE_VIEW.id)
			{
				accessRoleView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.ACCESS_ROLE_EXPORT.id)
			{
				accessRoleExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.USER_ADD.id)
			{
				userAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.USER_EDIT.id)
			{
				userEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.USER_DELETE.id)
			{
				userDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.USER_VIEW.id)
			{
				userView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.USER_EXPORT.id)
			{
				userExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.OPEN_COMPANY_MANAGEMENT.id)
			{
				openCompanyManagement = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMPANY_ADD.id)
			{
				companyAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMPANY_EDIT.id)
			{
				companyEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.COMPANY_DELETE.id)
			{
				companyDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.FIN_YEAR_ADD.id)
			{
				finYearAdd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.FIN_YEAR_EDIT.id)
			{
				finYearEdit = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.FIN_YEAR_DELETE.id)
			{
				finYearDelete = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.FIN_YEAR_OPEN.id)
			{
				finYearOpen = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.FIN_YEAR_CHANGE_DEFAULT.id)
			{
				finYearChangeDefault = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.BACKUP.id)
			{
				backup = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RESTORE.id)
			{
				restore = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.IMPORT_UD.id)
			{
				importUd = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_DAY_BOOK_VIEW_OWN.id)
			{
				rptDayBookViewOwn = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_DAY_BOOK_VIEW_ALL.id)
			{
				rptDayBookViewAll = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_DAY_BOOK_EXPORT.id)
			{
				rptDayBookExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_DAY_BOOK_PRINT.id)
			{
				rptDayBookPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_RETURN_BY_MONTH_VIEW.id)
			{
				rptSalesReturnByMonthView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_RETURN_BY_MONTH_EXPORT.id)
			{
				rptSalesReturnByMonthExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_RETURN_BY_DAY_VIEW.id)
			{
				rptSalesReturnByDayView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_RETURN_BY_DAY_EXPORT.id)
			{
				rptSalesReturnByDayExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_RETURN_BY_CUSTOMER_VIEW.id)
			{
				rptSalesReturnByCustomerView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_RETURN_BY_CUSTOMER_EXPORT.id)
			{
				rptSalesReturnByCustomerExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_RETURN_BY_PROD_CAT_VIEW.id)
			{
				rptSalesReturnByProdCatView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_RETURN_BY_PROD_CAT_EXPORT.id)
			{
				rptSalesReturnByProdCatExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_RETURN_BY_PROD_VIEW.id)
			{
				rptSalesReturnByProdView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_RETURN_BY_PROD_EXPORT.id)
			{
				rptSalesReturnByProdExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_RETURN_BY_CITY_VIEW.id)
			{
				rptSalesReturnByCityView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_RETURN_BY_CITY_EXPORT.id)
			{
				rptSalesReturnByCityExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_RETURN_BY_STATE_VIEW.id)
			{
				rptSalesReturnByStateView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_RETURN_BY_STATE_EXPORT.id)
			{
				rptSalesReturnByStateExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_RETURN_BY_AGENT_VIEW.id)
			{
				rptSalesReturnByAgentView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_RETURN_BY_AGENT_EXPORT.id)
			{
				rptSalesReturnByAgentExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_BY_MONTH_VIEW.id)
			{
				rptSalesByMonthView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_BY_MONTH_EXPORT.id)
			{
				rptSalesByMonthExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_BY_DAY_VIEW.id)
			{
				rptSalesByDayView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_BY_DAY_EXPORT.id)
			{
				rptSalesByDayExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_BY_CUSTOMER_VIEW.id)
			{
				rptSalesByCustomerView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_BY_CUSTOMER_EXPORT.id)
			{
				rptSalesByCustomerExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_BY_PROD_CAT_VIEW.id)
			{
				rptSalesByProdCatView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_BY_PROD_CAT_EXPORT.id)
			{
				rptSalesByProdCatExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_BY_PROD_VIEW.id)
			{
				rptSalesByProdView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_BY_PROD_EXPORT.id)
			{
				rptSalesByProdExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_BY_CITY_VIEW.id)
			{
				rptSalesByCityView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_BY_CITY_EXPORT.id)
			{
				rptSalesByCityExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_BY_STATE_VIEW.id)
			{
				rptSalesByStateView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_BY_STATE_EXPORT.id)
			{
				rptSalesByStateExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_BY_AGENT_VIEW.id)
			{
				rptSalesByAgentView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_BY_AGENT_EXPORT.id)
			{
				rptSalesByAgentExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_PROFIT_BY_CUSTOMER_VIEW.id)
			{
				rptSalesProfitByCustomerView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_PROFIT_BY_CUSTOMER_EXPORT.id)
			{
				rptSalesProfitByCustomerExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_PROFIT_BY_PROD_VIEW.id)
			{
				rptSalesProfitByProdView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_PROFIT_BY_PROD_EXPORT.id)
			{
				rptSalesProfitByProdExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_PROFIT_BY_SALES_VOU_VIEW.id)
			{
				rptSalesProfitBySalesVouView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_PROFIT_BY_SALES_VOU_EXPORT.id)
			{
				rptSalesProfitBySalesVouExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_PROFIT_BY_SALES_ITEM_VIEW.id)
			{
				rptSalesProfitBySalesItemView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_PROFIT_BY_SALES_ITEM_EXPORT.id)
			{
				rptSalesProfitBySalesItemExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_RETURN_BY_MONTH_VIEW.id)
			{
				rptPurchaseReturnByMonthView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_RETURN_BY_MONTH_EXPORT.id)
			{
				rptPurchaseReturnByMonthExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_RETURN_BY_DAY_VIEW.id)
			{
				rptPurchaseReturnByDayView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_RETURN_BY_DAY_EXPORT.id)
			{
				rptPurchaseReturnByDayExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_RETURN_BY_SUPPLIER_VIEW.id)
			{
				rptPurchaseReturnBySupplierView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_RETURN_BY_SUPPLIER_EXPORT.id)
			{
				rptPurchaseReturnBySupplierExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_RETURN_BY_PROD_CAT_VIEW.id)
			{
				rptPurchaseReturnByProdCatView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_RETURN_BY_PROD_CAT_EXPORT.id)
			{
				rptPurchaseReturnByProdCatExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_RETURN_BY_PROD_VIEW.id)
			{
				rptPurchaseReturnByProdView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_RETURN_BY_PROD_EXPORT.id)
			{
				rptPurchaseReturnByProdExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_RETURN_BY_CITY_VIEW.id)
			{
				rptPurchaseReturnByCityView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_RETURN_BY_CITY_EXPORT.id)
			{
				rptPurchaseReturnByCityExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_RETURN_BY_STATE_VIEW.id)
			{
				rptPurchaseReturnByStateView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_RETURN_BY_STATE_EXPORT.id)
			{
				rptPurchaseReturnByStateExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_BY_MONTH_VIEW.id)
			{
				rptPurchaseByMonthView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_BY_MONTH_EXPORT.id)
			{
				rptPurchaseByMonthExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_BY_DAY_VIEW.id)
			{
				rptPurchaseByDayView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_BY_DAY_EXPORT.id)
			{
				rptPurchaseByDayExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_BY_SUPPLIER_VIEW.id)
			{
				rptPurchaseBySupplierView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_BY_SUPPLIER_EXPORT.id)
			{
				rptPurchaseBySupplierExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_BY_PROD_CAT_VIEW.id)
			{
				rptPurchaseByProdCatView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_BY_PROD_CAT_EXPORT.id)
			{
				rptPurchaseByProdCatExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_BY_PROD_VIEW.id)
			{
				rptPurchaseByProdView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_BY_PROD_EXPORT.id)
			{
				rptPurchaseByProdExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_BY_CITY_VIEW.id)
			{
				rptPurchaseByCityView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_BY_CITY_EXPORT.id)
			{
				rptPurchaseByCityExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_BY_STATE_VIEW.id)
			{
				rptPurchaseByStateView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_BY_STATE_EXPORT.id)
			{
				rptPurchaseByStateExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_ESTIMATE_PENDING_BY_PROD_VIEW.id)
			{
				rptEstimatePendingByProdView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_ESTIMATE_PENDING_BY_PROD_EXPORT.id)
			{
				rptEstimatePendingByProdExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_ESTIMATE_PENDING_BY_CUSTOMER_VIEW.id)
			{
				rptEstimatePendingByCustomerView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_ESTIMATE_PENDING_BY_CUSTOMER_EXPORT.id)
			{
				rptEstimatePendingByCustomerExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_ESTIMATE_PENDING_BY_PENDING_PROD_VIEW.id)
			{
				rptEstimatePendingByPendingProdView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_ESTIMATE_PENDING_BY_PENDING_PROD_EXPORT.id)
			{
				rptEstimatePendingByPendingProdExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_DUE_RCVABLES_BY_CUSTOMER_VIEW.id)
			{
				rptDueRcvablesByCustomerView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_DUE_RCVABLES_BY_CUSTOMER_EXPORT.id)
			{
				rptDueRcvablesByCustomerExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_DUE_RCVABLES_BY_SALES_VIEW.id)
			{
				rptDueRcvablesBySalesView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_DUE_RCVABLES_BY_SALES_EXPORT.id)
			{
				rptDueRcvablesBySalesExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_IO_SUMM_BY_PROD_CAT_VIEW.id)
			{
				rptIoSummByProdCatView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_IO_SUMM_BY_PROD_CAT_EXPORT.id)
			{
				rptIoSummByProdCatExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_IO_SUMM_BY_MONTH_VIEW.id)
			{
				rptIoSummByMonthView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_IO_SUMM_BY_MONTH_EXPORT.id)
			{
				rptIoSummByMonthExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_IO_SUMM_BY_PROD_VIEW.id)
			{
				rptIoSummByProdView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_IO_SUMM_BY_PROD_EXPORT.id)
			{
				rptIoSummByProdExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_IO_DETAILED.id)
			{
				rptIoDetailed = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_LEDGER_VIEW.id)
			{
				rptLedgerView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_LEDGER_EXPORT.id)
			{
				rptLedgerExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_LEDGER_PRINT.id)
			{
				rptLedgerPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_LEDGER_SEND.id)
			{
				rptLedgerSend = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_ACCT_SUMM_VIEW.id)
			{
				rptAcctSummView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_ACCT_SUMM_EXPORT.id)
			{
				rptAcctSummExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_TRIAL_BAL_VIEW.id)
			{
				rptTrialBalView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_TRIAL_BAL_EXPORT.id)
			{
				rptTrialBalExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_TRIAL_BAL_PRINT.id)
			{
				rptTrialBalPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_TRADING_ACCT_VIEW.id)
			{
				rptTradingAcctView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_TRADING_ACCT_EXPORT.id)
			{
				rptTradingAcctExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_TRADING_ACCT_PRINT.id)
			{
				rptTradingAcctPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PL_ACCT_VIEW.id)
			{
				rptPlAcctView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PL_ACCT_EXPORT.id)
			{
				rptPlAcctExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PL_ACCT_PRINT.id)
			{
				rptPlAcctPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_BALANCE_SHEET_VIEW.id)
			{
				rptBalanceSheetView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_BALANCE_SHEET_EXPORT.id)
			{
				rptBalanceSheetExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_GSTR3B_VIEW.id)
			{
				rptGstr3BView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_GSTR3B_EXPORT.id)
			{
				rptGstr3BExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_GSTR3B_PRINT.id)
			{
				rptGstr3BPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_INVENTORY_LEDGER_VIEW.id)
			{
				rptInventoryLedgerView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_INVENTORY_LEDGER_EXPORT.id)
			{
				rptInventoryLedgerExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_INVENTORY_LEDGER_PRINT.id)
			{
				rptInventoryLedgerPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_CURRENT_STOCK_VIEW.id)
			{
				rptCurrentStockView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_CURRENT_STOCK_EXPORT.id)
			{
				rptCurrentStockExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_CURRENT_STOCK_PRINT.id)
			{
				rptCurrentStockPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_CURRENT_STOCK_VAL_VIEW.id)
			{
				rptCurrentStockValView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_CURRENT_STOCK_VAL_EXPORT.id)
			{
				rptCurrentStockValExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_CURRENT_STOCK_VAL_PRINT.id)
			{
				rptCurrentStockValPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_LOW_STOCK_VIEW.id)
			{
				rptLowStockView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_LOW_STOCK_EXPORT.id)
			{
				rptLowStockExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_LOW_STOCK_PRINT.id)
			{
				rptLowStockPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_ANALYSIS_VIEW.id)
			{
				rptSalesAnalysisView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_ANALYSIS_EXPORT.id)
			{
				rptSalesAnalysisExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_ANALYSIS_PRINT.id)
			{
				rptSalesAnalysisPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_CDP_VOU_LEDGER_VIEW.id)
			{
				rptCdpVouLedgerView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_CDP_VOU_LEDGER_EXPORT.id)
			{
				rptCdpVouLedgerExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_CDP_VOU_LEDGER_PRINT.id)
			{
				rptCdpVouLedgerPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_COMM_VOU_LEDGER_VIEW.id)
			{
				rptCommVouLedgerView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_COMM_VOU_LEDGER_EXPORT.id)
			{
				rptCommVouLedgerExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_COMM_VOU_LEDGER_PRINT.id)
			{
				rptCommVouLedgerPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_ORDER_PENDING_VIEW.id)
			{
				rptSalesOrderPendingView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_ORDER_PENDING_EXPORT.id)
			{
				rptSalesOrderPendingExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_SALES_ORDER_PENDING_PRINT.id)
			{
				rptSalesOrderPendingPrint = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_ORDER_PENDING_VIEW.id)
			{
				rptPurchaseOrderPendingView = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_ORDER_PENDING_EXPORT.id)
			{
				rptPurchaseOrderPendingExport = accessRolePermModel.isValue();
			}
			else if (accessRolePermModel.getPermId() == Keys.RPT_PURCHASE_ORDER_PENDING_PRINT.id)
			{
				rptPurchaseOrderPendingPrint = accessRolePermModel.isValue();
			}

		}
	}

	public boolean isMenuConfig()
	{
		return menuConfig;
	}

	public void setMenuConfig(boolean menuConfig)
	{
		this.menuConfig = menuConfig;
	}

	public boolean isCompanyProfileAdd()
	{
		return companyProfileAdd;
	}

	public void setCompanyProfileAdd(boolean companyProfileAdd)
	{
		this.companyProfileAdd = companyProfileAdd;
	}

	public boolean isCompanyProfileEdit()
	{
		return companyProfileEdit;
	}

	public void setCompanyProfileEdit(boolean companyProfileEdit)
	{
		this.companyProfileEdit = companyProfileEdit;
	}

	public boolean isCompanyProfileDelete()
	{
		return companyProfileDelete;
	}

	public void setCompanyProfileDelete(boolean companyProfileDelete)
	{
		this.companyProfileDelete = companyProfileDelete;
	}

	public boolean isCompanyProfileView()
	{
		return companyProfileView;
	}

	public void setCompanyProfileView(boolean companyProfileView)
	{
		this.companyProfileView = companyProfileView;
	}

	public boolean isCompanyProfileExport()
	{
		return companyProfileExport;
	}

	public void setCompanyProfileExport(boolean companyProfileExport)
	{
		this.companyProfileExport = companyProfileExport;
	}

	public boolean isStateAdd()
	{
		return stateAdd;
	}

	public void setStateAdd(boolean stateAdd)
	{
		this.stateAdd = stateAdd;
	}

	public boolean isStateEdit()
	{
		return stateEdit;
	}

	public void setStateEdit(boolean stateEdit)
	{
		this.stateEdit = stateEdit;
	}

	public boolean isStateDelete()
	{
		return stateDelete;
	}

	public void setStateDelete(boolean stateDelete)
	{
		this.stateDelete = stateDelete;
	}

	public boolean isStateView()
	{
		return stateView;
	}

	public void setStateView(boolean stateView)
	{
		this.stateView = stateView;
	}

	public boolean isStateExport()
	{
		return stateExport;
	}

	public void setStateExport(boolean stateExport)
	{
		this.stateExport = stateExport;
	}

	public boolean isVouOthChAdd()
	{
		return vouOthChAdd;
	}

	public void setVouOthChAdd(boolean vouOthChAdd)
	{
		this.vouOthChAdd = vouOthChAdd;
	}

	public boolean isVouOthChEdit()
	{
		return vouOthChEdit;
	}

	public void setVouOthChEdit(boolean vouOthChEdit)
	{
		this.vouOthChEdit = vouOthChEdit;
	}

	public boolean isVouOthChDelete()
	{
		return vouOthChDelete;
	}

	public void setVouOthChDelete(boolean vouOthChDelete)
	{
		this.vouOthChDelete = vouOthChDelete;
	}

	public boolean isVouOthChView()
	{
		return vouOthChView;
	}

	public void setVouOthChView(boolean vouOthChView)
	{
		this.vouOthChView = vouOthChView;
	}

	public boolean isVouOthChExport()
	{
		return vouOthChExport;
	}

	public void setVouOthChExport(boolean vouOthChExport)
	{
		this.vouOthChExport = vouOthChExport;
	}

	public boolean isCompanyInfo()
	{
		return companyInfo;
	}

	public void setCompanyInfo(boolean companyInfo)
	{
		this.companyInfo = companyInfo;
	}

	public boolean isBrowser()
	{
		return browser;
	}

	public void setBrowser(boolean browser)
	{
		this.browser = browser;
	}

	public boolean isMsgTemplateAdd()
	{
		return msgTemplateAdd;
	}

	public void setMsgTemplateAdd(boolean msgTemplateAdd)
	{
		this.msgTemplateAdd = msgTemplateAdd;
	}

	public boolean isMsgTemplateEdit()
	{
		return msgTemplateEdit;
	}

	public void setMsgTemplateEdit(boolean msgTemplateEdit)
	{
		this.msgTemplateEdit = msgTemplateEdit;
	}

	public boolean isMsgTemplateDelete()
	{
		return msgTemplateDelete;
	}

	public void setMsgTemplateDelete(boolean msgTemplateDelete)
	{
		this.msgTemplateDelete = msgTemplateDelete;
	}

	public boolean isMsgTemplateView()
	{
		return msgTemplateView;
	}

	public void setMsgTemplateView(boolean msgTemplateView)
	{
		this.msgTemplateView = msgTemplateView;
	}

	public boolean isMsgTemplateExport()
	{
		return msgTemplateExport;
	}

	public void setMsgTemplateExport(boolean msgTemplateExport)
	{
		this.msgTemplateExport = msgTemplateExport;
	}

	public boolean isTaxAdd()
	{
		return taxAdd;
	}

	public void setTaxAdd(boolean taxAdd)
	{
		this.taxAdd = taxAdd;
	}

	public boolean isTaxEdit()
	{
		return taxEdit;
	}

	public void setTaxEdit(boolean taxEdit)
	{
		this.taxEdit = taxEdit;
	}

	public boolean isTaxDelete()
	{
		return taxDelete;
	}

	public void setTaxDelete(boolean taxDelete)
	{
		this.taxDelete = taxDelete;
	}

	public boolean isTaxView()
	{
		return taxView;
	}

	public void setTaxView(boolean taxView)
	{
		this.taxView = taxView;
	}

	public boolean isTaxExport()
	{
		return taxExport;
	}

	public void setTaxExport(boolean taxExport)
	{
		this.taxExport = taxExport;
	}

	public boolean isTaxCalRateAdd()
	{
		return taxCalRateAdd;
	}

	public void setTaxCalRateAdd(boolean taxCalRateAdd)
	{
		this.taxCalRateAdd = taxCalRateAdd;
	}

	public boolean isTaxCalRateEdit()
	{
		return taxCalRateEdit;
	}

	public void setTaxCalRateEdit(boolean taxCalRateEdit)
	{
		this.taxCalRateEdit = taxCalRateEdit;
	}

	public boolean isTaxCalRateDelete()
	{
		return taxCalRateDelete;
	}

	public void setTaxCalRateDelete(boolean taxCalRateDelete)
	{
		this.taxCalRateDelete = taxCalRateDelete;
	}

	public boolean isTaxCalRateView()
	{
		return taxCalRateView;
	}

	public void setTaxCalRateView(boolean taxCalRateView)
	{
		this.taxCalRateView = taxCalRateView;
	}

	public boolean isTaxCalRateExport()
	{
		return taxCalRateExport;
	}

	public void setTaxCalRateExport(boolean taxCalRateExport)
	{
		this.taxCalRateExport = taxCalRateExport;
	}

	public boolean isTransporterAdd()
	{
		return transporterAdd;
	}

	public void setTransporterAdd(boolean transporterAdd)
	{
		this.transporterAdd = transporterAdd;
	}

	public boolean isTransporterEdit()
	{
		return transporterEdit;
	}

	public void setTransporterEdit(boolean transporterEdit)
	{
		this.transporterEdit = transporterEdit;
	}

	public boolean isTransporterDelete()
	{
		return transporterDelete;
	}

	public void setTransporterDelete(boolean transporterDelete)
	{
		this.transporterDelete = transporterDelete;
	}

	public boolean isTransporterView()
	{
		return transporterView;
	}

	public void setTransporterView(boolean transporterView)
	{
		this.transporterView = transporterView;
	}

	public boolean isTransporterExport()
	{
		return transporterExport;
	}

	public void setTransporterExport(boolean transporterExport)
	{
		this.transporterExport = transporterExport;
	}

	public boolean isSchemeAdd()
	{
		return schemeAdd;
	}

	public void setSchemeAdd(boolean schemeAdd)
	{
		this.schemeAdd = schemeAdd;
	}

	public boolean isSchemeEdit()
	{
		return schemeEdit;
	}

	public void setSchemeEdit(boolean schemeEdit)
	{
		this.schemeEdit = schemeEdit;
	}

	public boolean isSchemeDelete()
	{
		return schemeDelete;
	}

	public void setSchemeDelete(boolean schemeDelete)
	{
		this.schemeDelete = schemeDelete;
	}

	public boolean isSchemeView()
	{
		return schemeView;
	}

	public void setSchemeView(boolean schemeView)
	{
		this.schemeView = schemeView;
	}

	public boolean isSchemeExport()
	{
		return schemeExport;
	}

	public void setSchemeExport(boolean schemeExport)
	{
		this.schemeExport = schemeExport;
	}

	public boolean isUnitAdd()
	{
		return unitAdd;
	}

	public void setUnitAdd(boolean unitAdd)
	{
		this.unitAdd = unitAdd;
	}

	public boolean isUnitEdit()
	{
		return unitEdit;
	}

	public void setUnitEdit(boolean unitEdit)
	{
		this.unitEdit = unitEdit;
	}

	public boolean isUnitDelete()
	{
		return unitDelete;
	}

	public void setUnitDelete(boolean unitDelete)
	{
		this.unitDelete = unitDelete;
	}

	public boolean isUnitView()
	{
		return unitView;
	}

	public void setUnitView(boolean unitView)
	{
		this.unitView = unitView;
	}

	public boolean isUnitExport()
	{
		return unitExport;
	}

	public void setUnitExport(boolean unitExport)
	{
		this.unitExport = unitExport;
	}

	public boolean isProdOthChAdd()
	{
		return prodOthChAdd;
	}

	public void setProdOthChAdd(boolean prodOthChAdd)
	{
		this.prodOthChAdd = prodOthChAdd;
	}

	public boolean isProdOthChEdit()
	{
		return prodOthChEdit;
	}

	public void setProdOthChEdit(boolean prodOthChEdit)
	{
		this.prodOthChEdit = prodOthChEdit;
	}

	public boolean isProdOthChDelete()
	{
		return prodOthChDelete;
	}

	public void setProdOthChDelete(boolean prodOthChDelete)
	{
		this.prodOthChDelete = prodOthChDelete;
	}

	public boolean isProdOthChView()
	{
		return prodOthChView;
	}

	public void setProdOthChView(boolean prodOthChView)
	{
		this.prodOthChView = prodOthChView;
	}

	public boolean isProdOthChExport()
	{
		return prodOthChExport;
	}

	public void setProdOthChExport(boolean prodOthChExport)
	{
		this.prodOthChExport = prodOthChExport;
	}

	public boolean isCatAdd()
	{
		return catAdd;
	}

	public void setCatAdd(boolean catAdd)
	{
		this.catAdd = catAdd;
	}

	public boolean isCatEdit()
	{
		return catEdit;
	}

	public void setCatEdit(boolean catEdit)
	{
		this.catEdit = catEdit;
	}

	public boolean isCatDelete()
	{
		return catDelete;
	}

	public void setCatDelete(boolean catDelete)
	{
		this.catDelete = catDelete;
	}

	public boolean isCatView()
	{
		return catView;
	}

	public void setCatView(boolean catView)
	{
		this.catView = catView;
	}

	public boolean isCatExport()
	{
		return catExport;
	}

	public void setCatExport(boolean catExport)
	{
		this.catExport = catExport;
	}

	public boolean isTaxCategoryAdd()
	{
		return taxCategoryAdd;
	}

	public void setTaxCategoryAdd(boolean taxCategoryAdd)
	{
		this.taxCategoryAdd = taxCategoryAdd;
	}

	public boolean isTaxCategoryEdit()
	{
		return taxCategoryEdit;
	}

	public void setTaxCategoryEdit(boolean taxCategoryEdit)
	{
		this.taxCategoryEdit = taxCategoryEdit;
	}

	public boolean isTaxCategoryDelete()
	{
		return taxCategoryDelete;
	}

	public void setTaxCategoryDelete(boolean taxCategoryDelete)
	{
		this.taxCategoryDelete = taxCategoryDelete;
	}

	public boolean isTaxCategoryView()
	{
		return taxCategoryView;
	}

	public void setTaxCategoryView(boolean taxCategoryView)
	{
		this.taxCategoryView = taxCategoryView;
	}

	public boolean isTaxCategoryImport()
	{
		return taxCategoryImport;
	}

	public void setTaxCategoryImport(boolean taxCategoryImport)
	{
		this.taxCategoryImport = taxCategoryImport;
	}

	public boolean isTaxCategoryExport()
	{
		return taxCategoryExport;
	}

	public void setTaxCategoryExport(boolean taxCategoryExport)
	{
		this.taxCategoryExport = taxCategoryExport;
	}

	public boolean isProdAdd()
	{
		return prodAdd;
	}

	public void setProdAdd(boolean prodAdd)
	{
		this.prodAdd = prodAdd;
	}

	public boolean isProdEdit()
	{
		return prodEdit;
	}

	public void setProdEdit(boolean prodEdit)
	{
		this.prodEdit = prodEdit;
	}

	public boolean isProdDelete()
	{
		return prodDelete;
	}

	public void setProdDelete(boolean prodDelete)
	{
		this.prodDelete = prodDelete;
	}

	public boolean isProdView()
	{
		return prodView;
	}

	public void setProdView(boolean prodView)
	{
		this.prodView = prodView;
	}

	public boolean isProdImport()
	{
		return prodImport;
	}

	public void setProdImport(boolean prodImport)
	{
		this.prodImport = prodImport;
	}

	public boolean isProdExport()
	{
		return prodExport;
	}

	public void setProdExport(boolean prodExport)
	{
		this.prodExport = prodExport;
	}

	public boolean isProdPrintBarcode()
	{
		return prodPrintBarcode;
	}

	public void setProdPrintBarcode(boolean prodPrintBarcode)
	{
		this.prodPrintBarcode = prodPrintBarcode;
	}

	public boolean isServiceAdd()
	{
		return serviceAdd;
	}

	public void setServiceAdd(boolean serviceAdd)
	{
		this.serviceAdd = serviceAdd;
	}

	public boolean isServiceEdit()
	{
		return serviceEdit;
	}

	public void setServiceEdit(boolean serviceEdit)
	{
		this.serviceEdit = serviceEdit;
	}

	public boolean isServiceDelete()
	{
		return serviceDelete;
	}

	public void setServiceDelete(boolean serviceDelete)
	{
		this.serviceDelete = serviceDelete;
	}

	public boolean isServiceView()
	{
		return serviceView;
	}

	public void setServiceView(boolean serviceView)
	{
		this.serviceView = serviceView;
	}

	public boolean isServiceExport()
	{
		return serviceExport;
	}

	public void setServiceExport(boolean serviceExport)
	{
		this.serviceExport = serviceExport;
	}

	public boolean isPriceListAdd()
	{
		return priceListAdd;
	}

	public void setPriceListAdd(boolean priceListAdd)
	{
		this.priceListAdd = priceListAdd;
	}

	public boolean isPriceListEdit()
	{
		return priceListEdit;
	}

	public void setPriceListEdit(boolean priceListEdit)
	{
		this.priceListEdit = priceListEdit;
	}

	public boolean isPriceListDelete()
	{
		return priceListDelete;
	}

	public void setPriceListDelete(boolean priceListDelete)
	{
		this.priceListDelete = priceListDelete;
	}

	public boolean isPriceListView()
	{
		return priceListView;
	}

	public void setPriceListView(boolean priceListView)
	{
		this.priceListView = priceListView;
	}

	public boolean isPriceListImport()
	{
		return priceListImport;
	}

	public void setPriceListImport(boolean priceListImport)
	{
		this.priceListImport = priceListImport;
	}

	public boolean isPriceListExport()
	{
		return priceListExport;
	}

	public void setPriceListExport(boolean priceListExport)
	{
		this.priceListExport = priceListExport;
	}

	public boolean isCommListAdd()
	{
		return commListAdd;
	}

	public void setCommListAdd(boolean commListAdd)
	{
		this.commListAdd = commListAdd;
	}

	public boolean isCommListEdit()
	{
		return commListEdit;
	}

	public void setCommListEdit(boolean commListEdit)
	{
		this.commListEdit = commListEdit;
	}

	public boolean isCommListDelete()
	{
		return commListDelete;
	}

	public void setCommListDelete(boolean commListDelete)
	{
		this.commListDelete = commListDelete;
	}

	public boolean isCommListView()
	{
		return commListView;
	}

	public void setCommListView(boolean commListView)
	{
		this.commListView = commListView;
	}

	public boolean isCommListImport()
	{
		return commListImport;
	}

	public void setCommListImport(boolean commListImport)
	{
		this.commListImport = commListImport;
	}

	public boolean isCommListExport()
	{
		return commListExport;
	}

	public void setCommListExport(boolean commListExport)
	{
		this.commListExport = commListExport;
	}

	public boolean isInvAdjustAdd()
	{
		return invAdjustAdd;
	}

	public void setInvAdjustAdd(boolean invAdjustAdd)
	{
		this.invAdjustAdd = invAdjustAdd;
	}

	public boolean isInvAdjustEdit()
	{
		return invAdjustEdit;
	}

	public void setInvAdjustEdit(boolean invAdjustEdit)
	{
		this.invAdjustEdit = invAdjustEdit;
	}

	public boolean isInvAdjustDelete()
	{
		return invAdjustDelete;
	}

	public void setInvAdjustDelete(boolean invAdjustDelete)
	{
		this.invAdjustDelete = invAdjustDelete;
	}

	public boolean isInvAdjustView()
	{
		return invAdjustView;
	}

	public void setInvAdjustView(boolean invAdjustView)
	{
		this.invAdjustView = invAdjustView;
	}

	public boolean isInvAdjustExport()
	{
		return invAdjustExport;
	}

	public void setInvAdjustExport(boolean invAdjustExport)
	{
		this.invAdjustExport = invAdjustExport;
	}

	public boolean isLeadAdd()
	{
		return leadAdd;
	}

	public void setLeadAdd(boolean leadAdd)
	{
		this.leadAdd = leadAdd;
	}

	public boolean isLeadEdit()
	{
		return leadEdit;
	}

	public void setLeadEdit(boolean leadEdit)
	{
		this.leadEdit = leadEdit;
	}

	public boolean isLeadDelete()
	{
		return leadDelete;
	}

	public void setLeadDelete(boolean leadDelete)
	{
		this.leadDelete = leadDelete;
	}

	public boolean isLeadView()
	{
		return leadView;
	}

	public void setLeadView(boolean leadView)
	{
		this.leadView = leadView;
	}

	public boolean isLeadImport()
	{
		return leadImport;
	}

	public void setLeadImport(boolean leadImport)
	{
		this.leadImport = leadImport;
	}

	public boolean isLeadExport()
	{
		return leadExport;
	}

	public void setLeadExport(boolean leadExport)
	{
		this.leadExport = leadExport;
	}

	public boolean isAcctTypeAdd()
	{
		return acctTypeAdd;
	}

	public void setAcctTypeAdd(boolean acctTypeAdd)
	{
		this.acctTypeAdd = acctTypeAdd;
	}

	public boolean isAcctTypeEdit()
	{
		return acctTypeEdit;
	}

	public void setAcctTypeEdit(boolean acctTypeEdit)
	{
		this.acctTypeEdit = acctTypeEdit;
	}

	public boolean isAcctTypeDelete()
	{
		return acctTypeDelete;
	}

	public void setAcctTypeDelete(boolean acctTypeDelete)
	{
		this.acctTypeDelete = acctTypeDelete;
	}

	public boolean isAcctTypeView()
	{
		return acctTypeView;
	}

	public void setAcctTypeView(boolean acctTypeView)
	{
		this.acctTypeView = acctTypeView;
	}

	public boolean isAcctTypeImport()
	{
		return acctTypeImport;
	}

	public void setAcctTypeImport(boolean acctTypeImport)
	{
		this.acctTypeImport = acctTypeImport;
	}

	public boolean isAcctTypeExport()
	{
		return acctTypeExport;
	}

	public void setAcctTypeExport(boolean acctTypeExport)
	{
		this.acctTypeExport = acctTypeExport;
	}

	public boolean isAcctAdd()
	{
		return acctAdd;
	}

	public void setAcctAdd(boolean acctAdd)
	{
		this.acctAdd = acctAdd;
	}

	public boolean isAcctEdit()
	{
		return acctEdit;
	}

	public void setAcctEdit(boolean acctEdit)
	{
		this.acctEdit = acctEdit;
	}

	public boolean isAcctDelete()
	{
		return acctDelete;
	}

	public void setAcctDelete(boolean acctDelete)
	{
		this.acctDelete = acctDelete;
	}

	public boolean isAcctView()
	{
		return acctView;
	}

	public void setAcctView(boolean acctView)
	{
		this.acctView = acctView;
	}

	public boolean isAcctImport()
	{
		return acctImport;
	}

	public void setAcctImport(boolean acctImport)
	{
		this.acctImport = acctImport;
	}

	public boolean isAcctExport()
	{
		return acctExport;
	}

	public void setAcctExport(boolean acctExport)
	{
		this.acctExport = acctExport;
	}

	public boolean isAgentAdd()
	{
		return agentAdd;
	}

	public void setAgentAdd(boolean agentAdd)
	{
		this.agentAdd = agentAdd;
	}

	public boolean isAgentEdit()
	{
		return agentEdit;
	}

	public void setAgentEdit(boolean agentEdit)
	{
		this.agentEdit = agentEdit;
	}

	public boolean isAgentDelete()
	{
		return agentDelete;
	}

	public void setAgentDelete(boolean agentDelete)
	{
		this.agentDelete = agentDelete;
	}

	public boolean isAgentView()
	{
		return agentView;
	}

	public void setAgentView(boolean agentView)
	{
		this.agentView = agentView;
	}

	public boolean isAgentExport()
	{
		return agentExport;
	}

	public void setAgentExport(boolean agentExport)
	{
		this.agentExport = agentExport;
	}

	public boolean isSupplierAdd()
	{
		return supplierAdd;
	}

	public void setSupplierAdd(boolean supplierAdd)
	{
		this.supplierAdd = supplierAdd;
	}

	public boolean isSupplierEdit()
	{
		return supplierEdit;
	}

	public void setSupplierEdit(boolean supplierEdit)
	{
		this.supplierEdit = supplierEdit;
	}

	public boolean isSupplierDelete()
	{
		return supplierDelete;
	}

	public void setSupplierDelete(boolean supplierDelete)
	{
		this.supplierDelete = supplierDelete;
	}

	public boolean isSupplierView()
	{
		return supplierView;
	}

	public void setSupplierView(boolean supplierView)
	{
		this.supplierView = supplierView;
	}

	public boolean isSupplierExport()
	{
		return supplierExport;
	}

	public void setSupplierExport(boolean supplierExport)
	{
		this.supplierExport = supplierExport;
	}

	public boolean isSupplierPrintEnvelope()
	{
		return supplierPrintEnvelope;
	}

	public void setSupplierPrintEnvelope(boolean supplierPrintEnvelope)
	{
		this.supplierPrintEnvelope = supplierPrintEnvelope;
	}

	public boolean isSupplierPrintLedger()
	{
		return supplierPrintLedger;
	}

	public void setSupplierPrintLedger(boolean supplierPrintLedger)
	{
		this.supplierPrintLedger = supplierPrintLedger;
	}

	public boolean isCustomerAdd()
	{
		return customerAdd;
	}

	public void setCustomerAdd(boolean customerAdd)
	{
		this.customerAdd = customerAdd;
	}

	public boolean isCustomerEdit()
	{
		return customerEdit;
	}

	public void setCustomerEdit(boolean customerEdit)
	{
		this.customerEdit = customerEdit;
	}

	public boolean isCustomerDelete()
	{
		return customerDelete;
	}

	public void setCustomerDelete(boolean customerDelete)
	{
		this.customerDelete = customerDelete;
	}

	public boolean isCustomerView()
	{
		return customerView;
	}

	public void setCustomerView(boolean customerView)
	{
		this.customerView = customerView;
	}

	public boolean isCustomerExport()
	{
		return customerExport;
	}

	public void setCustomerExport(boolean customerExport)
	{
		this.customerExport = customerExport;
	}

	public boolean isCustomerPrintEnvelope()
	{
		return customerPrintEnvelope;
	}

	public void setCustomerPrintEnvelope(boolean customerPrintEnvelope)
	{
		this.customerPrintEnvelope = customerPrintEnvelope;
	}

	public boolean isCustomerPrintLedger()
	{
		return customerPrintLedger;
	}

	public void setCustomerPrintLedger(boolean customerPrintLedger)
	{
		this.customerPrintLedger = customerPrintLedger;
	}

	public boolean isBankAdd()
	{
		return bankAdd;
	}

	public void setBankAdd(boolean bankAdd)
	{
		this.bankAdd = bankAdd;
	}

	public boolean isBankEdit()
	{
		return bankEdit;
	}

	public void setBankEdit(boolean bankEdit)
	{
		this.bankEdit = bankEdit;
	}

	public boolean isBankDelete()
	{
		return bankDelete;
	}

	public void setBankDelete(boolean bankDelete)
	{
		this.bankDelete = bankDelete;
	}

	public boolean isBankView()
	{
		return bankView;
	}

	public void setBankView(boolean bankView)
	{
		this.bankView = bankView;
	}

	public boolean isBankExport()
	{
		return bankExport;
	}

	public void setBankExport(boolean bankExport)
	{
		this.bankExport = bankExport;
	}

	public boolean isOrderAdjustAdd()
	{
		return orderAdjustAdd;
	}

	public void setOrderAdjustAdd(boolean orderAdjustAdd)
	{
		this.orderAdjustAdd = orderAdjustAdd;
	}

	public boolean isOrderAdjustEdit()
	{
		return orderAdjustEdit;
	}

	public void setOrderAdjustEdit(boolean orderAdjustEdit)
	{
		this.orderAdjustEdit = orderAdjustEdit;
	}

	public boolean isOrderAdjustDelete()
	{
		return orderAdjustDelete;
	}

	public void setOrderAdjustDelete(boolean orderAdjustDelete)
	{
		this.orderAdjustDelete = orderAdjustDelete;
	}

	public boolean isOrderAdjustViewOwn()
	{
		return orderAdjustViewOwn;
	}

	public void setOrderAdjustViewOwn(boolean orderAdjustViewOwn)
	{
		this.orderAdjustViewOwn = orderAdjustViewOwn;
	}

	public boolean isOrderAdjustViewAll()
	{
		return orderAdjustViewAll;
	}

	public void setOrderAdjustViewAll(boolean orderAdjustViewAll)
	{
		this.orderAdjustViewAll = orderAdjustViewAll;
	}

	public boolean isOrderAdjustExport()
	{
		return orderAdjustExport;
	}

	public void setOrderAdjustExport(boolean orderAdjustExport)
	{
		this.orderAdjustExport = orderAdjustExport;
	}

	public boolean isOrderAdjustSend()
	{
		return orderAdjustSend;
	}

	public void setOrderAdjustSend(boolean orderAdjustSend)
	{
		this.orderAdjustSend = orderAdjustSend;
	}

	public boolean isCdpVouAdd()
	{
		return cdpVouAdd;
	}

	public void setCdpVouAdd(boolean cdpVouAdd)
	{
		this.cdpVouAdd = cdpVouAdd;
	}

	public boolean isCdpVouEdit()
	{
		return cdpVouEdit;
	}

	public void setCdpVouEdit(boolean cdpVouEdit)
	{
		this.cdpVouEdit = cdpVouEdit;
	}

	public boolean isCdpVouDelete()
	{
		return cdpVouDelete;
	}

	public void setCdpVouDelete(boolean cdpVouDelete)
	{
		this.cdpVouDelete = cdpVouDelete;
	}

	public boolean isCdpVouViewOwn()
	{
		return cdpVouViewOwn;
	}

	public void setCdpVouViewOwn(boolean cdpVouViewOwn)
	{
		this.cdpVouViewOwn = cdpVouViewOwn;
	}

	public boolean isCdpVouViewAll()
	{
		return cdpVouViewAll;
	}

	public void setCdpVouViewAll(boolean cdpVouViewAll)
	{
		this.cdpVouViewAll = cdpVouViewAll;
	}

	public boolean isCdpVouExport()
	{
		return cdpVouExport;
	}

	public void setCdpVouExport(boolean cdpVouExport)
	{
		this.cdpVouExport = cdpVouExport;
	}

	public boolean isCdpVouSend()
	{
		return cdpVouSend;
	}

	public void setCdpVouSend(boolean cdpVouSend)
	{
		this.cdpVouSend = cdpVouSend;
	}

	public boolean isCdpJournalVouAdd()
	{
		return cdpJournalVouAdd;
	}

	public void setCdpJournalVouAdd(boolean cdpJournalVouAdd)
	{
		this.cdpJournalVouAdd = cdpJournalVouAdd;
	}

	public boolean isCdpJournalVouEdit()
	{
		return cdpJournalVouEdit;
	}

	public void setCdpJournalVouEdit(boolean cdpJournalVouEdit)
	{
		this.cdpJournalVouEdit = cdpJournalVouEdit;
	}

	public boolean isCdpJournalVouDelete()
	{
		return cdpJournalVouDelete;
	}

	public void setCdpJournalVouDelete(boolean cdpJournalVouDelete)
	{
		this.cdpJournalVouDelete = cdpJournalVouDelete;
	}

	public boolean isCdpJournalVouViewOwn()
	{
		return cdpJournalVouViewOwn;
	}

	public void setCdpJournalVouViewOwn(boolean cdpJournalVouViewOwn)
	{
		this.cdpJournalVouViewOwn = cdpJournalVouViewOwn;
	}

	public boolean isCdpJournalVouViewAll()
	{
		return cdpJournalVouViewAll;
	}

	public void setCdpJournalVouViewAll(boolean cdpJournalVouViewAll)
	{
		this.cdpJournalVouViewAll = cdpJournalVouViewAll;
	}

	public boolean isCdpJournalVouExport()
	{
		return cdpJournalVouExport;
	}

	public void setCdpJournalVouExport(boolean cdpJournalVouExport)
	{
		this.cdpJournalVouExport = cdpJournalVouExport;
	}

	public boolean isCdpJournalVouPrint()
	{
		return cdpJournalVouPrint;
	}

	public void setCdpJournalVouPrint(boolean cdpJournalVouPrint)
	{
		this.cdpJournalVouPrint = cdpJournalVouPrint;
	}

	public boolean isCdpJournalVouSend()
	{
		return cdpJournalVouSend;
	}

	public void setCdpJournalVouSend(boolean cdpJournalVouSend)
	{
		this.cdpJournalVouSend = cdpJournalVouSend;
	}

	public boolean isCommVouAdd()
	{
		return commVouAdd;
	}

	public void setCommVouAdd(boolean commVouAdd)
	{
		this.commVouAdd = commVouAdd;
	}

	public boolean isCommVouEdit()
	{
		return commVouEdit;
	}

	public void setCommVouEdit(boolean commVouEdit)
	{
		this.commVouEdit = commVouEdit;
	}

	public boolean isCommVouDelete()
	{
		return commVouDelete;
	}

	public void setCommVouDelete(boolean commVouDelete)
	{
		this.commVouDelete = commVouDelete;
	}

	public boolean isCommVouViewOwn()
	{
		return commVouViewOwn;
	}

	public void setCommVouViewOwn(boolean commVouViewOwn)
	{
		this.commVouViewOwn = commVouViewOwn;
	}

	public boolean isCommVouViewAll()
	{
		return commVouViewAll;
	}

	public void setCommVouViewAll(boolean commVouViewAll)
	{
		this.commVouViewAll = commVouViewAll;
	}

	public boolean isCommVouExport()
	{
		return commVouExport;
	}

	public void setCommVouExport(boolean commVouExport)
	{
		this.commVouExport = commVouExport;
	}

	public boolean isCommVouPrint()
	{
		return commVouPrint;
	}

	public void setCommVouPrint(boolean commVouPrint)
	{
		this.commVouPrint = commVouPrint;
	}

	public boolean isCommVouSend()
	{
		return commVouSend;
	}

	public void setCommVouSend(boolean commVouSend)
	{
		this.commVouSend = commVouSend;
	}

	public boolean isPurchaseOrderAdd()
	{
		return purchaseOrderAdd;
	}

	public void setPurchaseOrderAdd(boolean purchaseOrderAdd)
	{
		this.purchaseOrderAdd = purchaseOrderAdd;
	}

	public boolean isPurchaseOrderEdit()
	{
		return purchaseOrderEdit;
	}

	public void setPurchaseOrderEdit(boolean purchaseOrderEdit)
	{
		this.purchaseOrderEdit = purchaseOrderEdit;
	}

	public boolean isPurchaseOrderDelete()
	{
		return purchaseOrderDelete;
	}

	public void setPurchaseOrderDelete(boolean purchaseOrderDelete)
	{
		this.purchaseOrderDelete = purchaseOrderDelete;
	}

	public boolean isPurchaseOrderViewOwn()
	{
		return purchaseOrderViewOwn;
	}

	public void setPurchaseOrderViewOwn(boolean purchaseOrderViewOwn)
	{
		this.purchaseOrderViewOwn = purchaseOrderViewOwn;
	}

	public boolean isPurchaseOrderViewAll()
	{
		return purchaseOrderViewAll;
	}

	public void setPurchaseOrderViewAll(boolean purchaseOrderViewAll)
	{
		this.purchaseOrderViewAll = purchaseOrderViewAll;
	}

	public boolean isPurchaseOrderExport()
	{
		return purchaseOrderExport;
	}

	public void setPurchaseOrderExport(boolean purchaseOrderExport)
	{
		this.purchaseOrderExport = purchaseOrderExport;
	}

	public boolean isPurchaseOrderPrint()
	{
		return purchaseOrderPrint;
	}

	public void setPurchaseOrderPrint(boolean purchaseOrderPrint)
	{
		this.purchaseOrderPrint = purchaseOrderPrint;
	}

	public boolean isPurchaseOrderPrintList()
	{
		return purchaseOrderPrintList;
	}

	public void setPurchaseOrderPrintList(boolean purchaseOrderPrintList)
	{
		this.purchaseOrderPrintList = purchaseOrderPrintList;
	}

	public boolean isPurchaseOrderSend()
	{
		return purchaseOrderSend;
	}

	public void setPurchaseOrderSend(boolean purchaseOrderSend)
	{
		this.purchaseOrderSend = purchaseOrderSend;
	}

	public boolean isEstimateAdd()
	{
		return estimateAdd;
	}

	public void setEstimateAdd(boolean estimateAdd)
	{
		this.estimateAdd = estimateAdd;
	}

	public boolean isEstimateEdit()
	{
		return estimateEdit;
	}

	public void setEstimateEdit(boolean estimateEdit)
	{
		this.estimateEdit = estimateEdit;
	}

	public boolean isEstimateDelete()
	{
		return estimateDelete;
	}

	public void setEstimateDelete(boolean estimateDelete)
	{
		this.estimateDelete = estimateDelete;
	}

	public boolean isEstimateViewOwn()
	{
		return estimateViewOwn;
	}

	public void setEstimateViewOwn(boolean estimateViewOwn)
	{
		this.estimateViewOwn = estimateViewOwn;
	}

	public boolean isEstimateViewAll()
	{
		return estimateViewAll;
	}

	public void setEstimateViewAll(boolean estimateViewAll)
	{
		this.estimateViewAll = estimateViewAll;
	}

	public boolean isEstimateExport()
	{
		return estimateExport;
	}

	public void setEstimateExport(boolean estimateExport)
	{
		this.estimateExport = estimateExport;
	}

	public boolean isEstimatePrint()
	{
		return estimatePrint;
	}

	public void setEstimatePrint(boolean estimatePrint)
	{
		this.estimatePrint = estimatePrint;
	}

	public boolean isEstimatePrintList()
	{
		return estimatePrintList;
	}

	public void setEstimatePrintList(boolean estimatePrintList)
	{
		this.estimatePrintList = estimatePrintList;
	}

	public boolean isEstimateSend()
	{
		return estimateSend;
	}

	public void setEstimateSend(boolean estimateSend)
	{
		this.estimateSend = estimateSend;
	}

	public boolean isSalesOrderAdd()
	{
		return salesOrderAdd;
	}

	public void setSalesOrderAdd(boolean salesOrderAdd)
	{
		this.salesOrderAdd = salesOrderAdd;
	}

	public boolean isSalesOrderEdit()
	{
		return salesOrderEdit;
	}

	public void setSalesOrderEdit(boolean salesOrderEdit)
	{
		this.salesOrderEdit = salesOrderEdit;
	}

	public boolean isSalesOrderDelete()
	{
		return salesOrderDelete;
	}

	public void setSalesOrderDelete(boolean salesOrderDelete)
	{
		this.salesOrderDelete = salesOrderDelete;
	}

	public boolean isSalesOrderViewOwn()
	{
		return salesOrderViewOwn;
	}

	public void setSalesOrderViewOwn(boolean salesOrderViewOwn)
	{
		this.salesOrderViewOwn = salesOrderViewOwn;
	}

	public boolean isSalesOrderViewAll()
	{
		return salesOrderViewAll;
	}

	public void setSalesOrderViewAll(boolean salesOrderViewAll)
	{
		this.salesOrderViewAll = salesOrderViewAll;
	}

	public boolean isSalesOrderExport()
	{
		return salesOrderExport;
	}

	public void setSalesOrderExport(boolean salesOrderExport)
	{
		this.salesOrderExport = salesOrderExport;
	}

	public boolean isSalesOrderPrint()
	{
		return salesOrderPrint;
	}

	public void setSalesOrderPrint(boolean salesOrderPrint)
	{
		this.salesOrderPrint = salesOrderPrint;
	}

	public boolean isSalesOrderPrintList()
	{
		return salesOrderPrintList;
	}

	public void setSalesOrderPrintList(boolean salesOrderPrintList)
	{
		this.salesOrderPrintList = salesOrderPrintList;
	}

	public boolean isSalesOrderSend()
	{
		return salesOrderSend;
	}

	public void setSalesOrderSend(boolean salesOrderSend)
	{
		this.salesOrderSend = salesOrderSend;
	}

	public boolean isPiAdd()
	{
		return piAdd;
	}

	public void setPiAdd(boolean piAdd)
	{
		this.piAdd = piAdd;
	}

	public boolean isPiEdit()
	{
		return piEdit;
	}

	public void setPiEdit(boolean piEdit)
	{
		this.piEdit = piEdit;
	}

	public boolean isPiDelete()
	{
		return piDelete;
	}

	public void setPiDelete(boolean piDelete)
	{
		this.piDelete = piDelete;
	}

	public boolean isPiViewOwn()
	{
		return piViewOwn;
	}

	public void setPiViewOwn(boolean piViewOwn)
	{
		this.piViewOwn = piViewOwn;
	}

	public boolean isPiViewAll()
	{
		return piViewAll;
	}

	public void setPiViewAll(boolean piViewAll)
	{
		this.piViewAll = piViewAll;
	}

	public boolean isPiExport()
	{
		return piExport;
	}

	public void setPiExport(boolean piExport)
	{
		this.piExport = piExport;
	}

	public boolean isPiPrint()
	{
		return piPrint;
	}

	public void setPiPrint(boolean piPrint)
	{
		this.piPrint = piPrint;
	}

	public boolean isPiPrintChallan()
	{
		return piPrintChallan;
	}

	public void setPiPrintChallan(boolean piPrintChallan)
	{
		this.piPrintChallan = piPrintChallan;
	}

	public boolean isPiPrintList()
	{
		return piPrintList;
	}

	public void setPiPrintList(boolean piPrintList)
	{
		this.piPrintList = piPrintList;
	}

	public boolean isPiSend()
	{
		return piSend;
	}

	public void setPiSend(boolean piSend)
	{
		this.piSend = piSend;
	}

	public boolean isPurchaseReturnAdd()
	{
		return purchaseReturnAdd;
	}

	public void setPurchaseReturnAdd(boolean purchaseReturnAdd)
	{
		this.purchaseReturnAdd = purchaseReturnAdd;
	}

	public boolean isPurchaseReturnEdit()
	{
		return purchaseReturnEdit;
	}

	public void setPurchaseReturnEdit(boolean purchaseReturnEdit)
	{
		this.purchaseReturnEdit = purchaseReturnEdit;
	}

	public boolean isPurchaseReturnDelete()
	{
		return purchaseReturnDelete;
	}

	public void setPurchaseReturnDelete(boolean purchaseReturnDelete)
	{
		this.purchaseReturnDelete = purchaseReturnDelete;
	}

	public boolean isPurchaseReturnViewOwn()
	{
		return purchaseReturnViewOwn;
	}

	public void setPurchaseReturnViewOwn(boolean purchaseReturnViewOwn)
	{
		this.purchaseReturnViewOwn = purchaseReturnViewOwn;
	}

	public boolean isPurchaseReturnViewAll()
	{
		return purchaseReturnViewAll;
	}

	public void setPurchaseReturnViewAll(boolean purchaseReturnViewAll)
	{
		this.purchaseReturnViewAll = purchaseReturnViewAll;
	}

	public boolean isPurchaseReturnExport()
	{
		return purchaseReturnExport;
	}

	public void setPurchaseReturnExport(boolean purchaseReturnExport)
	{
		this.purchaseReturnExport = purchaseReturnExport;
	}

	public boolean isPurchaseReturnPrint()
	{
		return purchaseReturnPrint;
	}

	public void setPurchaseReturnPrint(boolean purchaseReturnPrint)
	{
		this.purchaseReturnPrint = purchaseReturnPrint;
	}

	public boolean isPurchaseReturnPrintChallan()
	{
		return purchaseReturnPrintChallan;
	}

	public void setPurchaseReturnPrintChallan(boolean purchaseReturnPrintChallan)
	{
		this.purchaseReturnPrintChallan = purchaseReturnPrintChallan;
	}

	public boolean isPurchaseReturnPrintList()
	{
		return purchaseReturnPrintList;
	}

	public void setPurchaseReturnPrintList(boolean purchaseReturnPrintList)
	{
		this.purchaseReturnPrintList = purchaseReturnPrintList;
	}

	public boolean isPurchaseReturnSend()
	{
		return purchaseReturnSend;
	}

	public void setPurchaseReturnSend(boolean purchaseReturnSend)
	{
		this.purchaseReturnSend = purchaseReturnSend;
	}

	public boolean isPurchaseAdd()
	{
		return purchaseAdd;
	}

	public void setPurchaseAdd(boolean purchaseAdd)
	{
		this.purchaseAdd = purchaseAdd;
	}

	public boolean isPurchaseEdit()
	{
		return purchaseEdit;
	}

	public void setPurchaseEdit(boolean purchaseEdit)
	{
		this.purchaseEdit = purchaseEdit;
	}

	public boolean isPurchaseDelete()
	{
		return purchaseDelete;
	}

	public void setPurchaseDelete(boolean purchaseDelete)
	{
		this.purchaseDelete = purchaseDelete;
	}

	public boolean isPurchaseViewOwn()
	{
		return purchaseViewOwn;
	}

	public void setPurchaseViewOwn(boolean purchaseViewOwn)
	{
		this.purchaseViewOwn = purchaseViewOwn;
	}

	public boolean isPurchaseViewAll()
	{
		return purchaseViewAll;
	}

	public void setPurchaseViewAll(boolean purchaseViewAll)
	{
		this.purchaseViewAll = purchaseViewAll;
	}

	public boolean isPurchaseExport()
	{
		return purchaseExport;
	}

	public void setPurchaseExport(boolean purchaseExport)
	{
		this.purchaseExport = purchaseExport;
	}

	public boolean isPurchasePrint()
	{
		return purchasePrint;
	}

	public void setPurchasePrint(boolean purchasePrint)
	{
		this.purchasePrint = purchasePrint;
	}

	public boolean isPurchasePrintList()
	{
		return purchasePrintList;
	}

	public void setPurchasePrintList(boolean purchasePrintList)
	{
		this.purchasePrintList = purchasePrintList;
	}

	public boolean isPurchasePrintBarcode()
	{
		return purchasePrintBarcode;
	}

	public void setPurchasePrintBarcode(boolean purchasePrintBarcode)
	{
		this.purchasePrintBarcode = purchasePrintBarcode;
	}

	public boolean isPurchaseSend()
	{
		return purchaseSend;
	}

	public void setPurchaseSend(boolean purchaseSend)
	{
		this.purchaseSend = purchaseSend;
	}

	public boolean isSalesReturnAdd()
	{
		return salesReturnAdd;
	}

	public void setSalesReturnAdd(boolean salesReturnAdd)
	{
		this.salesReturnAdd = salesReturnAdd;
	}

	public boolean isSalesReturnEdit()
	{
		return salesReturnEdit;
	}

	public void setSalesReturnEdit(boolean salesReturnEdit)
	{
		this.salesReturnEdit = salesReturnEdit;
	}

	public boolean isSalesReturnDelete()
	{
		return salesReturnDelete;
	}

	public void setSalesReturnDelete(boolean salesReturnDelete)
	{
		this.salesReturnDelete = salesReturnDelete;
	}

	public boolean isSalesReturnViewOwn()
	{
		return salesReturnViewOwn;
	}

	public void setSalesReturnViewOwn(boolean salesReturnViewOwn)
	{
		this.salesReturnViewOwn = salesReturnViewOwn;
	}

	public boolean isSalesReturnViewAll()
	{
		return salesReturnViewAll;
	}

	public void setSalesReturnViewAll(boolean salesReturnViewAll)
	{
		this.salesReturnViewAll = salesReturnViewAll;
	}

	public boolean isSalesReturnExport()
	{
		return salesReturnExport;
	}

	public void setSalesReturnExport(boolean salesReturnExport)
	{
		this.salesReturnExport = salesReturnExport;
	}

	public boolean isSalesReturnPrint()
	{
		return salesReturnPrint;
	}

	public void setSalesReturnPrint(boolean salesReturnPrint)
	{
		this.salesReturnPrint = salesReturnPrint;
	}

	public boolean isSalesReturnPrintBarcode()
	{
		return salesReturnPrintBarcode;
	}

	public void setSalesReturnPrintBarcode(boolean salesReturnPrintBarcode)
	{
		this.salesReturnPrintBarcode = salesReturnPrintBarcode;
	}

	public boolean isSalesReturnPrintList()
	{
		return salesReturnPrintList;
	}

	public void setSalesReturnPrintList(boolean salesReturnPrintList)
	{
		this.salesReturnPrintList = salesReturnPrintList;
	}

	public boolean isSalesReturnSend()
	{
		return salesReturnSend;
	}

	public void setSalesReturnSend(boolean salesReturnSend)
	{
		this.salesReturnSend = salesReturnSend;
	}

	public boolean isSalesAdd()
	{
		return salesAdd;
	}

	public void setSalesAdd(boolean salesAdd)
	{
		this.salesAdd = salesAdd;
	}

	public boolean isSalesEdit()
	{
		return salesEdit;
	}

	public void setSalesEdit(boolean salesEdit)
	{
		this.salesEdit = salesEdit;
	}

	public boolean isSalesDelete()
	{
		return salesDelete;
	}

	public void setSalesDelete(boolean salesDelete)
	{
		this.salesDelete = salesDelete;
	}

	public boolean isSalesViewOwn()
	{
		return salesViewOwn;
	}

	public void setSalesViewOwn(boolean salesViewOwn)
	{
		this.salesViewOwn = salesViewOwn;
	}

	public boolean isSalesViewAll()
	{
		return salesViewAll;
	}

	public void setSalesViewAll(boolean salesViewAll)
	{
		this.salesViewAll = salesViewAll;
	}

	public boolean isSalesExport()
	{
		return salesExport;
	}

	public void setSalesExport(boolean salesExport)
	{
		this.salesExport = salesExport;
	}

	public boolean isSalesPrint()
	{
		return salesPrint;
	}

	public void setSalesPrint(boolean salesPrint)
	{
		this.salesPrint = salesPrint;
	}

	public boolean isSalesPrintChallan()
	{
		return salesPrintChallan;
	}

	public void setSalesPrintChallan(boolean salesPrintChallan)
	{
		this.salesPrintChallan = salesPrintChallan;
	}

	public boolean isSalesPrintList()
	{
		return salesPrintList;
	}

	public void setSalesPrintList(boolean salesPrintList)
	{
		this.salesPrintList = salesPrintList;
	}

	public boolean isSalesSend()
	{
		return salesSend;
	}

	public void setSalesSend(boolean salesSend)
	{
		this.salesSend = salesSend;
	}

	public boolean isPaymentAdd()
	{
		return paymentAdd;
	}

	public void setPaymentAdd(boolean paymentAdd)
	{
		this.paymentAdd = paymentAdd;
	}

	public boolean isPaymentEdit()
	{
		return paymentEdit;
	}

	public void setPaymentEdit(boolean paymentEdit)
	{
		this.paymentEdit = paymentEdit;
	}

	public boolean isPaymentDelete()
	{
		return paymentDelete;
	}

	public void setPaymentDelete(boolean paymentDelete)
	{
		this.paymentDelete = paymentDelete;
	}

	public boolean isPaymentViewOwn()
	{
		return paymentViewOwn;
	}

	public void setPaymentViewOwn(boolean paymentViewOwn)
	{
		this.paymentViewOwn = paymentViewOwn;
	}

	public boolean isPaymentViewAll()
	{
		return paymentViewAll;
	}

	public void setPaymentViewAll(boolean paymentViewAll)
	{
		this.paymentViewAll = paymentViewAll;
	}

	public boolean isPaymentExport()
	{
		return paymentExport;
	}

	public void setPaymentExport(boolean paymentExport)
	{
		this.paymentExport = paymentExport;
	}

	public boolean isPaymentPrint()
	{
		return paymentPrint;
	}

	public void setPaymentPrint(boolean paymentPrint)
	{
		this.paymentPrint = paymentPrint;
	}

	public boolean isPaymentSend()
	{
		return paymentSend;
	}

	public void setPaymentSend(boolean paymentSend)
	{
		this.paymentSend = paymentSend;
	}

	public boolean isReceiptAdd()
	{
		return receiptAdd;
	}

	public void setReceiptAdd(boolean receiptAdd)
	{
		this.receiptAdd = receiptAdd;
	}

	public boolean isReceiptEdit()
	{
		return receiptEdit;
	}

	public void setReceiptEdit(boolean receiptEdit)
	{
		this.receiptEdit = receiptEdit;
	}

	public boolean isReceiptDelete()
	{
		return receiptDelete;
	}

	public void setReceiptDelete(boolean receiptDelete)
	{
		this.receiptDelete = receiptDelete;
	}

	public boolean isReceiptViewOwn()
	{
		return receiptViewOwn;
	}

	public void setReceiptViewOwn(boolean receiptViewOwn)
	{
		this.receiptViewOwn = receiptViewOwn;
	}

	public boolean isReceiptViewAll()
	{
		return receiptViewAll;
	}

	public void setReceiptViewAll(boolean receiptViewAll)
	{
		this.receiptViewAll = receiptViewAll;
	}

	public boolean isReceiptExport()
	{
		return receiptExport;
	}

	public void setReceiptExport(boolean receiptExport)
	{
		this.receiptExport = receiptExport;
	}

	public boolean isReceiptPrint()
	{
		return receiptPrint;
	}

	public void setReceiptPrint(boolean receiptPrint)
	{
		this.receiptPrint = receiptPrint;
	}

	public boolean isReceiptSend()
	{
		return receiptSend;
	}

	public void setReceiptSend(boolean receiptSend)
	{
		this.receiptSend = receiptSend;
	}

	public boolean isContraAdd()
	{
		return contraAdd;
	}

	public void setContraAdd(boolean contraAdd)
	{
		this.contraAdd = contraAdd;
	}

	public boolean isContraEdit()
	{
		return contraEdit;
	}

	public void setContraEdit(boolean contraEdit)
	{
		this.contraEdit = contraEdit;
	}

	public boolean isContraDelete()
	{
		return contraDelete;
	}

	public void setContraDelete(boolean contraDelete)
	{
		this.contraDelete = contraDelete;
	}

	public boolean isContraViewOwn()
	{
		return contraViewOwn;
	}

	public void setContraViewOwn(boolean contraViewOwn)
	{
		this.contraViewOwn = contraViewOwn;
	}

	public boolean isContraViewAll()
	{
		return contraViewAll;
	}

	public void setContraViewAll(boolean contraViewAll)
	{
		this.contraViewAll = contraViewAll;
	}

	public boolean isContraExport()
	{
		return contraExport;
	}

	public void setContraExport(boolean contraExport)
	{
		this.contraExport = contraExport;
	}

	public boolean isContraPrint()
	{
		return contraPrint;
	}

	public void setContraPrint(boolean contraPrint)
	{
		this.contraPrint = contraPrint;
	}

	public boolean isContraSend()
	{
		return contraSend;
	}

	public void setContraSend(boolean contraSend)
	{
		this.contraSend = contraSend;
	}

	public boolean isJournalAdd()
	{
		return journalAdd;
	}

	public void setJournalAdd(boolean journalAdd)
	{
		this.journalAdd = journalAdd;
	}

	public boolean isJournalEdit()
	{
		return journalEdit;
	}

	public void setJournalEdit(boolean journalEdit)
	{
		this.journalEdit = journalEdit;
	}

	public boolean isJournalDelete()
	{
		return journalDelete;
	}

	public void setJournalDelete(boolean journalDelete)
	{
		this.journalDelete = journalDelete;
	}

	public boolean isJournalViewOwn()
	{
		return journalViewOwn;
	}

	public void setJournalViewOwn(boolean journalViewOwn)
	{
		this.journalViewOwn = journalViewOwn;
	}

	public boolean isJournalViewAll()
	{
		return journalViewAll;
	}

	public void setJournalViewAll(boolean journalViewAll)
	{
		this.journalViewAll = journalViewAll;
	}

	public boolean isJournalExport()
	{
		return journalExport;
	}

	public void setJournalExport(boolean journalExport)
	{
		this.journalExport = journalExport;
	}

	public boolean isJournalPrint()
	{
		return journalPrint;
	}

	public void setJournalPrint(boolean journalPrint)
	{
		this.journalPrint = journalPrint;
	}

	public boolean isJournalSend()
	{
		return journalSend;
	}

	public void setJournalSend(boolean journalSend)
	{
		this.journalSend = journalSend;
	}

	public boolean isTaskAdd()
	{
		return taskAdd;
	}

	public void setTaskAdd(boolean taskAdd)
	{
		this.taskAdd = taskAdd;
	}

	public boolean isTaskEdit()
	{
		return taskEdit;
	}

	public void setTaskEdit(boolean taskEdit)
	{
		this.taskEdit = taskEdit;
	}

	public boolean isTaskDelete()
	{
		return taskDelete;
	}

	public void setTaskDelete(boolean taskDelete)
	{
		this.taskDelete = taskDelete;
	}

	public boolean isTaskViewOwn()
	{
		return taskViewOwn;
	}

	public void setTaskViewOwn(boolean taskViewOwn)
	{
		this.taskViewOwn = taskViewOwn;
	}

	public boolean isTaskViewAll()
	{
		return taskViewAll;
	}

	public void setTaskViewAll(boolean taskViewAll)
	{
		this.taskViewAll = taskViewAll;
	}

	public boolean isTaskExport()
	{
		return taskExport;
	}

	public void setTaskExport(boolean taskExport)
	{
		this.taskExport = taskExport;
	}

	public boolean isAcctBookOpen()
	{
		return acctBookOpen;
	}

	public void setAcctBookOpen(boolean acctBookOpen)
	{
		this.acctBookOpen = acctBookOpen;
	}

	public boolean isOpenSystemSettings()
	{
		return openSystemSettings;
	}

	public void setOpenSystemSettings(boolean openSystemSettings)
	{
		this.openSystemSettings = openSystemSettings;
	}

	public boolean isAccessRoleAdd()
	{
		return accessRoleAdd;
	}

	public void setAccessRoleAdd(boolean accessRoleAdd)
	{
		this.accessRoleAdd = accessRoleAdd;
	}

	public boolean isAccessRoleEdit()
	{
		return accessRoleEdit;
	}

	public void setAccessRoleEdit(boolean accessRoleEdit)
	{
		this.accessRoleEdit = accessRoleEdit;
	}

	public boolean isAccessRoleDelete()
	{
		return accessRoleDelete;
	}

	public void setAccessRoleDelete(boolean accessRoleDelete)
	{
		this.accessRoleDelete = accessRoleDelete;
	}

	public boolean isAccessRoleView()
	{
		return accessRoleView;
	}

	public void setAccessRoleView(boolean accessRoleView)
	{
		this.accessRoleView = accessRoleView;
	}

	public boolean isAccessRoleExport()
	{
		return accessRoleExport;
	}

	public void setAccessRoleExport(boolean accessRoleExport)
	{
		this.accessRoleExport = accessRoleExport;
	}

	public boolean isUserAdd()
	{
		return userAdd;
	}

	public void setUserAdd(boolean userAdd)
	{
		this.userAdd = userAdd;
	}

	public boolean isUserEdit()
	{
		return userEdit;
	}

	public void setUserEdit(boolean userEdit)
	{
		this.userEdit = userEdit;
	}

	public boolean isUserDelete()
	{
		return userDelete;
	}

	public void setUserDelete(boolean userDelete)
	{
		this.userDelete = userDelete;
	}

	public boolean isUserView()
	{
		return userView;
	}

	public void setUserView(boolean userView)
	{
		this.userView = userView;
	}

	public boolean isUserExport()
	{
		return userExport;
	}

	public void setUserExport(boolean userExport)
	{
		this.userExport = userExport;
	}

	public boolean isOpenCompanyManagement()
	{
		return openCompanyManagement;
	}

	public void setOpenCompanyManagement(boolean openCompanyManagement)
	{
		this.openCompanyManagement = openCompanyManagement;
	}

	public boolean isCompanyAdd()
	{
		return companyAdd;
	}

	public void setCompanyAdd(boolean companyAdd)
	{
		this.companyAdd = companyAdd;
	}

	public boolean isCompanyEdit()
	{
		return companyEdit;
	}

	public void setCompanyEdit(boolean companyEdit)
	{
		this.companyEdit = companyEdit;
	}

	public boolean isCompanyDelete()
	{
		return companyDelete;
	}

	public void setCompanyDelete(boolean companyDelete)
	{
		this.companyDelete = companyDelete;
	}

	public boolean isFinYearAdd()
	{
		return finYearAdd;
	}

	public void setFinYearAdd(boolean finYearAdd)
	{
		this.finYearAdd = finYearAdd;
	}

	public boolean isFinYearEdit()
	{
		return finYearEdit;
	}

	public void setFinYearEdit(boolean finYearEdit)
	{
		this.finYearEdit = finYearEdit;
	}

	public boolean isFinYearDelete()
	{
		return finYearDelete;
	}

	public void setFinYearDelete(boolean finYearDelete)
	{
		this.finYearDelete = finYearDelete;
	}

	public boolean isFinYearOpen()
	{
		return finYearOpen;
	}

	public void setFinYearOpen(boolean finYearOpen)
	{
		this.finYearOpen = finYearOpen;
	}

	public boolean isFinYearChangeDefault()
	{
		return finYearChangeDefault;
	}

	public void setFinYearChangeDefault(boolean finYearChangeDefault)
	{
		this.finYearChangeDefault = finYearChangeDefault;
	}

	public boolean isBackup()
	{
		return backup;
	}

	public void setBackup(boolean backup)
	{
		this.backup = backup;
	}

	public boolean isRestore()
	{
		return restore;
	}

	public void setRestore(boolean restore)
	{
		this.restore = restore;
	}

	public boolean isImportUd()
	{
		return importUd;
	}

	public void setImportUd(boolean importUd)
	{
		this.importUd = importUd;
	}

	public boolean isRptDayBookViewOwn()
	{
		return rptDayBookViewOwn;
	}

	public void setRptDayBookViewOwn(boolean rptDayBookViewOwn)
	{
		this.rptDayBookViewOwn = rptDayBookViewOwn;
	}

	public boolean isRptDayBookViewAll()
	{
		return rptDayBookViewAll;
	}

	public void setRptDayBookViewAll(boolean rptDayBookViewAll)
	{
		this.rptDayBookViewAll = rptDayBookViewAll;
	}

	public boolean isRptDayBookExport()
	{
		return rptDayBookExport;
	}

	public void setRptDayBookExport(boolean rptDayBookExport)
	{
		this.rptDayBookExport = rptDayBookExport;
	}

	public boolean isRptDayBookPrint()
	{
		return rptDayBookPrint;
	}

	public void setRptDayBookPrint(boolean rptDayBookPrint)
	{
		this.rptDayBookPrint = rptDayBookPrint;
	}

	public boolean isRptSalesReturnByMonthView()
	{
		return rptSalesReturnByMonthView;
	}

	public void setRptSalesReturnByMonthView(boolean rptSalesReturnByMonthView)
	{
		this.rptSalesReturnByMonthView = rptSalesReturnByMonthView;
	}

	public boolean isRptSalesReturnByMonthExport()
	{
		return rptSalesReturnByMonthExport;
	}

	public void setRptSalesReturnByMonthExport(boolean rptSalesReturnByMonthExport)
	{
		this.rptSalesReturnByMonthExport = rptSalesReturnByMonthExport;
	}

	public boolean isRptSalesReturnByDayView()
	{
		return rptSalesReturnByDayView;
	}

	public void setRptSalesReturnByDayView(boolean rptSalesReturnByDayView)
	{
		this.rptSalesReturnByDayView = rptSalesReturnByDayView;
	}

	public boolean isRptSalesReturnByDayExport()
	{
		return rptSalesReturnByDayExport;
	}

	public void setRptSalesReturnByDayExport(boolean rptSalesReturnByDayExport)
	{
		this.rptSalesReturnByDayExport = rptSalesReturnByDayExport;
	}

	public boolean isRptSalesReturnByCustomerView()
	{
		return rptSalesReturnByCustomerView;
	}

	public void setRptSalesReturnByCustomerView(boolean rptSalesReturnByCustomerView)
	{
		this.rptSalesReturnByCustomerView = rptSalesReturnByCustomerView;
	}

	public boolean isRptSalesReturnByCustomerExport()
	{
		return rptSalesReturnByCustomerExport;
	}

	public void setRptSalesReturnByCustomerExport(boolean rptSalesReturnByCustomerExport)
	{
		this.rptSalesReturnByCustomerExport = rptSalesReturnByCustomerExport;
	}

	public boolean isRptSalesReturnByProdCatView()
	{
		return rptSalesReturnByProdCatView;
	}

	public void setRptSalesReturnByProdCatView(boolean rptSalesReturnByProdCatView)
	{
		this.rptSalesReturnByProdCatView = rptSalesReturnByProdCatView;
	}

	public boolean isRptSalesReturnByProdCatExport()
	{
		return rptSalesReturnByProdCatExport;
	}

	public void setRptSalesReturnByProdCatExport(boolean rptSalesReturnByProdCatExport)
	{
		this.rptSalesReturnByProdCatExport = rptSalesReturnByProdCatExport;
	}

	public boolean isRptSalesReturnByProdView()
	{
		return rptSalesReturnByProdView;
	}

	public void setRptSalesReturnByProdView(boolean rptSalesReturnByProdView)
	{
		this.rptSalesReturnByProdView = rptSalesReturnByProdView;
	}

	public boolean isRptSalesReturnByProdExport()
	{
		return rptSalesReturnByProdExport;
	}

	public void setRptSalesReturnByProdExport(boolean rptSalesReturnByProdExport)
	{
		this.rptSalesReturnByProdExport = rptSalesReturnByProdExport;
	}

	public boolean isRptSalesReturnByCityView()
	{
		return rptSalesReturnByCityView;
	}

	public void setRptSalesReturnByCityView(boolean rptSalesReturnByCityView)
	{
		this.rptSalesReturnByCityView = rptSalesReturnByCityView;
	}

	public boolean isRptSalesReturnByCityExport()
	{
		return rptSalesReturnByCityExport;
	}

	public void setRptSalesReturnByCityExport(boolean rptSalesReturnByCityExport)
	{
		this.rptSalesReturnByCityExport = rptSalesReturnByCityExport;
	}

	public boolean isRptSalesReturnByStateView()
	{
		return rptSalesReturnByStateView;
	}

	public void setRptSalesReturnByStateView(boolean rptSalesReturnByStateView)
	{
		this.rptSalesReturnByStateView = rptSalesReturnByStateView;
	}

	public boolean isRptSalesReturnByStateExport()
	{
		return rptSalesReturnByStateExport;
	}

	public void setRptSalesReturnByStateExport(boolean rptSalesReturnByStateExport)
	{
		this.rptSalesReturnByStateExport = rptSalesReturnByStateExport;
	}

	public boolean isRptSalesReturnByAgentView()
	{
		return rptSalesReturnByAgentView;
	}

	public void setRptSalesReturnByAgentView(boolean rptSalesReturnByAgentView)
	{
		this.rptSalesReturnByAgentView = rptSalesReturnByAgentView;
	}

	public boolean isRptSalesReturnByAgentExport()
	{
		return rptSalesReturnByAgentExport;
	}

	public void setRptSalesReturnByAgentExport(boolean rptSalesReturnByAgentExport)
	{
		this.rptSalesReturnByAgentExport = rptSalesReturnByAgentExport;
	}

	public boolean isRptSalesByMonthView()
	{
		return rptSalesByMonthView;
	}

	public void setRptSalesByMonthView(boolean rptSalesByMonthView)
	{
		this.rptSalesByMonthView = rptSalesByMonthView;
	}

	public boolean isRptSalesByMonthExport()
	{
		return rptSalesByMonthExport;
	}

	public void setRptSalesByMonthExport(boolean rptSalesByMonthExport)
	{
		this.rptSalesByMonthExport = rptSalesByMonthExport;
	}

	public boolean isRptSalesByDayView()
	{
		return rptSalesByDayView;
	}

	public void setRptSalesByDayView(boolean rptSalesByDayView)
	{
		this.rptSalesByDayView = rptSalesByDayView;
	}

	public boolean isRptSalesByDayExport()
	{
		return rptSalesByDayExport;
	}

	public void setRptSalesByDayExport(boolean rptSalesByDayExport)
	{
		this.rptSalesByDayExport = rptSalesByDayExport;
	}

	public boolean isRptSalesByCustomerView()
	{
		return rptSalesByCustomerView;
	}

	public void setRptSalesByCustomerView(boolean rptSalesByCustomerView)
	{
		this.rptSalesByCustomerView = rptSalesByCustomerView;
	}

	public boolean isRptSalesByCustomerExport()
	{
		return rptSalesByCustomerExport;
	}

	public void setRptSalesByCustomerExport(boolean rptSalesByCustomerExport)
	{
		this.rptSalesByCustomerExport = rptSalesByCustomerExport;
	}

	public boolean isRptSalesByProdCatView()
	{
		return rptSalesByProdCatView;
	}

	public void setRptSalesByProdCatView(boolean rptSalesByProdCatView)
	{
		this.rptSalesByProdCatView = rptSalesByProdCatView;
	}

	public boolean isRptSalesByProdCatExport()
	{
		return rptSalesByProdCatExport;
	}

	public void setRptSalesByProdCatExport(boolean rptSalesByProdCatExport)
	{
		this.rptSalesByProdCatExport = rptSalesByProdCatExport;
	}

	public boolean isRptSalesByProdView()
	{
		return rptSalesByProdView;
	}

	public void setRptSalesByProdView(boolean rptSalesByProdView)
	{
		this.rptSalesByProdView = rptSalesByProdView;
	}

	public boolean isRptSalesByProdExport()
	{
		return rptSalesByProdExport;
	}

	public void setRptSalesByProdExport(boolean rptSalesByProdExport)
	{
		this.rptSalesByProdExport = rptSalesByProdExport;
	}

	public boolean isRptSalesByCityView()
	{
		return rptSalesByCityView;
	}

	public void setRptSalesByCityView(boolean rptSalesByCityView)
	{
		this.rptSalesByCityView = rptSalesByCityView;
	}

	public boolean isRptSalesByCityExport()
	{
		return rptSalesByCityExport;
	}

	public void setRptSalesByCityExport(boolean rptSalesByCityExport)
	{
		this.rptSalesByCityExport = rptSalesByCityExport;
	}

	public boolean isRptSalesByStateView()
	{
		return rptSalesByStateView;
	}

	public void setRptSalesByStateView(boolean rptSalesByStateView)
	{
		this.rptSalesByStateView = rptSalesByStateView;
	}

	public boolean isRptSalesByStateExport()
	{
		return rptSalesByStateExport;
	}

	public void setRptSalesByStateExport(boolean rptSalesByStateExport)
	{
		this.rptSalesByStateExport = rptSalesByStateExport;
	}

	public boolean isRptSalesByAgentView()
	{
		return rptSalesByAgentView;
	}

	public void setRptSalesByAgentView(boolean rptSalesByAgentView)
	{
		this.rptSalesByAgentView = rptSalesByAgentView;
	}

	public boolean isRptSalesByAgentExport()
	{
		return rptSalesByAgentExport;
	}

	public void setRptSalesByAgentExport(boolean rptSalesByAgentExport)
	{
		this.rptSalesByAgentExport = rptSalesByAgentExport;
	}

	public boolean isRptSalesProfitByCustomerView()
	{
		return rptSalesProfitByCustomerView;
	}

	public void setRptSalesProfitByCustomerView(boolean rptSalesProfitByCustomerView)
	{
		this.rptSalesProfitByCustomerView = rptSalesProfitByCustomerView;
	}

	public boolean isRptSalesProfitByCustomerExport()
	{
		return rptSalesProfitByCustomerExport;
	}

	public void setRptSalesProfitByCustomerExport(boolean rptSalesProfitByCustomerExport)
	{
		this.rptSalesProfitByCustomerExport = rptSalesProfitByCustomerExport;
	}

	public boolean isRptSalesProfitByProdView()
	{
		return rptSalesProfitByProdView;
	}

	public void setRptSalesProfitByProdView(boolean rptSalesProfitByProdView)
	{
		this.rptSalesProfitByProdView = rptSalesProfitByProdView;
	}

	public boolean isRptSalesProfitByProdExport()
	{
		return rptSalesProfitByProdExport;
	}

	public void setRptSalesProfitByProdExport(boolean rptSalesProfitByProdExport)
	{
		this.rptSalesProfitByProdExport = rptSalesProfitByProdExport;
	}

	public boolean isRptSalesProfitBySalesVouView()
	{
		return rptSalesProfitBySalesVouView;
	}

	public void setRptSalesProfitBySalesVouView(boolean rptSalesProfitBySalesVouView)
	{
		this.rptSalesProfitBySalesVouView = rptSalesProfitBySalesVouView;
	}

	public boolean isRptSalesProfitBySalesVouExport()
	{
		return rptSalesProfitBySalesVouExport;
	}

	public void setRptSalesProfitBySalesVouExport(boolean rptSalesProfitBySalesVouExport)
	{
		this.rptSalesProfitBySalesVouExport = rptSalesProfitBySalesVouExport;
	}

	public boolean isRptSalesProfitBySalesItemView()
	{
		return rptSalesProfitBySalesItemView;
	}

	public void setRptSalesProfitBySalesItemView(boolean rptSalesProfitBySalesItemView)
	{
		this.rptSalesProfitBySalesItemView = rptSalesProfitBySalesItemView;
	}

	public boolean isRptSalesProfitBySalesItemExport()
	{
		return rptSalesProfitBySalesItemExport;
	}

	public void setRptSalesProfitBySalesItemExport(boolean rptSalesProfitBySalesItemExport)
	{
		this.rptSalesProfitBySalesItemExport = rptSalesProfitBySalesItemExport;
	}

	public boolean isRptPurchaseReturnByMonthView()
	{
		return rptPurchaseReturnByMonthView;
	}

	public void setRptPurchaseReturnByMonthView(boolean rptPurchaseReturnByMonthView)
	{
		this.rptPurchaseReturnByMonthView = rptPurchaseReturnByMonthView;
	}

	public boolean isRptPurchaseReturnByMonthExport()
	{
		return rptPurchaseReturnByMonthExport;
	}

	public void setRptPurchaseReturnByMonthExport(boolean rptPurchaseReturnByMonthExport)
	{
		this.rptPurchaseReturnByMonthExport = rptPurchaseReturnByMonthExport;
	}

	public boolean isRptPurchaseReturnByDayView()
	{
		return rptPurchaseReturnByDayView;
	}

	public void setRptPurchaseReturnByDayView(boolean rptPurchaseReturnByDayView)
	{
		this.rptPurchaseReturnByDayView = rptPurchaseReturnByDayView;
	}

	public boolean isRptPurchaseReturnByDayExport()
	{
		return rptPurchaseReturnByDayExport;
	}

	public void setRptPurchaseReturnByDayExport(boolean rptPurchaseReturnByDayExport)
	{
		this.rptPurchaseReturnByDayExport = rptPurchaseReturnByDayExport;
	}

	public boolean isRptPurchaseReturnBySupplierView()
	{
		return rptPurchaseReturnBySupplierView;
	}

	public void setRptPurchaseReturnBySupplierView(boolean rptPurchaseReturnBySupplierView)
	{
		this.rptPurchaseReturnBySupplierView = rptPurchaseReturnBySupplierView;
	}

	public boolean isRptPurchaseReturnBySupplierExport()
	{
		return rptPurchaseReturnBySupplierExport;
	}

	public void setRptPurchaseReturnBySupplierExport(boolean rptPurchaseReturnBySupplierExport)
	{
		this.rptPurchaseReturnBySupplierExport = rptPurchaseReturnBySupplierExport;
	}

	public boolean isRptPurchaseReturnByProdCatView()
	{
		return rptPurchaseReturnByProdCatView;
	}

	public void setRptPurchaseReturnByProdCatView(boolean rptPurchaseReturnByProdCatView)
	{
		this.rptPurchaseReturnByProdCatView = rptPurchaseReturnByProdCatView;
	}

	public boolean isRptPurchaseReturnByProdCatExport()
	{
		return rptPurchaseReturnByProdCatExport;
	}

	public void setRptPurchaseReturnByProdCatExport(boolean rptPurchaseReturnByProdCatExport)
	{
		this.rptPurchaseReturnByProdCatExport = rptPurchaseReturnByProdCatExport;
	}

	public boolean isRptPurchaseReturnByProdView()
	{
		return rptPurchaseReturnByProdView;
	}

	public void setRptPurchaseReturnByProdView(boolean rptPurchaseReturnByProdView)
	{
		this.rptPurchaseReturnByProdView = rptPurchaseReturnByProdView;
	}

	public boolean isRptPurchaseReturnByProdExport()
	{
		return rptPurchaseReturnByProdExport;
	}

	public void setRptPurchaseReturnByProdExport(boolean rptPurchaseReturnByProdExport)
	{
		this.rptPurchaseReturnByProdExport = rptPurchaseReturnByProdExport;
	}

	public boolean isRptPurchaseReturnByCityView()
	{
		return rptPurchaseReturnByCityView;
	}

	public void setRptPurchaseReturnByCityView(boolean rptPurchaseReturnByCityView)
	{
		this.rptPurchaseReturnByCityView = rptPurchaseReturnByCityView;
	}

	public boolean isRptPurchaseReturnByCityExport()
	{
		return rptPurchaseReturnByCityExport;
	}

	public void setRptPurchaseReturnByCityExport(boolean rptPurchaseReturnByCityExport)
	{
		this.rptPurchaseReturnByCityExport = rptPurchaseReturnByCityExport;
	}

	public boolean isRptPurchaseReturnByStateView()
	{
		return rptPurchaseReturnByStateView;
	}

	public void setRptPurchaseReturnByStateView(boolean rptPurchaseReturnByStateView)
	{
		this.rptPurchaseReturnByStateView = rptPurchaseReturnByStateView;
	}

	public boolean isRptPurchaseReturnByStateExport()
	{
		return rptPurchaseReturnByStateExport;
	}

	public void setRptPurchaseReturnByStateExport(boolean rptPurchaseReturnByStateExport)
	{
		this.rptPurchaseReturnByStateExport = rptPurchaseReturnByStateExport;
	}

	public boolean isRptPurchaseByMonthView()
	{
		return rptPurchaseByMonthView;
	}

	public void setRptPurchaseByMonthView(boolean rptPurchaseByMonthView)
	{
		this.rptPurchaseByMonthView = rptPurchaseByMonthView;
	}

	public boolean isRptPurchaseByMonthExport()
	{
		return rptPurchaseByMonthExport;
	}

	public void setRptPurchaseByMonthExport(boolean rptPurchaseByMonthExport)
	{
		this.rptPurchaseByMonthExport = rptPurchaseByMonthExport;
	}

	public boolean isRptPurchaseByDayView()
	{
		return rptPurchaseByDayView;
	}

	public void setRptPurchaseByDayView(boolean rptPurchaseByDayView)
	{
		this.rptPurchaseByDayView = rptPurchaseByDayView;
	}

	public boolean isRptPurchaseByDayExport()
	{
		return rptPurchaseByDayExport;
	}

	public void setRptPurchaseByDayExport(boolean rptPurchaseByDayExport)
	{
		this.rptPurchaseByDayExport = rptPurchaseByDayExport;
	}

	public boolean isRptPurchaseBySupplierView()
	{
		return rptPurchaseBySupplierView;
	}

	public void setRptPurchaseBySupplierView(boolean rptPurchaseBySupplierView)
	{
		this.rptPurchaseBySupplierView = rptPurchaseBySupplierView;
	}

	public boolean isRptPurchaseBySupplierExport()
	{
		return rptPurchaseBySupplierExport;
	}

	public void setRptPurchaseBySupplierExport(boolean rptPurchaseBySupplierExport)
	{
		this.rptPurchaseBySupplierExport = rptPurchaseBySupplierExport;
	}

	public boolean isRptPurchaseByProdCatView()
	{
		return rptPurchaseByProdCatView;
	}

	public void setRptPurchaseByProdCatView(boolean rptPurchaseByProdCatView)
	{
		this.rptPurchaseByProdCatView = rptPurchaseByProdCatView;
	}

	public boolean isRptPurchaseByProdCatExport()
	{
		return rptPurchaseByProdCatExport;
	}

	public void setRptPurchaseByProdCatExport(boolean rptPurchaseByProdCatExport)
	{
		this.rptPurchaseByProdCatExport = rptPurchaseByProdCatExport;
	}

	public boolean isRptPurchaseByProdView()
	{
		return rptPurchaseByProdView;
	}

	public void setRptPurchaseByProdView(boolean rptPurchaseByProdView)
	{
		this.rptPurchaseByProdView = rptPurchaseByProdView;
	}

	public boolean isRptPurchaseByProdExport()
	{
		return rptPurchaseByProdExport;
	}

	public void setRptPurchaseByProdExport(boolean rptPurchaseByProdExport)
	{
		this.rptPurchaseByProdExport = rptPurchaseByProdExport;
	}

	public boolean isRptPurchaseByCityView()
	{
		return rptPurchaseByCityView;
	}

	public void setRptPurchaseByCityView(boolean rptPurchaseByCityView)
	{
		this.rptPurchaseByCityView = rptPurchaseByCityView;
	}

	public boolean isRptPurchaseByCityExport()
	{
		return rptPurchaseByCityExport;
	}

	public void setRptPurchaseByCityExport(boolean rptPurchaseByCityExport)
	{
		this.rptPurchaseByCityExport = rptPurchaseByCityExport;
	}

	public boolean isRptPurchaseByStateView()
	{
		return rptPurchaseByStateView;
	}

	public void setRptPurchaseByStateView(boolean rptPurchaseByStateView)
	{
		this.rptPurchaseByStateView = rptPurchaseByStateView;
	}

	public boolean isRptPurchaseByStateExport()
	{
		return rptPurchaseByStateExport;
	}

	public void setRptPurchaseByStateExport(boolean rptPurchaseByStateExport)
	{
		this.rptPurchaseByStateExport = rptPurchaseByStateExport;
	}

	public boolean isRptEstimatePendingByProdView()
	{
		return rptEstimatePendingByProdView;
	}

	public void setRptEstimatePendingByProdView(boolean rptEstimatePendingByProdView)
	{
		this.rptEstimatePendingByProdView = rptEstimatePendingByProdView;
	}

	public boolean isRptEstimatePendingByProdExport()
	{
		return rptEstimatePendingByProdExport;
	}

	public void setRptEstimatePendingByProdExport(boolean rptEstimatePendingByProdExport)
	{
		this.rptEstimatePendingByProdExport = rptEstimatePendingByProdExport;
	}

	public boolean isRptEstimatePendingByCustomerView()
	{
		return rptEstimatePendingByCustomerView;
	}

	public void setRptEstimatePendingByCustomerView(boolean rptEstimatePendingByCustomerView)
	{
		this.rptEstimatePendingByCustomerView = rptEstimatePendingByCustomerView;
	}

	public boolean isRptEstimatePendingByCustomerExport()
	{
		return rptEstimatePendingByCustomerExport;
	}

	public void setRptEstimatePendingByCustomerExport(boolean rptEstimatePendingByCustomerExport)
	{
		this.rptEstimatePendingByCustomerExport = rptEstimatePendingByCustomerExport;
	}

	public boolean isRptEstimatePendingByPendingProdView()
	{
		return rptEstimatePendingByPendingProdView;
	}

	public void setRptEstimatePendingByPendingProdView(boolean rptEstimatePendingByPendingProdView)
	{
		this.rptEstimatePendingByPendingProdView = rptEstimatePendingByPendingProdView;
	}

	public boolean isRptEstimatePendingByPendingProdExport()
	{
		return rptEstimatePendingByPendingProdExport;
	}

	public void setRptEstimatePendingByPendingProdExport(boolean rptEstimatePendingByPendingProdExport)
	{
		this.rptEstimatePendingByPendingProdExport = rptEstimatePendingByPendingProdExport;
	}

	public boolean isRptDueRcvablesByCustomerView()
	{
		return rptDueRcvablesByCustomerView;
	}

	public void setRptDueRcvablesByCustomerView(boolean rptDueRcvablesByCustomerView)
	{
		this.rptDueRcvablesByCustomerView = rptDueRcvablesByCustomerView;
	}

	public boolean isRptDueRcvablesByCustomerExport()
	{
		return rptDueRcvablesByCustomerExport;
	}

	public void setRptDueRcvablesByCustomerExport(boolean rptDueRcvablesByCustomerExport)
	{
		this.rptDueRcvablesByCustomerExport = rptDueRcvablesByCustomerExport;
	}

	public boolean isRptDueRcvablesBySalesView()
	{
		return rptDueRcvablesBySalesView;
	}

	public void setRptDueRcvablesBySalesView(boolean rptDueRcvablesBySalesView)
	{
		this.rptDueRcvablesBySalesView = rptDueRcvablesBySalesView;
	}

	public boolean isRptDueRcvablesBySalesExport()
	{
		return rptDueRcvablesBySalesExport;
	}

	public void setRptDueRcvablesBySalesExport(boolean rptDueRcvablesBySalesExport)
	{
		this.rptDueRcvablesBySalesExport = rptDueRcvablesBySalesExport;
	}

	public boolean isRptIoSummByProdCatView()
	{
		return rptIoSummByProdCatView;
	}

	public void setRptIoSummByProdCatView(boolean rptIoSummByProdCatView)
	{
		this.rptIoSummByProdCatView = rptIoSummByProdCatView;
	}

	public boolean isRptIoSummByProdCatExport()
	{
		return rptIoSummByProdCatExport;
	}

	public void setRptIoSummByProdCatExport(boolean rptIoSummByProdCatExport)
	{
		this.rptIoSummByProdCatExport = rptIoSummByProdCatExport;
	}

	public boolean isRptIoSummByMonthView()
	{
		return rptIoSummByMonthView;
	}

	public void setRptIoSummByMonthView(boolean rptIoSummByMonthView)
	{
		this.rptIoSummByMonthView = rptIoSummByMonthView;
	}

	public boolean isRptIoSummByMonthExport()
	{
		return rptIoSummByMonthExport;
	}

	public void setRptIoSummByMonthExport(boolean rptIoSummByMonthExport)
	{
		this.rptIoSummByMonthExport = rptIoSummByMonthExport;
	}

	public boolean isRptIoSummByProdView()
	{
		return rptIoSummByProdView;
	}

	public void setRptIoSummByProdView(boolean rptIoSummByProdView)
	{
		this.rptIoSummByProdView = rptIoSummByProdView;
	}

	public boolean isRptIoSummByProdExport()
	{
		return rptIoSummByProdExport;
	}

	public void setRptIoSummByProdExport(boolean rptIoSummByProdExport)
	{
		this.rptIoSummByProdExport = rptIoSummByProdExport;
	}

	public boolean isRptIoDetailed()
	{
		return rptIoDetailed;
	}

	public void setRptIoDetailed(boolean rptIoDetailed)
	{
		this.rptIoDetailed = rptIoDetailed;
	}

	public boolean isRptLedgerView()
	{
		return rptLedgerView;
	}

	public void setRptLedgerView(boolean rptLedgerView)
	{
		this.rptLedgerView = rptLedgerView;
	}

	public boolean isRptLedgerExport()
	{
		return rptLedgerExport;
	}

	public void setRptLedgerExport(boolean rptLedgerExport)
	{
		this.rptLedgerExport = rptLedgerExport;
	}

	public boolean isRptLedgerPrint()
	{
		return rptLedgerPrint;
	}

	public void setRptLedgerPrint(boolean rptLedgerPrint)
	{
		this.rptLedgerPrint = rptLedgerPrint;
	}

	public boolean isRptLedgerSend()
	{
		return rptLedgerSend;
	}

	public void setRptLedgerSend(boolean rptLedgerSend)
	{
		this.rptLedgerSend = rptLedgerSend;
	}

	public boolean isRptAcctSummView()
	{
		return rptAcctSummView;
	}

	public void setRptAcctSummView(boolean rptAcctSummView)
	{
		this.rptAcctSummView = rptAcctSummView;
	}

	public boolean isRptAcctSummExport()
	{
		return rptAcctSummExport;
	}

	public void setRptAcctSummExport(boolean rptAcctSummExport)
	{
		this.rptAcctSummExport = rptAcctSummExport;
	}

	public boolean isRptTrialBalView()
	{
		return rptTrialBalView;
	}

	public void setRptTrialBalView(boolean rptTrialBalView)
	{
		this.rptTrialBalView = rptTrialBalView;
	}

	public boolean isRptTrialBalExport()
	{
		return rptTrialBalExport;
	}

	public void setRptTrialBalExport(boolean rptTrialBalExport)
	{
		this.rptTrialBalExport = rptTrialBalExport;
	}

	public boolean isRptTrialBalPrint()
	{
		return rptTrialBalPrint;
	}

	public void setRptTrialBalPrint(boolean rptTrialBalPrint)
	{
		this.rptTrialBalPrint = rptTrialBalPrint;
	}

	public boolean isRptTradingAcctView()
	{
		return rptTradingAcctView;
	}

	public void setRptTradingAcctView(boolean rptTradingAcctView)
	{
		this.rptTradingAcctView = rptTradingAcctView;
	}

	public boolean isRptTradingAcctExport()
	{
		return rptTradingAcctExport;
	}

	public void setRptTradingAcctExport(boolean rptTradingAcctExport)
	{
		this.rptTradingAcctExport = rptTradingAcctExport;
	}

	public boolean isRptTradingAcctPrint()
	{
		return rptTradingAcctPrint;
	}

	public void setRptTradingAcctPrint(boolean rptTradingAcctPrint)
	{
		this.rptTradingAcctPrint = rptTradingAcctPrint;
	}

	public boolean isRptPlAcctView()
	{
		return rptPlAcctView;
	}

	public void setRptPlAcctView(boolean rptPlAcctView)
	{
		this.rptPlAcctView = rptPlAcctView;
	}

	public boolean isRptPlAcctExport()
	{
		return rptPlAcctExport;
	}

	public void setRptPlAcctExport(boolean rptPlAcctExport)
	{
		this.rptPlAcctExport = rptPlAcctExport;
	}

	public boolean isRptPlAcctPrint()
	{
		return rptPlAcctPrint;
	}

	public void setRptPlAcctPrint(boolean rptPlAcctPrint)
	{
		this.rptPlAcctPrint = rptPlAcctPrint;
	}

	public boolean isRptBalanceSheetView()
	{
		return rptBalanceSheetView;
	}

	public void setRptBalanceSheetView(boolean rptBalanceSheetView)
	{
		this.rptBalanceSheetView = rptBalanceSheetView;
	}

	public boolean isRptBalanceSheetExport()
	{
		return rptBalanceSheetExport;
	}

	public void setRptBalanceSheetExport(boolean rptBalanceSheetExport)
	{
		this.rptBalanceSheetExport = rptBalanceSheetExport;
	}

	public boolean isRptGstr3BView()
	{
		return rptGstr3BView;
	}

	public void setRptGstr3BView(boolean rptGstr3BView)
	{
		this.rptGstr3BView = rptGstr3BView;
	}

	public boolean isRptGstr3BExport()
	{
		return rptGstr3BExport;
	}

	public void setRptGstr3BExport(boolean rptGstr3BExport)
	{
		this.rptGstr3BExport = rptGstr3BExport;
	}

	public boolean isRptGstr3BPrint()
	{
		return rptGstr3BPrint;
	}

	public void setRptGstr3BPrint(boolean rptGstr3BPrint)
	{
		this.rptGstr3BPrint = rptGstr3BPrint;
	}

	public boolean isRptInventoryLedgerView()
	{
		return rptInventoryLedgerView;
	}

	public void setRptInventoryLedgerView(boolean rptInventoryLedgerView)
	{
		this.rptInventoryLedgerView = rptInventoryLedgerView;
	}

	public boolean isRptInventoryLedgerExport()
	{
		return rptInventoryLedgerExport;
	}

	public void setRptInventoryLedgerExport(boolean rptInventoryLedgerExport)
	{
		this.rptInventoryLedgerExport = rptInventoryLedgerExport;
	}

	public boolean isRptInventoryLedgerPrint()
	{
		return rptInventoryLedgerPrint;
	}

	public void setRptInventoryLedgerPrint(boolean rptInventoryLedgerPrint)
	{
		this.rptInventoryLedgerPrint = rptInventoryLedgerPrint;
	}

	public boolean isRptCurrentStockView()
	{
		return rptCurrentStockView;
	}

	public void setRptCurrentStockView(boolean rptCurrentStockView)
	{
		this.rptCurrentStockView = rptCurrentStockView;
	}

	public boolean isRptCurrentStockExport()
	{
		return rptCurrentStockExport;
	}

	public void setRptCurrentStockExport(boolean rptCurrentStockExport)
	{
		this.rptCurrentStockExport = rptCurrentStockExport;
	}

	public boolean isRptCurrentStockPrint()
	{
		return rptCurrentStockPrint;
	}

	public void setRptCurrentStockPrint(boolean rptCurrentStockPrint)
	{
		this.rptCurrentStockPrint = rptCurrentStockPrint;
	}

	public boolean isRptCurrentStockValView()
	{
		return rptCurrentStockValView;
	}

	public void setRptCurrentStockValView(boolean rptCurrentStockValView)
	{
		this.rptCurrentStockValView = rptCurrentStockValView;
	}

	public boolean isRptCurrentStockValExport()
	{
		return rptCurrentStockValExport;
	}

	public void setRptCurrentStockValExport(boolean rptCurrentStockValExport)
	{
		this.rptCurrentStockValExport = rptCurrentStockValExport;
	}

	public boolean isRptCurrentStockValPrint()
	{
		return rptCurrentStockValPrint;
	}

	public void setRptCurrentStockValPrint(boolean rptCurrentStockValPrint)
	{
		this.rptCurrentStockValPrint = rptCurrentStockValPrint;
	}

	public boolean isRptLowStockView()
	{
		return rptLowStockView;
	}

	public void setRptLowStockView(boolean rptLowStockView)
	{
		this.rptLowStockView = rptLowStockView;
	}

	public boolean isRptLowStockExport()
	{
		return rptLowStockExport;
	}

	public void setRptLowStockExport(boolean rptLowStockExport)
	{
		this.rptLowStockExport = rptLowStockExport;
	}

	public boolean isRptLowStockPrint()
	{
		return rptLowStockPrint;
	}

	public void setRptLowStockPrint(boolean rptLowStockPrint)
	{
		this.rptLowStockPrint = rptLowStockPrint;
	}

	public boolean isRptSalesAnalysisView()
	{
		return rptSalesAnalysisView;
	}

	public void setRptSalesAnalysisView(boolean rptSalesAnalysisView)
	{
		this.rptSalesAnalysisView = rptSalesAnalysisView;
	}

	public boolean isRptSalesAnalysisExport()
	{
		return rptSalesAnalysisExport;
	}

	public void setRptSalesAnalysisExport(boolean rptSalesAnalysisExport)
	{
		this.rptSalesAnalysisExport = rptSalesAnalysisExport;
	}

	public boolean isRptSalesAnalysisPrint()
	{
		return rptSalesAnalysisPrint;
	}

	public void setRptSalesAnalysisPrint(boolean rptSalesAnalysisPrint)
	{
		this.rptSalesAnalysisPrint = rptSalesAnalysisPrint;
	}

	public boolean isRptCdpVouLedgerView()
	{
		return rptCdpVouLedgerView;
	}

	public void setRptCdpVouLedgerView(boolean rptCdpVouLedgerView)
	{
		this.rptCdpVouLedgerView = rptCdpVouLedgerView;
	}

	public boolean isRptCdpVouLedgerExport()
	{
		return rptCdpVouLedgerExport;
	}

	public void setRptCdpVouLedgerExport(boolean rptCdpVouLedgerExport)
	{
		this.rptCdpVouLedgerExport = rptCdpVouLedgerExport;
	}

	public boolean isRptCdpVouLedgerPrint()
	{
		return rptCdpVouLedgerPrint;
	}

	public void setRptCdpVouLedgerPrint(boolean rptCdpVouLedgerPrint)
	{
		this.rptCdpVouLedgerPrint = rptCdpVouLedgerPrint;
	}

	public boolean isRptCommVouLedgerView()
	{
		return rptCommVouLedgerView;
	}

	public void setRptCommVouLedgerView(boolean rptCommVouLedgerView)
	{
		this.rptCommVouLedgerView = rptCommVouLedgerView;
	}

	public boolean isRptCommVouLedgerExport()
	{
		return rptCommVouLedgerExport;
	}

	public void setRptCommVouLedgerExport(boolean rptCommVouLedgerExport)
	{
		this.rptCommVouLedgerExport = rptCommVouLedgerExport;
	}

	public boolean isRptCommVouLedgerPrint()
	{
		return rptCommVouLedgerPrint;
	}

	public void setRptCommVouLedgerPrint(boolean rptCommVouLedgerPrint)
	{
		this.rptCommVouLedgerPrint = rptCommVouLedgerPrint;
	}

	public boolean isRptSalesOrderPendingView()
	{
		return rptSalesOrderPendingView;
	}

	public void setRptSalesOrderPendingView(boolean rptSalesOrderPendingView)
	{
		this.rptSalesOrderPendingView = rptSalesOrderPendingView;
	}

	public boolean isRptSalesOrderPendingExport()
	{
		return rptSalesOrderPendingExport;
	}

	public void setRptSalesOrderPendingExport(boolean rptSalesOrderPendingExport)
	{
		this.rptSalesOrderPendingExport = rptSalesOrderPendingExport;
	}

	public boolean isRptSalesOrderPendingPrint()
	{
		return rptSalesOrderPendingPrint;
	}

	public void setRptSalesOrderPendingPrint(boolean rptSalesOrderPendingPrint)
	{
		this.rptSalesOrderPendingPrint = rptSalesOrderPendingPrint;
	}

	public boolean isRptPurchaseOrderPendingView()
	{
		return rptPurchaseOrderPendingView;
	}

	public void setRptPurchaseOrderPendingView(boolean rptPurchaseOrderPendingView)
	{
		this.rptPurchaseOrderPendingView = rptPurchaseOrderPendingView;
	}

	public boolean isRptPurchaseOrderPendingExport()
	{
		return rptPurchaseOrderPendingExport;
	}

	public void setRptPurchaseOrderPendingExport(boolean rptPurchaseOrderPendingExport)
	{
		this.rptPurchaseOrderPendingExport = rptPurchaseOrderPendingExport;
	}

	public boolean isRptPurchaseOrderPendingPrint()
	{
		return rptPurchaseOrderPendingPrint;
	}

	public void setRptPurchaseOrderPendingPrint(boolean rptPurchaseOrderPendingPrint)
	{
		this.rptPurchaseOrderPendingPrint = rptPurchaseOrderPendingPrint;
	}

	public boolean getValueByEnum(Keys keys)
	{
		for (AccessRolePermModel accessRolePermModel : accessRolePermModels)
		{
			if (accessRolePermModel.getPermId() == keys.id)
			{
				return accessRolePermModel.isValue();
			}
		}
		return false;
	}

	public List<AccessRolePermModel> getAccessRolePermModels()
	{

		this.accessRolePermModels = new ArrayList<>();

		accessRolePermModels.add(new AccessRolePermModel(Keys.MENU_CONFIG.getId(), menuConfig));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMPANY_PROFILE_ADD.getId(), companyProfileAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMPANY_PROFILE_EDIT.getId(), companyProfileEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMPANY_PROFILE_DELETE.getId(), companyProfileDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMPANY_PROFILE_VIEW.getId(), companyProfileView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMPANY_PROFILE_EXPORT.getId(), companyProfileExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.STATE_ADD.getId(), stateAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.STATE_EDIT.getId(), stateEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.STATE_DELETE.getId(), stateDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.STATE_VIEW.getId(), stateView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.STATE_EXPORT.getId(), stateExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.VOU_OTH_CH_ADD.getId(), vouOthChAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.VOU_OTH_CH_EDIT.getId(), vouOthChEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.VOU_OTH_CH_DELETE.getId(), vouOthChDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.VOU_OTH_CH_VIEW.getId(), vouOthChView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.VOU_OTH_CH_EXPORT.getId(), vouOthChExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMPANY_INFO.getId(), companyInfo));
		accessRolePermModels.add(new AccessRolePermModel(Keys.BROWSER.getId(), browser));
		accessRolePermModels.add(new AccessRolePermModel(Keys.MSG_TEMPLATE_ADD.getId(), msgTemplateAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.MSG_TEMPLATE_EDIT.getId(), msgTemplateEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.MSG_TEMPLATE_DELETE.getId(), msgTemplateDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.MSG_TEMPLATE_VIEW.getId(), msgTemplateView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.MSG_TEMPLATE_EXPORT.getId(), msgTemplateExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TAX_ADD.getId(), taxAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TAX_EDIT.getId(), taxEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TAX_DELETE.getId(), taxDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TAX_VIEW.getId(), taxView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TAX_EXPORT.getId(), taxExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TAX_CAL_RATE_ADD.getId(), taxCalRateAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TAX_CAL_RATE_EDIT.getId(), taxCalRateEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TAX_CAL_RATE_DELETE.getId(), taxCalRateDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TAX_CAL_RATE_VIEW.getId(), taxCalRateView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TAX_CAL_RATE_EXPORT.getId(), taxCalRateExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TRANSPORTER_ADD.getId(), transporterAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TRANSPORTER_EDIT.getId(), transporterEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TRANSPORTER_DELETE.getId(), transporterDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TRANSPORTER_VIEW.getId(), transporterView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TRANSPORTER_EXPORT.getId(), transporterExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SCHEME_ADD.getId(), schemeAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SCHEME_EDIT.getId(), schemeEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SCHEME_DELETE.getId(), schemeDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SCHEME_VIEW.getId(), schemeView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SCHEME_EXPORT.getId(), schemeExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.UNIT_ADD.getId(), unitAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.UNIT_EDIT.getId(), unitEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.UNIT_DELETE.getId(), unitDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.UNIT_VIEW.getId(), unitView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.UNIT_EXPORT.getId(), unitExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PROD_OTH_CH_ADD.getId(), prodOthChAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PROD_OTH_CH_EDIT.getId(), prodOthChEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PROD_OTH_CH_DELETE.getId(), prodOthChDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PROD_OTH_CH_VIEW.getId(), prodOthChView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PROD_OTH_CH_EXPORT.getId(), prodOthChExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CAT_ADD.getId(), catAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CAT_EDIT.getId(), catEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CAT_DELETE.getId(), catDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CAT_VIEW.getId(), catView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CAT_EXPORT.getId(), catExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TAX_CAT_ADD.getId(), taxCategoryAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TAX_CAT_EDIT.getId(), taxCategoryEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TAX_CAT_DELETE.getId(), taxCategoryDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TAX_CAT_VIEW.getId(), taxCategoryView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TAX_CAT_IMPORT.getId(), taxCategoryImport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TAX_CAT_EXPORT.getId(), taxCategoryExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PROD_ADD.getId(), prodAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PROD_EDIT.getId(), prodEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PROD_DELETE.getId(), prodDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PROD_VIEW.getId(), prodView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PROD_IMPORT.getId(), prodImport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PROD_EXPORT.getId(), prodExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PROD_PRINT_BARCODE.getId(), prodPrintBarcode));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SERVICE_ADD.getId(), serviceAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SERVICE_EDIT.getId(), serviceEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SERVICE_DELETE.getId(), serviceDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SERVICE_VIEW.getId(), serviceView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SERVICE_EXPORT.getId(), serviceExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PRICE_LIST_ADD.getId(), priceListAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PRICE_LIST_EDIT.getId(), priceListEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PRICE_LIST_DELETE.getId(), priceListDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PRICE_LIST_VIEW.getId(), priceListView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PRICE_LIST_IMPORT.getId(), priceListImport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PRICE_LIST_EXPORT.getId(), priceListExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMM_LIST_ADD.getId(), commListAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMM_LIST_EDIT.getId(), commListEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMM_LIST_DELETE.getId(), commListDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMM_LIST_VIEW.getId(), commListView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMM_LIST_IMPORT.getId(), commListImport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMM_LIST_EXPORT.getId(), commListExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.INV_ADJUST_ADD.getId(), invAdjustAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.INV_ADJUST_EDIT.getId(), invAdjustEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.INV_ADJUST_DELETE.getId(), invAdjustDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.INV_ADJUST_VIEW.getId(), invAdjustView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.INV_ADJUST_EXPORT.getId(), invAdjustExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.LEAD_ADD.getId(), leadAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.LEAD_EDIT.getId(), leadEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.LEAD_DELETE.getId(), leadDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.LEAD_VIEW.getId(), leadView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.LEAD_IMPORT.getId(), leadImport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.LEAD_EXPORT.getId(), leadExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCT_TYPE_ADD.getId(), acctTypeAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCT_TYPE_EDIT.getId(), acctTypeEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCT_TYPE_DELETE.getId(), acctTypeDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCT_TYPE_VIEW.getId(), acctTypeView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCT_TYPE_IMPORT.getId(), acctTypeImport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCT_TYPE_EXPORT.getId(), acctTypeExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCT_ADD.getId(), acctAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCT_EDIT.getId(), acctEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCT_DELETE.getId(), acctDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCT_VIEW.getId(), acctView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCT_IMPORT.getId(), acctImport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCT_EXPORT.getId(), acctExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.AGENT_ADD.getId(), agentAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.AGENT_EDIT.getId(), agentEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.AGENT_DELETE.getId(), agentDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.AGENT_VIEW.getId(), agentView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.AGENT_EXPORT.getId(), agentExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SUPPLIER_ADD.getId(), supplierAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SUPPLIER_EDIT.getId(), supplierEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SUPPLIER_DELETE.getId(), supplierDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SUPPLIER_VIEW.getId(), supplierView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SUPPLIER_EXPORT.getId(), supplierExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SUPPLIER_PRINT_ENVELOPE.getId(), supplierPrintEnvelope));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SUPPLIER_PRINT_LEDGER.getId(), supplierPrintLedger));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CUSTOMER_ADD.getId(), customerAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CUSTOMER_EDIT.getId(), customerEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CUSTOMER_DELETE.getId(), customerDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CUSTOMER_VIEW.getId(), customerView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CUSTOMER_EXPORT.getId(), customerExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CUSTOMER_PRINT_ENVELOPE.getId(), customerPrintEnvelope));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CUSTOMER_PRINT_LEDGER.getId(), customerPrintLedger));
		accessRolePermModels.add(new AccessRolePermModel(Keys.BANK_ADD.getId(), bankAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.BANK_EDIT.getId(), bankEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.BANK_DELETE.getId(), bankDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.BANK_VIEW.getId(), bankView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.BANK_EXPORT.getId(), bankExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ORDER_ADJUST_ADD.getId(), orderAdjustAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ORDER_ADJUST_EDIT.getId(), orderAdjustEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ORDER_ADJUST_DELETE.getId(), orderAdjustDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ORDER_ADJUST_VIEW_OWN.getId(), orderAdjustViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ORDER_ADJUST_VIEW_ALL.getId(), orderAdjustViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ORDER_ADJUST_EXPORT.getId(), orderAdjustExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ORDER_ADJUST_SEND.getId(), orderAdjustSend));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CDP_VOU_ADD.getId(), cdpVouAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CDP_VOU_EDIT.getId(), cdpVouEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CDP_VOU_DELETE.getId(), cdpVouDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CDP_VOU_VIEW_OWN.getId(), cdpVouViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CDP_VOU_VIEW_ALL.getId(), cdpVouViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CDP_VOU_EXPORT.getId(), cdpVouExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CDP_VOU_SEND.getId(), cdpVouSend));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CDP_JOURNAL_VOU_ADD.getId(), cdpJournalVouAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CDP_JOURNAL_VOU_EDIT.getId(), cdpJournalVouEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CDP_JOURNAL_VOU_DELETE.getId(), cdpJournalVouDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CDP_JOURNAL_VOU_VIEW_OWN.getId(), cdpJournalVouViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CDP_JOURNAL_VOU_VIEW_ALL.getId(), cdpJournalVouViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CDP_JOURNAL_VOU_EXPORT.getId(), cdpJournalVouExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CDP_JOURNAL_VOU_PRINT.getId(), cdpJournalVouPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CDP_JOURNAL_VOU_SEND.getId(), cdpJournalVouSend));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMM_VOU_ADD.getId(), commVouAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMM_VOU_EDIT.getId(), commVouEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMM_VOU_DELETE.getId(), commVouDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMM_VOU_VIEW_OWN.getId(), commVouViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMM_VOU_VIEW_ALL.getId(), commVouViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMM_VOU_EXPORT.getId(), commVouExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMM_VOU_PRINT.getId(), commVouPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMM_VOU_SEND.getId(), commVouSend));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_ORDER_ADD.getId(), purchaseOrderAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_ORDER_EDIT.getId(), purchaseOrderEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_ORDER_DELETE.getId(), purchaseOrderDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_ORDER_VIEW_OWN.getId(), purchaseOrderViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_ORDER_VIEW_ALL.getId(), purchaseOrderViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_ORDER_EXPORT.getId(), purchaseOrderExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_ORDER_PRINT.getId(), purchaseOrderPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_ORDER_PRINT_LIST.getId(), purchaseOrderPrintList));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_ORDER_SEND.getId(), purchaseOrderSend));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ESTIMATE_ADD.getId(), estimateAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ESTIMATE_EDIT.getId(), estimateEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ESTIMATE_DELETE.getId(), estimateDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ESTIMATE_VIEW_OWN.getId(), estimateViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ESTIMATE_VIEW_ALL.getId(), estimateViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ESTIMATE_EXPORT.getId(), estimateExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ESTIMATE_PRINT.getId(), estimatePrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ESTIMATE_PRINT_LIST.getId(), estimatePrintList));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ESTIMATE_SEND.getId(), estimateSend));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_ORDER_ADD.getId(), salesOrderAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_ORDER_EDIT.getId(), salesOrderEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_ORDER_DELETE.getId(), salesOrderDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_ORDER_VIEW_OWN.getId(), salesOrderViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_ORDER_VIEW_ALL.getId(), salesOrderViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_ORDER_EXPORT.getId(), salesOrderExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_ORDER_PRINT.getId(), salesOrderPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_ORDER_PRINT_LIST.getId(), salesOrderPrintList));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_ORDER_SEND.getId(), salesOrderSend));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PI_ADD.getId(), piAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PI_EDIT.getId(), piEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PI_DELETE.getId(), piDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PI_VIEW_OWN.getId(), piViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PI_VIEW_ALL.getId(), piViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PI_EXPORT.getId(), piExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PI_PRINT.getId(), piPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PI_PRINT_CHALLAN.getId(), piPrintChallan));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PI_PRINT_LIST.getId(), piPrintList));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PI_SEND.getId(), piSend));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_RETURN_ADD.getId(), purchaseReturnAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_RETURN_EDIT.getId(), purchaseReturnEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_RETURN_DELETE.getId(), purchaseReturnDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_RETURN_VIEW_OWN.getId(), purchaseReturnViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_RETURN_VIEW_ALL.getId(), purchaseReturnViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_RETURN_EXPORT.getId(), purchaseReturnExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_RETURN_PRINT.getId(), purchaseReturnPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_RETURN_PRINT_CHALLAN.getId(), purchaseReturnPrintChallan));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_RETURN_PRINT_LIST.getId(), purchaseReturnPrintList));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_RETURN_SEND.getId(), purchaseReturnSend));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_ADD.getId(), purchaseAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_EDIT.getId(), purchaseEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_DELETE.getId(), purchaseDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_VIEW_OWN.getId(), purchaseViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_VIEW_ALL.getId(), purchaseViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_EXPORT.getId(), purchaseExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_PRINT.getId(), purchasePrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_PRINT_LIST.getId(), purchasePrintList));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_PRINT_BARCODE.getId(), purchasePrintBarcode));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PURCHASE_SEND.getId(), purchaseSend));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_RETURN_ADD.getId(), salesReturnAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_RETURN_EDIT.getId(), salesReturnEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_RETURN_DELETE.getId(), salesReturnDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_RETURN_VIEW_OWN.getId(), salesReturnViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_RETURN_VIEW_ALL.getId(), salesReturnViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_RETURN_EXPORT.getId(), salesReturnExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_RETURN_PRINT.getId(), salesReturnPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_RETURN_PRINT_BARCODE.getId(), salesReturnPrintBarcode));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_RETURN_PRINT_LIST.getId(), salesReturnPrintList));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_RETURN_SEND.getId(), salesReturnSend));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_ADD.getId(), salesAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_EDIT.getId(), salesEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_DELETE.getId(), salesDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_VIEW_OWN.getId(), salesViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_VIEW_ALL.getId(), salesViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_EXPORT.getId(), salesExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_PRINT.getId(), salesPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_PRINT_CHALLAN.getId(), salesPrintChallan));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_PRINT_LIST.getId(), salesPrintList));
		accessRolePermModels.add(new AccessRolePermModel(Keys.SALES_SEND.getId(), salesSend));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PAYMENT_ADD.getId(), paymentAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PAYMENT_EDIT.getId(), paymentEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PAYMENT_DELETE.getId(), paymentDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PAYMENT_VIEW_OWN.getId(), paymentViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PAYMENT_VIEW_ALL.getId(), paymentViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PAYMENT_EXPORT.getId(), paymentExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PAYMENT_PRINT.getId(), paymentPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.PAYMENT_SEND.getId(), paymentSend));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RECEIPT_ADD.getId(), receiptAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RECEIPT_EDIT.getId(), receiptEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RECEIPT_DELETE.getId(), receiptDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RECEIPT_VIEW_OWN.getId(), receiptViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RECEIPT_VIEW_ALL.getId(), receiptViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RECEIPT_EXPORT.getId(), receiptExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RECEIPT_PRINT.getId(), receiptPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RECEIPT_SEND.getId(), receiptSend));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CONTRA_ADD.getId(), contraAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CONTRA_EDIT.getId(), contraEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CONTRA_DELETE.getId(), contraDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CONTRA_VIEW_OWN.getId(), contraViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CONTRA_VIEW_ALL.getId(), contraViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CONTRA_EXPORT.getId(), contraExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CONTRA_PRINT.getId(), contraPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.CONTRA_SEND.getId(), contraSend));
		accessRolePermModels.add(new AccessRolePermModel(Keys.JOURNAL_ADD.getId(), journalAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.JOURNAL_EDIT.getId(), journalEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.JOURNAL_DELETE.getId(), journalDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.JOURNAL_VIEW_OWN.getId(), journalViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.JOURNAL_VIEW_ALL.getId(), journalViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.JOURNAL_EXPORT.getId(), journalExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.JOURNAL_PRINT.getId(), journalPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.JOURNAL_SEND.getId(), journalSend));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TASK_ADD.getId(), taskAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TASK_EDIT.getId(), taskEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TASK_DELETE.getId(), taskDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TASK_VIEW_OWN.getId(), taskViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TASK_VIEW_ALL.getId(), taskViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.TASK_EXPORT.getId(), taskExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCT_BOOK_OPEN.getId(), acctBookOpen));
		accessRolePermModels.add(new AccessRolePermModel(Keys.OPEN_SYSTEM_SETTINGS.getId(), openSystemSettings));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCESS_ROLE_ADD.getId(), accessRoleAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCESS_ROLE_EDIT.getId(), accessRoleEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCESS_ROLE_DELETE.getId(), accessRoleDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCESS_ROLE_VIEW.getId(), accessRoleView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.ACCESS_ROLE_EXPORT.getId(), accessRoleExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.USER_ADD.getId(), userAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.USER_EDIT.getId(), userEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.USER_DELETE.getId(), userDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.USER_VIEW.getId(), userView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.USER_EXPORT.getId(), userExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.OPEN_COMPANY_MANAGEMENT.getId(), openCompanyManagement));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMPANY_ADD.getId(), companyAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMPANY_EDIT.getId(), companyEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.COMPANY_DELETE.getId(), companyDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.FIN_YEAR_ADD.getId(), finYearAdd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.FIN_YEAR_EDIT.getId(), finYearEdit));
		accessRolePermModels.add(new AccessRolePermModel(Keys.FIN_YEAR_DELETE.getId(), finYearDelete));
		accessRolePermModels.add(new AccessRolePermModel(Keys.FIN_YEAR_OPEN.getId(), finYearOpen));
		accessRolePermModels.add(new AccessRolePermModel(Keys.FIN_YEAR_CHANGE_DEFAULT.getId(), finYearChangeDefault));
		accessRolePermModels.add(new AccessRolePermModel(Keys.BACKUP.getId(), backup));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RESTORE.getId(), restore));
		accessRolePermModels.add(new AccessRolePermModel(Keys.IMPORT_UD.getId(), importUd));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_DAY_BOOK_VIEW_OWN.getId(), rptDayBookViewOwn));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_DAY_BOOK_VIEW_ALL.getId(), rptDayBookViewAll));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_DAY_BOOK_EXPORT.getId(), rptDayBookExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_DAY_BOOK_PRINT.getId(), rptDayBookPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_RETURN_BY_MONTH_VIEW.getId(), rptSalesReturnByMonthView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_RETURN_BY_MONTH_EXPORT.getId(), rptSalesReturnByMonthExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_RETURN_BY_DAY_VIEW.getId(), rptSalesReturnByDayView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_RETURN_BY_DAY_EXPORT.getId(), rptSalesReturnByDayExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_RETURN_BY_CUSTOMER_VIEW.getId(), rptSalesReturnByCustomerView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_RETURN_BY_CUSTOMER_EXPORT.getId(), rptSalesReturnByCustomerExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_RETURN_BY_PROD_CAT_VIEW.getId(), rptSalesReturnByProdCatView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_RETURN_BY_PROD_CAT_EXPORT.getId(), rptSalesReturnByProdCatExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_RETURN_BY_PROD_VIEW.getId(), rptSalesReturnByProdView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_RETURN_BY_PROD_EXPORT.getId(), rptSalesReturnByProdExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_RETURN_BY_CITY_VIEW.getId(), rptSalesReturnByCityView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_RETURN_BY_CITY_EXPORT.getId(), rptSalesReturnByCityExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_RETURN_BY_STATE_VIEW.getId(), rptSalesReturnByStateView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_RETURN_BY_STATE_EXPORT.getId(), rptSalesReturnByStateExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_RETURN_BY_AGENT_VIEW.getId(), rptSalesReturnByAgentView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_RETURN_BY_AGENT_EXPORT.getId(), rptSalesReturnByAgentExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_BY_MONTH_VIEW.getId(), rptSalesByMonthView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_BY_MONTH_EXPORT.getId(), rptSalesByMonthExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_BY_DAY_VIEW.getId(), rptSalesByDayView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_BY_DAY_EXPORT.getId(), rptSalesByDayExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_BY_CUSTOMER_VIEW.getId(), rptSalesByCustomerView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_BY_CUSTOMER_EXPORT.getId(), rptSalesByCustomerExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_BY_PROD_CAT_VIEW.getId(), rptSalesByProdCatView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_BY_PROD_CAT_EXPORT.getId(), rptSalesByProdCatExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_BY_PROD_VIEW.getId(), rptSalesByProdView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_BY_PROD_EXPORT.getId(), rptSalesByProdExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_BY_CITY_VIEW.getId(), rptSalesByCityView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_BY_CITY_EXPORT.getId(), rptSalesByCityExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_BY_STATE_VIEW.getId(), rptSalesByStateView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_BY_STATE_EXPORT.getId(), rptSalesByStateExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_BY_AGENT_VIEW.getId(), rptSalesByAgentView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_BY_AGENT_EXPORT.getId(), rptSalesByAgentExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_PROFIT_BY_CUSTOMER_VIEW.getId(), rptSalesProfitByCustomerView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_PROFIT_BY_CUSTOMER_EXPORT.getId(), rptSalesProfitByCustomerExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_PROFIT_BY_PROD_VIEW.getId(), rptSalesProfitByProdView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_PROFIT_BY_PROD_EXPORT.getId(), rptSalesProfitByProdExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_PROFIT_BY_SALES_VOU_VIEW.getId(), rptSalesProfitBySalesVouView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_PROFIT_BY_SALES_VOU_EXPORT.getId(), rptSalesProfitBySalesVouExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_PROFIT_BY_SALES_ITEM_VIEW.getId(), rptSalesProfitBySalesItemView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_PROFIT_BY_SALES_ITEM_EXPORT.getId(), rptSalesProfitBySalesItemExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_RETURN_BY_MONTH_VIEW.getId(), rptPurchaseReturnByMonthView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_RETURN_BY_MONTH_EXPORT.getId(), rptPurchaseReturnByMonthExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_RETURN_BY_DAY_VIEW.getId(), rptPurchaseReturnByDayView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_RETURN_BY_DAY_EXPORT.getId(), rptPurchaseReturnByDayExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_RETURN_BY_SUPPLIER_VIEW.getId(), rptPurchaseReturnBySupplierView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_RETURN_BY_SUPPLIER_EXPORT.getId(), rptPurchaseReturnBySupplierExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_RETURN_BY_PROD_CAT_VIEW.getId(), rptPurchaseReturnByProdCatView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_RETURN_BY_PROD_CAT_EXPORT.getId(), rptPurchaseReturnByProdCatExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_RETURN_BY_PROD_VIEW.getId(), rptPurchaseReturnByProdView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_RETURN_BY_PROD_EXPORT.getId(), rptPurchaseReturnByProdExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_RETURN_BY_CITY_VIEW.getId(), rptPurchaseReturnByCityView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_RETURN_BY_CITY_EXPORT.getId(), rptPurchaseReturnByCityExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_RETURN_BY_STATE_VIEW.getId(), rptPurchaseReturnByStateView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_RETURN_BY_STATE_EXPORT.getId(), rptPurchaseReturnByStateExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_BY_MONTH_VIEW.getId(), rptPurchaseByMonthView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_BY_MONTH_EXPORT.getId(), rptPurchaseByMonthExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_BY_DAY_VIEW.getId(), rptPurchaseByDayView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_BY_DAY_EXPORT.getId(), rptPurchaseByDayExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_BY_SUPPLIER_VIEW.getId(), rptPurchaseBySupplierView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_BY_SUPPLIER_EXPORT.getId(), rptPurchaseBySupplierExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_BY_PROD_CAT_VIEW.getId(), rptPurchaseByProdCatView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_BY_PROD_CAT_EXPORT.getId(), rptPurchaseByProdCatExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_BY_PROD_VIEW.getId(), rptPurchaseByProdView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_BY_PROD_EXPORT.getId(), rptPurchaseByProdExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_BY_CITY_VIEW.getId(), rptPurchaseByCityView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_BY_CITY_EXPORT.getId(), rptPurchaseByCityExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_BY_STATE_VIEW.getId(), rptPurchaseByStateView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_BY_STATE_EXPORT.getId(), rptPurchaseByStateExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_ESTIMATE_PENDING_BY_PROD_VIEW.getId(), rptEstimatePendingByProdView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_ESTIMATE_PENDING_BY_PROD_EXPORT.getId(), rptEstimatePendingByProdExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_ESTIMATE_PENDING_BY_CUSTOMER_VIEW.getId(), rptEstimatePendingByCustomerView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_ESTIMATE_PENDING_BY_CUSTOMER_EXPORT.getId(), rptEstimatePendingByCustomerExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_ESTIMATE_PENDING_BY_PENDING_PROD_VIEW.getId(), rptEstimatePendingByPendingProdView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_ESTIMATE_PENDING_BY_PENDING_PROD_EXPORT.getId(), rptEstimatePendingByPendingProdExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_DUE_RCVABLES_BY_CUSTOMER_VIEW.getId(), rptDueRcvablesByCustomerView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_DUE_RCVABLES_BY_CUSTOMER_EXPORT.getId(), rptDueRcvablesByCustomerExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_DUE_RCVABLES_BY_SALES_VIEW.getId(), rptDueRcvablesBySalesView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_DUE_RCVABLES_BY_SALES_EXPORT.getId(), rptDueRcvablesBySalesExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_IO_SUMM_BY_PROD_CAT_VIEW.getId(), rptIoSummByProdCatView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_IO_SUMM_BY_PROD_CAT_EXPORT.getId(), rptIoSummByProdCatExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_IO_SUMM_BY_MONTH_VIEW.getId(), rptIoSummByMonthView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_IO_SUMM_BY_MONTH_EXPORT.getId(), rptIoSummByMonthExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_IO_SUMM_BY_PROD_VIEW.getId(), rptIoSummByProdView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_IO_SUMM_BY_PROD_EXPORT.getId(), rptIoSummByProdExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_IO_DETAILED.getId(), rptIoDetailed));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_LEDGER_VIEW.getId(), rptLedgerView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_LEDGER_EXPORT.getId(), rptLedgerExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_LEDGER_PRINT.getId(), rptLedgerPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_LEDGER_SEND.getId(), rptLedgerSend));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_ACCT_SUMM_VIEW.getId(), rptAcctSummView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_ACCT_SUMM_EXPORT.getId(), rptAcctSummExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_TRIAL_BAL_VIEW.getId(), rptTrialBalView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_TRIAL_BAL_EXPORT.getId(), rptTrialBalExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_TRIAL_BAL_PRINT.getId(), rptTrialBalPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_TRADING_ACCT_VIEW.getId(), rptTradingAcctView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_TRADING_ACCT_EXPORT.getId(), rptTradingAcctExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_TRADING_ACCT_PRINT.getId(), rptTradingAcctPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PL_ACCT_VIEW.getId(), rptPlAcctView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PL_ACCT_EXPORT.getId(), rptPlAcctExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PL_ACCT_PRINT.getId(), rptPlAcctPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_BALANCE_SHEET_VIEW.getId(), rptBalanceSheetView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_BALANCE_SHEET_EXPORT.getId(), rptBalanceSheetExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_GSTR3B_VIEW.getId(), rptGstr3BView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_GSTR3B_EXPORT.getId(), rptGstr3BExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_GSTR3B_PRINT.getId(), rptGstr3BPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_INVENTORY_LEDGER_VIEW.getId(), rptInventoryLedgerView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_INVENTORY_LEDGER_EXPORT.getId(), rptInventoryLedgerExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_INVENTORY_LEDGER_PRINT.getId(), rptInventoryLedgerPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_CURRENT_STOCK_VIEW.getId(), rptCurrentStockView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_CURRENT_STOCK_EXPORT.getId(), rptCurrentStockExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_CURRENT_STOCK_PRINT.getId(), rptCurrentStockPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_CURRENT_STOCK_VAL_VIEW.getId(), rptCurrentStockValView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_CURRENT_STOCK_VAL_EXPORT.getId(), rptCurrentStockValExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_CURRENT_STOCK_VAL_PRINT.getId(), rptCurrentStockValPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_LOW_STOCK_VIEW.getId(), rptLowStockView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_LOW_STOCK_EXPORT.getId(), rptLowStockExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_LOW_STOCK_PRINT.getId(), rptLowStockPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_ANALYSIS_VIEW.getId(), rptSalesAnalysisView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_ANALYSIS_EXPORT.getId(), rptSalesAnalysisExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_ANALYSIS_PRINT.getId(), rptSalesAnalysisPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_CDP_VOU_LEDGER_VIEW.getId(), rptCdpVouLedgerView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_CDP_VOU_LEDGER_EXPORT.getId(), rptCdpVouLedgerExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_CDP_VOU_LEDGER_PRINT.getId(), rptCdpVouLedgerPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_COMM_VOU_LEDGER_VIEW.getId(), rptCommVouLedgerView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_COMM_VOU_LEDGER_EXPORT.getId(), rptCommVouLedgerExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_COMM_VOU_LEDGER_PRINT.getId(), rptCommVouLedgerPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_ORDER_PENDING_VIEW.getId(), rptSalesOrderPendingView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_ORDER_PENDING_EXPORT.getId(), rptSalesOrderPendingExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_SALES_ORDER_PENDING_PRINT.getId(), rptSalesOrderPendingPrint));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_ORDER_PENDING_VIEW.getId(), rptPurchaseOrderPendingView));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_ORDER_PENDING_EXPORT.getId(), rptPurchaseOrderPendingExport));
		accessRolePermModels.add(new AccessRolePermModel(Keys.RPT_PURCHASE_ORDER_PENDING_PRINT.getId(), rptPurchaseOrderPendingPrint));

		return accessRolePermModels;
	}

}
