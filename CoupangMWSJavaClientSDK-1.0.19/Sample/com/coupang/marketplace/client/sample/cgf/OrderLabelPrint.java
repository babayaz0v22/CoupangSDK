package com.coupang.marketplace.client.sample.cgf;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.CsCancelRequestDto;
import com.coupang.marketplace.client.model.product.OrderLabelPrintRequest;
import com.coupang.marketplace.client.model.product.ResponseDtoOfCSReceiptResult;
import com.coupang.marketplace.client.model.product.ResponseDtoOfstring;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class OrderLabelPrint {
    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        String VENDOR_ID = vendorConfig.getValue("vendor.id");

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY, true);

        try {
            OrderLabelPrintRequest request = new OrderLabelPrintRequest();
            request.setOrderIdList(Arrays.asList(10000120670440L,
                    20000120391907L,
                    6000121622041L,
                    22000121025601L));
            request.setQuantity(2);
            request.setTemplateName("SIXTY_FORTY_MM");
            // Invoke API
            ResponseDtoOfstring result = apiInstance.printOrderLabel(request, VENDOR_ID, VENDOR_ID);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling printOrderLabel! " + e.getResponseBody());
        }
    }
}
