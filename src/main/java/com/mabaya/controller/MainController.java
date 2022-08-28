package com.mabaya.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mabaya.dto.CampaignDto;
import com.mabaya.dto.ProductDto;
import com.mabaya.service.CampaignService;
import com.mabaya.service.ProductService;

@RestController
public class MainController {
	@Autowired
	private CampaignService campaignService;
	@Autowired
	private ProductService productService;
	
	private static final int DAYS = 10;
	
	@PostMapping("/campaign/create")
	public CampaignDto createCampaign(@Valid @RequestBody CampaignDto campaignDto) {
		return campaignService.save(campaignDto);
	}
	
	@GetMapping("/campaign/allactive")
	public List<CampaignDto> getActiveCampaigns() {
		
		return campaignService.findAllWithStartDateBefore(getActiveDate());
	} 
	
	@GetMapping("/product/all")
	public List<ProductDto> getAllProducts() {		
		List<ProductDto> res = productService.findAll();
		return res;
	}
	
	
	@GetMapping("/ads")
	public ProductDto getByCategory(@RequestParam String category) {
		//return campaignService.findAllWithStartDateBeforeAndCategory(category, getActiveDate());
		return productService.findAllWithStartDateBeforeAndCategory(category, getActiveDate());
	}
	
	private LocalDateTime getActiveDate() {
		return LocalDateTime.now().minusDays(DAYS);
	}
	
	
	
	

}
