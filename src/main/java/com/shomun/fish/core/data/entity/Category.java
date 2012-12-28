package com.shomun.fish.core.data.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.shomun.fish.core.data.entity.EntityBase;

@Entity
@Table(name="m_category")
public class Category extends EntityBase {
	
	@Id
//	@GeneratedValue
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="description")
	private String description;
	
	@Column(name="parent_id")
	private String parentId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	
	
}
