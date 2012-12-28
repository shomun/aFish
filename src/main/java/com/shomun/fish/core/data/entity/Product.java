package com.shomun.fish.core.data.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.shomun.fish.core.data.entity.EntityBase;

@Entity
@Table(name="m_product")
public class Product extends EntityBase {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="description")
	private String description;
	
	@Column(name="unit")
	private String unit;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="shop_id")
	private long shopId;
	
	@Column(name="category_id")
	private String categoryId;
	
	@OneToMany(cascade =CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="m_product_categorybasedtype_mapping",joinColumns={@JoinColumn(name="product_id")},inverseJoinColumns={@JoinColumn(name="category_base_type_id")})
	private List<CategoryBasedType> categoryBaseTypes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public List<CategoryBasedType> getCategoryBaseTypes() {
		return categoryBaseTypes;
	}

	public void setCategoryBaseTypes(List<CategoryBasedType> categoryBaseTypes) {
		this.categoryBaseTypes = categoryBaseTypes;
	}

	public void addCategory(CategoryBasedType categoryBaseType) {
		if(this.categoryBaseTypes == null){
			this.categoryBaseTypes = new ArrayList<CategoryBasedType>();
		}
		this.categoryBaseTypes.add(categoryBaseType);
	}

	
	
	
	
}
