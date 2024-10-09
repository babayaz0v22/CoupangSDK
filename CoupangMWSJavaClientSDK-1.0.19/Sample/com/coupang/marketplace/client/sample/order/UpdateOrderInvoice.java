package com.coupang.marketplace.client.sample.order;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.*;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * 송장업데이트 처리
 */
public class UpdateOrderInvoice {
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
            List<OrderSheetInvoiceDto> OrderSheetInvoiceDtos = new ArrayList<>();
            OrderSheetInvoiceDto orderSheetInvoiceDto =  new OrderSheetInvoiceDto();
            orderSheetInvoiceDto.setShipmentBoxId(614018634L);
            orderSheetInvoiceDto.setOrderId(2000019631453L);
            orderSheetInvoiceDto.setVendorItemId(3819657333L);
            orderSheetInvoiceDto.setDeliveryCompanyCode("KDEXP");
            orderSheetInvoiceDto.setInvoiceNumber("201808231414");
            orderSheetInvoiceDto.setSplitShipping(false);
            orderSheetInvoiceDto.setPreSplitShipped(false);
            orderSheetInvoiceDto.setEstimatedShippingDate("");

            InvoiceReqDto invoiceReqDto = new InvoiceReqDto();
            invoiceReqDto.setVendorId(VENDOR_ID);
            invoiceReqDto.setOrderSheetInvoiceApplyDtos(OrderSheetInvoiceDtos);

            // Invoke API
            ResponseDtoOfOrderSheetResponseDto result = apiInstance.updateInvoices(invoiceReqDto, VENDOR_ID, VENDOR_ID);
            //print result
            System.out.println("result : " + result);
        }
        catch (ApiException e) {
            System.err.println("Exception while calling return receive confirmation! " + e.getResponseBody());
        }
    }
}
