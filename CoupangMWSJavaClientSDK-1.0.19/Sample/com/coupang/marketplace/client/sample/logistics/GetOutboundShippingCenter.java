package com.coupang.marketplace.client.sample.logistics;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ResponseDtoOfPagedListOfOutboundInquiryReturnDTO;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 출고지 목록조회
 */
public class GetOutboundShippingCenter {


    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");
        String searchType = "OSPC"; // provide your own search type
        String outboundShippingPlaceCodes = "1069482"; // provide your own outbound shipping place code
        int pageNum = 1; // provide your own page number
        int pageSize = 50; // provide your own page size

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            ResponseDtoOfPagedListOfOutboundInquiryReturnDTO result = apiInstance.getOutboundShippingCenter(VENDOR_ID, VENDOR_ID, searchType, outboundShippingPlaceCodes, pageNum, pageSize);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling getOutboundShippingCenter! " + e.getResponseBody());
        }
    }
}
