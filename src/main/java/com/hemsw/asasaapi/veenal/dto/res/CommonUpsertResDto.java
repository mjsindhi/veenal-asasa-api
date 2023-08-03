package com.hemsw.asasaapi.veenal.dto.res;

import com.hemsw.asasaapi.veenal.util.ExceptionUtil;
import java.util.Date;
import lombok.ToString;

@ToString
public class CommonUpsertResDto
{

	private boolean isSuccess;
	private boolean hasException;
	private int createdId;
	private ErrorResDto errorResDto;

	public CommonUpsertResDto()
	{
		this.isSuccess = false;
		this.hasException = false;
		this.createdId = -1;
		this.errorResDto = null;
	}

	public CommonUpsertResDto(ErrorResDto errorResDto)
	{
		this.isSuccess = false;
		this.hasException = false;
		this.createdId = -1;
		this.errorResDto = errorResDto;
	}

	public CommonUpsertResDto(int createdId)
	{
		this.isSuccess = true;
		this.hasException = false;
		this.createdId = createdId;
		this.errorResDto = null;
	}

	public CommonUpsertResDto(Exception ex)
	{
		this.isSuccess = false;
		this.hasException = true;
		this.createdId = -1;
		this.errorResDto = new ErrorResDto(new Date(), "internal_server_error", ExceptionUtil.getString(ex), ExceptionUtil.getString(ex));

	}

	public CommonUpsertResDto(Exception... exceptions)
	{
		this.isSuccess = false;
		this.hasException = true;
		this.createdId = -1;
		this.errorResDto = new ErrorResDto();
		this.errorResDto.setTimestamp(new Date());
		this.errorResDto.setCode("internal_server_error");
		for (Exception exception : exceptions)
		{
			this.errorResDto.setDetails(this.errorResDto + "\n" + ExceptionUtil.getString(exception));
		}
		this.errorResDto.setMessage(this.errorResDto.getDetails());
	}

	public CommonUpsertResDto(boolean isSuccess, boolean hasException, int createdId, ErrorResDto errorResDto)
	{
		this.isSuccess = isSuccess;
		this.hasException = hasException;
		this.createdId = createdId;
		this.errorResDto = errorResDto;
	}

	public boolean isIsSuccess()
	{
		return isSuccess;
	}

	public void setIsSuccess(boolean isSuccess)
	{
		this.isSuccess = isSuccess;
	}

	public boolean isHasException()
	{
		return hasException;
	}

	public void setHasException(boolean hasException)
	{
		this.hasException = hasException;
	}

	public int getCreatedId()
	{
		return createdId;
	}

	public void setCreatedId(int createdId)
	{
		this.createdId = createdId;
	}

	public ErrorResDto getErrorResDto()
	{
		return errorResDto;
	}

	public void setErrorResDto(ErrorResDto errorResDto)
	{
		this.errorResDto = errorResDto;
	}

}
