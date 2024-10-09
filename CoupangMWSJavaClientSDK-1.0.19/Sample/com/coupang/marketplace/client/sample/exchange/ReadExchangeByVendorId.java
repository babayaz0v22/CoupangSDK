package com.coupang.marketplace.client.sample.exchange;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.PagedResponseDtoOfListOfExchangeDtoV1;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 교환요청 목록 조회
 */
public class ReadExchangeByVendorId {

	
	private static VendorConfig vendorConfig;
	
	static {
		vendorConfig = new VendorConfig();
	}
	
	public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");

        final String createdAtFrom = ""; // provide your own filtering start date
	    final String createdAtTo = ""; // provide your own filtering end date
	    final String status = ""; // provide your own exchange status
        
	    CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);
	
	    try {
	        // Invoke API
	    	PagedResponseDtoOfListOfExchangeDtoV1 result = apiInstance.getExchangesByVendorId(VENDOR_ID, VENDOR_ID, createdAtFrom, createdAtTo, status, null, null, 50);

			//print result
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println("result : " + gson.toJson(result));
	    }
	    catch (ApiException e) {
			System.err.println("Exception while fetching the list of exchanges for a Vendor! " + e.getResponseBody());
	    }
	}
}
