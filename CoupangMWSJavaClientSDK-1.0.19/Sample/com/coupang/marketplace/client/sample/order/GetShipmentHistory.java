package com.coupang.marketplace.client.sample.order;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ResponseDtoOfDeliveryHistoryDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 배송상태 변경 히스토리 조회
 */
public class GetShipmentHistory {


	private static VendorConfig vendorConfig;

	static {
		vendorConfig = new VendorConfig();
	}
	
	public static void main(String[] args) {
		final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
		final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
		final String VENDOR_ID = vendorConfig.getValue("vendor.id");

	    long shipmentBoxId = 0L; // provide your own shipment box id

	    CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);
	
	    try {
	        // Invoke API
	    	ResponseDtoOfDeliveryHistoryDto result = apiInstance.getDeliveryHistoriesByShipmentBoxId(shipmentBoxId, VENDOR_ID, VENDOR_ID);

	        //print result
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println("result : " + gson.toJson(result));
	    }
	    catch (ApiException e) {
			System.err.println("Exception when calling delivery history by shipment box Id! " + e.getResponseBody());
	    }
	}
}
