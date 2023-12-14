package com.hemsw.asasaapi.veenal.model.gen;

import com.hemsw.asasaapi.veenal.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.Date;

@Entity
@Table(name = TableName.TAX_CAT)
public class TaxCatModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "tax_id")
	private int taxId;

	@Column(name = "hsn")
	private Integer hsn;

	@Column(name = "created_by_user_id")
	private int createdByUserId;

	@Transient
	@Column(name = "created_at")
	private Date createdAt;

	public TaxCatModel()
	{
	}

	public TaxCatModel(String name, int taxId, Integer hsn)
	{
		this.name = name;
		this.taxId = taxId;
		this.hsn = hsn;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getTaxId()
	{
		return taxId;
	}

	public void setTaxId(int taxId)
	{
		this.taxId = taxId;
	}

	public Integer getHsn()
	{
		return hsn;
	}

	public void setHsn(Integer hsn)
	{
		this.hsn = hsn;
	}

	public int getCreatedByUserId()
	{
		return createdByUserId;
	}

	public void setCreatedByUserId(int createdByUserId)
	{
		this.createdByUserId = createdByUserId;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}

}
