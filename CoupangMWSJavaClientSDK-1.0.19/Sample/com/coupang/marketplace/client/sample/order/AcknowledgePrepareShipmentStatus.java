package com.coupang.marketplace.client.sample.order;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.PrepareShipmentReqDto;
import com.coupang.marketplace.client.model.product.ResponseDtoOfOrderSheetResponseDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;

/**
 * 상품준비중 처리
 */
public class AcknowledgePrepareShipmentStatus {

	
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
	    	ResponseDtoOfOrderSheetResponseDto result = apiInstance.applyPrepareShipmentStatus(createPrepareShipmentReqDto(), VENDOR_ID, VENDOR_ID);
	
	        //print result
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println("result : " + gson.toJson(result));
	    }
	    catch (ApiException e) {
			System.err.println("Exception while acknowledging shipment status! " + e.getResponseBody());
	    }
	}
	
	private static PrepareShipmentReqDto createPrepareShipmentReqDto()  {
		PrepareShipmentReqDto prepareShipmentReqDto = new PrepareShipmentReqDto();
		prepareShipmentReqDto.setVendorId(vendorConfig.getValue("vendor.id"));
		final String shipmentBoxIds = vendorConfig.getValue("shipment.shipment.box.ids");
		if(!StringUtils.isBlank(shipmentBoxIds)) {
			String[] shipmentBoxes = shipmentBoxIds.split(",");
			
			for(String shipmentBox : shipmentBoxes) {
				prepareShipmentReqDto.addShipmentBoxIdsItem(Long.parseLong(shipmentBox));
			}
			
		}
		return prepareShipmentReqDto;
	}

}
