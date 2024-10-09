package com.coupang.marketplace.client.sample.order;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ResponseDtoOfListOfOrderSheetDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 발주서 목록 조회 (일단위 / 분단위 페이징)
 */
public class ReadOrderSheetByVendorId {


	private static VendorConfig vendorConfig;

	static {
		vendorConfig = new VendorConfig();
	}
	
	public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");

	    final String createdAtFrom = "2019-08-22"; // provide your own filtering start date
	    final String createdAtTo = "2019-08-29"; // provide your own filtering end date
	    final String status = "ACCEPT"; // provide your own order status
	    final String nextToken = ""; // provide your own next token
		final String searchType = ""; // provide your own search type
		int maxPerPage = 5; // provide your own page record limit

	    CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);
	
	    try {
	        // Invoke API
	    	ResponseDtoOfListOfOrderSheetDto result = apiInstance.getOrderSheetsByVendorId(VENDOR_ID, VENDOR_ID, createdAtFrom, createdAtTo, status, nextToken, maxPerPage, searchType);
	
	        //print result
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println("result : " + gson.toJson(result));
	    }
	    catch (ApiException e) {
			System.err.println("Exception when calling orderSheetByOrderId! " + e.getResponseBody());
	    }
	}
}
