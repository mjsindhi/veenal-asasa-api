package com.hemsw.asasaapi.veenal.dto.hdto;

import com.hemsw.asasaapi.veenal.enums.RateType;
import java.math.BigDecimal;

public interface IPusaOthChNonTaxable
{

	public int getId();

	public void setId(int id);

	public int getNo();

	public void setNo(int no);

	public int getOthChargeId();

	public void setOthChargeId(int othChargeId);

	public int getRateTypeId();

	public void setRateTypeId(int rateTypeId);

	public RateType getRateType();

	public void setRateType(RateType vouItemCalcType);

	public BigDecimal getRate();

	public void setRate(BigDecimal rate);

	public BigDecimal getAmt();

	public void setAmt(BigDecimal amt);
}
