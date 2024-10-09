package com.coupang.marketplace.client.sample.coupons;

import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ExpireCoupon;
import com.coupang.marketplace.client.model.product.ExpireCouponRequest;
import com.coupang.marketplace.client.model.product.ResponseOfExpireCouponResponse;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * 다운로드쿠폰 파기
 */
public class ExpireDownloadableCoupon {

    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
//        final String VENDOR_ID = vendorConfig.getValue("vendor.id");

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            ExpireCouponRequest request = new ExpireCouponRequest();
            ExpireCoupon coupon1 = new ExpireCoupon();
            coupon1.setCouponId(16513129L);
            coupon1.setReason("expired");
            coupon1.setUserId("testId123");

            request.setExpireCouponList(Arrays.asList(coupon1));
            List<ResponseOfExpireCouponResponse> result = apiInstance.expireDownloadableCoupons(request);
            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (Exception e) {
            System.err.println("Exception while creating a coupon! " + e);
        }
    }

}
