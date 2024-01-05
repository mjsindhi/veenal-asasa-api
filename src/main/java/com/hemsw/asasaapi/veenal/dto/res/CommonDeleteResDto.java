package com.hemsw.asasaapi.veenal.dto.res;

import java.util.Date;
import lombok.ToString;

@ToString
public class CommonDeleteResDto
{

	private boolean isSuccess;
	private boolean hasException;
	private ErrorResDto errorResDto;

	public CommonDeleteResDto()
	{
		this.isSuccess = true;
		this.hasException = false;
		this.errorResDto = null;
	}

	public CommonDeleteResDto(ErrorResDto errorResDto)
	{
		this.isSuccess = false;
		this.hasException = false;
		this.errorResDto = errorResDto;
	}

	public CommonDeleteResDto(Exception ex)
	{
		this.isSuccess = false;
		this.hasException = true;
		//this.errorMsg = ExceptionUtil.getString(ex);
		this.errorResDto = new ErrorResDto(
				new Date(),
				"internal_server_error",
				"Internal server error occured",
				"Internal server error occured"
		);
	}

	public CommonDeleteResDto(Exception... exceptions)
	{
		this.isSuccess = false;
		this.hasException = true;
		/*
		this.errorResDto.setTimestamp(new Date());
		this.errorResDto.setCode("internal_server_error");
		for (Exception exception : exceptions)
		{
			this.errorResDto.setDetails(this.errorResDto + "\n" + ExceptionUtil.getString(exception));
		}
		this.errorResDto.setMessage(this.errorResDto.getDetails());
		 */
		this.errorResDto = new ErrorResDto(
				new Date(),
				"internal_server_error",
				"Internal server error occured",
				"Internal server error occured"
		);
	}

	public CommonDeleteResDto(boolean isSuccess, boolean hasException, ErrorResDto errorResDto)
	{
		this.isSuccess = isSuccess;
		this.hasException = hasException;
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

	public ErrorResDto getErrorResDto()
	{
		return errorResDto;
	}

	public void setErrorResDto(ErrorResDto errorResDto)
	{
		this.errorResDto = errorResDto;
	}

}
