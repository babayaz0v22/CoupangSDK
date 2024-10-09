package com.coupang.marketplace.client.sample.product;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.OpenApiResult;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 상품 승인 요청
 */
public class SendApprovalRequest {



    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        String VENDOR_ID = vendorConfig.getValue("vendor.id");
        String sellerProductId = vendorConfig.getValue("seller.product.id"); // provide your own seller product id

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            OpenApiResult result = apiInstance.sendApprovalRequest(VENDOR_ID, sellerProductId);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling readSellerProductHistory! " + e.getResponseBody());
        }
    }
}
