package com.coupang.marketplace.client.sample.order;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ReleaseInfoDto;
import com.coupang.marketplace.client.model.product.ResponseDtoOfSimpleResultDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 이미출고 처리
 */
public class AlreadyReleaseOrder {

	
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
        	ResponseDtoOfSimpleResultDto result = apiInstance.doAlreadyRelease(Long.parseLong(receiptId), VENDOR_ID, createReleaseInfoDto(), VENDOR_ID);

			//print result
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println("result : " + gson.toJson(result));
        }
        catch (ApiException e) {
			System.err.println("Exception when doing a stop release for an order! " + e.getResponseBody());
        }
	}

	private static ReleaseInfoDto createReleaseInfoDto() {
		ReleaseInfoDto releaseInfoDto = new ReleaseInfoDto();
		releaseInfoDto.setVendorId(vendorConfig.getValue("vendor.id"));
		releaseInfoDto.setReceiptId(Long.parseLong(vendorConfig.getValue("order.receipt.id")));
		releaseInfoDto.setInvoiceNumber(vendorConfig.getValue("order.invoice.number"));
		releaseInfoDto.setDeliveryCompanyCode("KGB");
		return releaseInfoDto;
	}
}
