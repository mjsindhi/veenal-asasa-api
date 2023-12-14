package com.hemsw.asasaapi.veenal.dto.hdto;

import java.math.BigDecimal;

public interface IPusa
{

	public int getId();

	public void setId(int id);

	public int getSucuId();

	public void setSucuId(int sucuId);

	public boolean isIsIntra();

	public void setIsIntra(boolean isIntra);

	public BigDecimal getSumQxr();

	public void setSumQxr(BigDecimal sumQxr);

	public BigDecimal getSumAmtAfterItemDisc();

	public void setSumAmtAfterItemDisc(BigDecimal sumAmtAfterItemDisc);

	public BigDecimal getSumItemTaxableAmt();

	public void setSumItemTaxableAmt(BigDecimal sumTaxableAmt);

	public boolean isIsTax();

	public void setIsTax(boolean isTax);

	public BigDecimal getCgstA();

	public void setCgstA(BigDecimal cgstA);

	public BigDecimal getSgstA();

	public void setSgstA(BigDecimal sgstA);

	public BigDecimal getIgstA();

	public void setIgstA(BigDecimal igstA);

	public BigDecimal getSumAmtAfterTax();

	public void setSumAmtAfterTax(BigDecimal sumAmtAfterTax);

	public BigDecimal getTotalAmt();

	public void setTotalAmt(BigDecimal totalAmt);

	public BigDecimal getRoundOff();

	public void setRoundOff(BigDecimal roundOff);

	public BigDecimal getAmtPayable();

	public void setAmtPayable(BigDecimal amtPayable);

	public BigDecimal getSumQty();

	public void setSumQty(BigDecimal sumQty);

}
