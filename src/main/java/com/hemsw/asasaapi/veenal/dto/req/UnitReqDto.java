package com.hemsw.asasaapi.veenal.dto.req;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class UnitReqDto
{

	private String name;
	private String code;
	private Boolean isDerived;
	private Integer baseUnitId;
	private Integer operatorId;
	private BigDecimal qty;

}
