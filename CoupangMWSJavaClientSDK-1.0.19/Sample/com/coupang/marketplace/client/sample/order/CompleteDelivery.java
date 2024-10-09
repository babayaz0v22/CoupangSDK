package com.coupang.marketplace.client.sample.order;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.DeliveryReqDto;
import com.coupang.marketplace.client.model.product.ResponseDtoOfboolean;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 장기미배송 배송완료 처리
 */
public class CompleteDelivery {

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
            DeliveryReqDto request = new DeliveryReqDto();
            request.setShipmentBoxId(482231895L);
            request.setInvoiceNumber("505124853844");
            // Invoke API
            ResponseDtoOfboolean result = apiInstance.completeDelivery(VENDOR_ID, VENDOR_ID, request);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling CompleteDelivery! " + e.getResponseBody());
        }
    }
}
