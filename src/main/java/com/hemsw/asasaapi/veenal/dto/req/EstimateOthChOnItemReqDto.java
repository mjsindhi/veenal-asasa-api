package com.hemsw.asasaapi.veenal.dto.req;

import com.hemsw.asasaapi.veenal.enums.RateType;
import java.math.BigDecimal;

public class EstimateOthChOnItemReqDto
{

	private int othChId;
	private BigDecimal rate;
	private int rateTypeId;

	public EstimateOthChOnItemReqDto()
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
