package com.coupang.marketplace.client.sample.category;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.AutoCategorizationRequestDto;
import com.coupang.marketplace.client.model.product.ResponseDtoOfAutoCategorizationResponseDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 카테고리 추천
 */
public class GetCategoryPrediction {
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
            // Invoke API
            ResponseDtoOfAutoCategorizationResponseDto result = apiInstance.doProductCategorizationUsingPOST(VENDOR_ID, createAutoCategorizationRequestDto());

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling getCategoryPrediction! " + e.getResponseBody());
        }
    }

    private static AutoCategorizationRequestDto createAutoCategorizationRequestDto() {
        AutoCategorizationRequestDto requestDto = new AutoCategorizationRequestDto();
        requestDto.setSellerSkuCode("123123");
        requestDto.setProductName("코데즈컴바인 양트임싱글코트");
        requestDto.setProductDescription("모니터 해상도, 밝기, 컴퓨터 사양 등에 따라 실물과 약간의 색상차이가 있을 수 있습니다. 캐주얼하지만 큐티한디자인이 돋보이는 싱글코트에요 약간박시한핏이라 여유있고 편하게  스타일링하기 좋은 캐주얼 싱글코트입니다. 컬러:베이지,네이비 사이즈:FREE 실측(측정자,측정기준,제작과정에따라 다소차이가있을수있습니다) 단면기준 CM 단위  가슴단면:61 어깨:54 팔기장:55(어깨절개선기준) 총장:88");
        requestDto.setBrand("코데즈컴바인");
        Map<String, String> attributes = new HashMap<>();
        attributes.put("제품 소재", "모달:53.8 폴리:43.2 레이온:2.4 면:0.6");
        attributes.put("색상", "베이지,네이비");
        attributes.put("제조국", "한국");
        requestDto.setAttributes(attributes);
        return requestDto;
    }
}
