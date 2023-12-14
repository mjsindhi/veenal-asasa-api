package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.AcctContactNoModel;
import com.hemsw.asasaapi.veenal.model.gen.AcctGrpModel;
import com.hemsw.asasaapi.veenal.model.gen.AcctModel;
import com.hemsw.asasaapi.veenal.model.gen.CustomerAgentCommListModel;
import com.hemsw.asasaapi.veenal.model.gen.CustomerAgentCommModel;
import com.hemsw.asasaapi.veenal.model.gen.CustomerAgentModel;
import com.hemsw.asasaapi.veenal.model.gen.CustomerCommListModel;
import com.hemsw.asasaapi.veenal.model.gen.CustomerCommModel;
import com.hemsw.asasaapi.veenal.model.gen.CustomerDiscModel;
import com.hemsw.asasaapi.veenal.model.gen.CustomerModel;
import com.hemsw.asasaapi.veenal.model.gen.CustomerPriceListAModel;
import com.hemsw.asasaapi.veenal.model.gen.CustomerPriceListBModel;
import java.util.List;

public class CustomerHoDto
{

	AcctModel acctModel;
	CustomerModel customerModel;

	List<AcctContactNoModel> acctContactNoModels;
	List<AcctGrpModel> acctGrpModels;
	List<CustomerAgentModel> customerAgentModels;
	List<CustomerAgentCommListModel> customerAgentCommListModels;
	List<CustomerAgentCommModel> customerAgentCommModels;
	List<CustomerCommListModel> customerCommListModels;
	List<CustomerCommModel> customerCommModels;
	List<CustomerDiscModel> customerDiscModels;
	List<CustomerPriceListAModel> customerPriceListAModels;
	List<CustomerPriceListBModel> customerPriceListBModels;

	public AcctModel getAcctModel()
	{
		return acctModel;
	}

	public void setAcctModel(AcctModel acctModel)
	{
		this.acctModel = acctModel;
	}

	public CustomerModel getCustomerModel()
	{
		return customerModel;
	}

	public void setCustomerModel(CustomerModel customerModel)
	{
		this.customerModel = customerModel;
	}

	public List<AcctContactNoModel> getAcctContactNoModels()
	{
		return acctContactNoModels;
	}

	public void setAcctContactNoModels(List<AcctContactNoModel> acctContactNoModels)
	{
		this.acctContactNoModels = acctContactNoModels;
	}

	public List<AcctGrpModel> getAcctGrpModels()
	{
		return acctGrpModels;
	}

	public void setAcctGrpModels(List<AcctGrpModel> acctGrpModels)
	{
		this.acctGrpModels = acctGrpModels;
	}

	public List<CustomerAgentModel> getCustomerAgentModels()
	{
		return customerAgentModels;
	}

	public void setCustomerAgentModels(List<CustomerAgentModel> customerAgentModels)
	{
		this.customerAgentModels = customerAgentModels;
	}

	public List<CustomerAgentCommListModel> getCustomerAgentCommListModels()
	{
		return customerAgentCommListModels;
	}

	public void setCustomerAgentCommListModels(List<CustomerAgentCommListModel> customerAgentCommListModels)
	{
		this.customerAgentCommListModels = customerAgentCommListModels;
	}

	public List<CustomerAgentCommModel> getCustomerAgentCommModels()
	{
		return customerAgentCommModels;
	}

	public void setCustomerAgentCommModels(List<CustomerAgentCommModel> customerAgentCommModels)
	{
		this.customerAgentCommModels = customerAgentCommModels;
	}

	public List<CustomerCommListModel> getCustomerCommListModels()
	{
		return customerCommListModels;
	}

	public void setCustomerCommListModels(List<CustomerCommListModel> customerCommListModels)
	{
		this.customerCommListModels = customerCommListModels;
	}

	public List<CustomerCommModel> getCustomerCommModels()
	{
		return customerCommModels;
	}

	public void setCustomerCommModels(List<CustomerCommModel> customerCommModels)
	{
		this.customerCommModels = customerCommModels;
	}

	public List<CustomerDiscModel> getCustomerDiscModels()
	{
		return customerDiscModels;
	}

	public void setCustomerDiscModels(List<CustomerDiscModel> customerDiscModels)
	{
		this.customerDiscModels = customerDiscModels;
	}

	public List<CustomerPriceListAModel> getCustomerPriceListAModels()
	{
		return customerPriceListAModels;
	}

	public void setCustomerPriceListAModels(List<CustomerPriceListAModel> customerPriceListAModels)
	{
		this.customerPriceListAModels = customerPriceListAModels;
	}

	public List<CustomerPriceListBModel> getCustomerPriceListBModels()
	{
		return customerPriceListBModels;
	}

	public void setCustomerPriceListBModels(List<CustomerPriceListBModel> customerPriceListBModels)
	{
		this.customerPriceListBModels = customerPriceListBModels;
	}

}
