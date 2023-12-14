package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.dto.ldto.TaxCategoryLdto;
import com.hemsw.asasaapi.veenal.dto.req.TaxCatReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.security.UserDetailsImpl;
import com.hemsw.asasaapi.veenal.service.gen.TaxCatSer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path = "/taxCategoryegorys")
public class TaxCatCont
{

	@Autowired
	TaxCatSer taxCatSer;

	@PostMapping("/tax-categories")
	public ResponseEntity create(@RequestBody TaxCatReqDto taxCatReqDto)
	{

		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserModel userModel = userDetailsImpl.getUserModel();

		CommonUpsertResDto commonUpsertResDto = taxCatSer.create(taxCatReqDto, userModel);

		if (commonUpsertResDto.isHasException())
		{
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(commonUpsertResDto.getErrorResDto());
		}

		if (!commonUpsertResDto.isIsSuccess())
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(commonUpsertResDto.getErrorResDto());
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

	@GetMapping("/tax-categories")
	public ResponseEntity getTaxCategories(
			@RequestParam(required = false) String name
	)
	{
		CommonGetResDto<List<TaxCategoryLdto>> commonGetResDto = taxCatSer.getLdtos(name);

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
