package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class PurchaseReturnLdto
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "no")
	private String no;

	@Column(name = "purchase_return_ledger")
	private String purchaseReturnLedger;

	@Column(name = "date")
	private Date date;

	//Supplier Details
	@Column(name = "supplier_name")
	private String supplierName;

	@Column(name = "city")
	private String city;

	@Column(name = "state_name")
	private String stateName;

	@Column(name = "agent_name")
	private String agentName;

	//Transport Details
	@Column(name = "lr_no")
	private String lrNo;

	@Column(name = "lr_date")
	private Date lrDate;

	@Column(name = "transporter_name")
	private String transporterName;

	@Column(name = "amt_payable")
	private BigDecimal amtPayable;

	@Column(name = "amt_clrd")
	private BigDecimal amtClrd;

	@Column(name = "amt_unclrd")
	private BigDecimal amtUnclrd;

	@Column(name = "note")
	private String note;

	@Column(name = "created_by_user_name")
	private String createdByUserName;

	@Column(name = "created_at")
	private Date createdAt;

	public int getId()
	{
		return id;
	}

	public String getNo()
	{
		return no;
	}

	public String getPurchaseReturnLedger()
	{
		return purchaseReturnLedger;
	}

	public Date getDate()
	{
		return date;
	}

	public String getSupplierName()
	{
		return supplierName;
	}

	public String getCity()
	{
		return city;
	}

	public String getStateName()
	{
		return stateName;
	}

	public String getAgentName()
	{
		return agentName;
	}

	public String getLrNo()
	{
		return lrNo;
	}

	public Date getLrDate()
	{
		return lrDate;
	}

	public String getTransporterName()
	{
		return transporterName;
	}

	public BigDecimal getAmtPayable()
	{
		return amtPayable;
	}

	public BigDecimal getAmtClrd()
	{
		return amtClrd;
	}

	public BigDecimal getAmtUnclrd()
	{
		return amtUnclrd;
	}

	public String getNote()
	{
		return note;
	}

	public String getCreatedByUserName()
	{
		return createdByUserName;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

}
