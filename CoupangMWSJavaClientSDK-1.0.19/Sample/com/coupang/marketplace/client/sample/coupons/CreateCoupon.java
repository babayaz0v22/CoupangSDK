package com.coupang.marketplace.client.sample.coupons;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.CouponCreateRequestOpenAPIV2Form;
import com.coupang.marketplace.client.model.product.OpenapiResponseOfRequested;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 즉시할인쿠폰 생성
 */
public class CreateCoupon {

	private static VendorConfig vendorConfig;
	
	static {
		vendorConfig = new VendorConfig();
	}
	
	public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);
	    
	    try {
	    	OpenapiResponseOfRequested result = apiInstance.createCoupon(VENDOR_ID, createCouponCreateRequestOpenAPIV2Form());
	    	//print result
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println("result : " + gson.toJson(result));
	    } catch (ApiException e) {
			System.err.println("Exception while creating a coupon! " + e.getResponseBody());
	    }
	}
	
	private static CouponCreateRequestOpenAPIV2Form createCouponCreateRequestOpenAPIV2Form() {
		CouponCreateRequestOpenAPIV2Form couponCreateRequestOpenAPIV2Form = new CouponCreateRequestOpenAPIV2Form();
		couponCreateRequestOpenAPIV2Form.setContractId(Long.parseLong(vendorConfig.getValue("coupon.contract.id")));
		couponCreateRequestOpenAPIV2Form.setName(vendorConfig.getValue("coupon.name"));
		couponCreateRequestOpenAPIV2Form.setMaxDiscountPrice(Long.parseLong(vendorConfig.getValue("coupon.max.disc.price")));
		couponCreateRequestOpenAPIV2Form.setDiscount(Double.parseDouble(vendorConfig.getValue("coupon.disc.price")));
		couponCreateRequestOpenAPIV2Form.setStartAt(vendorConfig.getValue("coupon.disc.startAt"));
		couponCreateRequestOpenAPIV2Form.setEndAt(vendorConfig.getValue("coupon.disc.endAt"));
		couponCreateRequestOpenAPIV2Form.setType(vendorConfig.getValue("coupon.disc.type"));
		return couponCreateRequestOpenAPIV2Form;
	}
}
