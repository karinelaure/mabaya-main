package com.mabaya.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mabaya.dto.CampaignDto;
import com.mabaya.model.Campaign;
import com.mabaya.model.Product;
import com.mabaya.repository.CampaignRepository;
import com.mabaya.repository.ProductRepository;

import com.mabaya.util.Util;

@Service
public class CampaignService {

	@Autowired
	private CampaignRepository campaignRepository;
	@Autowired
	private ProductRepository productRepository;

	public CampaignDto save(CampaignDto campaignDto) {
		Campaign campaign = dtoToModel(campaignDto);
		return modelToDto(campaignRepository.save(campaign));
	}

	public List<CampaignDto> findAllWithStartDateBefore(LocalDateTime dateFrom) {
		List<Campaign> campRes = campaignRepository.findAllWithStartDateBefore(dateFrom);
		List<CampaignDto> dtos = campRes.stream().map(camp -> modelToDto(camp)).collect(Collectors.toList());
		return dtos;
	}
	
	

	private Campaign dtoToModel(CampaignDto campaignDto) {
		Campaign campaign = new Campaign();
		campaign.setName(campaignDto.getName());
		campaign.setBid(campaignDto.getBid());
		campaign.setStartDate(Util.stringToDate(campaignDto.getStartDate()));
		List<Product> prodList = new ArrayList<Product>();
		
		for (Long prodId : campaignDto.getProdList()) {
			Optional<Product> resProd = productRepository.findById(prodId);
			if (resProd.isPresent()) {
				Product product = resProd.get();
				if (product != null) {
					product.getCampaigns().add(campaign);
					prodList.add(product);
				}
			}
		}
		
		campaign.setProducts(prodList);
		return campaign;
	}

	private CampaignDto modelToDto(Campaign campaign) {
		CampaignDto campaignDto = new CampaignDto();
		campaignDto.setName(campaign.getName());
		campaignDto.setBid(campaign.getBid());
		campaignDto.setStartDate(Util.dateToString(campaign.getStartDate()));
		Set<Long> prodList = new HashSet<>();
		
		for (Product prod : campaign.getProducts()) {
			prodList.add(prod.getSerialNumber());
		}
		
		campaignDto.setProdList(prodList);
		return campaignDto;
	}

}
