package com.coupang.marketplace.client.sample.returnorder;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.PagedResponseDtoWithPageIndexOfListOfReturnWithdrawDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 반품철회 이력 기간별 조회
 */
public class GetReturnWithdrawRequestsByPageV4 {

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
            String dateFrom = "2018-11-03";
            String dateTo = "2018-11-06";
            Integer sizePerPage = 3;
            Integer pageIndex = 1;
            // Invoke API
            PagedResponseDtoWithPageIndexOfListOfReturnWithdrawDto result = apiInstance.getReturnWithdrawRequestsByPageV4(VENDOR_ID, dateFrom, dateTo, sizePerPage, pageIndex, VENDOR_ID);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling GetReturnWithdrawRequestsByPageV4! " + e.getResponseBody());
        }
    }
}
