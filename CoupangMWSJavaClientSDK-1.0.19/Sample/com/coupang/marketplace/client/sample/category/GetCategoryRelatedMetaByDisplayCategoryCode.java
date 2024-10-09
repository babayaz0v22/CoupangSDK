package com.coupang.marketplace.client.sample.category;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.OpenApiResultOfOCategoryMeta;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 카테고리 메타 정보 조회(Code)
 */
public class GetCategoryRelatedMetaByDisplayCategoryCode {



    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        String VENDOR_ID = vendorConfig.getValue("vendor.id");
        String categoryCode = "69716"; // provide your own category code

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            OpenApiResultOfOCategoryMeta result = apiInstance.getCategoryRelatedMetaByDisplayCategoryCode(VENDOR_ID, categoryCode);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling getCategoryRelatedMetaByDisplayCategoryCode! " + e.getResponseBody());
        }

    }
}
