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
import com.coupang.marketplace.client.util.ResourceBundleFactory;
import com.coupang.marketplace.client.util.SellerProductCategoryValidator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 상품 생성
 */
public class CreateSellerProduct {



    private static VendorConfig vendorConfig;

    static {
        vendorConfig = new VendorConfig();
    }

    public static void main(String[] args) {
        String language = vendorConfig.getValue("language");
        String ACCESS_KEY = vendorConfig.getValue("vendor.access.key");
        String SECRET_KEY = vendorConfig.getValue("vendor.secret.key");
        String VENDOR_ID = vendorConfig.getValue("vendor.id");

        // Create a product to be passed into the API
        OSellerProduct oSellerProduct = new OSellerProduct();
        Long code = new Long(81256);
        oSellerProduct.setDisplayCategoryCode(code);
        oSellerProduct.setSellerProductName("haitao_test_java");
        oSellerProduct.setVendorId(VENDOR_ID);
        oSellerProduct.setSaleStartedAt("2017-11-30T00:00:00");
        oSellerProduct.setSaleEndedAt("2099-01-01T23:59:59");
        oSellerProduct.setBrand("Stchodo");
        oSellerProduct.setDeliveryMethod(OSellerProduct.DeliveryMethodEnum.SEQUENCIAL);
        oSellerProduct.setDeliveryCompanyCode("KGB");
        oSellerProduct.setDeliveryChargeType(OSellerProduct.DeliveryChargeTypeEnum.CONDITIONAL_FREE);
        oSellerProduct.setDeliveryCharge(new Double(0));
        oSellerProduct.setFreeShipOverAmount(new Double(2500));
        oSellerProduct.setDeliveryChargeOnReturn(new Double(0));
        oSellerProduct.setRemoteAreaDeliverable(OSellerProduct.RemoteAreaDeliverableEnum.N);
        oSellerProduct.setUnionDeliveryType(OSellerProduct.UnionDeliveryTypeEnum.UNION_DELIVERY);
        oSellerProduct.setReturnCenterCode("1000274592");
        oSellerProduct.setReturnChargeName("대표이름4");
        oSellerProduct.setCompanyContactNumber("02-1234-678");
        oSellerProduct.setReturnZipCode("135-090");
        oSellerProduct.setReturnAddress("서울특별시 강남구 삼성동");
        oSellerProduct.setReturnAddressDetail("333");
        oSellerProduct.setReturnCharge(new Double(5000));
        oSellerProduct.setReturnChargeVendor(OSellerProduct.ReturnChargeVendorEnum.N);
        oSellerProduct.setAfterServiceContactNumber("1544-1255");
        oSellerProduct.setAfterServiceInformation("A/S안내 1544-1255");
        oSellerProduct.setOutboundShippingPlaceCode(new Long(74010));
        oSellerProduct.setVendorUserId("et5");
        oSellerProduct.setRequested(false);
        oSellerProduct.setRequiredDocuments(null);
        oSellerProduct.setManufacture("제조사");
        oSellerProduct.setContributorType("API_Seller_SDKJavaV1");

        // Populate product items.  This example will create two items
        List<OSellerProductItem> items = new ArrayList<OSellerProductItem>();
        OSellerProductItem item1 = new OSellerProductItem();
        OSellerProductItem item2 = new OSellerProductItem();

        // Populate item1
        item1.setItemName("[Stchodo] 스쳐도 민트코코 빅에디션 버핑 44");
        item1.setOriginalPrice(new Double(13000));
        item1.setSalePrice(new Double(10000));
        item1.setMaximumBuyCount(9999);
        item1.setMaximumBuyForPerson(0);
        item1.setMaximumBuyForPersonPeriod(1);
        item1.setOutboundShippingTimeDay(2);
        item1.setUnitCount(1);
        item1.setFreePriceType("NO_FREE_PRICE");
        item1.setAdultOnly(OSellerProductItem.AdultOnlyEnum.EVERYONE);
        item1.setTaxType(OSellerProductItem.TaxTypeEnum.TAX);
        item1.setParallelImported(OSellerProductItem.ParallelImportedEnum.NOT_PARALLEL_IMPORTED);
        item1.setOverseasPurchased(OSellerProductItem.OverseasPurchasedEnum.NOT_OVERSEAS_PURCHASED);
        item1.setBarcode("");
        item1.setExternalVendorSku("90726");
        item1.setEmptyBarcode(false);
        item1.setEmptyBarcodeReason("");
        item1.setModelNo("");

        // Add extra properties for item1
        Map<String, String> extraProperteis = new HashMap<String, String>();
        extraProperteis.put("coupangSalePrice", "5000");
        extraProperteis.put("onlineSalePriceForBooks", "10000");
        extraProperteis.put("transactionType", "manufacturer");
        extraProperteis.put("businessType", "Beauty");

        item1.setExtraProperties(extraProperteis);

        // Add certifications for item1
        List<OSellerProductItemCertification> certs = new ArrayList<OSellerProductItemCertification>();
        OSellerProductItemCertification cert11 = new OSellerProductItemCertification();
        cert11.setCertificationType("NOT_REQUIRED");
        cert11.setCertificationCode("");

        item1.setCertifications(certs);

        // Add search tags for item1
        List<String> tags = new ArrayList<String>();
        tags.add("검색어1");
        tags.add("검색어2");

        item1.setSearchTags(tags);

        // Populate images for item1
        List<OSellerProductItemImage> imagesForItem1 = new ArrayList<OSellerProductItemImage>();
        OSellerProductItemImage image1ForItem1 = new OSellerProductItemImage();
        image1ForItem1.setImageOrder(new Long(0));
        image1ForItem1.setImageType(OSellerProductItemImage.ImageTypeEnum.REPRESENTATION);
        image1ForItem1.setVendorPath("http://img3.ownerclan.com/api/images/151009/151009021007000006.jpg");
        imagesForItem1.add(image1ForItem1);

        OSellerProductItemImage image2ForItem1 = new OSellerProductItemImage();
        image2ForItem1.setImageOrder(new Long(1));
        image2ForItem1.setImageType(OSellerProductItemImage.ImageTypeEnum.USED_PRODUCT);
        image2ForItem1.setVendorPath("http://img.fashionplus.co.kr/mall/assets/product_img/27673/plg27673_0000004440.jpg");
        imagesForItem1.add(image2ForItem1);

        OSellerProductItemImage image3ForItem1 = new OSellerProductItemImage();
        image3ForItem1.setImageOrder(new Long(2));
        image3ForItem1.setImageType(OSellerProductItemImage.ImageTypeEnum.USED_PRODUCT);
        image3ForItem1.setVendorPath("http://img3.ownerclan.com/api/images/151009/151009021007000006.jpg");
        imagesForItem1.add(image3ForItem1);

        item1.setImages(imagesForItem1);

        // Populate notices for item1
        List<OSellerProductItemNotice> notictsForItem1 = new ArrayList<OSellerProductItemNotice>();
        OSellerProductItemNotice notice1ForItem1 = new OSellerProductItemNotice();
        notice1ForItem1.setNoticeCategoryName("구두/신발");
        notice1ForItem1.setNoticeCategoryDetailName("제품의 주소재(운동화인 경우에는 겉감,안감을 구분하여 표시)");
        notice1ForItem1.setContent("상세페이지 참조");
        OSellerProductItemNotice notice2ForItem1 = new OSellerProductItemNotice();
        notice2ForItem1.setNoticeCategoryName("구두/신발");
        notice2ForItem1.setNoticeCategoryDetailName("색상");
        notice2ForItem1.setContent("상세페이지 참조");
        OSellerProductItemNotice notice3ForItem1 = new OSellerProductItemNotice();
        notice3ForItem1.setNoticeCategoryName("구두/신발");
        notice3ForItem1.setNoticeCategoryDetailName("치수");
        notice3ForItem1.setContent("상세페이지 참조");
        OSellerProductItemNotice notice4ForItem1 = new OSellerProductItemNotice();
        notice4ForItem1.setNoticeCategoryName("구두/신발");
        notice4ForItem1.setNoticeCategoryDetailName("제조자(수입자)");
        notice4ForItem1.setContent("상세페이지 참조");
        OSellerProductItemNotice notice5ForItem1 = new OSellerProductItemNotice();
        notice5ForItem1.setNoticeCategoryName("구두/신발");
        notice5ForItem1.setNoticeCategoryDetailName("제조국");
        notice5ForItem1.setContent("상세페이지 참조");
        OSellerProductItemNotice notice6ForItem1 = new OSellerProductItemNotice();
        notice6ForItem1.setNoticeCategoryName("구두/신발");
        notice6ForItem1.setNoticeCategoryDetailName("취급시 주의사항");
        notice6ForItem1.setContent("상세페이지 참조");
        OSellerProductItemNotice notice7ForItem1 = new OSellerProductItemNotice();
        notice7ForItem1.setNoticeCategoryName("구두/신발");
        notice7ForItem1.setNoticeCategoryDetailName("품질보증기준");
        notice7ForItem1.setContent("상세페이지 참조");
        OSellerProductItemNotice notice8ForItem1 = new OSellerProductItemNotice();
        notice8ForItem1.setNoticeCategoryName("구두/신발");
        notice8ForItem1.setNoticeCategoryDetailName("A/S 책임자와 전화번호");
        notice8ForItem1.setContent("상세페이지 참조");

        notictsForItem1.add(notice1ForItem1);
        notictsForItem1.add(notice2ForItem1);
        notictsForItem1.add(notice3ForItem1);
        notictsForItem1.add(notice4ForItem1);
        notictsForItem1.add(notice5ForItem1);
        notictsForItem1.add(notice6ForItem1);
        notictsForItem1.add(notice7ForItem1);
        notictsForItem1.add(notice8ForItem1);
        item1.setNotices(notictsForItem1);

        // Populate attributes for item1
        List<OSellerProductItemAttribute> attrsForItem1 = new ArrayList<OSellerProductItemAttribute>();
        OSellerProductItemAttribute attr1ForItem1 = new OSellerProductItemAttribute();
        attr1ForItem1.setAttributeTypeName("색상");
        attr1ForItem1.setAttributeValueName("GREY");

        OSellerProductItemAttribute attr2ForItem1 = new OSellerProductItemAttribute();
        attr2ForItem1.setAttributeTypeName("신발사이즈(mm)");
        attr2ForItem1.setAttributeValueName("44");

        attrsForItem1.add(attr1ForItem1);
        attrsForItem1.add(attr2ForItem1);
        item1.setAttributes(attrsForItem1);

        // Populate contents for item1
        List<OSellerProductItemContent> contentsForItem1 = new ArrayList<OSellerProductItemContent>();
        OSellerProductItemContent content1ForItem1 = new OSellerProductItemContent();
        content1ForItem1.setContentsType(OSellerProductItemContent.ContentsTypeEnum.TEXT);
        List<OVendorInventoryItemContentDetail> details = new ArrayList<OVendorInventoryItemContentDetail>();
        OVendorInventoryItemContentDetail detail1 = new OVendorInventoryItemContentDetail();
        detail1.setDetailType(OVendorInventoryItemContentDetail.DetailTypeEnum.TEXT);
        detail1.setContent("<html><div></div><div><img src='http://www.babomall.com/bbsemarket/gimage/7005345_2014_04_09_10_02_25_111.jpg' /><div></html>");
        details.add(detail1);
        content1ForItem1.setContentDetails(details);

        contentsForItem1.add(content1ForItem1);
        item1.setContents(contentsForItem1);

        // Populate item2
        item2.setItemName("[Stchodo] 스쳐도 민트코코 빅에디션 버핑 55");
        item2.setOriginalPrice(new Double(13000));
        item2.setSalePrice(new Double(10000));
        item2.setMaximumBuyCount(9999);
        item2.setMaximumBuyForPerson(0);
        item2.setMaximumBuyForPersonPeriod(1);
        item2.setOutboundShippingTimeDay(2);
        item2.setUnitCount(1);
        item2.setFreePriceType("NO_FREE_PRICE");
        item2.setAdultOnly(OSellerProductItem.AdultOnlyEnum.EVERYONE);
        item2.setTaxType(OSellerProductItem.TaxTypeEnum.TAX);
        item2.setParallelImported(OSellerProductItem.ParallelImportedEnum.NOT_PARALLEL_IMPORTED);
        item2.setOverseasPurchased(OSellerProductItem.OverseasPurchasedEnum.NOT_OVERSEAS_PURCHASED);
        item2.setBarcode("");
        item2.setExternalVendorSku("90726");
        item2.setEmptyBarcode(false);
        item2.setEmptyBarcodeReason("");
        item2.setModelNo("");
        item2.setExtraProperties(null);

        // Populate certifications for item2
        List<OSellerProductItemCertification> certsForItem2 = new ArrayList<OSellerProductItemCertification>();
        OSellerProductItemCertification cert12 = new OSellerProductItemCertification();
        cert12.setCertificationType("NOT_REQUIRED");
        cert12.setCertificationCode("");

        item2.setCertifications(certsForItem2);

        // Populate search tags for item2
        List<String> tagsForItem2 = new ArrayList<String>();
        tagsForItem2.add("검색어1");
        tagsForItem2.add("검색어2");

        item2.setSearchTags(tagsForItem2);

        // Populate images for item2
        List<OSellerProductItemImage> imagesForItem2 = new ArrayList<OSellerProductItemImage>();
        OSellerProductItemImage image1ForItem2 = new OSellerProductItemImage();
        image1ForItem2.setImageOrder(new Long(0));
        image1ForItem2.setImageType(OSellerProductItemImage.ImageTypeEnum.REPRESENTATION);
        image1ForItem2.setVendorPath("http://img3.ownerclan.com/api/images/151009/151009021007000006.jpg");

        OSellerProductItemImage image2ForItem2 = new OSellerProductItemImage();
        image2ForItem2.setImageOrder(new Long(1));
        image2ForItem2.setImageType(OSellerProductItemImage.ImageTypeEnum.USED_PRODUCT);
        image2ForItem2.setVendorPath("http://img.fashionplus.co.kr/mall/assets/product_img/27673/plg27673_0000004440.jpg");

        OSellerProductItemImage image3ForItem2 = new OSellerProductItemImage();
        image3ForItem2.setImageOrder(new Long(2));
        image3ForItem2.setImageType(OSellerProductItemImage.ImageTypeEnum.USED_PRODUCT);
        image3ForItem2.setVendorPath("http://img3.ownerclan.com/api/images/151009/151009021007000006.jpg");

        imagesForItem2.add(image1ForItem2);
        imagesForItem2.add(image2ForItem2);
        imagesForItem2.add(image3ForItem2);
        item2.setImages(imagesForItem2);

        // Populate notices for item2
        List<OSellerProductItemNotice> notictsForItem2 = new ArrayList<OSellerProductItemNotice>();
        OSellerProductItemNotice notice1ForItem2 = new OSellerProductItemNotice();
        notice1ForItem2.setNoticeCategoryName("구두/신발");
        notice1ForItem2.setNoticeCategoryDetailName("제품의 주소재(운동화인 경우에는 겉감,안감을 구분하여 표시)");
        notice1ForItem2.setContent("상세페이지 참조");
        OSellerProductItemNotice notice2ForItem2 = new OSellerProductItemNotice();
        notice2ForItem2.setNoticeCategoryName("구두/신발");
        notice2ForItem2.setNoticeCategoryDetailName("색상");
        notice2ForItem2.setContent("상세페이지 참조");
        OSellerProductItemNotice notice3ForItem2 = new OSellerProductItemNotice();
        notice3ForItem2.setNoticeCategoryName("구두/신발");
        notice3ForItem2.setNoticeCategoryDetailName("치수");
        notice3ForItem2.setContent("상세페이지 참조");
        OSellerProductItemNotice notice4ForItem2 = new OSellerProductItemNotice();
        notice4ForItem2.setNoticeCategoryName("구두/신발");
        notice4ForItem2.setNoticeCategoryDetailName("제조자(수입자)");
        notice4ForItem2.setContent("상세페이지 참조");
        OSellerProductItemNotice notice5ForItem2 = new OSellerProductItemNotice();
        notice5ForItem2.setNoticeCategoryName("구두/신발");
        notice5ForItem2.setNoticeCategoryDetailName("제조국");
        notice5ForItem2.setContent("상세페이지 참조");
        OSellerProductItemNotice notice6ForItem2 = new OSellerProductItemNotice();
        notice6ForItem2.setNoticeCategoryName("구두/신발");
        notice6ForItem2.setNoticeCategoryDetailName("취급시 주의사항");
        notice6ForItem2.setContent("상세페이지 참조");
        OSellerProductItemNotice notice7ForItem2 = new OSellerProductItemNotice();
        notice7ForItem2.setNoticeCategoryName("구두/신발");
        notice7ForItem2.setNoticeCategoryDetailName("품질보증기준");
        notice7ForItem2.setContent("상세페이지 참조");
        OSellerProductItemNotice notice8ForItem2 = new OSellerProductItemNotice();
        notice8ForItem2.setNoticeCategoryName("구두/신발");
        notice8ForItem2.setNoticeCategoryDetailName("A/S 책임자와 전화번호");
        notice8ForItem2.setContent("상세페이지 참조");

        notictsForItem2.add(notice1ForItem2);
        notictsForItem2.add(notice2ForItem2);
        notictsForItem2.add(notice3ForItem2);
        notictsForItem2.add(notice4ForItem2);
        notictsForItem2.add(notice5ForItem2);
        notictsForItem2.add(notice6ForItem2);
        notictsForItem2.add(notice7ForItem2);
        notictsForItem2.add(notice8ForItem2);
        item2.setNotices(notictsForItem2);

        // Populate attributes for item2
        List<OSellerProductItemAttribute> attrsForItem2 = new ArrayList<OSellerProductItemAttribute>();
        OSellerProductItemAttribute attr1ForItem2 = new OSellerProductItemAttribute();
        attr1ForItem2.setAttributeTypeName("색상");
        attr1ForItem2.setAttributeValueName("GREY");

        OSellerProductItemAttribute attr2ForItem2 = new OSellerProductItemAttribute();
        attr2ForItem2.setAttributeTypeName("신발사이즈(mm)");
        attr2ForItem2.setAttributeValueName("55");

        attrsForItem2.add(attr1ForItem2);
        attrsForItem2.add(attr2ForItem2);
        item2.setAttributes(attrsForItem2);

        // Populate contents for item2
        List<OSellerProductItemContent> contentsForItem2 = new ArrayList<OSellerProductItemContent>();
        OSellerProductItemContent content1ForItem2 = new OSellerProductItemContent();
        content1ForItem2.setContentsType(OSellerProductItemContent.ContentsTypeEnum.TEXT);
        List<OVendorInventoryItemContentDetail> detailss = new ArrayList<OVendorInventoryItemContentDetail>();
        OVendorInventoryItemContentDetail detail12 = new OVendorInventoryItemContentDetail();
        detail12.setDetailType(OVendorInventoryItemContentDetail.DetailTypeEnum.TEXT);
        detail12.setContent("<html><div></div><div><img src='http://www.babomall.com/bbsemarket/gimage/7005345_2014_04_09_10_02_25_111.jpg' /><div></html>");
        detailss.add(detail1);
        content1ForItem2.setContentDetails(detailss);

        contentsForItem2.add(content1ForItem2);
        item2.setContents(contentsForItem2);

        // Add items to the collection
        items.add(item1);
        items.add(item2);

        oSellerProduct.setItems(items);

        try {
            // "validation_message" is the base name of the resource bundle to localize the validation message in both Korean and English
            ResourceBundle resourceBundle = ResourceBundleFactory.createResourceBundle("validation_message", language);
            // Validate OSellerProduct
            SellerProductCategoryValidator.validateSellerProduct(VENDOR_ID, code, SECRET_KEY, ACCESS_KEY, oSellerProduct, resourceBundle);

            // Provide the api name, secret key and access key to generate HMAC token
            // api name is the the method invoked on DefaultAPI.  For example: if invoking apiInstance.createSellerProduct
            // the api name is "createSellerProduct" case sensitive.
            CoupangMarketPlaceApi apiInstance = new CoupangMarketPlaceApi(SECRET_KEY, ACCESS_KEY);

            // Invoke API
            OpenApiResultOflong result = apiInstance.createSellerProduct(VENDOR_ID, oSellerProduct);

            //print result
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("result : " + gson.toJson(result));
        }
        catch (ApiException e) {
            System.err.println("Exception when calling createSellerProduct! " + e.getResponseBody());
        }
        catch (Exception e) {
            System.err.println("Exception thrown " + e);
        }
    }
}
