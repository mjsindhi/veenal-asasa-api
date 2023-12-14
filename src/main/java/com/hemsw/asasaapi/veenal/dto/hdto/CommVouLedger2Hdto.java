package com.hemsw.asasaapi.veenal.dto.hdto;

import com.hemsw.asasaapi.veenal.enums.VoucherType;
import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class CommVouLedger2Hdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "voucher_type_id")
	private int voucherTypeId;

	@Column(name = "date")
	private Date date;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "agent_id")
	private int agentId;

	@Column(name = "agent_name")
	private String agentName;

	@Column(name = "voucher_amt")
	private BigDecimal voucherAmt;

	@Column(name = "estimated_comm")
	private BigDecimal estimatedComm;

	@Column(name = "comm_payable_estimated")
	private BigDecimal commPayableEstimated;

	@Column(name = "comm_payable")
	private BigDecimal commPayable;

	@Column(name = "tx_type_id")
	private int txTypeId;

	public int getId()
	{
		return id;
	}

	public int getVoucherTypeId()
	{
		return voucherTypeId;
	}

	public Date getDate()
	{
		return date;
	}

	public int getCustomerId()
	{
		return customerId;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public int getAgentId()
	{
		return agentId;
	}

	public String getAgentName()
	{
		return agentName;
	}

	public BigDecimal getVoucherAmt()
	{
		return voucherAmt;
	}

	public BigDecimal getEstimatedComm()
	{
		return estimatedComm;
	}

	public BigDecimal getCommPayableEstimated()
	{
		return commPayableEstimated;
	}

	public BigDecimal getCommPayable()
	{
		return commPayable;
	}

	public int getTxTypeId()
	{
		return txTypeId;
	}

	//
	public VoucherType getVoucherType()
	{
		for (VoucherType value : VoucherType.values())
		{
			if (voucherTypeId == value.getId())
			{
				return value;
			}
		}
		return null;
	}
}
