package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dao.gen.ConfigDao;
import com.hemsw.asasaapi.veenal.dto.hdto.ConfigHdto;
import com.hemsw.asasaapi.veenal.enums.BarcodeContainsType;
import com.hemsw.asasaapi.veenal.enums.DeductRawMaterialBy;
import com.hemsw.asasaapi.veenal.enums.DiscOn;
import com.hemsw.asasaapi.veenal.enums.InvoiceNoSeqType;
import com.hemsw.asasaapi.veenal.enums.MfgBusType;
import com.hemsw.asasaapi.veenal.enums.MfgMode;
import com.hemsw.asasaapi.veenal.enums.PrintPageFormat;
import com.hemsw.asasaapi.veenal.enums.ProductCodeGenType;
import com.hemsw.asasaapi.veenal.enums.RateType;
import com.hemsw.asasaapi.veenal.enums.WorkRateDependsOn;
import com.hemsw.asasaapi.veenal.model.gen.ConfigModel;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigSer
{

	private enum Keys
	{
		NegativeStockAllowed("negative_stock_allowed"),
		IsHosieryBus("is_hosiery_bus"),
		IS_PROC_BUS("is_proc_bus"),
		IsMfgBus("is_mfg_bus"),
		IsEstimateQtyUsingQtyPerUnit("is_mfg_bus.is_estimate_qty_using_qty_per_unit"),
		HasColorGroups("is_mfg_bus.has_color_groups"),
		MFG_MODE("is_mfg_bus.mfg_mode"),
		WORK_RATE_DEPENDS_ON("is_mfg_bus.work_rate_depends_on"),
		DEDUCT_RAW_MATERIAL_BY("is_mfg_bus.deduct_raw_material_by"),
		CUSTOMER_WISE_SALES_RATE("customer_wise_sales_rate"),
		SALES_INVOICE_NO_SEQ_TYPE_ID("sales.invoice_no_seq_type_id"),
		DISC_ON("disc_on"),
		DEFAULT_DISC_RATE_TYPE_ID("default_disc_rate_type_id"),
		IS_ADD_TAX("is_add_tax"),
		IS_BLANK_HEADER_IN_TX("is_blank_header_in_tx"),
		DEFAULT_PRINT_PAGE_FORMAT_ID("default_print_page_format_id"),
		IS_REMOVE_FOOTER_IN_INVOICE_PRINT("is_remove_footer_in_invoice_print"),
		YEAR_CODE("year_code"),
		IS_PRINT_BARCODE_ON_SAVE("is_print_barcode_on_save"),
		IS_BARCODE_SYSTEM("is_barcode_system"),
		IS_SALES_RATE_WITH_PURCHASE_AND_OS("is_sales_rate_with_purchase_and_os"),
		PRINT_AMT_FACTOR("print_amt_factor"),
		MFG_BUS_TYPE("is_mfg_bus.bus_type"),
		IS_DERIVED_UNIT_SYTEM("is_derived_unit_system"),
		BARCODE_CONTAINS_TYPE("is_barcode_system.barcode_contains_type_id"),
		PRODUCT_CODE_GEN_TYPE("is_barcode_system.product_code_gen_type_id"),
		AVG_SALES_DAYS("avg_sales_days"),;

		private final String name;

		private Keys(String s)
		{
			name = s;
		}

		public boolean equalsName(String otherName)
		{
			// (otherName == null) check is not needed because name.equals(null) returns false 
			return name.equals(otherName);
		}

		public String getName()
		{
			return name;
		}

		public String toString()
		{
			return this.name;
		}
	}
	
	@Autowired
	ConfigDao configDao;

	public ConfigHdto get()
	{
		ConfigHdto data = null;
		List<ConfigModel> configModels = configDao.get();
		data = new ConfigHdto();

		for (ConfigModel configDto : configModels)
		{
			if (configDto.getKey().equals(Keys.NegativeStockAllowed.getName()))
			{
				data.setIsNegativeStockAllowed(configDto.getValue().equals("1"));
			}
			else if (configDto.getKey().equals(Keys.IsHosieryBus.getName()))
			{
				data.setIsHosieryBusiness(configDto.getValue().equals("1"));
			}
			else if (configDto.getKey().equals(Keys.IS_PROC_BUS.getName()))
			{
				data.setIsProcBus(configDto.getValue().equals("1"));
			}
			else if (configDto.getKey().equals(Keys.IsMfgBus.getName()))
			{
				data.setIsMfgBus(configDto.getValue().equals("1"));
			}
			else if (configDto.getKey().equals(Keys.IsEstimateQtyUsingQtyPerUnit.getName()))
			{
				data.setIsEstimateQtyUsingQtyPerUnit(configDto.getValue().equals("1"));
			}
			else if (configDto.getKey().equals(Keys.HasColorGroups.getName()))
			{
				data.setHasColorGroups(configDto.getValue().equals("1"));
			}
			else if (configDto.getKey().equals(Keys.MFG_MODE.getName()))
			{

				for (MfgMode value : MfgMode.values())
				{
					if (configDto.getValue().equals(String.valueOf(value.getId())))
					{
						data.setMfgMode(value);
					}
				}

			}
			else if (configDto.getKey().equals(Keys.WORK_RATE_DEPENDS_ON.getName()))
			{
				for (WorkRateDependsOn value : WorkRateDependsOn.values())
				{
					if (configDto.getValue().equals(String.valueOf(value.getId())))
					{
						data.setWorkRateDependsOn(value);
					}
				}
			}
			else if (configDto.getKey().equals(Keys.DEDUCT_RAW_MATERIAL_BY.getName()))
			{

				for (DeductRawMaterialBy value : DeductRawMaterialBy.values())
				{
					if (configDto.getValue().equals(String.valueOf(value.getId())))
					{
						data.setDeductRawMaterialBy(value);
					}

				}

			}
			else if (configDto.getKey().equals(Keys.CUSTOMER_WISE_SALES_RATE.getName()))
			{
				data.setIsCustomerWiseSalesRate(configDto.getValue().equals("1"));

			}
			else if (configDto.getKey().equals(Keys.SALES_INVOICE_NO_SEQ_TYPE_ID.getName()))
			{
				for (InvoiceNoSeqType value : InvoiceNoSeqType.values())
				{
					if (configDto.getValue().equals(String.valueOf(value.getId())))
					{
						data.setSalesInvoiceNoSeqType(value);
					}
				}
			}
			else if (configDto.getKey().equals(Keys.DISC_ON.getName()))
			{
				for (DiscOn value : DiscOn.values())
				{
					if (configDto.getValue().equals(String.valueOf(value.getId())))
					{
						data.setDiscOn(value);
					}
				}
			}
			else if (configDto.getKey().equals(Keys.DEFAULT_DISC_RATE_TYPE_ID.getName()))
			{
				for (RateType value : RateType.values())
				{
					if (configDto.getValue().equals(String.valueOf(value.getId())))
					{
						data.setDefaultDiscRateType(value);
					}
				}
			}
			else if (configDto.getKey().equals(Keys.IS_ADD_TAX.getName()))
			{
				data.setIsAddTax(configDto.getValue().equals("1"));
			}
			else if (configDto.getKey().equals(Keys.IS_BLANK_HEADER_IN_TX.getName()))
			{
				data.setIsBlankHeaderInTx(configDto.getValue().equals("1"));
			}
			else if (configDto.getKey().equals(Keys.DEFAULT_PRINT_PAGE_FORMAT_ID.getName()))
			{

				for (PrintPageFormat value : PrintPageFormat.values())
				{
					if (configDto.getValue().equals(String.valueOf(value.getId())))
					{
						data.setDefaultPrintPageFormat(value);
					}
				}
			}
			else if (configDto.getKey().equals(Keys.IS_REMOVE_FOOTER_IN_INVOICE_PRINT.getName()))
			{
				data.setIsRemoveFooterInInvoicePrint(configDto.getValue().equals("1"));

			}
			else if (configDto.getKey().equals(Keys.YEAR_CODE.getName()))
			{
				data.setYearCode(Integer.parseInt(configDto.getValue()));

			}
			else if (configDto.getKey().equals(Keys.IS_PRINT_BARCODE_ON_SAVE.getName()))
			{
				data.setIsPrintBarcodeOnSave(configDto.getValue().equals("1"));
			}
			else if (configDto.getKey().equals(Keys.IS_BARCODE_SYSTEM.getName()))
			{
				data.setIsBarcodeSystem(configDto.getValue().equals("1"));
			}
			else if (configDto.getKey().equals(Keys.IS_SALES_RATE_WITH_PURCHASE_AND_OS.getName()))
			{
				data.setIsSalesRateWithPurchaseAndOs(configDto.getValue().equals("1"));
			}
			else if (configDto.getKey().equals(Keys.PRINT_AMT_FACTOR.getName()))
			{
				data.setPrintAmtFactor(BigDecimal.valueOf(Double.parseDouble(configDto.getValue())));

			}
			else if (configDto.getKey().equals(Keys.MFG_BUS_TYPE.getName()))
			{
				for (MfgBusType value : MfgBusType.values())
				{
					if (configDto.getValue().equals(String.valueOf(value.getId())))
					{
						data.setMfgBusType(value);
					}
				}
			}
			else if (configDto.getKey().equals(Keys.IS_DERIVED_UNIT_SYTEM.getName()))
			{
				data.setIsDerivedUnitSystem(configDto.getValue().equals("1"));
			}
			else if (configDto.getKey().equals(Keys.BARCODE_CONTAINS_TYPE.getName()))
			{
				for (BarcodeContainsType value : BarcodeContainsType.values())
				{
					if (configDto.getValue().equals(String.valueOf(value.getId())))
					{
						data.setBarcodeContainsType(value);
					}
				}
			}
			else if (configDto.getKey().equals(Keys.PRODUCT_CODE_GEN_TYPE.getName()))
			{
				for (ProductCodeGenType value : ProductCodeGenType.values())
				{
					if (configDto.getValue().equals(String.valueOf(value.getId())))
					{
						data.setProductCodeGenType(value);
					}
				}
			}
			else if (configDto.getKey().equals(Keys.AVG_SALES_DAYS.getName()))
			{
				if (!configDto.getValue().isEmpty())
				{
					data.setAvgSalesDays(Integer.parseInt(configDto.getValue()));
				}
			}
		}

		return data;
	}

	public boolean set(ConfigHdto data)
	{
		setNonTx(data);
		return true;
	}

	public void setNonTx(ConfigHdto data)
	{
		List<ConfigModel> configModels = configDao.get();

		for (ConfigModel configDto : configModels)
		{
			if (configDto.getKey().equals(Keys.NegativeStockAllowed.getName()))
			{
				configDto.setValue(data.isIsNegativeStockAllowed() ? "1" : "0");
			}
			else if (configDto.getKey().equals(Keys.IsHosieryBus.getName()))
			{
				configDto.setValue(data.isIsHosieryBusiness() ? "1" : "0");
			}
			else if (configDto.getKey().equals(Keys.IS_PROC_BUS.getName()))
			{
				configDto.setValue(data.isIsProcBus() ? "1" : "0");
			}
			else if (configDto.getKey().equals(Keys.IsMfgBus.getName()))
			{
				configDto.setValue(data.isIsMfgBus() ? "1" : "0");
			}
			else if (configDto.getKey().equals(Keys.IsEstimateQtyUsingQtyPerUnit.getName()))
			{
				configDto.setValue(data.isIsEstimateQtyUsingQtyPerUnit() ? "1" : "0");
			}
			else if (configDto.getKey().equals(Keys.HasColorGroups.getName()))
			{
				configDto.setValue(data.isHasColorGroups() ? "1" : "0");
			}
			else if (configDto.getKey().equals(Keys.MFG_MODE.getName()))
			{
				configDto.setValue(String.valueOf(data.getMfgMode().getId()));
			}
			else if (configDto.getKey().equals(Keys.WORK_RATE_DEPENDS_ON.getName()))
			{
				configDto.setValue(String.valueOf(data.getWorkRateDependsOn().getId()));
			}
			else if (configDto.getKey().equals(Keys.DEDUCT_RAW_MATERIAL_BY.getName()))
			{
				configDto.setValue(String.valueOf(data.getDeductRawMaterialBy().getId()));
			}
			else if (configDto.getKey().equals(Keys.CUSTOMER_WISE_SALES_RATE.getName()))
			{
				configDto.setValue(data.isIsCustomerWiseSalesRate() ? "1" : "0");
			}
			else if (configDto.getKey().equals(Keys.SALES_INVOICE_NO_SEQ_TYPE_ID.getName()))
			{
				configDto.setValue(String.valueOf(data.getSalesInvoiceNoSeqType().getId()));
			}
			else if (configDto.getKey().equals(Keys.DISC_ON.getName()))
			{
				configDto.setValue(String.valueOf(data.getDiscOn().getId()));
			}
			else if (configDto.getKey().equals(Keys.DEFAULT_DISC_RATE_TYPE_ID.getName()))
			{
				configDto.setValue(String.valueOf(data.getDefaultDiscRateType().getId()));
			}
			else if (configDto.getKey().equals(Keys.IS_ADD_TAX.getName()))
			{
				configDto.setValue(data.isIsAddTax() ? "1" : "0");
			}
			else if (configDto.getKey().equals(Keys.IS_BLANK_HEADER_IN_TX.getName()))
			{
				configDto.setValue(data.isIsBlankHeaderInTx() ? "1" : "0");
			}
			else if (configDto.getKey().equals(Keys.DEFAULT_PRINT_PAGE_FORMAT_ID.getName()))
			{
				configDto.setValue(String.valueOf(data.getDefaultPrintPageFormat().getId()));
			}
			else if (configDto.getKey().equals(Keys.IS_REMOVE_FOOTER_IN_INVOICE_PRINT.getName()))
			{
				configDto.setValue(data.isIsRemoveFooterInInvoicePrint() ? "1" : "0");
			}
			else if (configDto.getKey().equals(Keys.YEAR_CODE.getName()))
			{
				configDto.setValue(String.valueOf(data.getYearCode()));
			}
			else if (configDto.getKey().equals(Keys.IS_PRINT_BARCODE_ON_SAVE.getName()))
			{
				configDto.setValue(data.isIsPrintBarcodeOnSave() ? "1" : "0");
			}
			else if (configDto.getKey().equals(Keys.IS_BARCODE_SYSTEM.getName()))
			{
				configDto.setValue(data.isIsBarcodeSystem() ? "1" : "0");
			}
			else if (configDto.getKey().equals(Keys.IS_SALES_RATE_WITH_PURCHASE_AND_OS.getName()))
			{
				configDto.setValue(data.isIsSalesRateWithPurchaseAndOs() ? "1" : "0");
			}
			else if (configDto.getKey().equals(Keys.PRINT_AMT_FACTOR.getName()))
			{
				configDto.setValue(String.valueOf(data.getPrintAmtFactor().toString()));
			}
			else if (configDto.getKey().equals(Keys.MFG_BUS_TYPE.getName()))
			{
				configDto.setValue(String.valueOf(data.getMfgBusType().getId()));
			}
			else if (configDto.getKey().equals(Keys.IS_DERIVED_UNIT_SYTEM.getName()))
			{
				configDto.setValue(data.isIsDerivedUnitSystem() ? "1" : "0");
			}
			else if (configDto.getKey().equals(Keys.BARCODE_CONTAINS_TYPE.getName()))
			{
				configDto.setValue(String.valueOf(data.getBarcodeContainsType().getId()));
			}
			else if (configDto.getKey().equals(Keys.PRODUCT_CODE_GEN_TYPE.getName()))
			{
				configDto.setValue(String.valueOf(data.getProductCodeGenType().getId()));
			}
			else if (configDto.getKey().equals(Keys.AVG_SALES_DAYS.getName()))
			{
				configDto.setValue(data.getAvgSalesDays() == null ? "" : data.getAvgSalesDays().toString());
			}

		}
	}
}
