package com.hemsw.asasaapi.veenal.dto.res;

import com.hemsw.asasaapi.veenal.util.ExceptionUtil;
import java.util.Date;
import java.util.List;
import lombok.ToString;

@ToString
public class CommonGetResDto<T>
{

	private boolean isSuccess;
	private boolean hasException;
	private List<T> rows;
	private ErrorResDto errorResDto;

	public CommonGetResDto()
	{
		this.isSuccess = false;
		this.hasException = false;
		this.rows = null;
		this.errorResDto = null;
	}

	public CommonGetResDto(List<T> rows)
	{
		this.isSuccess = true;
		this.hasException = false;
		this.rows = rows;
		this.errorResDto = null;
	}

	public CommonGetResDto(ErrorResDto errorResDto)
	{
		this.isSuccess = false;
		this.hasException = false;
		this.rows = null;
		this.errorResDto = errorResDto;
	}

	public CommonGetResDto(Exception ex)
	{
		this.isSuccess = false;
		this.hasException = true;
		this.rows = null;
		this.errorResDto = new ErrorResDto(new Date(), "internal_server_error", ExceptionUtil.getString(ex), ExceptionUtil.getString(ex));
	}

	public CommonGetResDto(Exception... exceptions)
	{
		this.isSuccess = false;
		this.hasException = true;
		this.rows = null;
		this.errorResDto = new ErrorResDto();
		this.errorResDto.setTimestamp(new Date());
		this.errorResDto.setCode("internal_server_error");
		for (Exception exception : exceptions)
		{
			this.errorResDto.setDetails(this.errorResDto + "\n" + ExceptionUtil.getString(exception));
		}
		this.errorResDto.setMessage(this.errorResDto.getDetails());
	}

	public CommonGetResDto(boolean isSuccess, boolean hasException, List<T> rows, ErrorResDto errorResDto)
	{
		this.isSuccess = isSuccess;
		this.hasException = hasException;
		this.rows = rows;
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

	public List<T> getRows()
	{
		return rows;
	}

	public void setRows(List<T> rows)
	{
		this.rows = rows;
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
