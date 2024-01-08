package com.hemsw.asasaapi.veenal.dto.rr;

import java.util.ArrayList;
import java.util.List;

public class EstimateRrHoDto
{

	private EstimateRrDto estimateRrDto;
	private List<EstimateItemRrDto> estimateItemRrDtos;
	private List<EstimateOthChOnItemRrDto> estimateOthChOnItemRrDtos;
	private List<EstimateOthChTaxableRrDto> estimateOthChTaxableRrDtos;
	private List<EstimateOthChNonTaxableRrDto> estimateOthChNonTaxableRrDtos;

	public EstimateRrHoDto()
	{
		estimateItemRrDtos = new ArrayList<>();
		estimateOthChOnItemRrDtos = new ArrayList<>();
		estimateOthChTaxableRrDtos = new ArrayList<>();
		estimateOthChNonTaxableRrDtos = new ArrayList<>();
	}

	public EstimateRrDto getEstimateRrDto()
	{
		return estimateRrDto;
	}

	public void setEstimateRrDto(EstimateRrDto estimateRrDto)
	{
		this.estimateRrDto = estimateRrDto;
	}

	public List<EstimateItemRrDto> getEstimateItemRrDtos()
	{
		return estimateItemRrDtos;
	}

	public void setEstimateItemRrDtos(List<EstimateItemRrDto> estimateItemRrDtos)
	{
		this.estimateItemRrDtos = estimateItemRrDtos;
	}

	public List<EstimateOthChOnItemRrDto> getEstimateOthChOnItemRrDtos()
	{
		return estimateOthChOnItemRrDtos;
	}

	public void setEstimateOthChOnItemRrDtos(List<EstimateOthChOnItemRrDto> estimateOthChOnItemRrDtos)
	{
		this.estimateOthChOnItemRrDtos = estimateOthChOnItemRrDtos;
	}

	public List<EstimateOthChTaxableRrDto> getEstimateOthChTaxableRrDtos()
	{
		return estimateOthChTaxableRrDtos;
	}

	public void setEstimateOthChTaxableRrDtos(List<EstimateOthChTaxableRrDto> estimateOthChTaxableRrDtos)
	{
		this.estimateOthChTaxableRrDtos = estimateOthChTaxableRrDtos;
	}

	public List<EstimateOthChNonTaxableRrDto> getEstimateOthChNonTaxableRrDtos()
	{
		return estimateOthChNonTaxableRrDtos;
	}

	public void setEstimateOthChNonTaxableRrDtos(List<EstimateOthChNonTaxableRrDto> estimateOthChNonTaxableRrDtos)
	{
		this.estimateOthChNonTaxableRrDtos = estimateOthChNonTaxableRrDtos;
	}

}
