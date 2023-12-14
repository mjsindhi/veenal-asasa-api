package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.dto.req.EstimateReqHoDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.security.UserDetailsImpl;
import com.hemsw.asasaapi.veenal.service.gen.EstimateSer;
import java.util.Date;
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
//@RequestMapping(path = "/estimates")
public class EstimateCont
{

	@Autowired
	EstimateSer estimateSer;

	@PostMapping("/estimates")
	public ResponseEntity create(@RequestBody EstimateReqHoDto estimateReqHoDto)
	{

		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserModel userModel = userDetailsImpl.getUserModel();

		CommonUpsertResDto commonUpsertResDto = estimateSer.create(estimateReqHoDto, userModel);

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

	@GetMapping("/estimates")
	public ResponseEntity getEstimates(
			@RequestParam(required = false) Integer no,
			@RequestParam(required = false) Date dateFrom,
			@RequestParam(required = false) Date dateTo,
			@RequestParam(required = false) Integer customerId,
			@RequestParam(required = false) String customerName,
			@RequestParam(required = false) String city,
			@RequestParam(required = false) Integer stateId,
			@RequestParam(required = false) String state,
			@RequestParam(required = false) String note,
			@RequestParam(required = false) Boolean convertedToSo,
			@RequestParam(required = false) Integer statusId
	)
	{
		CommonGetResDto commonGetResDto = estimateSer.getLdtos(
				no, dateFrom, dateTo, customerId, customerName, city, stateId, state, note, convertedToSo, statusId
		);

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
