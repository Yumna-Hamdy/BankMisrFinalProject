package com.example.finalProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category {  //The linking Table,the movie can relate to multiple categories
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String catName;
	
}
