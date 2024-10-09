package com.coupang.marketplace.client.sample.cs;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.CSAddComment;
import com.coupang.marketplace.client.model.product.ResponseDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 고객문의 답변
 */
public class UpdateCustomerServiceRequest {
    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        String VENDOR_ID = vendorConfig.getValue("vendor.id");

        String inquiryId = "38442481";
        CSAddComment cSAddComment = new CSAddComment();
        cSAddComment.setReplyBy("et5openpai");
        cSAddComment.setContent("Test reply. Thank you");
        cSAddComment.setVendorId(VENDOR_ID);

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            ResponseDto result = apiInstance.addCommentToInquiry(inquiryId, VENDOR_ID, VENDOR_ID, cSAddComment);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling addCommentToInquiry! " + e.getResponseBody());
        }
    }
}
