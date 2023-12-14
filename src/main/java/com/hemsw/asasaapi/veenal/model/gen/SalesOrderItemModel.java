package com.hemsw.asasaapi.veenal.model.gen;

import com.hemsw.asasaapi.veenal.enums.RateType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "sales_order_item")
public class SalesOrderItemModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "seq_no")
	private int seqNo;

	@Column(name = "sales_order_id")
	private int salesOrderId;

	@Column(name = "product_id")
	private int productId;

	@Column(name = "desc")
	private String desc;

	@Column(name = "order_qty")
	private BigDecimal orderQty;

	@Column(name = "order_unit_id")
	private int orderUnitId;

	@Column(name = "qty")
	private BigDecimal qty;

	@Column(name = "rate")
	private BigDecimal rate;

	@Column(name = "qxr")
	private BigDecimal qxr;

	@Column(name = "disc_rate")
	private BigDecimal discRate;

	@Column(name = "disc_rate_type_id")
	private Integer discRateTypeId;

	@Column(name = "disc_a")
	private BigDecimal discA;

	@Column(name = "amt_after_disc")
	private BigDecimal amtAfterDisc;

	@Column(name = "taxable_amt")
	private BigDecimal taxableAmt;

	@Column(name = "tax_id")
	private Integer taxId;

	@Column(name = "tax_rate")
	private BigDecimal taxRate;

	@Column(name = "cgst_a")
	private BigDecimal cgstA;

	@Column(name = "sgst_a")
	private BigDecimal sgstA;

	@Column(name = "igst_a")
	private BigDecimal igstA;

	@Column(name = "amt")
	private BigDecimal amt;

	public SalesOrderItemModel()
	{
	}

	public SalesOrderItemModel(EstimateItemModel estimateItemModel, int unitId)
	{
		this.productId = estimateItemModel.getProductId();
		this.desc = estimateItemModel.getDesc();
		this.orderQty = estimateItemModel.getQty();
		this.orderUnitId = unitId;
		this.qty = estimateItemModel.getQty();
		this.rate = estimateItemModel.getRate();
		this.qxr = estimateItemModel.getQxr();
		this.discRate = estimateItemModel.getDiscRate();
		this.discRateTypeId = estimateItemModel.getDiscRateTypeId();
		this.discA = estimateItemModel.getDiscA();
		this.amtAfterDisc = estimateItemModel.getAmtAfterDisc();
		this.taxableAmt = estimateItemModel.getTaxableAmt();
		this.taxId = estimateItemModel.getTaxId();
		this.taxRate = estimateItemModel.getTaxRate();
		this.cgstA = estimateItemModel.getCgstA();
		this.sgstA = estimateItemModel.getSgstA();
		this.igstA = estimateItemModel.getIgstA();
		this.amt = estimateItemModel.getAmt();
	}

	public SalesOrderItemModel(PiItemModel piItemModel, int unitId)
	{
		this.productId = piItemModel.getProductId();
		this.desc = piItemModel.getDesc();
		this.orderQty = piItemModel.getQty();
		this.orderUnitId = unitId;
		this.qty = piItemModel.getQty();
		this.rate = piItemModel.getRate();
		this.qxr = piItemModel.getQxr();
		this.discRate = piItemModel.getDiscRate();
		this.discRateTypeId = piItemModel.getDiscRateTypeId();
		this.discA = piItemModel.getDiscA();
		this.amtAfterDisc = piItemModel.getAmtAfterDisc();
		this.taxableAmt = piItemModel.getTaxableAmt();
		this.taxId = piItemModel.getTaxId();
		this.taxRate = piItemModel.getTaxRate();
		this.cgstA = piItemModel.getCgstA();
		this.sgstA = piItemModel.getSgstA();
		this.igstA = piItemModel.getIgstA();
		this.amt = piItemModel.getAmt();
	}

	public SalesOrderItemModel(SalesOrderItemModel salesOrderItemModel)
	{
		this.id = salesOrderItemModel.id;
		this.seqNo = salesOrderItemModel.seqNo;
		this.salesOrderId = salesOrderItemModel.salesOrderId;
		this.productId = salesOrderItemModel.productId;
		this.desc = salesOrderItemModel.desc;
		this.orderQty = salesOrderItemModel.orderQty;
		this.orderUnitId = salesOrderItemModel.orderUnitId;
		this.qty = salesOrderItemModel.qty;
		this.rate = salesOrderItemModel.rate;
		this.qxr = salesOrderItemModel.qxr;
		this.discRate = salesOrderItemModel.discRate;
		this.discRateTypeId = salesOrderItemModel.discRateTypeId;
		this.discA = salesOrderItemModel.discA;
		this.amtAfterDisc = salesOrderItemModel.amtAfterDisc;
		this.taxableAmt = salesOrderItemModel.taxableAmt;
		this.taxId = salesOrderItemModel.taxId;
		this.taxRate = salesOrderItemModel.taxRate;
		this.cgstA = salesOrderItemModel.cgstA;
		this.sgstA = salesOrderItemModel.sgstA;
		this.igstA = salesOrderItemModel.igstA;
		this.amt = salesOrderItemModel.amt;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getSeqNo()
	{
		return seqNo;
	}

	public void setSeqNo(int seqNo)
	{
		this.seqNo = seqNo;
	}

	public int getSalesOrderId()
	{
		return salesOrderId;
	}

	public void setSalesOrderId(int salesOrderId)
	{
		this.salesOrderId = salesOrderId;
	}

	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public BigDecimal getOrderQty()
	{
		return orderQty;
	}

	public void setOrderQty(BigDecimal orderQty)
	{
		this.orderQty = orderQty;
	}

	public int getOrderUnitId()
	{
		return orderUnitId;
	}

	public void setOrderUnitId(int orderUnitId)
	{
		this.orderUnitId = orderUnitId;
	}

	public BigDecimal getQty()
	{
		return qty;
	}

	public void setQty(BigDecimal qty)
	{
		this.qty = qty;
	}

	public BigDecimal getRate()
	{
		return rate;
	}

	public void setRate(BigDecimal rate)
	{
		this.rate = rate;
	}

	public BigDecimal getQxr()
	{
		return qxr;
	}

	public void setQxr(BigDecimal qxr)
	{
		this.qxr = qxr;
	}

	public BigDecimal getDiscRate()
	{
		return discRate;
	}

	public void setDiscRate(BigDecimal discRate)
	{
		this.discRate = discRate;
	}

	public Integer getDiscRateTypeId()
	{
		return discRateTypeId;
	}

	public void setDiscRateTypeId(Integer discRateTypeId)
	{
		this.discRateTypeId = discRateTypeId;
	}

	public BigDecimal getDiscA()
	{
		return discA;
	}

	public void setDiscA(BigDecimal discA)
	{
		this.discA = discA;
	}

	public BigDecimal getAmtAfterDisc()
	{
		return amtAfterDisc;
	}

	public void setAmtAfterDisc(BigDecimal amtAfterDisc)
	{
		this.amtAfterDisc = amtAfterDisc;
	}

	public BigDecimal getTaxableAmt()
	{
		return taxableAmt;
	}

	public void setTaxableAmt(BigDecimal taxableAmt)
	{
		this.taxableAmt = taxableAmt;
	}

	public Integer getTaxId()
	{
		return taxId;
	}

	public void setTaxId(Integer taxId)
	{
		this.taxId = taxId;
	}

	public BigDecimal getTaxRate()
	{
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate)
	{
		this.taxRate = taxRate;
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

	public BigDecimal getAmt()
	{
		return amt;
	}

	public void setAmt(BigDecimal amt)
	{
		this.amt = amt;
	}

//
	public RateType getDiscRateType()
	{
		if (discRateTypeId == null)
		{
			return null;
		}

		for (RateType value : RateType.values())
		{
			if (value.getId() == discRateTypeId)
			{
				return value;
			}
		}
		return null;
	}

	public void setDiscRateType(RateType vouItemRateType)
	{
		if (vouItemRateType == null)
		{
			this.discRateTypeId = null;
		}
		else
		{
			this.discRateTypeId = vouItemRateType.getId();
		}
	}

}
