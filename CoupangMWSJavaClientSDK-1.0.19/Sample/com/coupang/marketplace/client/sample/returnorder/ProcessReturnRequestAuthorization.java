package com.coupang.marketplace.client.sample.returnorder;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ResponseDto;
import com.coupang.marketplace.client.model.product.ReturnApprovalDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

/**
 * 반품요청 승인 처리
 */
public class ProcessReturnRequestAuthorization {

	
	private static VendorConfig vendorConfig;
	
	static {
		vendorConfig = new VendorConfig();
	}
	
	public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");
        String receiptId = ""; // return request receipt id
	
	    CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);
	
	    try {
	        // Invoke API
	    	ResponseDto result = apiInstance.confirmCancelByPartnerByReceiptId(Long.parseLong(receiptId), createReturnApprovalDto(), VENDOR_ID, VENDOR_ID);
	
	        //print result
			System.out.println("result : " + result);
	    }
	    catch (ApiException e) {
			System.err.println("Exception while calling return receive confirmation! " + e.getResponseBody());
	    }
	}

	private static ReturnApprovalDto createReturnApprovalDto() {
		ReturnApprovalDto returnApprovalDto = new ReturnApprovalDto();
		returnApprovalDto.setVendorId(vendorConfig.getValue("vendor.id"));
		returnApprovalDto.setReceiptId(Long.parseLong(vendorConfig.getValue("return.request.receipt.id")));
		returnApprovalDto.setCancelCount(1);
		
		return returnApprovalDto;
	}
}
