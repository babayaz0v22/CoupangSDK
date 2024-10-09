package com.coupang.marketplace.client.sample.product;

import com.coupang.marketplace.client.ApiException;
import com.coupang.marketplace.client.api.CoupangMarketPlaceApi;
import com.coupang.marketplace.client.model.product.OSellerProduct;
import com.coupang.marketplace.client.model.product.OSellerProductItem;
import com.coupang.marketplace.client.model.product.OSellerProductItemAttribute;
import com.coupang.marketplace.client.model.product.OSellerProductItemCertification;
import com.coupang.marketplace.client.model.product.OSellerProductItemContent;
import com.coupang.marketplace.client.model.product.OSellerProductItemImage;
import com.coupang.marketplace.client.model.product.OSellerProductItemNotice;
import com.coupang.marketplace.client.model.product.OVendorInventoryItemContentDetail;
import com.coupang.marketplace.client.model.product.OpenApiResultOflong;
import com.coupang.marketplace.client.sample.config.VendorConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 상품 수정
 */
public class UpdateSellerProduct {


    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {

        String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        String VENDOR_ID = vendorConfig.getValue("vendor.id");
        String sellerProductId = ""; // provide your own seller product id

        // Replace with your own seller product id
        long SELLER_PRODUCT_ID = Long.parseLong(sellerProductId);
        // Update an existing product by passing an oSellerProduct object
        OSellerProduct oSellerProduct = new OSellerProduct();

        // Seller product id is required for identifying the product to be updated
        oSellerProduct.setSellerProductId(SELLER_PRODUCT_ID);

        Long code = 81592L;
        oSellerProduct.setDisplayCategoryCode(code);
        oSellerProduct.setSellerProductName("Your updated seller product name");
        oSellerProduct.setVendorId(VENDOR_ID);
        oSellerProduct.setSaleStartedAt("2021-11-30T00:00:00");
        oSellerProduct.setSaleEndedAt("2099-01-01T23:59:59");
        oSellerProduct.setBrand("나이키");
        oSellerProduct.setDeliveryMethod(OSellerProduct.DeliveryMethodEnum.SEQUENCIAL);
        oSellerProduct.setDeliveryCompanyCode("KGB");
        oSellerProduct.setDeliveryChargeType(OSellerProduct.DeliveryChargeTypeEnum.FREE);
        oSellerProduct.setDeliveryCharge(0.0);
        oSellerProduct.setFreeShipOverAmount(0.0);
        oSellerProduct.setDeliveryChargeOnReturn(0.0);
        oSellerProduct.setRemoteAreaDeliverable(OSellerProduct.RemoteAreaDeliverableEnum.N);
        oSellerProduct.setUnionDeliveryType(OSellerProduct.UnionDeliveryTypeEnum.UNION_DELIVERY);
        oSellerProduct.setReturnCenterCode("1000274592");
        oSellerProduct.setReturnChargeName("대표이름4");
        oSellerProduct.setCompanyContactNumber("02-1234-678");
        oSellerProduct.setReturnZipCode("135-090");
        oSellerProduct.setReturnAddress("서울특별시 강남구 삼성동");
        oSellerProduct.setReturnAddressDetail("333");
        oSellerProduct.setReturnCharge(5000.0);
        oSellerProduct.setReturnChargeVendor(OSellerProduct.ReturnChargeVendorEnum.N);
        oSellerProduct.setAfterServiceContactNumber("1544-1255");
        oSellerProduct.setAfterServiceInformation("A/S안내 1544-1255");
        oSellerProduct.setOutboundShippingPlaceCode(74010L);
        oSellerProduct.setVendorUserId("et5");
        oSellerProduct.setRequested(false);
        oSellerProduct.setRequiredDocuments(null);
        oSellerProduct.setManufacture("나이키");

        // Populate product items.
        List<OSellerProductItem> items = new ArrayList<>();
        OSellerProductItem item = new OSellerProductItem();

        // Populate item
        item.setVendorItemId(1234L);
        item.setItemName("Your item name");
        item.setOriginalPrice(0.0);
        item.setSalePrice(1000000.0);
        item.setMaximumBuyCount(0);
        item.setMaximumBuyForPerson(0);
        item.setMaximumBuyForPersonPeriod(1);
        item.setOutboundShippingTimeDay(1);
        item.setUnitCount(0);
        item.setFreePriceType(null);
        item.setAdultOnly(OSellerProductItem.AdultOnlyEnum.EVERYONE);
        item.setTaxType(OSellerProductItem.TaxTypeEnum.TAX);
        item.setParallelImported(OSellerProductItem.ParallelImportedEnum.NOT_PARALLEL_IMPORTED);
        item.setOverseasPurchased(OSellerProductItem.OverseasPurchasedEnum.NOT_OVERSEAS_PURCHASED);
        item.setBarcode("");
        item.setExternalVendorSku(null);
        item.setEmptyBarcode(true);
        item.setEmptyBarcodeReason("NOT_ISSUED");
        item.setModelNo("");

        // Add extra properties for item
        Map<String, String> extraProperties = new HashMap<>();
        item.setExtraProperties(extraProperties);

        // Add certifications for item
        List<OSellerProductItemCertification> certs = new ArrayList<>();
        OSellerProductItemCertification cert = new OSellerProductItemCertification();
        cert.setCertificationType("NOT_REQUIRED");
        cert.setCertificationCode("");

        item.setCertifications(certs);

        // Add search tags for item
        List<String> tags = new ArrayList<>();
        item.setSearchTags(tags);

        // Populate images for item
        List<OSellerProductItemImage> imagesForItem = new ArrayList<>();
        OSellerProductItemImage image1ForItem = new OSellerProductItemImage();
        image1ForItem.setImageOrder(0L);
        image1ForItem.setImageType(OSellerProductItemImage.ImageTypeEnum.REPRESENTATION);
        image1ForItem.setVendorPath("http://img3.ownerclan.com/api/images/151009/151009021007000006.jpg");
        imagesForItem.add(image1ForItem);
        item.setImages(imagesForItem);

        // Populate notices for item
        List<OSellerProductItemNotice> noticesForItem = new ArrayList<>();
        OSellerProductItemNotice notice1ForItem = new OSellerProductItemNotice();
        notice1ForItem.setNoticeCategoryName("패션잡화(모자/벨트/액세서리)");
        notice1ForItem.setNoticeCategoryDetailName("종류");
        notice1ForItem.setContent("상세페이지 참조");
        OSellerProductItemNotice notice2ForItem = new OSellerProductItemNotice();
        notice2ForItem.setNoticeCategoryName("패션잡화(모자/벨트/액세서리)");
        notice2ForItem.setNoticeCategoryDetailName("소재");
        notice2ForItem.setContent("상세페이지 참조");
        OSellerProductItemNotice notice3ForItem = new OSellerProductItemNotice();
        notice3ForItem.setNoticeCategoryName("패션잡화(모자/벨트/액세서리)");
        notice3ForItem.setNoticeCategoryDetailName("치수");
        notice3ForItem.setContent("상세페이지 참조");
        OSellerProductItemNotice notice4ForItem = new OSellerProductItemNotice();
        notice4ForItem.setNoticeCategoryName("패션잡화(모자/벨트/액세서리)");
        notice4ForItem.setNoticeCategoryDetailName("제조자(수입자)");
        notice4ForItem.setContent("상세페이지 참조");
        OSellerProductItemNotice notice5ForItem = new OSellerProductItemNotice();
        notice5ForItem.setNoticeCategoryName("패션잡화(모자/벨트/액세서리)");
        notice5ForItem.setNoticeCategoryDetailName("제조국");
        notice5ForItem.setContent("상세페이지 참조");
        OSellerProductItemNotice notice6ForItem = new OSellerProductItemNotice();
        notice6ForItem.setNoticeCategoryName("패션잡화(모자/벨트/액세서리)");
        notice6ForItem.setNoticeCategoryDetailName("취급시 주의사항");
        notice6ForItem.setContent("상세페이지 참조");
        OSellerProductItemNotice notice7ForItem = new OSellerProductItemNotice();
        notice7ForItem.setNoticeCategoryName("패션잡화(모자/벨트/액세서리)");
        notice7ForItem.setNoticeCategoryDetailName("품질보증기준");
        notice7ForItem.setContent("상세페이지 참조");
        OSellerProductItemNotice notice8ForItem = new OSellerProductItemNotice();
        notice8ForItem.setNoticeCategoryName("패션잡화(모자/벨트/액세서리)");
        notice8ForItem.setNoticeCategoryDetailName("A/S 책임자와 전화번호");
        notice8ForItem.setContent("상세페이지 참조");

        noticesForItem.add(notice1ForItem);
        noticesForItem.add(notice2ForItem);
        noticesForItem.add(notice3ForItem);
        noticesForItem.add(notice4ForItem);
        noticesForItem.add(notice5ForItem);
        noticesForItem.add(notice6ForItem);
        noticesForItem.add(notice7ForItem);
        noticesForItem.add(notice8ForItem);

        item.setNotices(noticesForItem);

        // Populate attributes for item
        List<OSellerProductItemAttribute> attrsForItem = new ArrayList<>();
        OSellerProductItemAttribute attr1ForItem = new OSellerProductItemAttribute();
        attr1ForItem.setAttributeTypeName("신발사이즈(mm)");
        attr1ForItem.setAttributeValueName("250");

        OSellerProductItemAttribute attr2ForItem = new OSellerProductItemAttribute();
        attr2ForItem.setAttributeTypeName("패션 의류/잡화 색상계열");
        attr2ForItem.setAttributeValueName("nice");

        OSellerProductItemAttribute attr3ForItem = new OSellerProductItemAttribute();
        attr3ForItem.setAttributeTypeName("제조년도");
        attr3ForItem.setAttributeValueName("good");

        OSellerProductItemAttribute attr4ForItem = new OSellerProductItemAttribute();
        attr4ForItem.setAttributeTypeName("색상");
        attr4ForItem.setAttributeValueName("705149-410");

        OSellerProductItemAttribute attr5ForItem = new OSellerProductItemAttribute();
        attr5ForItem.setAttributeTypeName("사용계절");
        attr5ForItem.setAttributeValueName("super");

        attrsForItem.add(attr1ForItem);
        attrsForItem.add(attr2ForItem);
        attrsForItem.add(attr3ForItem);
        attrsForItem.add(attr4ForItem);
        attrsForItem.add(attr5ForItem);
        item.setAttributes(attrsForItem);

        // Populate contents for item
        List<OSellerProductItemContent> contentsForItem = new ArrayList<>();
        OSellerProductItemContent content1ForItem = new OSellerProductItemContent();
        content1ForItem.setContentsType(OSellerProductItemContent.ContentsTypeEnum.HTML);
        List<OVendorInventoryItemContentDetail> details = new ArrayList<>();
        OVendorInventoryItemContentDetail detail1 = new OVendorInventoryItemContentDetail();
        detail1.setDetailType(OVendorInventoryItemContentDetail.DetailTypeEnum.TEXT);
        detail1.setContent("<html><div></div><div><img src='http://www.babomall.com/bbsemarket/gimage/7005345_2014_04_09_10_02_25_111.jpg' /><div></html>");
        details.add(detail1);
        content1ForItem.setContentDetails(details);

        contentsForItem.add(content1ForItem);
        item.setContents(contentsForItem);

        // Add items to the collection
        items.add(item);

        oSellerProduct.setItems(items);

        CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

        try {
            // Invoke API
            OpenApiResultOflong result = apiInstance.updateSellerProduct(VENDOR_ID, oSellerProduct);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        } catch (ApiException e) {
            System.err.println("Exception when calling updateSellerProduct! " + e.getResponseBody());
        }
    }
}
