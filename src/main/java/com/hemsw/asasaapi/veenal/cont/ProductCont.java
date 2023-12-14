package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.dto.req.ProductReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.enums.GetProdObjectType;
import com.hemsw.asasaapi.veenal.security.UserDetailsImpl;
import com.hemsw.asasaapi.veenal.service.gen.ProductSer;
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
public class ProductCont
{

	@Autowired
	ProductSer productSer;

	@PostMapping("/products")
	public ResponseEntity create(@RequestBody ProductReqDto productReqDto)
	{

		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserModel userModel = userDetailsImpl.getUserModel();

		CommonUpsertResDto commonUpsertResDto = productSer.create(productReqDto, userModel);

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

	@GetMapping("/products")
	public ResponseEntity getProducts(
			@RequestParam(required = false) GetProdObjectType returnObjectType,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer unitId,
			@RequestParam(required = false) Boolean withCategory,
			@RequestParam(required = false) Integer categoryId,
			@RequestParam(required = false) Boolean searchInSubCat,
			@RequestParam(required = false) String categoryName,
			@RequestParam(required = false) Integer taxCatId,
			@RequestParam(required = false) Boolean isMfg
	)
	{
		if (returnObjectType == null)
		{
			returnObjectType = GetProdObjectType.PROD;
		}

		CommonGetResDto commonGetResDto = null;

		switch (returnObjectType)
		{
			case PROD:
				commonGetResDto = productSer.getLdtos(name, unitId, withCategory, categoryId, searchInSubCat, categoryName, taxCatId, isMfg);
				break;
			case PROD_FOR_ESTIMATE:
				commonGetResDto = productSer.getProdForEstimate();
				break;
		}

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
