package com.coupang.marketplace.client.sample.returnorder;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ResponseDto;
import com.coupang.marketplace.client.model.product.WarehouseCheckDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

/**
 * 반품상품 입고 확인처리
 */
public class ReturnReceiveConfirmation {

	
	private static VendorConfig vendorConfig;
	
	static {
		vendorConfig = new VendorConfig();
	}
	
	public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");
		Long receiptId = null; // provide your own return receipt id

	    CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);
	
	    try {
	        // Invoke API
	    	ResponseDto result = apiInstance.returnDeliveryDoneConfirmation(receiptId, createWarehouseCheckDto(), VENDOR_ID, VENDOR_ID);
	
	        //print result
			System.out.println("result : " + result);
	    } catch (ApiException e) {
			System.err.println("Exception while calling return receive confirmation! " + e.getResponseBody());
	    }
	}
	
	private static WarehouseCheckDto createWarehouseCheckDto() {
		WarehouseCheckDto warehouseCheckDto = new WarehouseCheckDto();
		warehouseCheckDto.setVendorId(vendorConfig.getValue("vendor.id"));
		warehouseCheckDto.setReceiptId(Long.parseLong(vendorConfig.getValue("return.receipt.id")));
		return warehouseCheckDto;
	}
}
