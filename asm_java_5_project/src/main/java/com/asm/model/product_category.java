package com.asm.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class product_category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private 	Integer 		category_id;
	private 	String 			image;
	private 	String 			name;
	
	@OneToMany(mappedBy = "category")
	List<product> listProduct;
}
