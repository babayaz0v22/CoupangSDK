package com.coupang.marketplace.client.sample.coupons;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.OpenapiResponseOfListOfCouponInfoOpenAPIV2Response;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * 즉시할인쿠폰 목록(status) 조회
 */
public class GetCouponsByVendor {

	private static VendorConfig vendorConfig;
	
	static {
		vendorConfig = new VendorConfig();
	}
	
	public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");
        final String couponStatus = ""; // provide your own coupon status

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);
	
	    try {
	    	Integer page = 1;
	    	Integer size = 10;
	    	List<String> sort = Arrays.asList("asc");
	        // Invoke API
	    	OpenapiResponseOfListOfCouponInfoOpenAPIV2Response result = apiInstance.getCouponsByVendor(VENDOR_ID, couponStatus, page, size, sort);

			//print result
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println("result : " + gson.toJson(result));
	    }
	    catch (ApiException e) {
			System.err.println("Exception while fetching the coupons! " + e.getResponseBody());
	    }
	}
}
