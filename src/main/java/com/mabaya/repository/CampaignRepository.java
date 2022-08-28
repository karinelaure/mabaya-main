package com.mabaya.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mabaya.model.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
	@Query(value = "select c from Campaign c where c.startDate >= :fromDate order by c.bid desc " )
	public List<Campaign> findAllWithStartDateBefore(@Param("fromDate") LocalDateTime fromDate);
	
}
