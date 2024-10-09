package com.coupang.marketplace.client.sample.order;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ResponseDtoOfOrderSheetDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 발주서 단건 조회 (shipmentBoxId)
 */
public class ReadOrderByShipmentBoxId {


	private static VendorConfig vendorConfig;

	static {
		vendorConfig = new VendorConfig();
	}

	public static void main(String[] args) {
		final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
		final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
		final String VENDOR_ID = vendorConfig.getValue("vendor.id");

		final long shipmentBoxId = 0L; // provide your own shipment box id

        // Provide the api name, secret key and access key to generate HMAC token
        // api name is the the method invoked on DefaultAPI.  For example: if invoking apiInstance.readSellerProduct
        // the api name "readSellerProduct" case sensitive.
	
	    CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
        	ResponseDtoOfOrderSheetDto result = apiInstance.getOrderSheetByShipmentBoxId(shipmentBoxId, VENDOR_ID, VENDOR_ID);

            //print result
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println("result : " + gson.toJson(result));
        }
        catch (ApiException e) {
			System.err.println("Exception when calling orderSheetBy shipmentBox Id! " + e.getResponseBody());
        }
	}
}
