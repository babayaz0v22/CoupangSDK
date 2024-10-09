package com.coupang.marketplace.client.sample.logistics;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.GoodsflowInfoOpenApiDto;
import com.coupang.marketplace.client.model.product.PlaceAddressDto;
import com.coupang.marketplace.client.model.product.RemoteInfoDto;
import com.coupang.marketplace.client.model.product.ResponseDtoOfSimpleResultDto;
import com.coupang.marketplace.client.model.product.ShippingPlaceDetailDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * 출고지 수정
 */
public class UpdateOutboundShippingCenter {


    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");
        long outboundShippingPlaceCode = 1069482L; // provide your own outbound shipping place code

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            ResponseDtoOfSimpleResultDto result = apiInstance.updateOutboundShippingCenter(VENDOR_ID, outboundShippingPlaceCode, createShippingPlaceDetailDto(outboundShippingPlaceCode), VENDOR_ID);

            //print result
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling updateOutboundShippingCenter! " + e.getResponseBody());
        }
    }

    private static ShippingPlaceDetailDto createShippingPlaceDetailDto(long outboundShippingPlaceCode) {
        ShippingPlaceDetailDto shippingPlaceDetailDto = new ShippingPlaceDetailDto();
        shippingPlaceDetailDto.setGlobal(false);
        shippingPlaceDetailDto.setOutboundShippingPlaceCode(outboundShippingPlaceCode);
        shippingPlaceDetailDto.setShippingPlaceName("SDK test of modification outbound shipping place");
        shippingPlaceDetailDto.usable(true);
        shippingPlaceDetailDto.setUserId("et5openapi");
        shippingPlaceDetailDto.vendorId("A00013264");

        PlaceAddressDto placeAddressDto1 = new PlaceAddressDto();
        placeAddressDto1.setAddressType("JIBUN");
        placeAddressDto1.setCompanyContactNumber("02-1234-5678");
        placeAddressDto1.setCountryCode("0");
        placeAddressDto1.setPhoneNumber2("02-1234-5678");
        placeAddressDto1.setReturnAddress("address1");
        placeAddressDto1.setReturnAddressDetail("JIBUN");
        placeAddressDto1.setReturnZipCode("10516");

        PlaceAddressDto placeAddressDto2 = new PlaceAddressDto();
        placeAddressDto2.setAddressType("JIBUN");
        placeAddressDto2.setCompanyContactNumber("02-1234-5678");
        placeAddressDto2.setCountryCode("1");
        placeAddressDto2.setPhoneNumber2("02-1234-5678");
        placeAddressDto2.setReturnAddress("address2");
        placeAddressDto2.setReturnAddressDetail("JIBUN");
        placeAddressDto2.setReturnZipCode("10516");

        List<PlaceAddressDto> placeAddressDtos = Arrays.asList(placeAddressDto1, placeAddressDto2);
        shippingPlaceDetailDto.setPlaceAddresses(placeAddressDtos);

        RemoteInfoDto remoteInfoDto1 = new RemoteInfoDto();
        remoteInfoDto1.setDeliveryCode("AJOU");
        remoteInfoDto1.setJeju(5000);
        remoteInfoDto1.setNotJeju(2500);
        remoteInfoDto1.setUsable(true);

        List<RemoteInfoDto> remoteInfoDtos = Arrays.asList(remoteInfoDto1);
        shippingPlaceDetailDto.setRemoteInfos(remoteInfoDtos);
        return shippingPlaceDetailDto;
    }
}