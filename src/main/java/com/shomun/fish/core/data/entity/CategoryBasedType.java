package com.shomun.fish.core.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="m_category_based_type")
public class CategoryBasedType extends EntityBase {

	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="nameResocurceKey")
	private String nameResocurceKey;
	
	@Column(name="descResocurceKey")
	private String descResocurceKey;
	
	@Column(name="parentId")
	private long parentId;
	
	@Column(name="categoryId")
	private String categoryId;

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

	public String getNameResocurceKey() {
		return nameResocurceKey;
	}

	public void setNameResocurceKey(String nameResocurceKey) {
		this.nameResocurceKey = nameResocurceKey;
	}

	public String getDescResocurceKey() {
		return descResocurceKey;
	}

	public void setDescResocurceKey(String descResocurceKey) {
		this.descResocurceKey = descResocurceKey;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
	
	
}
