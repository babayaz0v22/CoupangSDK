package com.coupang.marketplace.client.sample.coupons;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.OpenapiResponseOfContractOpenAPIV2Dto;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * (공통)계약서 단건 조회
 */
public class GetContract {

    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");
        final Long contractId = 9962L;

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            OpenapiResponseOfContractOpenAPIV2Dto result = apiInstance.getContract(VENDOR_ID, contractId);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        }
        catch (ApiException e) {
            System.err.println("Exception while proccesing the coupons! " + e.getResponseBody());
        }
    }
}
