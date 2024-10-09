package com.coupang.marketplace.client.sample.coupons;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.*;
import com.coupang.marketplace.client.sample.config.VendorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 다운로드쿠폰 생성
 */
public class CreateDownloadableCoupon {

    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
//        final String VENDOR_ID = vendorConfig.getValue("vendor.id");

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            CreateCouponResponse result = apiInstance.createDownloadableCoupon(createCouponCreateRequest());
            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception while creating a coupon! " + e.getResponseBody());
        }
    }

    private static CreateCouponRequest createCouponCreateRequest() {
        CreateCouponRequest request = new CreateCouponRequest();
        CouponPolicyRequest policy1 = new CouponPolicyRequest();
        policy1.setTitle("해당쿠폰의 정책 1 명칭");
        policy1.setTypeOfDiscount(CouponPolicyRequest.TypeOfDiscountEnum.PRICE);
        policy1.setDescription("해당정책 안내 문구 작성");
        policy1.setMinimumPrice(new BigDecimal(10000));
        policy1.setDiscount(new Double(1000));
        policy1.setMaximumDiscountPrice(1000L);
        policy1.setMaximumPerDaily(1);

        CouponPolicyRequest policy2 = new CouponPolicyRequest();
        policy2.setTitle("해당쿠폰의 정책 2 명칭");
        policy2.setTypeOfDiscount(CouponPolicyRequest.TypeOfDiscountEnum.PRICE);
        policy2.setDescription("해당정책 안내 문구 작성");
        policy2.setMinimumPrice(new BigDecimal(20000));
        policy2.setDiscount(new Double(2000));
        policy2.setMaximumDiscountPrice(1000L);
        policy2.setMaximumPerDaily(1);

        CouponPolicyRequest policy3 = new CouponPolicyRequest();
        policy3.setTitle("해당쿠폰의 정책 3 명칭");
        policy3.setTypeOfDiscount(CouponPolicyRequest.TypeOfDiscountEnum.PRICE);
        policy3.setDescription("해당정책 안내 문구 작성");
        policy3.setMinimumPrice(new BigDecimal(30000));
        policy3.setDiscount(new Double(3000));
        policy3.setMaximumDiscountPrice(1000L);
        policy3.setMaximumPerDaily(1);

        request.setTitle("쿠폰 명칭");
        request.setContractId(15L);
        request.setCouponType(CreateCouponRequest.CouponTypeEnum.DOWNLOAD);
        request.setStartDate("2019-05-22 19:55:00");
        request.setEndDate("2019-06-08 11:00:00");
        request.setUserId("testaccout1");
        request.setPolicies(Arrays.asList(policy1, policy2, policy3));
        return request;
    }
}
