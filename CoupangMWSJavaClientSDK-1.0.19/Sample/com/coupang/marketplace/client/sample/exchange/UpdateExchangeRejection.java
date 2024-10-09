package com.coupang.marketplace.client.sample.exchange;


import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ExchangeCancelDto;
import com.coupang.marketplace.client.model.product.ResponseDtoOfSimpleResultDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 교환요청 거부 처리
 */
public class UpdateExchangeRejection {

	
	private static VendorConfig vendorConfig;
	
	static {
		vendorConfig = new VendorConfig();
	}
	
	public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");
        long exchangeId = 1L; // provide your own exchange id

	    CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);
	
	    try {
	        // Invoke API
	    	ResponseDtoOfSimpleResultDto result = apiInstance.cancelExchange(exchangeId, createExchangeCancelDto(), VENDOR_ID, VENDOR_ID);
	
	        //print result
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println("result : " + gson.toJson(result));
	    }
	    catch (ApiException e) {
			System.err.println("Exception while updating the exchange rejection reason! " + e.getResponseBody());
	    }
	}
	
	private static ExchangeCancelDto createExchangeCancelDto() {
		ExchangeCancelDto exchangeCancelDto = new ExchangeCancelDto();
		exchangeCancelDto.setExchangeId(Long.parseLong(vendorConfig.getValue("exchange.id")));
		exchangeCancelDto.setExchangeRejectCode("SOLDOUT");
		exchangeCancelDto.setVendorId(vendorConfig.getValue("vendor.id"));
		return exchangeCancelDto;
	}
}
