package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.enums.GetAcctsObjectType;
import static com.hemsw.asasaapi.veenal.enums.GetAcctsObjectType.ACCT_LIST_FOR_CUSTOMER_HDTO;
import com.hemsw.asasaapi.veenal.service.gen.AcctSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcctCont
{

	@Autowired
	AcctSer acctSer;

	@GetMapping("/accounts")
	public ResponseEntity getAccts(
			@RequestParam(required = false) GetAcctsObjectType returnObjectType,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer acctTypeId,
			@RequestParam(required = false) String acctType
	)
	{

		if (returnObjectType == null)
		{
			returnObjectType = GetAcctsObjectType.ACCT;
		}

		CommonGetResDto commonGetResDto = null;

		switch (returnObjectType)
		{
			case ACCT:
				commonGetResDto = acctSer.getLdtos(name, acctTypeId, acctType);
				break;
			case ACCT_LIST_FOR_CUSTOMER_HDTO:
				commonGetResDto = acctSer.getAcctListForCustomerHdtos(null);
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
