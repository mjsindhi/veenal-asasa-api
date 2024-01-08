package com.hemsw.asasaapi.veenal.dto.rr;

import com.hemsw.asasaapi.veenal.enums.RateType;
import java.math.BigDecimal;

public class EstimateOthChOnItemRrDto
{

	private int othChId;
	private BigDecimal rate;
	private int rateTypeId;

	public EstimateOthChOnItemRrDto()
	{
	}

	public int getOthChId()
	{
		return othChId;
	}

	public void setOthChId(int othChId)
	{
		this.othChId = othChId;
	}

	public BigDecimal getRate()
	{
		return rate;
	}

	public void setRate(BigDecimal rate)
	{
		this.rate = rate;
	}

	public int getRateTypeId()
	{
		return rateTypeId;
	}

	public void setRateTypeId(int rateTypeId)
	{
		this.rateTypeId = rateTypeId;
	}

	public RateType getRateType()
	{
		for (RateType value1 : RateType.values())
		{
			if (value1.getId() == rateTypeId)
			{
				return value1;
			}
		}
		return null;
	}

	public void setRateType(RateType vouItemCalcType)
	{
		this.rateTypeId = vouItemCalcType.getId();
	}

}
