package com.hemsw.asasaapi.veenal.model.gen;

import com.hemsw.asasaapi.veenal.enums.SalesType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "sales")
public class SalesModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "type_id")
	private Integer typeId;

	//Customer Details
	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "is_intra")
	private boolean isIntra;

	//Order Details
	@Column(name = "sales_order_id")
	private Integer salesOrderId;

	@Column(name = "order_no")
	private String orderNo;

	@Column(name = "order_date")
	private Date orderDate;

	//Transport Details
	@Column(name = "lr_no")
	private String lrNo;

	@Column(name = "lr_date")
	private Date lrDate;

	@Column(name = "transporter_id")
	private Integer transporterId;

	@Column(name = "destination")
	private String destination;

	@Column(name = "sum_qty")
	private BigDecimal sumQty;

	@Column(name = "no_of_carton")
	private Integer noOfCarton;

	//variables for internal use
	@Column(name = "sum_qxr")
	private BigDecimal sumQxr;

	//Item val
	@Column(name = "sum_amt_after_item_disc")
	private BigDecimal sumAmtAfterItemDisc;

	@Column(name = "sum_item_taxable_amt")
	private BigDecimal sumItemTaxableAmt;

	// Tax
	@Column(name = "is_tax")
	private boolean isTax;

	@Column(name = "cgst_a")
	private BigDecimal cgstA;

	@Column(name = "sgst_a")
	private BigDecimal sgstA;

	@Column(name = "igst_a")
	private BigDecimal igstA;

	@Column(name = "sum_amt_after_tax")
	private BigDecimal sumAmtAfterTax;

	@Column(name = "total_amt")
	private BigDecimal totalAmt;

	@Column(name = "round_off")
	private BigDecimal roundOff;

	@Column(name = "amt_payable")
	private BigDecimal amtPayable;

	@Column(name = "note")
	private String note;

	@Column(name = "final_invoice_no")
	private String finalInvoiceNo;

	@Column(name = "company_profile_id")
	private Integer companyProfileId;

	@Column(name = "delivery_by")
	private String deliveryBy;

	public SalesModel()
	{
		finalInvoiceNo = "";
		note = "";
		deliveryBy = "";
	}

	public SalesModel(EstimateModel estimateModel)
	{
		this();

		this.customerId = estimateModel.getCustomerId();
		this.isIntra = estimateModel.isIsIntra();
		this.transporterId = estimateModel.getTransporterId();
		this.sumQty = estimateModel.getSumQty();
		this.sumQxr = estimateModel.getSumQxr();
		this.sumAmtAfterItemDisc = estimateModel.getSumAmtAfterItemDisc();
		this.sumItemTaxableAmt = estimateModel.getSumItemTaxableAmt();
		this.isTax = estimateModel.isIsTax();
		this.cgstA = estimateModel.getCgstA();
		this.sgstA = estimateModel.getSgstA();
		this.igstA = estimateModel.getIgstA();
		this.sumAmtAfterTax = estimateModel.getSumAmtAfterTax();
		this.totalAmt = estimateModel.getTotalAmt();
		this.roundOff = estimateModel.getRoundOff();
		this.amtPayable = estimateModel.getAmtPayable();
		this.note = estimateModel.getNote();
	}

	public SalesModel(SalesOrderModel salesOrderModel)
	{
		this();

		this.customerId = salesOrderModel.getCustomerId();
		this.isIntra = salesOrderModel.isIsIntra();
		this.salesOrderId = salesOrderModel.getId();
		this.transporterId = salesOrderModel.getTransporterId();
		this.sumQty = salesOrderModel.getSumQty();
		this.sumQxr = salesOrderModel.getSumQxr();
		this.sumAmtAfterItemDisc = salesOrderModel.getSumAmtAfterItemDisc();
		this.sumItemTaxableAmt = salesOrderModel.getSumItemTaxableAmt();
		this.isTax = salesOrderModel.isIsTax();
		this.cgstA = salesOrderModel.getCgstA();
		this.sgstA = salesOrderModel.getSgstA();
		this.igstA = salesOrderModel.getIgstA();
		this.sumAmtAfterTax = salesOrderModel.getSumAmtAfterTax();
		this.totalAmt = salesOrderModel.getTotalAmt();
		this.roundOff = salesOrderModel.getRoundOff();
		this.amtPayable = salesOrderModel.getAmtPayable();
		this.note = salesOrderModel.getNote();
	}

	public SalesModel(PiModel piModel)
	{
		this();

		this.customerId = piModel.getCustomerId();
		this.isIntra = piModel.isIsIntra();
		this.sumQty = piModel.getSumQty();
		this.sumQxr = piModel.getSumQxr();
		this.sumAmtAfterItemDisc = piModel.getSumAmtAfterItemDisc();
		this.sumItemTaxableAmt = piModel.getSumItemTaxableAmt();
		this.isTax = piModel.isIsTax();
		this.cgstA = piModel.getCgstA();
		this.sgstA = piModel.getSgstA();
		this.igstA = piModel.getIgstA();
		this.sumAmtAfterTax = piModel.getSumAmtAfterTax();
		this.totalAmt = piModel.getTotalAmt();
		this.roundOff = piModel.getRoundOff();
		this.amtPayable = piModel.getAmtPayable();
		this.note = piModel.getNote();
	}

	public SalesModel(SalesModel salesModel, boolean copyId)
	{
		if (copyId)
		{
			this.id = salesModel.id;
		}

		this.typeId = salesModel.typeId;
		this.customerName = salesModel.customerName;
		this.customerId = salesModel.customerId;
		this.isIntra = salesModel.isIntra;
		this.salesOrderId = salesModel.salesOrderId;
		this.orderNo = salesModel.orderNo;
		this.orderDate = salesModel.orderDate;
		this.lrNo = salesModel.lrNo;
		this.lrDate = salesModel.lrDate;
		this.transporterId = salesModel.transporterId;
		this.destination = salesModel.destination;
		this.sumQty = salesModel.sumQty;
		this.noOfCarton = salesModel.noOfCarton;
		this.sumQxr = salesModel.sumQxr;
		this.sumAmtAfterItemDisc = salesModel.sumAmtAfterItemDisc;
		this.sumItemTaxableAmt = salesModel.sumItemTaxableAmt;
		this.isTax = salesModel.isTax;
		this.cgstA = salesModel.cgstA;
		this.sgstA = salesModel.sgstA;
		this.igstA = salesModel.igstA;
		this.sumAmtAfterTax = salesModel.sumAmtAfterTax;
		this.totalAmt = salesModel.totalAmt;
		this.roundOff = salesModel.roundOff;
		this.amtPayable = salesModel.amtPayable;
		this.note = salesModel.note;
		this.finalInvoiceNo = salesModel.finalInvoiceNo;
		this.companyProfileId = salesModel.companyProfileId;
		this.deliveryBy = salesModel.deliveryBy;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Integer getTypeId()
	{
		return typeId;
	}

	public void setTypeId(Integer typeId)
	{
		this.typeId = typeId;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	public Integer getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(Integer customerId)
	{
		this.customerId = customerId;
	}

	public boolean isIsIntra()
	{
		return isIntra;
	}

	public void setIsIntra(boolean isIntra)
	{
		this.isIntra = isIntra;
	}

	public Integer getSalesOrderId()
	{
		return salesOrderId;
	}

	public void setSalesOrderId(Integer salesOrderId)
	{
		this.salesOrderId = salesOrderId;
	}

	public String getOrderNo()
	{
		return orderNo;
	}

	public void setOrderNo(String orderNo)
	{
		this.orderNo = orderNo;
	}

	public Date getOrderDate()
	{
		return orderDate;
	}

	public void setOrderDate(Date orderDate)
	{
		this.orderDate = orderDate;
	}

	public String getLrNo()
	{
		return lrNo;
	}

	public void setLrNo(String lrNo)
	{
		this.lrNo = lrNo;
	}

	public Date getLrDate()
	{
		return lrDate;
	}

	public void setLrDate(Date lrDate)
	{
		this.lrDate = lrDate;
	}

	public Integer getTransporterId()
	{
		return transporterId;
	}

	public void setTransporterId(Integer transporterId)
	{
		this.transporterId = transporterId;
	}

	public String getDestination()
	{
		return destination;
	}

	public void setDestination(String destination)
	{
		this.destination = destination;
	}

	public BigDecimal getSumQty()
	{
		return sumQty;
	}

	public void setSumQty(BigDecimal sumQty)
	{
		this.sumQty = sumQty;
	}

	public Integer getNoOfCarton()
	{
		return noOfCarton;
	}

	public void setNoOfCarton(Integer noOfCarton)
	{
		this.noOfCarton = noOfCarton;
	}

	public BigDecimal getSumQxr()
	{
		return sumQxr;
	}

	public void setSumQxr(BigDecimal sumQxr)
	{
		this.sumQxr = sumQxr;
	}

	public BigDecimal getSumAmtAfterItemDisc()
	{
		return sumAmtAfterItemDisc;
	}

	public void setSumAmtAfterItemDisc(BigDecimal sumAmtAfterItemDisc)
	{
		this.sumAmtAfterItemDisc = sumAmtAfterItemDisc;
	}

	public BigDecimal getSumItemTaxableAmt()
	{
		return sumItemTaxableAmt;
	}

	public void setSumItemTaxableAmt(BigDecimal sumItemTaxableAmt)
	{
		this.sumItemTaxableAmt = sumItemTaxableAmt;
	}

	public boolean isIsTax()
	{
		return isTax;
	}

	public void setIsTax(boolean isTax)
	{
		this.isTax = isTax;
	}

	public BigDecimal getCgstA()
	{
		return cgstA;
	}

	public void setCgstA(BigDecimal cgstA)
	{
		this.cgstA = cgstA;
	}

	public BigDecimal getSgstA()
	{
		return sgstA;
	}

	public void setSgstA(BigDecimal sgstA)
	{
		this.sgstA = sgstA;
	}

	public BigDecimal getIgstA()
	{
		return igstA;
	}

	public void setIgstA(BigDecimal igstA)
	{
		this.igstA = igstA;
	}

	public BigDecimal getSumAmtAfterTax()
	{
		return sumAmtAfterTax;
	}

	public void setSumAmtAfterTax(BigDecimal sumAmtAfterTax)
	{
		this.sumAmtAfterTax = sumAmtAfterTax;
	}

	public BigDecimal getTotalAmt()
	{
		return totalAmt;
	}

	public void setTotalAmt(BigDecimal totalAmt)
	{
		this.totalAmt = totalAmt;
	}

	public BigDecimal getRoundOff()
	{
		return roundOff;
	}

	public void setRoundOff(BigDecimal roundOff)
	{
		this.roundOff = roundOff;
	}

	public BigDecimal getAmtPayable()
	{
		return amtPayable;
	}

	public void setAmtPayable(BigDecimal amtPayable)
	{
		this.amtPayable = amtPayable;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public String getFinalInvoiceNo()
	{
		return finalInvoiceNo;
	}

	public void setFinalInvoiceNo(String finalInvoiceNo)
	{
		this.finalInvoiceNo = finalInvoiceNo;
	}

	public Integer getCompanyProfileId()
	{
		return companyProfileId;
	}

	public void setCompanyProfileId(Integer companyProfileId)
	{
		this.companyProfileId = companyProfileId;
	}

	public String getDeliveryBy()
	{
		return deliveryBy;
	}

	public void setDeliveryBy(String deliveryBy)
	{
		this.deliveryBy = deliveryBy;
	}

	//
	public SalesType getType()
	{
		for (SalesType value : SalesType.values())
		{
			if (value.getId() == typeId)
			{
				return value;
			}
		}
		return null;
	}

	public int getSucuId()
	{
		return customerId;
	}

	public void setSucuId(int sucuId)
	{
		this.customerId = sucuId;
	}

}
