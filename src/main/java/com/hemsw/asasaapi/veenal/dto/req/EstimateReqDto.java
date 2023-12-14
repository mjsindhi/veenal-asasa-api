package com.hemsw.asasaapi.veenal.dto.req;

import java.math.BigDecimal;
import java.util.Date;

public class EstimateReqDto
{

	private Date date;
	private String no;
	private Integer customerId;
	private boolean isIntra;
	private Integer transporterId;
	private boolean isTax;
	private String note;
	private Integer statusId;
	private Integer paymentModeId;
	private Integer paymentTermId;
	private Integer salesChannelId;
	private Integer tradeTermId;
	private Integer currencyId;
	private BigDecimal currencyConversionRate;
	private Integer lockStatusForDays;

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getNo()
	{
		return no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	public Integer getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(Integer customerId)
	{
		this.customerId = customerId;
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

	public boolean isIsTax()
	{
		return isTax;
	}

	public void setIsTax(boolean isTax)
	{
		this.isTax = isTax;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
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

	public Integer getLockStatusForDays()
	{
		return lockStatusForDays;
	}

	public void setLockStatusForDays(Integer lockStatusForDays)
	{
		this.lockStatusForDays = lockStatusForDays;
	}

}
