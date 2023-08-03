package com.hemsw.asasaapi.veenal.model.gen;

import com.hemsw.asasaapi.veenal.enums.UnitOperatorType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "unit")
public class UnitModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "is_derived")
	private boolean isDerived;

	@Column(name = "base_unit_id")
	private Integer baseUnitId;

	@Column(name = "operator_id")
	private Integer operatorId;

	@Column(name = "num")
	private BigDecimal num;

	@Column(name = "created_by_user_id")
	private int createdByUserId;

	@Column(name = "created_at")
	private Date createdAt;

	public UnitModel()
	{
	}

	public UnitModel(String code, String name, boolean isDerived, Integer baseUnitId, Integer operatorId, BigDecimal num)
	{
		this.code = code;
		this.name = name;
		this.isDerived = isDerived;
		this.baseUnitId = baseUnitId;
		this.operatorId = operatorId;
		this.num = num;
	}

	// Custom geter setter
	public UnitOperatorType getUnitOperatorType()
	{
		return UnitOperatorType.getById(operatorId);
	}

	public void setUnitOperatorType(UnitOperatorType accountType)
	{
		this.operatorId = accountType.getId();
	}

}
