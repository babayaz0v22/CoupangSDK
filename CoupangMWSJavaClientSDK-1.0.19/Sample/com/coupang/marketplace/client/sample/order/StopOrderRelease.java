package com.coupang.marketplace.client.sample.order;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ReleaseStopDto;
import com.coupang.marketplace.client.model.product.ResponseDtoOfSimpleResultDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 출고중지완료 처리
 */
public class StopOrderRelease {

	
	private static VendorConfig vendorConfig;
	
	static {
		vendorConfig = new VendorConfig();
	}

	public static void main(String[] args) {
		final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
		final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
		final String VENDOR_ID = vendorConfig.getValue("vendor.id");

		final String receiptId = ""; // provide your own order receipt id

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
        	ResponseDtoOfSimpleResultDto result = apiInstance.doStopRelease(Long.parseLong(receiptId), VENDOR_ID, createReleaseStopDto(), VENDOR_ID);

            //print result
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println("result : " + gson.toJson(result));
        }
        catch (ApiException e) {
			System.err.println("Exception when doing a stop release for an order! " + e.getResponseBody());
        }
	}

	private static ReleaseStopDto createReleaseStopDto() {
		ReleaseStopDto releaseStopDto = new ReleaseStopDto();
		releaseStopDto.setVendorId(vendorConfig.getValue("vendor.id"));
		releaseStopDto.setReceiptId(Long.parseLong(vendorConfig.getValue("order.receipt.id")));
		releaseStopDto.setCancelCount(1);
		return releaseStopDto;
	}
}
