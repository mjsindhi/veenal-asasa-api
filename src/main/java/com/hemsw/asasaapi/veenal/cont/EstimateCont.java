package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.dto.rr.EstimateRrHoDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonDeleteResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetOneResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.security.UserDetailsImpl;
import com.hemsw.asasaapi.veenal.service.gen.EstimateSer;
import com.hemsw.asasaapi.veenal.util.Util;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity createEstimate(@RequestBody EstimateRrHoDto estimateReqHoDto)
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

	@PutMapping("/estimates/{id}")
	public ResponseEntity updateEstimate(
			@PathVariable("id") String idStr,
			@RequestBody EstimateRrHoDto estimateReqHoDto
	)
	{

		if (idStr == null)
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResDto(
							new Date(),
							"id_invalid",
							"Enter valid id",
							"Enter valid id"
					));
		}

		if (!Util.isInt(idStr))
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResDto(
							new Date(),
							"id_invalid",
							"Enter valid id",
							"Enter valid id"
					));
		}

		int id = Integer.parseInt(idStr);

		CommonUpsertResDto commonUpsertResDto = estimateSer.update(id, estimateReqHoDto);

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

	@GetMapping("/estimates/{id}")
	public ResponseEntity getEstimate(@PathVariable("id") String idStr)
	{
		if (idStr == null)
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResDto(
							new Date(),
							"id_invalid",
							"Enter valid id",
							"Enter valid id"
					));
		}

		if (!Util.isInt(idStr))
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResDto(
							new Date(),
							"id_invalid",
							"Enter valid id",
							"Enter valid id"
					));
		}

		int id = Integer.parseInt(idStr);

		CommonGetOneResDto<EstimateRrHoDto> commonGetOneResDto = estimateSer.getRrHoDtoById(id);

		if (commonGetOneResDto.isHasException())
		{
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(commonGetOneResDto.getErrorResDto());
		}

		if (!commonGetOneResDto.isIsSuccess())
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(commonGetOneResDto.getErrorResDto());
		}

		return ResponseEntity.ok(commonGetOneResDto.getItem());
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

	@DeleteMapping("/estimates/{id}")
	public ResponseEntity deleteEstimate(@PathVariable("id") String idStr)
	{
		if (idStr == null)
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResDto(
							new Date(),
							"id_invalid",
							"Enter valid id",
							"Enter valid id"
					));
		}

		if (!Util.isInt(idStr))
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResDto(
							new Date(),
							"id_invalid",
							"Enter valid id",
							"Enter valid id"
					));
		}

		int id = Integer.parseInt(idStr);

		CommonDeleteResDto commonDeleteResDto = estimateSer.delete(id);

		if (commonDeleteResDto.isHasException())
		{
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(commonDeleteResDto.getErrorResDto());
		}

		if (!commonDeleteResDto.isIsSuccess())
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(commonDeleteResDto.getErrorResDto());
		}

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}
