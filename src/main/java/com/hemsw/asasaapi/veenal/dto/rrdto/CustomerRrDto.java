package com.hemsw.asasaapi.veenal.dto.rrdto;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class CustomerRrDto
{

	private String name;
	private String address;
	private String city;
	private Integer stateId;
	private Integer countryId;
	private String pin;
	private String email;
	private String gstNo;
	private boolean isShippingSameAsBilling;
	private String shippingName;
	private String shippingAddress;
	private String shippingCity;
	private Integer shippingStateId;
	private Integer shippingCountryId;
	private String shippingPin;
	private String shippingEmail;
	private String shippingGstNo;
	private String shippingContactNo;
	private String bankName;
	private String bankBranchName;
	private String bankAcctName;
	private String bankAcctNo;
	private String bankIfsc;
	private Integer creditDays;
	private BigDecimal creditAmtLimit;
	private BigDecimal disc;
	private Integer prefTransId;
	private Integer prefAgentId;
	private String note;
	private BigDecimal ob;
	private Integer obTypeId;
}
