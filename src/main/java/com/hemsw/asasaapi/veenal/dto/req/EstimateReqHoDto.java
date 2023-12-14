package com.hemsw.asasaapi.veenal.dto.req;

import java.util.ArrayList;
import java.util.List;

public class EstimateReqHoDto
{

	private EstimateReqDto estimateReqDto;
	private List<EstimateItemReqDto> estimateItemReqDtos;
	private List<EstimateOthChOnItemReqDto> estimateOthChOnItemReqDtos;
	private List<EstimateOthChTaxableReqDto> estimateOthChTaxableReqDtos;
	private List<EstimateOthChNonTaxableReqDto> estimateOthChNonTaxableReqDtos;

	public EstimateReqHoDto()
	{
		estimateItemReqDtos = new ArrayList<>();
		estimateOthChOnItemReqDtos = new ArrayList<>();
		estimateOthChTaxableReqDtos = new ArrayList<>();
		estimateOthChNonTaxableReqDtos = new ArrayList<>();
	}

	public EstimateReqDto getEstimateReqDto()
	{
		return estimateReqDto;
	}

	public void setEstimateReqDto(EstimateReqDto estimateReqDto)
	{
		this.estimateReqDto = estimateReqDto;
	}

	public List<EstimateItemReqDto> getEstimateItemReqDtos()
	{
		return estimateItemReqDtos;
	}

	public void setEstimateItemReqDtos(List<EstimateItemReqDto> estimateItemReqDtos)
	{
		this.estimateItemReqDtos = estimateItemReqDtos;
	}

	public List<EstimateOthChOnItemReqDto> getEstimateOthChOnItemReqDtos()
	{
		return estimateOthChOnItemReqDtos;
	}

	public void setEstimateOthChOnItemReqDtos(List<EstimateOthChOnItemReqDto> estimateOthChOnItemReqDtos)
	{
		this.estimateOthChOnItemReqDtos = estimateOthChOnItemReqDtos;
	}

	public List<EstimateOthChTaxableReqDto> getEstimateOthChTaxableReqDtos()
	{
		return estimateOthChTaxableReqDtos;
	}

	public void setEstimateOthChTaxableReqDtos(List<EstimateOthChTaxableReqDto> estimateOthChTaxableReqDtos)
	{
		this.estimateOthChTaxableReqDtos = estimateOthChTaxableReqDtos;
	}

	public List<EstimateOthChNonTaxableReqDto> getEstimateOthChNonTaxableReqDtos()
	{
		return estimateOthChNonTaxableReqDtos;
	}

	public void setEstimateOthChNonTaxableReqDtos(List<EstimateOthChNonTaxableReqDto> estimateOthChNonTaxableReqDtos)
	{
		this.estimateOthChNonTaxableReqDtos = estimateOthChNonTaxableReqDtos;
	}

}
