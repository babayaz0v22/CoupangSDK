package com.coupang.marketplace.client.sample.settlement;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.SettlementHistoryDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * 지급 내역 조회
 */
public class GetSettlementHistories {

    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        String VENDOR_ID = vendorConfig.getValue("vendor.id");

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            String revenueRecognitionYearMonth = "2019-07";
            // Invoke API
            List<SettlementHistoryDto> result = apiInstance.getSettlementHistories(VENDOR_ID, revenueRecognitionYearMonth);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling GetSettlementHistories! " + e.getResponseBody());
        }
    }
}
