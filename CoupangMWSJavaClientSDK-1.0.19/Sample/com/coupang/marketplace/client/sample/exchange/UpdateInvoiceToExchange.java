package com.coupang.marketplace.client.sample.exchange;

import java.util.LinkedList;
import java.util.List;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.ExchangeInvoicesDto;
import com.coupang.marketplace.client.model.product.ResponseDtoOfSimpleResultDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 교환상품 송장 업로드 처리
 */
public class UpdateInvoiceToExchange {

	
	private static VendorConfig vendorConfig;
	
	static {
		vendorConfig = new VendorConfig();
	}
	
	public static void main(String[] args) {
        final String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        final String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        final String VENDOR_ID = vendorConfig.getValue("vendor.id");
        long exchangeId = 1L; // provide your own exchange id
	    
	    CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);
	
	    try {
	        // Invoke API
	    	ResponseDtoOfSimpleResultDto result = apiInstance.saveInvoice(exchangeId, VENDOR_ID, createExchangeInvoiceDtos(), VENDOR_ID);
	
	        //print result
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println("result : " + gson.toJson(result));
	    }
	    catch (ApiException e) {
			System.err.println("Exception while updating the invoice for an exchange! " + e.getResponseBody());
	    }
	}
	
	private static List<ExchangeInvoicesDto> createExchangeInvoiceDtos() {
		List<ExchangeInvoicesDto> exchangeInvoices = new LinkedList<>();
		ExchangeInvoicesDto exchangeInvoicesDto = new ExchangeInvoicesDto();
		exchangeInvoicesDto.setExchangeId(Long.parseLong(vendorConfig.getValue("exchange.id")));
		exchangeInvoicesDto.setVendorId(vendorConfig.getValue("vendor.id"));
		exchangeInvoicesDto.setShipmentBoxId(Long.parseLong(vendorConfig.getValue("exchange.shipment.box.id")));
		exchangeInvoicesDto.setGoodsDeliveryCode(vendorConfig.getValue("exchange.goods.delivery.code"));
		exchangeInvoicesDto.setInvoiceNumber(vendorConfig.getValue("exchange.invoice.number"));
		exchangeInvoices.add(exchangeInvoicesDto);
		return exchangeInvoices;
	}
}
