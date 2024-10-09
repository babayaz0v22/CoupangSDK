package com.coupang.marketplace.client.sample.coupons;

import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.OpenapiResponseOfCouponInfoOpenAPIV2Response;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 즉시할인쿠폰 단건 조회(couponId)
 */
public class GetCouponByVendor {

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
            Long couponId = 91L;

            OpenapiResponseOfCouponInfoOpenAPIV2Response result = apiInstance.getCouponByVendor(VENDOR_ID, couponId);
            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (Exception e) {
            System.err.println("Exception while creating a coupon! " + e);
        }
    }
}
