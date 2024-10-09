package com.coupang.marketplace.client.sample.cs;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ResponseDtoOfPagedListOfCSCustomerInquiryDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 상품별 고객문의 조회
 */
public class GetCustomerServiceRequest {

    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        String VENDOR_ID = vendorConfig.getValue("vendor.id");

        String inquiryStartAt, inquiryEndAt, answeredType;
        Long vendorItemId = null;
        Integer pageNum, pageSize;

        inquiryStartAt = "2019-06-17"; // yyyy-MM-dd
        inquiryEndAt = "2019-06-17"; // yyyy-MM-dd
        answeredType = "ALL"; //ALL|ANSWERED|NOANSWER
        pageNum = 1;
        pageSize = 10;

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
             ResponseDtoOfPagedListOfCSCustomerInquiryDto result = apiInstance.getCustomerInquiriesByVendorId(VENDOR_ID, VENDOR_ID, inquiryStartAt, inquiryEndAt, answeredType, vendorItemId, pageNum, pageSize);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling getCustomerInquiriesByVendorId! " + e.getResponseBody());
        }

    }
}
