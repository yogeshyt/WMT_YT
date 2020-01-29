package com.ms.wmadv.modelrecommend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WMTAdvModelRecommendationController {

	@Autowired
	WMTAdvModelRecommendationService wMTAdvModelRecommendationService;
	
	@ResponseBody
	@RequestMapping(path = "/prodcuts",method=RequestMethod.GET,produces="application/json")
	public Response getProducts(@RequestParam(value="query",required=false) String query) {
		if(StringUtils.isEmpty(query)) {
			return wMTAdvModelRecommendationService.pullAllProducts();
		}else {
			return wMTAdvModelRecommendationService.fetchProductsBySymbol(query);
		}
	}
	
	@ResponseBody
	@RequestMapping(path = "/prodcuts/{productId}",method=RequestMethod.GET,produces="application/json")
	public Response getProductById(@PathVariable("productId") String productId) {
		return wMTAdvModelRecommendationService.fetchProductsById(productId);
	}
	
	
	@ResponseBody
	@RequestMapping(path = "/prodcuts/recommendation/{riskScore}",method=RequestMethod.GET,produces="application/json")
	public Response getProductRecommendation(@PathVariable("riskScore") String riskScore) {
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping(path = "/model",method=RequestMethod.POST,produces="application/json")
	public Model saveModel(@RequestBody Model model) {
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping(path = "/model",method=RequestMethod.POST,produces="application/json")
	public Model saveModel(@RequestBody ModelHolding modelHolding) {
		
		return null;
	}

	
}
