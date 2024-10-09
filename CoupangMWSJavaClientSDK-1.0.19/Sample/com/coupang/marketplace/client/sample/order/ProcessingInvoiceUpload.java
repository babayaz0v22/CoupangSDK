package com.coupang.marketplace.client.sample.order;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.OrderSheetInvoiceApplyDtoV2;
import com.coupang.marketplace.client.model.product.ResponseDtoOfOrderSheetResponseDto;
import com.coupang.marketplace.client.model.product.UploadInvoiceReqDtoV2;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 송장업로드 처리
 */
public class ProcessingInvoiceUpload {

	
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
	    	ResponseDtoOfOrderSheetResponseDto result = apiInstance.applyInvoicesUpload(createUploadInvoiceReqDto(), VENDOR_ID, VENDOR_ID);

			//print result
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println("result : " + gson.toJson(result));
	    }
	    catch (ApiException e) {
			System.err.println("Exception while applying invoices! " + e.getResponseBody());
	    }
	}
	
	private static UploadInvoiceReqDtoV2 createUploadInvoiceReqDto() {
		UploadInvoiceReqDtoV2 uploadInvoiceReqDtoV2 = new UploadInvoiceReqDtoV2();
		
		OrderSheetInvoiceApplyDtoV2 orderSheetInvoiceApplyDtoV2 = new OrderSheetInvoiceApplyDtoV2();
		orderSheetInvoiceApplyDtoV2.setShipmentBoxId(Long.parseLong(vendorConfig.getValue("invoice.shipment.box.id")));
		orderSheetInvoiceApplyDtoV2.setOrderId(Long.parseLong(vendorConfig.getValue("invoice.order.id")));
		orderSheetInvoiceApplyDtoV2.setVendorItemId(Long.parseLong(vendorConfig.getValue("invoice.vendor.item.id")));
		orderSheetInvoiceApplyDtoV2.setDeliveryCompanyCode(vendorConfig.getValue("invoice.delivery.company.code"));
		orderSheetInvoiceApplyDtoV2.setInvoiceNumber(vendorConfig.getValue("invoice.number"));
		orderSheetInvoiceApplyDtoV2.setSplitShipping(Boolean.valueOf(vendorConfig.getValue("invoice.split.shipping")));
		orderSheetInvoiceApplyDtoV2.setPreSplitShipped(Boolean.valueOf(vendorConfig.getValue("invoice.pre.split.shipped")));
		orderSheetInvoiceApplyDtoV2.setEstimatedShippingDate("");
		
		uploadInvoiceReqDtoV2.addOrderSheetInvoiceApplyDtosItem(orderSheetInvoiceApplyDtoV2);
		uploadInvoiceReqDtoV2.setVendorId(vendorConfig.getValue("vendor.id"));
		
		return uploadInvoiceReqDtoV2;
	}

}
