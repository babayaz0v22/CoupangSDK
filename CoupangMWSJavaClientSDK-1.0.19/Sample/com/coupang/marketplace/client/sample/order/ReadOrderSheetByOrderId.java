package com.coupang.marketplace.client.sample.order;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ResponseDtoOfListOfOrderSheetDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 발주서 단건 조회 (orderId)
 */
public class ReadOrderSheetByOrderId {


	private static VendorConfig vendorConfig;

	static {
		vendorConfig = new VendorConfig();
	}

	public static void main(String[] args) {
		final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
		final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
		final String VENDOR_ID = vendorConfig.getValue("vendor.id");

		final String orderId = ""; // provide your own order id
	
	    CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
        	ResponseDtoOfListOfOrderSheetDto result = apiInstance.getOrderSheetByOrderId(Long.parseLong(orderId), VENDOR_ID, VENDOR_ID);

            //print result
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println("result : " + gson.toJson(result));
        }
        catch (ApiException e) {
			System.err.println("Exception when calling orderSheetByOrderId! " + e.getResponseBody());
        }
	}
}
