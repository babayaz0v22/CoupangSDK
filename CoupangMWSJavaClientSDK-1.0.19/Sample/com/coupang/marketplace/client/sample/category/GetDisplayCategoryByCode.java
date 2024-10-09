package com.coupang.marketplace.client.sample.category;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.OpenApiResultOfODisplayCategory;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 카테고리 조회
 */
public class GetDisplayCategoryByCode {



    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        String VENDOR_ID = vendorConfig.getValue("vendor.id");
        String categoryCode = ""; // provide your own category code

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            OpenApiResultOfODisplayCategory result = apiInstance.getDisplayCategoryByCode(VENDOR_ID, categoryCode);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling getDisplayCategoryByCode! " + e.getResponseBody());
        }
    }
}
