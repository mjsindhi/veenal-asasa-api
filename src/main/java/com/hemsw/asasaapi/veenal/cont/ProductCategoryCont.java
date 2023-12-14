package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.dto.ldto.ProductCategoryLdto;
import com.hemsw.asasaapi.veenal.dto.req.ProductCatReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.security.UserDetailsImpl;
import com.hemsw.asasaapi.veenal.service.gen.ProductCatSer;
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
//@RequestMapping(path = "/productCategorys")
public class ProductCategoryCont
{

	@Autowired
	ProductCatSer productCatSer;

	@PostMapping("/product-categories")
	public ResponseEntity create(@RequestBody ProductCatReqDto productCatReqDto)
	{

		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserModel userModel = userDetailsImpl.getUserModel();

		CommonUpsertResDto commonUpsertResDto = productCatSer.create(productCatReqDto, userModel);

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

	@GetMapping("/product-categories")
	public ResponseEntity getProductCategories(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Boolean withParent,
			@RequestParam(required = false) Integer parentId,
			@RequestParam(required = false) Boolean searchInSubCat,
			@RequestParam(required = false) String parentCatName
	)
	{
		CommonGetResDto<List<ProductCategoryLdto>> commonGetResDto = productCatSer.getLdtos(name, withParent, parentId, searchInSubCat, parentCatName);

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
