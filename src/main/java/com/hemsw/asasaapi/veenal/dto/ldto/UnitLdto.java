package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.Getter;
import org.springframework.data.annotation.Immutable;

@Getter
@Entity
@Immutable
public class UnitLdto
{

	@Id
	private int id;
	private String code;
	private String name;
	private boolean isDerived;
	private String baseUnitName;
	private Integer operatorId;
	private BigDecimal num;

}
