package com.coupang.marketplace.client.sample.logistics;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.GoodsflowInfoOpenApiDto;
import com.coupang.marketplace.client.model.product.PlaceAddressDto;
import com.coupang.marketplace.client.model.product.RemoteInfoDto;
import com.coupang.marketplace.client.model.product.ResponseDtoOfSimpleResultDto;
import com.coupang.marketplace.client.model.product.ShippingPlaceDetailDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 출고지 생성
 */
public class CreateOutboundShippingCenter {


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
            ResponseDtoOfSimpleResultDto result = apiInstance.createOutboundShippingCenter(VENDOR_ID, createShippingPlaceDetailDto(), VENDOR_ID);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling createOutboundShippingCenter! " + e.getResponseBody());
        }
    }

    private static ShippingPlaceDetailDto createShippingPlaceDetailDto() {
        ShippingPlaceDetailDto shippingPlaceDetailDto = new ShippingPlaceDetailDto();
        // shippingPlaceDetailDto.setAddressId(3L);
        shippingPlaceDetailDto.setGlobal(false);
        shippingPlaceDetailDto.setShippingPlaceName("test creation of return center");
        shippingPlaceDetailDto.usable(true);
        shippingPlaceDetailDto.setUserId("et5openapi");
        shippingPlaceDetailDto.vendorId("A00013264");

        GoodsflowInfoOpenApiDto goodsflowInfoOpenApiDto = new GoodsflowInfoOpenApiDto();
        goodsflowInfoOpenApiDto.setConsumerCashFee05kg(2500);
        goodsflowInfoOpenApiDto.setConsumerCashFee10kg(2500);
        goodsflowInfoOpenApiDto.setConsumerCashFee20kg(2500);
        goodsflowInfoOpenApiDto.setContractCustomerNumber("02-1234-5678");
        goodsflowInfoOpenApiDto.setContractNumber("85500067");
        goodsflowInfoOpenApiDto.setDeliverCode("DONGBU");
        goodsflowInfoOpenApiDto.setReturnFee05kg(2500);
        goodsflowInfoOpenApiDto.setReturnFee10kg(2500);
        goodsflowInfoOpenApiDto.setReturnFee20kg(2500);
        goodsflowInfoOpenApiDto.setVendorCashFee05kg(2500);
        goodsflowInfoOpenApiDto.setVendorCashFee10kg(2500);
        goodsflowInfoOpenApiDto.setVendorCashFee20kg(2500);
        goodsflowInfoOpenApiDto.setVendorCreditFee05kg(2500);
        goodsflowInfoOpenApiDto.setVendorCreditFee10kg(2500);
        goodsflowInfoOpenApiDto.setVendorCreditFee20kg(2500);
        shippingPlaceDetailDto.setGoodsflowInfoOpenApiDto(goodsflowInfoOpenApiDto);

        PlaceAddressDto placeAddressDto1 = new PlaceAddressDto();
        placeAddressDto1.setAddressType("JIBUN");
        placeAddressDto1.setCompanyContactNumber("02-1234-5678");
        placeAddressDto1.setPhoneNumber2("02-1234-5678");
        placeAddressDto1.setReturnAddress("address1");
        placeAddressDto1.setReturnAddressDetail("JIBUN");
        placeAddressDto1.setReturnZipCode("10516");

        PlaceAddressDto placeAddressDto2 = new PlaceAddressDto();
        placeAddressDto2.setAddressType("JIBUN");
        placeAddressDto2.setCompanyContactNumber("02-1234-5678");
        placeAddressDto2.setPhoneNumber2("02-1234-5678");
        placeAddressDto2.setReturnAddress("address2");
        placeAddressDto2.setReturnAddressDetail("JIBUN");
        placeAddressDto2.setReturnZipCode("10516");

        List<PlaceAddressDto> placeAddressDtos = Arrays.asList(placeAddressDto1, placeAddressDto2);
        shippingPlaceDetailDto.setPlaceAddresses(placeAddressDtos);

        return shippingPlaceDetailDto;
    }
}
