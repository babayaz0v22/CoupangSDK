package com.coupang.marketplace.client.sample.exchange;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ConfirmContent;
import com.coupang.marketplace.client.model.product.ResponseDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 교환요청상품 입고 확인처리
 */
public class ExchangeGoodsReceiptConfirmation {

	
	private static VendorConfig vendorConfig;
	
	static {
		vendorConfig = new VendorConfig();
	}
	
	public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");
        final String exchangeId = ""; // provide your own exchange id

	    CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);
	
	    try {
	        // Invoke API
	    	ResponseDto result = apiInstance.confirmReturnDeliveryDoneByExchangeId(VENDOR_ID, Long.parseLong(exchangeId), VENDOR_ID, createConfirmContent());
	
	        //print result
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println("result : " + gson.toJson(result));
	    }
	    catch (ApiException e) {
			System.err.println("Exception while fetching the list of exchanges for a Vendor! " + e.getResponseBody());
	    }
	}

	private static ConfirmContent createConfirmContent() {
		ConfirmContent confirmContent = new ConfirmContent();
		confirmContent.setExchangeId(Long.parseLong(vendorConfig.getValue("exchange.id")));
		confirmContent.setVendorId(vendorConfig.getValue("vendor.id"));
		return confirmContent;
	}
}
