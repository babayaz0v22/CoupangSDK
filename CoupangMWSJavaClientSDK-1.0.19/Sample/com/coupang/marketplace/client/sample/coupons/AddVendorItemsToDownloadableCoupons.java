package com.coupang.marketplace.client.sample.coupons;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.*;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * 다운로드쿠폰 아이템 생성
 */
public class AddVendorItemsToDownloadableCoupons {

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
            CouponItemRequest request = new CouponItemRequest();

            CouponItem couponItem1 = new CouponItem();
            couponItem1.setCouponId(15350660L);
            couponItem1.setUserId("testaccount1");
            couponItem1.setVendorItemIds(Arrays.asList(2306264997L, 4802314648L, 4230264914L));

            request.setCouponItems(Arrays.asList(couponItem1));

            List<ResponseOfCouponItemResponse> result = apiInstance.addVendorItemsToDownloadableCoupons(request);
            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception while creating a coupon! " + e.getResponseBody());
        }
    }
}
