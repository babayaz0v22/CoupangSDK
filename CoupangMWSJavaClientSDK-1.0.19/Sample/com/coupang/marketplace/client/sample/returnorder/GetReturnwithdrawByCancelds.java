package com.coupang.marketplace.client.sample.returnorder;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ResponseDtoOfListOfReturnWithdrawDto;
import com.coupang.marketplace.client.model.product.ReturnWithdrawReqDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * 반품철회 이력 접수번호로 조회
 */
public class GetReturnwithdrawByCancelds {


    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            ReturnWithdrawReqDto returnWithdrawReqDto = new ReturnWithdrawReqDto();
            List<Long> cancelIds = new ArrayList<>();
            cancelIds.add(87033689L);
            returnWithdrawReqDto.setCancelIds(cancelIds);
            // Invoke API
            ResponseDtoOfListOfReturnWithdrawDto result = apiInstance.getReturnWithdrawRequestedList(VENDOR_ID, VENDOR_ID, returnWithdrawReqDto);

            //print result
            System.out.println("result : " + result);
        }
        catch (ApiException e) {
            System.err.println("Exception while calling return receive confirmation! " + e.getResponseBody());
        }
    }

}
