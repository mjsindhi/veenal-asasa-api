package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.dto.hdto.AccessRolePermHdto;
import com.hemsw.asasaapi.veenal.model.app.AccessRoleModel;

public class AccessRoleHoDto
{

	AccessRoleModel accessRoleModel;
	AccessRolePermHdto accessRolePermHdto;

	public AccessRoleModel getAccessRoleModel()
	{
		return accessRoleModel;
	}

	public void setAccessRoleModel(AccessRoleModel accessRoleModel)
	{
		this.accessRoleModel = accessRoleModel;
	}

	public AccessRolePermHdto getAccessRolePermHdto()
	{
		return accessRolePermHdto;
	}

	public void setAccessRolePermHdto(AccessRolePermHdto accessRolePermHdto)
	{
		this.accessRolePermHdto = accessRolePermHdto;
	}

}
