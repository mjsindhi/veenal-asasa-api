package com.hemsw.asasaapi.veenal.dto.req;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class CustomerReqDto
{

	private String name;
	private String address;
	private String city;
	private Integer stateId;
	private String pin;
	private String email;
	private String gstNo;
	private String bankName;
	private String bankBranchName;
	private String bankAcctName;
	private String bankAcctNo;
	private String bankIfsc;
	private Integer creditDays;
	private BigDecimal creditAmtLimit;
	private BigDecimal disc;
	private Integer prefTransId;
	private String note;
	private BigDecimal ob;
	private Integer obTypeId;
}
