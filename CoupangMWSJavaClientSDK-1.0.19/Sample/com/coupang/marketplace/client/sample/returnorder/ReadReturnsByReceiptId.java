package com.coupang.marketplace.client.sample.returnorder;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ResponseDtoOfReturnDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

/**
 * 반품요청 단건 조회
 */
public class ReadReturnsByReceiptId {

	
	private static VendorConfig vendorConfig;
	
	static {
		vendorConfig = new VendorConfig();
	}
	
	public static void main(String[] args) {
		final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");
        final String receiptId = "";
	
	    CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);
	
	    try {
	        // Invoke API
	    	ResponseDtoOfReturnDto result = apiInstance.getReturnRequestedListByReceiptId(Long.parseLong(receiptId), VENDOR_ID, receiptId);
	
	        //print result
			System.out.println("result : " + result);
	    }
	    catch (ApiException e) {
			System.err.println("Exception while fetching the list of returns for a Vendor! " + e.getResponseBody());
	    }
	}
}
