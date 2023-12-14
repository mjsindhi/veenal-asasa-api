package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.AcctContactNoModel;
import com.hemsw.asasaapi.veenal.model.gen.AcctModel;
import com.hemsw.asasaapi.veenal.model.gen.SupplierModel;
import com.hemsw.asasaapi.veenal.model.gen.SupplierPriceListModel;
import java.util.List;

public class SupplierHoDto
{

	AcctModel acctModel;
	SupplierModel supplierModel;

	List<AcctContactNoModel> acctContactNoModels;
	List<SupplierPriceListModel> supplierPriceListModels;

	public AcctModel getAcctModel()
	{
		return acctModel;
	}

	public void setAcctModel(AcctModel acctModel)
	{
		this.acctModel = acctModel;
	}

	public SupplierModel getSupplierModel()
	{
		return supplierModel;
	}

	public void setSupplierModel(SupplierModel supplierModel)
	{
		this.supplierModel = supplierModel;
	}

	public List<AcctContactNoModel> getAcctContactNoModels()
	{
		return acctContactNoModels;
	}

	public void setAcctContactNoModels(List<AcctContactNoModel> acctContactNoModels)
	{
		this.acctContactNoModels = acctContactNoModels;
	}

	public List<SupplierPriceListModel> getSupplierPriceListModels()
	{
		return supplierPriceListModels;
	}

	public void setSupplierPriceListModels(List<SupplierPriceListModel> supplierPriceListModels)
	{
		this.supplierPriceListModels = supplierPriceListModels;
	}

}
