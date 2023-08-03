package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.dao.gen.SupplierDao;
import com.hemsw.asasaapi.veenal.dto.ldto.SupplierLdto;
import com.hemsw.asasaapi.veenal.dto.req.SupplierReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.security.UserDetailsImpl;
import com.hemsw.asasaapi.veenal.service.SupplierSer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierCont
{

	@Autowired
	SupplierSer supplierSer;

	@Autowired
	SupplierDao supplierDao;

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
	public ResponseEntity index()
	{
		List<SupplierLdto> supplierLdtos = supplierDao.getLdtos(
				null,
				null,
				null,
				null,
				null
		);
		return ResponseEntity
				.ok(supplierLdtos);
	}
}
