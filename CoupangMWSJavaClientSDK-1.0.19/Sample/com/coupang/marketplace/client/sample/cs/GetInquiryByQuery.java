package com.coupang.marketplace.client.sample.cs;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ResponseDtoOfPagedListOfCSCoupangInquiryDTO;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 쿠팡 콜센터 문의 조회
 */
public class GetInquiryByQuery {
    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        String VENDOR_ID = vendorConfig.getValue("vendor.id");

        String inquiryStartAt, inquiryEndAt, partnerCounselingStatus;
        Long vendorItemId = null, orderId =  null;
        Integer pageNum, pageSize;

        inquiryStartAt = "2019-06-17"; // yyyy-MM-dd
        inquiryEndAt = "2019-06-17"; // yyyy-MM-dd
        partnerCounselingStatus = "NONE"; // NONE|ANSWER|NO_ANSWER|TRANSFER
        pageNum = 1;
        pageSize = 10;

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            ResponseDtoOfPagedListOfCSCoupangInquiryDTO result = apiInstance.getInquiriesByVendor(VENDOR_ID, VENDOR_ID, inquiryStartAt, inquiryEndAt, orderId, partnerCounselingStatus, vendorItemId, pageNum, pageSize);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling getInquiriesByVendor! " + e.getResponseBody());
        }

    }
}
