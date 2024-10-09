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
 * 반품지 수정
 */
public class UpdateReturnShippingCenter {


    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");
        long returnCenterCode = 5678L; // provide your own return center code

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            ResponseDtoOfSimpleResultDto result = apiInstance.updateReturnShippingCenter(VENDOR_ID, returnCenterCode, createShippingPlaceDetailDto(), VENDOR_ID);

            //print result
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling updateReturnShippingCenter! " + e.getResponseBody());
        }
    }

    private static ShippingPlaceDetailDto createShippingPlaceDetailDto() {
        ShippingPlaceDetailDto shippingPlaceDetailDto = new ShippingPlaceDetailDto();
        shippingPlaceDetailDto.setAddressId(4L);
        shippingPlaceDetailDto.setGlobal(false);
        shippingPlaceDetailDto.setOutboundShippingPlaceCode(2L);
        shippingPlaceDetailDto.setReturnCenterCode("5678");
        shippingPlaceDetailDto.setShippingPlaceName("ZYX");
        shippingPlaceDetailDto.usable(true);
        shippingPlaceDetailDto.setUserId("123");
        shippingPlaceDetailDto.vendorId("A00013264");

        GoodsflowInfoOpenApiDto goodsflowInfoOpenApiDto = new GoodsflowInfoOpenApiDto();
        goodsflowInfoOpenApiDto.setConsumerCashFee05kg(1);
        goodsflowInfoOpenApiDto.setConsumerCashFee10kg(2);
        goodsflowInfoOpenApiDto.setConsumerCashFee20kg(3);
        goodsflowInfoOpenApiDto.setContractCustomerNumber("02-1234-5678");
        goodsflowInfoOpenApiDto.setContractNumber("02-1234-5678");
        goodsflowInfoOpenApiDto.setDeliverCode("789");
        goodsflowInfoOpenApiDto.setDeliverName("FastDelivery");
        goodsflowInfoOpenApiDto.setGoodsflowContractId(1L);
        goodsflowInfoOpenApiDto.setRequestKey(2L);
        goodsflowInfoOpenApiDto.setReturnFee05kg(1);
        goodsflowInfoOpenApiDto.setReturnFee10kg(2);
        goodsflowInfoOpenApiDto.setReturnFee20kg(3);
        goodsflowInfoOpenApiDto.setVendorCashFee05kg(1);
        goodsflowInfoOpenApiDto.setVendorCashFee10kg(2);
        goodsflowInfoOpenApiDto.setVendorCashFee20kg(3);
        goodsflowInfoOpenApiDto.setVendorCreditFee05kg(1);
        goodsflowInfoOpenApiDto.setVendorCreditFee10kg(2);
        goodsflowInfoOpenApiDto.setVendorCreditFee20kg(3);
        shippingPlaceDetailDto.setGoodsflowInfoOpenApiDto(goodsflowInfoOpenApiDto);

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
        remoteInfoDto1.setDeliveryCode("123");
        remoteInfoDto1.setJeju(1);
        remoteInfoDto1.setNotJeju(2);
        remoteInfoDto1.setRemoteInfoId(1L);
        remoteInfoDto1.setUsable(true);

        RemoteInfoDto remoteInfoDto2 = new RemoteInfoDto();
        remoteInfoDto2.setDeliveryCode("456");
        remoteInfoDto2.setJeju(3);
        remoteInfoDto2.setNotJeju(4);
        remoteInfoDto2.setRemoteInfoId(2L);
        remoteInfoDto2.setUsable(false);

        List<RemoteInfoDto> remoteInfoDtos = Arrays.asList(remoteInfoDto1, remoteInfoDto2);
        shippingPlaceDetailDto.setRemoteInfos(remoteInfoDtos);
        return shippingPlaceDetailDto;
    }
}