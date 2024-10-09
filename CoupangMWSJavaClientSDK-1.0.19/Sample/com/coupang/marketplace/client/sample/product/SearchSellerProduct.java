package com.coupang.marketplace.client.sample.product;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.OpenApiPagedResultOfOSellerProductListItem;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 상품 목록 페이징 조회
 */
public class SearchSellerProduct {



    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        String VENDOR_ID = vendorConfig.getValue("vendor.id");
        Long sellerProductId = null; // provide your own seller product id
        String sellerProductName = ""; // provide your own seller product name
        Long productId = null; // provide your own product id
        String mdId = ""; // provide your own mdId
        String status = ""; // provide your own status
        String manufacturer = ""; // provide your own manufacturer
        String brand = ""; // provide your own brand
        Long vendorItemId = null; // provide your own vendor item id
        Long nextToken = 1L; // provide your own seller product name
        Integer maxPerPage = 50; // provide your own seller product name

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            OpenApiPagedResultOfOSellerProductListItem result = apiInstance.searchSellerProduct(VENDOR_ID, nextToken, maxPerPage, sellerProductId, sellerProductName, productId, VENDOR_ID, mdId, status, manufacturer, brand, null, vendorItemId);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling searchSellerProduct! " + e.getResponseBody());
        }
    }
}
