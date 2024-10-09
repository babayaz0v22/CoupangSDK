package com.coupang.marketplace.client.sample.order;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.CancelRequestDtoV5;
import com.coupang.marketplace.client.model.product.ResponseDtoOfCancelApiResponseDtoV5;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

/**
 * 상품준비중 취소처리
 */
public class CancelOrderV5 {

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
            Long orderId = 2000006593044L;
            CancelRequestDtoV5 request = new CancelRequestDtoV5();
            request.setOrderId(orderId);
            request.setVendorItemIds(Arrays.asList(3145181064L, 3145181065L, 3145181067L));
            request.setReceiptCounts(Arrays.asList(1, 2, 1));
            request.setBigCancelCode("CANERR");
            request.setMiddleCancelCode("CCTTER");
            request.setUserId("et5");
            request.setVendorId(VENDOR_ID);
            // Invoke API
            ResponseDtoOfCancelApiResponseDtoV5 result = apiInstance.cancelOrderV5(VENDOR_ID, orderId, request);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling CancelOrderV5! " + e.getResponseBody());
        }
    }
}
