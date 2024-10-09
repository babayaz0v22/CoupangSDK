package com.coupang.marketplace.client.sample.product;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.OpenApiPagedResultOfOProduct;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 노출 상품 목록 페이징 조회
 */
public class SearchExistingProducts {



    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        String VENDOR_ID = vendorConfig.getValue("vendor.id");
        String productName = ""; // provide your own seller product name
        int nextToken = 1; // provide your own next token
        int maxPerPage = 50; // provide your own vendor item id

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            OpenApiPagedResultOfOProduct result = apiInstance.searchExistingProducts(VENDOR_ID, productName, nextToken, maxPerPage);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling searchExistingProducts! " + e.getResponseBody());
        }
    }
}
