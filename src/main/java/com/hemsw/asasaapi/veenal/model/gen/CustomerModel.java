package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "customer")
public class CustomerModel
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "state_id")
	private Integer stateId;

	@Column(name = "country_id")
	private Integer countryId;

	@Column(name = "pin")
	private String pin;

	@Column(name = "email")
	private String email;

	@Column(name = "gst_no")
	private String gstNo;

	@Column(name = "is_shipping_same_as_billing")
	private boolean isShippingSameAsBilling;

	@Column(name = "shipping_name")
	private String shippingName;

	@Column(name = "shipping_address")
	private String shippingAddress;

	@Column(name = "shipping_city")
	private String shippingCity;

	@Column(name = "shipping_state_id")
	private Integer shippingStateId;

	@Column(name = "shipping_country_id")
	private Integer shippingCountryId;

	@Column(name = "shipping_pin")
	private String shippingPin;

	@Column(name = "shipping_email")
	private String shippingEmail;

	@Column(name = "shipping_gst_no")
	private String shippingGstNo;

	@Column(name = "shipping_contact_no")
	private String shippingContactNo;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "bank_branch_name")
	private String bankBranchName;

	@Column(name = "bank_acct_name")
	private String bankAcctName;

	@Column(name = "bank_acct_no")
	private String bankAcctNo;

	@Column(name = "bank_ifsc")
	private String bankIfsc;

	@Column(name = "credit_days")
	private Integer creditDays;

	@Column(name = "credit_amt_limit")
	private BigDecimal creditAmtLimit;

	@Column(name = "disc")
	private BigDecimal disc;

	@Column(name = "pref_trans_id")
	private Integer prefTransId;

	@Column(name = "pref_agent_id")
	private Integer prefAgentId;

	@Column(name = "note")
	private String note;

	@Column(name = "has_image")
	private boolean hasImage;

	@Column(name = "old_id")
	private Integer oldId;

}
