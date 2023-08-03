package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.res.MenuResDto;
import com.hemsw.asasaapi.veenal.model.app.MenuModel;

public class MenuMapper
{

	public static MenuResDto toMenuResDto(MenuModel menuModel)
	{
		return new MenuResDto()
				.setId(menuModel.getId())
				.setSeqNo(menuModel.getSeqNo())
				.setName(menuModel.getName())
				.setDisplayName(menuModel.getDisplayName())
				.setParentId(menuModel.getParentId())
				.setSystemMenu(menuModel.isSystemMenu())
				.setHasAdd(menuModel.isHasAdd());
	}
}
