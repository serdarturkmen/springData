package com.example.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Category extends BaseModel {

	
	public Category() {
		super();
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "BaseCategoryId")
	private Category baseCategory;
}
