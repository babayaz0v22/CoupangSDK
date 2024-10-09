package com.coupang.marketplace.client.sample.product;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.OpenApiResultOfstring;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 상품 아이템별 가격 변경
 */
public class ChangeSalesPrice {



    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        String VENDOR_ID = vendorConfig.getValue("vendor.id");
        String vendorItemId = ""; // provide your own vendor item id
        String salesPrice = ""; // provide your own sale price

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            OpenApiResultOfstring result = apiInstance.changeSalePriceUsingPUT(VENDOR_ID, Long.parseLong(vendorItemId, 10), Long.parseLong(salesPrice, 10), false);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " +  gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling changeSalePriceUsingPUT! " + e.getResponseBody());
        }
    }
}
