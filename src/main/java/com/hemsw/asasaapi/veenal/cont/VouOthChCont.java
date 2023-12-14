package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.enums.GetVouOthChObjectType;
import com.hemsw.asasaapi.veenal.enums.VoucherType;
import com.hemsw.asasaapi.veenal.model.gen.VouOthChModel;
import com.hemsw.asasaapi.veenal.service.gen.VouOthChSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VouOthChCont
{

	@Autowired
	VouOthChSer vouOthChSer;

	@GetMapping("/voucher-other-charges")
	public ResponseEntity getVouOthChs(
			@RequestParam(required = false) GetVouOthChObjectType returnObjectType,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) VouOthChModel.CalcOnType calOnType,
			@RequestParam(required = false) Boolean isTaxable,
			@RequestParam(required = false) VoucherType voucherType,
			@RequestParam(required = false) Boolean isSystem
	)
	{
		if (returnObjectType == null)
		{
			returnObjectType = GetVouOthChObjectType.VOU_OTH_CH;
		}
		CommonGetResDto commonGetResDto = null;

		if (returnObjectType == GetVouOthChObjectType.VOU_OTH_CH)
		{
			commonGetResDto = vouOthChSer.getLdtos(name);
		}
		else if (returnObjectType == GetVouOthChObjectType.VOU_OTH_CH_FOR_ESTIMATE)
		{
			commonGetResDto = vouOthChSer.get(calOnType, isTaxable, voucherType, isSystem);
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
