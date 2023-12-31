package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "estimate")
public class EstimateModel
{

	@Id
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id")
	private VoucherModel voucherModel;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "state_id")
	private Integer stateId;

	@Column(name = "country_id")
	private Integer countryId;

	@Column(name = "pin")
	private String pin;

	@Column(name = "email")
	private String email;

	@Column(name = "contact_no")
	private String contactNo;

	@Column(name = "is_shipping_same_as_billing")
	private boolean isShippingSameAsBilling;

	@Column(name = "shipping_name")
	private String shippingName;

	@Column(name = "shipping_address")
	private String shippingAddress;

	@Column(name = "shipping_city")
	private String shippingCity;

	@Column(name = "shipping_state_id")
	private Integer shippingStateId;

	@Column(name = "shipping_country_id")
	private Integer shippingCountryId;

	@Column(name = "shipping_pin")
	private String shippingPin;

	@Column(name = "shipping_email")
	private String shippingEmail;

	@Column(name = "shipping_contact_no")
	private String shippingContactNo;

	@Column(name = "is_intra")
	private boolean isIntra;

	@Column(name = "transporter_id")
	private Integer transporterId;

	@Column(name = "sum_qty")
	private BigDecimal sumQty;

	//variables for internal use
	@Column(name = "sum_qxr")
	private BigDecimal sumQxr;

	//Item val
	@Column(name = "sum_amt_after_item_disc")
	private BigDecimal sumAmtAfterItemDisc;

	@Column(name = "sum_item_taxable_amt")
	private BigDecimal sumItemTaxableAmt;

	// Tax
	@Column(name = "is_tax")
	private boolean isTax;

	@Column(name = "cgst_a")
	private BigDecimal cgstA;

	@Column(name = "sgst_a")
	private BigDecimal sgstA;

	@Column(name = "igst_a")
	private BigDecimal igstA;

	@Column(name = "sum_amt_after_tax")
	private BigDecimal sumAmtAfterTax;

	@Column(name = "total_amt")
	private BigDecimal totalAmt;

	@Column(name = "round_off")
	private BigDecimal roundOff;

	@Column(name = "amt_payable")
	private BigDecimal amtPayable;

	@Column(name = "note")
	private String note;

	@Column(name = "company_profile_id")
	private Integer companyProfileId;

	@Column(name = "status_id")
	private Integer statusId;

	@Column(name = "payment_mode_id")
	private Integer paymentModeId;

	@Column(name = "payment_term_id")
	private Integer paymentTermId;

	@Column(name = "sales_channel_id")
	private Integer salesChannelId;

	@Column(name = "trade_term_id")
	private Integer tradeTermId;

	@Column(name = "currency_id")
	private Integer currencyId;

	@Column(name = "currency_conversion_rate")
	private BigDecimal currencyConversionRate;

	@Column(name = "lock_stock_for_days")
	private Integer lockStockForDays;

	@Column(name = "is_lut")
	private boolean isLut;

	public EstimateModel()
	{
		note = "";
	}

	public VoucherModel getVoucherModel()
	{
		return voucherModel;
	}

	public void setVoucherModel(VoucherModel voucherModel)
	{
		this.voucherModel = voucherModel;
	}

	public Integer getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(Integer customerId)
	{
		this.customerId = customerId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public Integer getStateId()
	{
		return stateId;
	}

	public void setStateId(Integer stateId)
	{
		this.stateId = stateId;
	}

	public Integer getCountryId()
	{
		return countryId;
	}

	public void setCountryId(Integer countryId)
	{
		this.countryId = countryId;
	}

	public String getPin()
	{
		return pin;
	}

	public void setPin(String pin)
	{
		this.pin = pin;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getContactNo()
	{
		return contactNo;
	}

	public void setContactNo(String contactNo)
	{
		this.contactNo = contactNo;
	}

	public boolean isIsShippingSameAsBilling()
	{
		return isShippingSameAsBilling;
	}

	public void setIsShippingSameAsBilling(boolean isShippingSameAsBilling)
	{
		this.isShippingSameAsBilling = isShippingSameAsBilling;
	}

	public String getShippingName()
	{
		return shippingName;
	}

	public void setShippingName(String shippingName)
	{
		this.shippingName = shippingName;
	}

	public String getShippingAddress()
	{
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}

	public String getShippingCity()
	{
		return shippingCity;
	}

	public void setShippingCity(String shippingCity)
	{
		this.shippingCity = shippingCity;
	}

	public Integer getShippingStateId()
	{
		return shippingStateId;
	}

	public void setShippingStateId(Integer shippingStateId)
	{
		this.shippingStateId = shippingStateId;
	}

	public Integer getShippingCountryId()
	{
		return shippingCountryId;
	}

	public void setShippingCountryId(Integer shippingCountryId)
	{
		this.shippingCountryId = shippingCountryId;
	}

	public String getShippingPin()
	{
		return shippingPin;
	}

	public void setShippingPin(String shippingPin)
	{
		this.shippingPin = shippingPin;
	}

	public String getShippingEmail()
	{
		return shippingEmail;
	}

	public void setShippingEmail(String shippingEmail)
	{
		this.shippingEmail = shippingEmail;
	}

	public String getShippingContactNo()
	{
		return shippingContactNo;
	}

	public void setShippingContactNo(String shippingContactNo)
	{
		this.shippingContactNo = shippingContactNo;
	}

	public boolean isIsIntra()
	{
		return isIntra;
	}

	public void setIsIntra(boolean isIntra)
	{
		this.isIntra = isIntra;
	}

	public Integer getTransporterId()
	{
		return transporterId;
	}

	public void setTransporterId(Integer transporterId)
	{
		this.transporterId = transporterId;
	}

	public BigDecimal getSumQty()
	{
		return sumQty;
	}

	public void setSumQty(BigDecimal sumQty)
	{
		this.sumQty = sumQty;
	}

	public BigDecimal getSumQxr()
	{
		return sumQxr;
	}

	public void setSumQxr(BigDecimal sumQxr)
	{
		this.sumQxr = sumQxr;
	}

	public BigDecimal getSumAmtAfterItemDisc()
	{
		return sumAmtAfterItemDisc;
	}

	public void setSumAmtAfterItemDisc(BigDecimal sumAmtAfterItemDisc)
	{
		this.sumAmtAfterItemDisc = sumAmtAfterItemDisc;
	}

	public BigDecimal getSumItemTaxableAmt()
	{
		return sumItemTaxableAmt;
	}

	public void setSumItemTaxableAmt(BigDecimal sumItemTaxableAmt)
	{
		this.sumItemTaxableAmt = sumItemTaxableAmt;
	}

	public boolean isIsTax()
	{
		return isTax;
	}

	public void setIsTax(boolean isTax)
	{
		this.isTax = isTax;
	}

	public BigDecimal getCgstA()
	{
		return cgstA;
	}

	public void setCgstA(BigDecimal cgstA)
	{
		this.cgstA = cgstA;
	}

	public BigDecimal getSgstA()
	{
		return sgstA;
	}

	public void setSgstA(BigDecimal sgstA)
	{
		this.sgstA = sgstA;
	}

	public BigDecimal getIgstA()
	{
		return igstA;
	}

	public void setIgstA(BigDecimal igstA)
	{
		this.igstA = igstA;
	}

	public BigDecimal getSumAmtAfterTax()
	{
		return sumAmtAfterTax;
	}

	public void setSumAmtAfterTax(BigDecimal sumAmtAfterTax)
	{
		this.sumAmtAfterTax = sumAmtAfterTax;
	}

	public BigDecimal getTotalAmt()
	{
		return totalAmt;
	}

	public void setTotalAmt(BigDecimal totalAmt)
	{
		this.totalAmt = totalAmt;
	}

	public BigDecimal getRoundOff()
	{
		return roundOff;
	}

	public void setRoundOff(BigDecimal roundOff)
	{
		this.roundOff = roundOff;
	}

	public BigDecimal getAmtPayable()
	{
		return amtPayable;
	}

	public void setAmtPayable(BigDecimal amtPayable)
	{
		this.amtPayable = amtPayable;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public Integer getCompanyProfileId()
	{
		return companyProfileId;
	}

	public void setCompanyProfileId(Integer companyProfileId)
	{
		this.companyProfileId = companyProfileId;
	}

	public Integer getStatusId()
	{
		return statusId;
	}

	public void setStatusId(Integer statusId)
	{
		this.statusId = statusId;
	}

	public Integer getPaymentModeId()
	{
		return paymentModeId;
	}

	public void setPaymentModeId(Integer paymentModeId)
	{
		this.paymentModeId = paymentModeId;
	}

	public Integer getPaymentTermId()
	{
		return paymentTermId;
	}

	public void setPaymentTermId(Integer paymentTermId)
	{
		this.paymentTermId = paymentTermId;
	}

	public Integer getSalesChannelId()
	{
		return salesChannelId;
	}

	public void setSalesChannelId(Integer salesChannelId)
	{
		this.salesChannelId = salesChannelId;
	}

	public Integer getTradeTermId()
	{
		return tradeTermId;
	}

	public void setTradeTermId(Integer tradeTermId)
	{
		this.tradeTermId = tradeTermId;
	}

	public Integer getCurrencyId()
	{
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId)
	{
		this.currencyId = currencyId;
	}

	public BigDecimal getCurrencyConversionRate()
	{
		return currencyConversionRate;
	}

	public void setCurrencyConversionRate(BigDecimal currencyConversionRate)
	{
		this.currencyConversionRate = currencyConversionRate;
	}

	public Integer getLockStockForDays()
	{
		return lockStockForDays;
	}

	public void setLockStockForDays(Integer lockStockForDays)
	{
		this.lockStockForDays = lockStockForDays;
	}

	public boolean isIsLut()
	{
		return isLut;
	}

	public void setIsLut(boolean isLut)
	{
		this.isLut = isLut;
	}

}
