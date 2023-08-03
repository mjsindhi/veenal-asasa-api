package com.hemsw.asasaapi.veenal.dto.res;

import com.hemsw.asasaapi.veenal.util.ExceptionUtil;
import java.util.Date;
import lombok.ToString;

@ToString
public class CommonGetOneResDto<T>
{

	private boolean isSuccess;
	private boolean hasException;
	private T item;
	private ErrorResDto errorResDto;

	public CommonGetOneResDto()
	{
		this.isSuccess = false;
		this.hasException = false;
		this.item = null;
		this.errorResDto = null;
	}

	public CommonGetOneResDto(T item)
	{
		this.isSuccess = true;
		this.hasException = false;
		this.item = item;
		this.errorResDto = null;
	}

	public CommonGetOneResDto(ErrorResDto errorResDto)
	{
		this.isSuccess = false;
		this.hasException = false;
		this.item = null;
		this.errorResDto = errorResDto;
	}

	public CommonGetOneResDto(Exception ex)
	{
		this.isSuccess = false;
		this.hasException = true;
		this.item = null;
		this.errorResDto = new ErrorResDto(new Date(), "internal_server_error", ExceptionUtil.getString(ex), ExceptionUtil.getString(ex));
	}

	public CommonGetOneResDto(Exception... exceptions)
	{
		this.isSuccess = false;
		this.hasException = true;
		this.item = null;
		this.errorResDto.setTimestamp(new Date());
		this.errorResDto.setCode("internal_server_error");
		for (Exception exception : exceptions)
		{
			this.errorResDto.setDetails(this.errorResDto + "\n" + ExceptionUtil.getString(exception));
		}
		this.errorResDto.setMessage(this.errorResDto.getDetails());
	}

	public CommonGetOneResDto(boolean isSuccess, boolean hasException, T item, ErrorResDto errorResDto)
	{
		this.isSuccess = isSuccess;
		this.hasException = hasException;
		this.item = item;
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

	public T getItem()
	{
		return item;
	}

	public void setItem(T item)
	{
		this.item = item;
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
