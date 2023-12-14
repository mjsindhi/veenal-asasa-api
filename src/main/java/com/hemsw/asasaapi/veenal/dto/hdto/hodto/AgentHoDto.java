package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.AcctContactNoModel;
import com.hemsw.asasaapi.veenal.model.gen.AcctModel;
import com.hemsw.asasaapi.veenal.model.gen.AgentCommListModel;
import com.hemsw.asasaapi.veenal.model.gen.AgentCommModel;
import com.hemsw.asasaapi.veenal.model.gen.AgentModel;
import java.util.List;

public class AgentHoDto
{

	AcctModel acctModel;
	AgentModel agentModel;
	List<AcctContactNoModel> acctContactNoModels;
	List<AgentCommModel> agentCommModels;
	List<AgentCommListModel> agentCommListModels;

	public AcctModel getAcctModel()
	{
		return acctModel;
	}

	public void setAcctModel(AcctModel acctModel)
	{
		this.acctModel = acctModel;
	}

	public AgentModel getAgentModel()
	{
		return agentModel;
	}

	public void setAgentModel(AgentModel agentModel)
	{
		this.agentModel = agentModel;
	}

	public List<AcctContactNoModel> getAcctContactNoModels()
	{
		return acctContactNoModels;
	}

	public void setAcctContactNoModels(List<AcctContactNoModel> acctContactNoModels)
	{
		this.acctContactNoModels = acctContactNoModels;
	}

	public List<AgentCommModel> getAgentCommModels()
	{
		return agentCommModels;
	}

	public void setAgentCommModels(List<AgentCommModel> agentCommModels)
	{
		this.agentCommModels = agentCommModels;
	}

	public List<AgentCommListModel> getAgentCommListModels()
	{
		return agentCommListModels;
	}

	public void setAgentCommListModels(List<AgentCommListModel> agentCommListModels)
	{
		this.agentCommListModels = agentCommListModels;
	}

}
