package com.coupang.marketplace.client.sample.logistics;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.PagedResponseOfOutboundInquiryReturn;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

/**
 * 출고지 조회
 */
public class GetOutboundShippingPlace {

    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");
        int pageNum = 1; // provide your own page number
        int pageSize = 10; // provide your own page size

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            PagedResponseOfOutboundInquiryReturn result = apiInstance.getOutboundShippingPlace(VENDOR_ID, null, null, null, Arrays.asList("출고지"));

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling getOutboundShippingCenter! " + e.getResponseBody());
        }
    }
}
