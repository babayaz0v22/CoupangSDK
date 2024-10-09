package com.coupang.marketplace.client.sample.cs;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.CSCoupangReplyCondition;
import com.coupang.marketplace.client.model.product.ResponseDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 쿠팡 콜센터 문의 답변
 */
public class UpdateInquiry {
    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        String VENDOR_ID = vendorConfig.getValue("vendor.id");

        String inquiryId = "1031911373";
        CSCoupangReplyCondition csCoupangReplyCondition = new CSCoupangReplyCondition();
        csCoupangReplyCondition.setInquiryId(inquiryId);
        csCoupangReplyCondition.setParentAnswerId("1048738780");
        csCoupangReplyCondition.setReplyBy(VENDOR_ID);
        csCoupangReplyCondition.setVendorId(VENDOR_ID);
        csCoupangReplyCondition.setContent("Test Reply. Thank you");

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            apiInstance.getApiClient().setBasePath("http://sk.stageverurl.com");
            ResponseDto result = apiInstance.replyInquiries(inquiryId, VENDOR_ID, csCoupangReplyCondition, VENDOR_ID);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling replyInquiries! " + e.getResponseBody());
        }

    }
}
