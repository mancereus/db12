package de.db12.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StaticEntity {
	@Id
	private long id;
	
	@Column(unique=true)
	private String extid;
	
	@Column(length=255)
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setExtid(String extid) {
		this.extid = extid;
	}

	public String getExtid() {
		return extid;
	}

	public long getId() {
		return id;
	}
	
	
}
