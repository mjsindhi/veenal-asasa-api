package com.hemsw.asasaapi.veenal;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Transient;
import org.springframework.data.domain.Persistable;

@MappedSuperclass
public abstract class AbstractEntity<ID> implements Persistable<ID>
{

	@Transient
	private boolean isNew = true;

	@Override
	public boolean isNew()
	{
		return isNew;
	}

	@PrePersist
	@PostLoad
	void markNotNew()
	{
		this.isNew = false;
	}

	// More code…
}
