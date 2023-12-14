package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.model.app.ColSettingModel;
import com.hemsw.asasaapi.veenal.service.app.ColSettingSer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColSettingCont
{

	@Autowired
	ColSettingSer colSettingSer;

	@GetMapping("/menus/{menuId}/col-settings")
	public ResponseEntity getColSettings(
			@PathVariable("menuId") int menuId,
			@RequestParam(name = "isVisible", required = false) Boolean isVisible)
	{
		if (isVisible == null)
		{
			isVisible = true;
		}

		CommonGetResDto<List<ColSettingModel>> commonGetResDto
				= colSettingSer.getByMenuIdForSelect(menuId, isVisible);

		if (commonGetResDto.isHasException())
		{
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(commonGetResDto.getErrorResDto());
		}

		if (!commonGetResDto.isIsSuccess())
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(commonGetResDto.getErrorResDto());
		}

		return ResponseEntity.ok(commonGetResDto.getRows());
	}
}
