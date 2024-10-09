package com.coupang.marketplace.client.sample.logistics;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ResponseDtoOfPagedListOfShippingPlaceResponseReturnDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 반품지 목록조회
 */
public class GetReturnShippingCenter {


    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");
        int pageNum = 1; // provide your own page number
        int pageSize = 50; // provide your own page size

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            ResponseDtoOfPagedListOfShippingPlaceResponseReturnDto result = apiInstance.getReturnShippingCenter(VENDOR_ID, VENDOR_ID, pageNum, pageSize);
            System.out.println(result.toString());

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling getReturnShippingCenter! " + e.getResponseBody());
        }
    }
}
