package com.coupang.marketplace.client.sample.returnorder;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.InvoiceNumberCreateDto;
import com.coupang.marketplace.client.model.product.ResponseDtoOfInvoiceNumberCreateDto;
import com.coupang.marketplace.client.sample.config.VendorConfig;

/**
 * 회수 수기 송장 등록
 */
public class CreateReturnExchangeInvoce {
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
            InvoiceNumberCreateDto invoiceNumberCreateDto = new InvoiceNumberCreateDto();
            invoiceNumberCreateDto.setDeliveryCompanyCode("KDEXP");
            invoiceNumberCreateDto.setReceiptId(101606005L);
            invoiceNumberCreateDto.setInvoiceNumber("201805291435");
            invoiceNumberCreateDto.setRegNumber("1234568");
            invoiceNumberCreateDto.setReturnExchangeDeliveryType("EXCHANGE");

            // Invoke API
            ResponseDtoOfInvoiceNumberCreateDto result = apiInstance.createInvoiceNumber(VENDOR_ID, invoiceNumberCreateDto, VENDOR_ID);

            //print result
            System.out.println("result : " + result);
        }
        catch (ApiException e) {
            System.err.println("Exception while calling return receive confirmation! " + e.getResponseBody());
        }
    }
}
