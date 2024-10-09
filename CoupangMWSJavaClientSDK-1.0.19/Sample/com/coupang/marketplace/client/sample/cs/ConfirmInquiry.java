package com.coupang.marketplace.client.sample.cs;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.CSCoupangConfirmCondition;
import com.coupang.marketplace.client.model.product.ResponseDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 쿠팡 콜센터 문의 확인
 */
public class ConfirmInquiry {
    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        String VENDOR_ID = vendorConfig.getValue("vendor.id");

        String inquiryId = "1027746193";
        String confirmBy = "et5openapi";
        CSCoupangConfirmCondition csCoupangConfirmCondition = new CSCoupangConfirmCondition();
        csCoupangConfirmCondition.setConfirmBy(confirmBy);

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            ResponseDto result = apiInstance.confirmInquiries(inquiryId, VENDOR_ID, csCoupangConfirmCondition, VENDOR_ID);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling confirmInquiries! " + e.getResponseBody());
        }

    }
}
