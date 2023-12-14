package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dto.res.CommonGetOneResDto;
import com.hemsw.asasaapi.veenal.dto.res.MenuResDto;
import com.hemsw.asasaapi.veenal.mapper.MenuMapper;
import com.hemsw.asasaapi.veenal.model.app.MenuModel;
import com.hemsw.asasaapi.veenal.repo.app.HomeMenuCustRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuSer
{

	@Autowired
	private HomeMenuCustRepo homeMenuCustRepo;

	public CommonGetOneResDto<MenuResDto> get()
	{

		MenuResDto menuResDto = new MenuResDto();
		addChildren(menuResDto);

		return new CommonGetOneResDto<>(menuResDto);
	}

	private void addChildren(MenuResDto menuResDto)
	{
		List<MenuModel> homeMenuCustModels;

		if (menuResDto.getId() <= 0)
		{
			homeMenuCustModels = homeMenuCustRepo.getByParentId(null);
		}
		else
		{
			homeMenuCustModels = homeMenuCustRepo.getByParentId(menuResDto.getId());
		}

		List<MenuResDto> menuResDtos = new ArrayList<>();
		for (MenuModel homeMenuCustModel : homeMenuCustModels)
		{
			MenuResDto menuResDtoInner = MenuMapper.toMenuResDto(homeMenuCustModel);
			addChildren(menuResDtoInner);
			menuResDtos.add(menuResDtoInner);
		}
		menuResDto.setMenuResDtos(menuResDtos);
	}
}
