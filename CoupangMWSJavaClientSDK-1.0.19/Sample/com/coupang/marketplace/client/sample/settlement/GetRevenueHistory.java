package com.coupang.marketplace.client.sample.settlement;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.OpenapiResponseOfListOfRevenueHistoryApiDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 매출 내역 조회
 */
public class GetRevenueHistory {

    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        String VENDOR_ID = vendorConfig.getValue("vendor.id");

        String recognitionDateFrom = "2024-05-01";
        String recognitionDateTo = "2024-05-14";
        String token = "";
        Integer maxPerPage = new Integer(10);

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            OpenapiResponseOfListOfRevenueHistoryApiDto result = apiInstance.getRevenueHistory(VENDOR_ID, recognitionDateFrom, recognitionDateTo, token, VENDOR_ID, maxPerPage);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling getRevenueHistory! " + e.getResponseBody());
        }
    }
}
