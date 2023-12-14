package com.hemsw.asasaapi.veenal.dto.hdto;

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
import java.math.BigDecimal;

public class ConfigHdto
{

	private boolean isNegativeStockAllowed;
	private boolean isHosieryBusiness;
	private boolean isProcBus;
	private boolean isMfgBus;
	private boolean isEstimateQtyUsingQtyPerUnit;
	private boolean hasColorGroups;
	private MfgMode mfgMode;
	private WorkRateDependsOn workRateDependsOn;
	private DeductRawMaterialBy deductRawMaterialBy;
	private boolean isCustomerWiseSalesRate;
	private InvoiceNoSeqType salesInvoiceNoSeqType;
	private DiscOn discOn;
	private RateType defaultDiscRateType;
	private boolean isAddTax;
	private boolean isBlankHeaderInTx;
	private PrintPageFormat defaultPrintPageFormat;
	private boolean isRemoveFooterInInvoicePrint;
	private int yearCode;
	private boolean isSalesRateWithPurchaseAndOs;
	private BigDecimal printAmtFactor;
	private MfgBusType mfgBusType;
	private boolean isDerivedUnitSystem;
	private boolean isBarcodeSystem;
	private boolean isPrintBarcodeOnSave;
	private BarcodeContainsType barcodeContainsType;
	private ProductCodeGenType productCodeGenType;

	private Integer avgSalesDays;

	// Temporary static properties for browser and whatsapp
	private boolean startSendingOnAdd = true;
	private boolean startWhatsappOnSend = true;
	private Integer msgDelayMin = 5;
	private Integer msgDelayMax = 10;
	private boolean sendSmsOnFail = false;
	private String smsApi = "";

	public boolean isIsNegativeStockAllowed()
	{
		return isNegativeStockAllowed;
	}

	public void setIsNegativeStockAllowed(boolean isNegativeStockAllowed)
	{
		this.isNegativeStockAllowed = isNegativeStockAllowed;
	}

	public boolean isIsHosieryBusiness()
	{
		return isHosieryBusiness;
	}

	public void setIsHosieryBusiness(boolean isHosieryBusiness)
	{
		this.isHosieryBusiness = isHosieryBusiness;
	}

	public boolean isIsProcBus()
	{
		return isProcBus;
	}

	public void setIsProcBus(boolean isProcBus)
	{
		this.isProcBus = isProcBus;
	}

	public boolean isIsMfgBus()
	{
		return isMfgBus;
	}

	public void setIsMfgBus(boolean isMfgBus)
	{
		this.isMfgBus = isMfgBus;
	}

	public boolean isIsEstimateQtyUsingQtyPerUnit()
	{
		return isEstimateQtyUsingQtyPerUnit;
	}

	public void setIsEstimateQtyUsingQtyPerUnit(boolean isEstimateQtyUsingQtyPerUnit)
	{
		this.isEstimateQtyUsingQtyPerUnit = isEstimateQtyUsingQtyPerUnit;
	}

	public boolean isHasColorGroups()
	{
		return hasColorGroups;
	}

	public void setHasColorGroups(boolean hasColorGroups)
	{
		this.hasColorGroups = hasColorGroups;
	}

	public MfgMode getMfgMode()
	{
		return mfgMode;
	}

	public void setMfgMode(MfgMode mfgMode)
	{
		this.mfgMode = mfgMode;
	}

	public WorkRateDependsOn getWorkRateDependsOn()
	{
		return workRateDependsOn;
	}

	public void setWorkRateDependsOn(WorkRateDependsOn workRateDependsOn)
	{
		this.workRateDependsOn = workRateDependsOn;
	}

	public DeductRawMaterialBy getDeductRawMaterialBy()
	{
		return deductRawMaterialBy;
	}

	public void setDeductRawMaterialBy(DeductRawMaterialBy deductRawMaterialBy)
	{
		this.deductRawMaterialBy = deductRawMaterialBy;
	}

	public boolean isIsCustomerWiseSalesRate()
	{
		return isCustomerWiseSalesRate;
	}

	public void setIsCustomerWiseSalesRate(boolean isCustomerWiseSalesRate)
	{
		this.isCustomerWiseSalesRate = isCustomerWiseSalesRate;
	}

	public InvoiceNoSeqType getSalesInvoiceNoSeqType()
	{
		return salesInvoiceNoSeqType;
	}

	public void setSalesInvoiceNoSeqType(InvoiceNoSeqType salesInvoiceNoSeqType)
	{
		this.salesInvoiceNoSeqType = salesInvoiceNoSeqType;
	}

