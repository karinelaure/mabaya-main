package com.mabaya.repository;



import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mabaya.model.Product;
 
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query(value = "select p from Product p join p.campaigns c where c.startDate >= :fromDate and p.category = :category and p.campaigns IS NOT EMPTY order by c.bid desc " )
	public List<Product> findAllWithStartDateBeforeAndCategory(@Param("fromDate") LocalDateTime fromDate, @Param("category") String category);
	
}
