package com.hemsw.asasaapi.veenal.dto.req;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class SupplierReqDto
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
	private Integer deliveryDays;
	private String note;
	private BigDecimal ob;
	private Integer obTypeId;
}