	public DiscOn getDiscOn()
	{
		return discOn;
	}

	public void setDiscOn(DiscOn discOn)
	{
		this.discOn = discOn;
	}

	public RateType getDefaultDiscRateType()
	{
		return defaultDiscRateType;
	}

	public void setDefaultDiscRateType(RateType defaultDiscRateType)
	{
		this.defaultDiscRateType = defaultDiscRateType;
	}

	public boolean isIsAddTax()
	{
		return isAddTax;
	}

	public void setIsAddTax(boolean isAddTax)
	{
		this.isAddTax = isAddTax;
	}

	public boolean isIsBlankHeaderInTx()
	{
		return isBlankHeaderInTx;
	}

	public void setIsBlankHeaderInTx(boolean isBlankHeaderInTx)
	{
		this.isBlankHeaderInTx = isBlankHeaderInTx;
	}

	public PrintPageFormat getDefaultPrintPageFormat()
	{
		return defaultPrintPageFormat;
	}

	public void setDefaultPrintPageFormat(PrintPageFormat defaultPrintPageFormat)
	{
		this.defaultPrintPageFormat = defaultPrintPageFormat;
	}

	public boolean isIsRemoveFooterInInvoicePrint()
	{
		return isRemoveFooterInInvoicePrint;
	}

	public void setIsRemoveFooterInInvoicePrint(boolean isRemoveFooterInInvoicePrint)
	{
		this.isRemoveFooterInInvoicePrint = isRemoveFooterInInvoicePrint;
	}

	public int getYearCode()
	{
		return yearCode;
	}

	public void setYearCode(int yearCode)
	{
		this.yearCode = yearCode;
	}

	public boolean isIsSalesRateWithPurchaseAndOs()
	{
		return isSalesRateWithPurchaseAndOs;
	}

	public void setIsSalesRateWithPurchaseAndOs(boolean isSalesRateWithPurchaseAndOs)
	{
		this.isSalesRateWithPurchaseAndOs = isSalesRateWithPurchaseAndOs;
	}

	public BigDecimal getPrintAmtFactor()
	{
		return printAmtFactor;
	}

	public void setPrintAmtFactor(BigDecimal printAmtFactor)
	{
		this.printAmtFactor = printAmtFactor;
	}

	public MfgBusType getMfgBusType()
	{
		return mfgBusType;
	}

	public void setMfgBusType(MfgBusType mfgBusType)
	{
		this.mfgBusType = mfgBusType;
	}

	public boolean isIsDerivedUnitSystem()
	{
		return isDerivedUnitSystem;
	}

	public void setIsDerivedUnitSystem(boolean isDerivedUnitSystem)
	{
		this.isDerivedUnitSystem = isDerivedUnitSystem;
	}

	public boolean isIsBarcodeSystem()
	{
		return isBarcodeSystem;
	}

	public void setIsBarcodeSystem(boolean isBarcodeSystem)
	{
		this.isBarcodeSystem = isBarcodeSystem;
	}

	public boolean isIsPrintBarcodeOnSave()
	{
		return isPrintBarcodeOnSave;
	}

	public void setIsPrintBarcodeOnSave(boolean isPrintBarcodeOnSave)
	{
		this.isPrintBarcodeOnSave = isPrintBarcodeOnSave;
	}

	public BarcodeContainsType getBarcodeContainsType()
	{
		return barcodeContainsType;
	}

	public void setBarcodeContainsType(BarcodeContainsType barcodeContainsType)
	{
		this.barcodeContainsType = barcodeContainsType;
	}

	public ProductCodeGenType getProductCodeGenType()
	{
		return productCodeGenType;
	}

	public void setProductCodeGenType(ProductCodeGenType productCodeGenType)
	{
		this.productCodeGenType = productCodeGenType;
	}

	public Integer getAvgSalesDays()
	{
		return avgSalesDays;
	}

	public void setAvgSalesDays(Integer avgSalesDays)
	{
		this.avgSalesDays = avgSalesDays;
	}

	//
	public boolean isStartSendingOnAdd()
	{
		return startSendingOnAdd;
	}

	public boolean isStartWhatsappOnSend()
	{
		return startWhatsappOnSend;
	}

	public Integer getMsgDelayMin()
	{
		return msgDelayMin;
	}

	public Integer getMsgDelayMax()
	{
		return msgDelayMax;
	}

	public boolean isSendSmsOnFail()
	{
		return sendSmsOnFail;
	}

	public String getSmsApi()
	{
		return smsApi;
	}

}
