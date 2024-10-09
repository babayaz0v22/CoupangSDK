package com.coupang.marketplace.client.sample.order;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.CsCancelRequestDto;
import com.coupang.marketplace.client.model.product.ResponseDtoOfCSReceiptResult;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

/**
 * 결제완료건 환불 처리
 */
public class CancelOrder {

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
            Long orderId = 28000005778875L;
            CsCancelRequestDto request = new CsCancelRequestDto();
            request.setOrderId(orderId);
            request.setVendorItemIds(Arrays.asList(3124304579L, 3124304580L));
            request.setReceiptCounts(Arrays.asList(1, 2));
            request.setBigCancelCode("CANERR");
            request.setMiddleCancelCode("CCTTER");
            request.setVendorId(VENDOR_ID);
            request.setUserId("et5");
            // Invoke API
            ResponseDtoOfCSReceiptResult result = apiInstance.cancelOrder(orderId, VENDOR_ID, request, VENDOR_ID);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling CancelOrder! " + e.getResponseBody());
        }
    }
}
