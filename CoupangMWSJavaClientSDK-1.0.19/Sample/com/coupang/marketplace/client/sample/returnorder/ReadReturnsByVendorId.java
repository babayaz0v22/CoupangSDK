package com.coupang.marketplace.client.sample.returnorder;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ResponseDtoOfListOfReturnDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

/**
 * 반품요청 목록 조회(일단위 / 분단위 페이징)
 */
public class ReadReturnsByVendorId {

	
	private static VendorConfig vendorConfig;
	
	static {
		vendorConfig = new VendorConfig();
	}
	
	public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");

        final Long orderId = null; // provide your own order id
        final String createdAtFrom = "2020-08-01"; // provide your own filtering start date
	    final String createdAtTo = "2020-08-10"; // provide your own filtering end date
	    final String status = "UC"; // provide your own status
		final String searchType = ""; // provide your own search type
		final String nextToken = "1"; // provide your own next token
		final String cancelType = ""; // if you want to query for canceled order list, set this to "CANCEL" and set status to null
		int maxPerPage = 10; // provide your own page size limit
	
	    CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);
	
	    try {
			apiInstance.getApiClient().addDefaultHeader("X-EXTENDED-TIMEOUT", "90000");
	        // Invoke API
	    	ResponseDtoOfListOfReturnDto result = apiInstance.getReturnRequestedListByVendorId(VENDOR_ID, VENDOR_ID, createdAtFrom, createdAtTo, status, orderId, nextToken, maxPerPage, searchType, cancelType);
	
	        //print result
			System.out.println("result : " + result);
	    }
	    catch (ApiException e) {
			System.err.println("Exception while fetching the list of returns for a Vendor! " + e.getResponseBody());
	    }
	}
}
