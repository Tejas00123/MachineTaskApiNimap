package com.mt.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
     private Long id;
	
	@Column(length = 50)
     private String name;
	
     private Double price;
     
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "category_id", nullable = false)
     @JsonBackReference  // Prevent infinite recursion in JSON
     private Category category;
}
