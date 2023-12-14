package com.hemsw.asasaapi.veenal.dto.hdto;

import com.hemsw.asasaapi.veenal.enums.RateType;
import java.math.BigDecimal;

public interface IPusaItem
{

	public int getId();

	public void setId(int id);

	public int getProductId();

	public void setProductId(int productId);

	public String getDesc();

	public void setDesc(String desc);

	public BigDecimal getQty();

	public void setQty(BigDecimal qty);

	public BigDecimal getRate();

	public void setRate(BigDecimal rate);

	public boolean isRateInclAll();

	public void setRateInclAll(boolean rateInclAll);

	public BigDecimal getQxr();

	public void setQxr(BigDecimal qxr);

	public BigDecimal getDiscRate();

	public void setDiscRate(BigDecimal discRate);

	public Integer getDiscRateTypeId();

	public void setDiscRateTypeId(Integer discRateTypeId);

	public BigDecimal getDiscA();

	public void setDiscA(BigDecimal discA);

	public BigDecimal getAmtAfterDisc();

	public void setAmtAfterDisc(BigDecimal amtAfterDisc);

	public BigDecimal getTaxableAmt();

	public void setTaxableAmt(BigDecimal taxableAmt);

	public Integer getTaxId();

	public void setTaxId(Integer taxId);

	public BigDecimal getCgstA();

	public void setCgstA(BigDecimal cgstA);

	public BigDecimal getSgstA();

	public void setSgstA(BigDecimal sgstA);

	public BigDecimal getIgstA();

	public void setIgstA(BigDecimal igstA);

	public BigDecimal getAmt();

	public void setAmt(BigDecimal amt);

	//
	public RateType getDiscRateType();

	public void setDiscRateType(RateType vouItemRateType);
}
