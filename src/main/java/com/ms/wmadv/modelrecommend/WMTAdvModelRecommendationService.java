package com.ms.wmadv.modelrecommend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wMTAdvModelRecommendationService")
public class WMTAdvModelRecommendationService {

	@Autowired
	WMTAdvModelRecommendationRepository wMTAdvModelRecommendationRepository;
	
	public Response pullAllProducts() {
		return new Response("Success", null, wMTAdvModelRecommendationRepository.fetchAllProducts());
	}
	
	public Response fetchProductsById(String id) {
		return new Response("Success", null, wMTAdvModelRecommendationRepository.fetchProductById(id));
	}
	
	public Response fetchProductsBySymbol(String symbol) {
		return new Response("Success", null, wMTAdvModelRecommendationRepository.fetchProductsBySymbol(symbol));
	}
	
}
