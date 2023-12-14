package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.dao.gen.SupplierDao;
import com.hemsw.asasaapi.veenal.dto.req.SupplierReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.security.UserDetailsImpl;
import com.hemsw.asasaapi.veenal.service.gen.SupplierSer;
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
public class SupplierCont
{

	@Autowired
	SupplierSer supplierSer;

	@PostMapping("/suppliers")
	public ResponseEntity create(@RequestBody SupplierReqDto supplierReqDto)
	{

		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserModel userModel = userDetailsImpl.getUserModel();

		CommonUpsertResDto commonUpsertResDto = supplierSer.create(supplierReqDto, userModel);

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

	@GetMapping("/suppliers")
	public ResponseEntity getSuppliers(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String city,
			@RequestParam(required = false) Integer stateId,
			@RequestParam(required = false) String state,
			@RequestParam(required = false) String no
	)
	{
		CommonGetResDto commonGetResDto = supplierSer.getLdtos(name, city, stateId, state, no);

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
