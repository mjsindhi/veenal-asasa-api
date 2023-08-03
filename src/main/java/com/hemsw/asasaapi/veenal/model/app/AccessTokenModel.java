package com.hemsw.asasaapi.veenal.model.app;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@Entity
@Table(name = "access_token")
public class AccessTokenModel
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "token", columnDefinition = "char")
	private String token;

	@Transient
	@Column(name = "created_at")
	private Date createdAt;

	@Transient
	@Column(name = "expiry_at")
	private Date expiryAt;

}
