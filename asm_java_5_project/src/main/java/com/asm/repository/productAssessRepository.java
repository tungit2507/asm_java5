package com.asm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asm.model.product;
import com.asm.model.product_access;

import jakarta.persistence.criteria.CriteriaBuilder.In;
@Repository
public interface productAssessRepository extends JpaRepository<product_access, Integer>{
	 List<product_access> findByProduct(product product);
	 @Query(value = "select AVG(start_rate) from product_access where product_id = ?1", nativeQuery = true)
	 Integer avgStart_rate(Integer id);
	 @Query(value = "select COUNT(review_id) from product_access where product_id = ?1", nativeQuery = true)
	 Integer countProductAccess(String id);
}
