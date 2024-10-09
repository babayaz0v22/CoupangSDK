package com.coupang.marketplace.client.sample.product;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ProductCashBackInputDto;
import com.coupang.marketplace.client.model.product.ResponseDtoOfProductCashBackOutputDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

/**
 * 상품 캐시백 적용
 */
public class SetCashbacksV4 {

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
            ProductCashBackInputDto request = new ProductCashBackInputDto();
            request.setRuleId("3944");
            request.setValueType("FIXED");
            request.setValue("1000");
            request.setMaxAmount("");
            request.setVendorItemIds(Arrays.asList("3000001897", "3000001887"));
            request.setStartAt("2016-12-24T10:43:54");
            request.setEndAt("2017-01-01T10:43:54");

            // Invoke API
            ResponseDtoOfProductCashBackOutputDto result = apiInstance.setCashbacksV4(VENDOR_ID, VENDOR_ID, request);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling SetCashbacksV4! " + e.getResponseBody());
        }
    }
}
