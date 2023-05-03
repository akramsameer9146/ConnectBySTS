package com.infy.projectname.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Id
		private int productId;
		private String productName;
		private String productPrice;
		
		@ManyToOne
		private Supplier supplier;

}