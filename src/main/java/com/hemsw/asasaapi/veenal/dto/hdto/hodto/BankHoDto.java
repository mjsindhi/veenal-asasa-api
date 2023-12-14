package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.AcctModel;
import com.hemsw.asasaapi.veenal.model.gen.BankModel;

public class BankHoDto
{

	AcctModel acctModel;
	BankModel bankModel;

	public AcctModel getAcctModel()
	{
		return acctModel;
	}

	public void setAcctModel(AcctModel acctModel)
	{
		this.acctModel = acctModel;
	}

	public BankModel getBankModel()
	{
		return bankModel;
	}

	public void setBankModel(BankModel bankModel)
	{
		this.bankModel = bankModel;
	}

}
