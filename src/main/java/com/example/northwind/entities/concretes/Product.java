package com.example.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.northwind.entities.abstracts.IEntity;

import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Product implements IEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) //id alanının veritabanında oluşturulması  için strateji/sql de Auto yaygın
	@Column(name="product_id")
	private int id;
	@Column(name = "category_id")
	private int categoryId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "unit_price")
	private double unitPrice;
	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;

}
