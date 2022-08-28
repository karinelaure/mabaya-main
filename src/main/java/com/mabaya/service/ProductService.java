package com.mabaya.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.mabaya.dto.ProductDto;
import com.mabaya.model.Campaign;
import com.mabaya.model.Product;
import com.mabaya.repository.ProductRepository;

@Service
public class ProductService implements CommandLineRunner{

	private static final int NUM_PRODUCTS = 8;
	private static final BigDecimal MIN_DECIMAL = new BigDecimal(10.03);
	private static final BigDecimal MAX_DECIMAL = new BigDecimal(144.98);
	private static final List<String> CATEGORIES = Arrays.asList("category 1", "category 2","category 3","category 4","category 5");
	@Autowired
	private ProductRepository productRepository;
	@Override
	public void run(String... args) throws Exception {

		for(int i=0; i< NUM_PRODUCTS; i++) {
			Product product = new Product();
			product.setTitle("Product "+(i+1));
			product.setCategory(generateRandomCategory());
			product.setPrice(generateRandomDecimal());
			productRepository.save(product);
			
		}
		
	}
	
	public List<ProductDto> findAll(){
		List<Product> prods = productRepository.findAll();
		List<ProductDto> dtos = new ArrayList<>();
		dtos.addAll(prods.stream().map(prod -> modelToDto(prod)).collect(Collectors.toList()));
		return dtos;
	}

	private ProductDto modelToDto(Product prod) {
		if(prod == null) {
			return null;
		}
		List<Long> campIds = new ArrayList<>();
		for (Campaign camp : prod.getCampaigns()) {
			campIds.add(camp.getId());
		}
		
		return new ProductDto(prod.getSerialNumber(),prod.getPrice(),prod.getTitle(),prod.getCategory(),campIds);
	}
	
	public ProductDto findAllWithStartDateBeforeAndCategory(String category, LocalDateTime dateFrom){
		List<Product> prodList = productRepository.findAllWithStartDateBeforeAndCategory(dateFrom, category);
		
		if(!prodList.isEmpty() && prodList.size()> 0) {
			Product prod = prodList.get(0);
			List<Long> campIds = new ArrayList<>();
			for (Campaign camp : prod.getCampaigns()) {
				campIds.add(camp.getId());
			}
				
			return new ProductDto(prod.getSerialNumber(), prod.getPrice(), prod.getTitle(), prod.getCategory(), campIds );
		}
		
		return null;
	}
	
	private static BigDecimal generateRandomDecimal() {
		BigDecimal random = MIN_DECIMAL.add(new BigDecimal(Math.random())).multiply(MAX_DECIMAL).subtract(MIN_DECIMAL);
		return random;
	}
	
	private static String generateRandomCategory() {
		Random rand = new Random();
		String category = CATEGORIES.get(rand.nextInt(CATEGORIES.size()));
		return category;
	}
	
	
}
