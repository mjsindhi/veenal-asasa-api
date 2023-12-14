package com.hemsw.asasaapi.veenal.dto.hdto;

import com.hemsw.asasaapi.veenal.enums.BalanceType;
import jakarta.persistence.Column;
import java.math.BigDecimal;

public class AcctJournalSumHdto
{

	@Column(name = "debit")
	private BigDecimal debit;

	@Column(name = "credit")
	private BigDecimal credit;

	public AcctJournalSumHdto(AcctJournalSumHdto acctJournalSumHdto)
	{
		this.debit = acctJournalSumHdto.debit;
		this.credit = acctJournalSumHdto.credit;
	}

	public BigDecimal getDebit()
	{
		return debit == null ? BigDecimal.ZERO : debit;
	}

	public void setDebit(BigDecimal debit)
	{
		this.debit = debit;
	}

	public BigDecimal getCredit()
	{
		return credit == null ? BigDecimal.ZERO : credit;
	}

	public void setCredit(BigDecimal credit)
	{
		this.credit = credit;
	}

	public void addDr(BigDecimal val)
	{
		if (val != null)
		{
			debit = debit.add(val);
		}
	}

	public void addCr(BigDecimal val)
	{
		if (val != null)
		{
			credit = credit.add(val);
		}
	}

	public boolean isDrBig()
	{
		if (debit == null)
		{
			debit = BigDecimal.ZERO;
		}
		if (credit == null)
		{
			credit = BigDecimal.ZERO;
		}
		return debit.compareTo(credit) > 0;
	}

	public boolean isCrBig()
	{
		if (debit == null)
		{
			debit = BigDecimal.ZERO;
		}
		if (credit == null)
		{
			credit = BigDecimal.ZERO;
		}
		return credit.compareTo(debit) > 0;
	}

	public boolean isCrDrSame()
	{
		if (debit == null)
		{
			debit = BigDecimal.ZERO;
		}
		if (credit == null)
		{
			credit = BigDecimal.ZERO;
		}
		return credit.compareTo(debit) == 0;
	}

	public BigDecimal getCrBal()
	{
		if (debit == null)
		{
			debit = BigDecimal.ZERO;
		}
		if (credit == null)
		{
			credit = BigDecimal.ZERO;
		}
		return credit.subtract(debit);
	}

	public BigDecimal getDrBal()
	{
		if (debit == null)
		{
			debit = BigDecimal.ZERO;
		}
		if (credit == null)
		{
			credit = BigDecimal.ZERO;
		}
		return debit.subtract(credit);
	}

	public BigDecimal getFinalBalance()
	{
		if (debit == null)
		{
			debit = BigDecimal.ZERO;
		}
		if (credit == null)
		{
			credit = BigDecimal.ZERO;
		}

		int comparisionRes = debit.compareTo(credit);
		if (comparisionRes < 0)
		{
			return credit.subtract(debit);
		}
		//else if (comparisionRes >= 0)
		else
		{
			return debit.subtract(credit);
		}
	}

	public BalanceType getFinalBalanceType()
	{
		if (debit == null)
		{
			debit = BigDecimal.ZERO;
		}
		if (credit == null)
		{
			credit = BigDecimal.ZERO;
		}

		int comparisionRes = debit.compareTo(credit);
		if (comparisionRes < 0)
		{
			return BalanceType.PAYABLE_CR_RCVD;
		}
		//else if (comparisionRes >= 0)
		else
		{
			return BalanceType.RECIEVABLE_DR_PAID;
		}
	}

	@Override
	public String toString()
	{
		return "BalSumHdto{" + "debit=" + debit + ", credit=" + credit + '}';
	}

}
