#1.0.19

Released date : Jan, 7, 2022

##Summary

* Add downaloableCoupon attribute to sales history inquiry API

##details

* [SSA-1241] Add shipmentType field into OPEN API SDK OrderSheetDTO class

#1.0.18

Released date : Nov, 5, 2021

##Summary

* Add downaloableCoupon attribute to sales history inquiry API

##details

* [LSOAPI-1367] Add downaloableCoupon attribute to sales history inquiry API

#1.0.17

Released date : Nov, 19, 2020

##Summary

* buf fix for CS confirmInquiry and update sample codes

##details

* [SSA-1058] buf fix for CS confirmInquiry 

#1.0.16

Released date : Aug, 10, 2020

##Summary

* add nextToken for return list api 

##details

* [SSA-977] add nextToken for return list api 

#1.0.15

Released date : May, 15, 2020

##Summary

* replace order cancellation api 

##details

* [SSA-946] replace order cancellation api 

#1.0.14

Released date : Apr, 16, 2020

##Summary

* update response message for return request api

##details

* [SSA-916] add response message's attributes 'releaseStatus' and 'cancelCompleteUser' for return request api

#1.0.13

Released date : Mar, 2, 2020

##Summary

* add parameter of udpate salePrice api

##details

* [SSA-874] add parameter 'forceSalePriceUpdate' of udpate salePrice api

#1.0.12

Released date : Feb, 12, 2020

##Summary

* update some sample codes and documents

##details

* [SSA-852] update wrong sample code 'UpdateCustomerServiceRequest', 'UpdateInquiry'
* [SSA-865] remove contents related to "Courantee Shutdown"

#1.0.11

Released date : December, 9, 2019

##Summary

* add attributes 'storeFeeDiscount', 'storeFeeDiscountVat' to settlement apis

##details

* [SSA-748] add attributes 'storeFeeDiscount', 'storeFeeDiscountVat' to settlement apis


#1.0.10

Released date : November, 27, 2019

##Summary

* correct data type of attribute "nextToken" of product list query api

##details

* [SSA-753] correct data type of attribute "nextToken" of product list query api
* [SSA-754] add new parameter of return request list api to SDK (cancelType)

#1.0.9

Released date : October, 28, 2019

##Summary

* Update SDK about missing attributes

##details

* [SSA-733] Add missing attribute "exposed", "groupNumber" for OAttributeType

#1.0.8

Released date : October, 18, 2019

##Summary

* Update SDK about missing attribute

##details

* [SSA-727] Add missing attribute extraInfoMessage for OSellerProduct

#1.0.7

Released date : August, 29, 2019

##Summary

* add missing parameter "nextToken" of PO Inquiry API

##details

* [SSA-674] add missing parameter "nextToken" to PO paging query API for SDK

#1.0.6

Released date : August, 23, 2019

##Summary

* Update SDK about coupon api

##details

* [SSA-627] add the GET settlement history API to SDK
* [SSA-541] update SDK for downloadable coupon api
* add missing API's sample codes

#1.0.5

Released date : August, 5, 2019

##Summary

* Update SDK about return request api

##details

* [SSA-643] Update SDK about return request api(realPhoneNumber)

#1.0.4

Released date : July, 5, 2019

##Summary

* APIs add to SDK - return, invoice, etc
* Apply changes to the onlineInquiry API

##details

* [SSA-578] Update SDK about online inquiry api
* [SSA-591] Add missing APIs to the SDK
* [SSA-594] Add CS API Sample to the SDK
* [SSA-596] Add new OutboundShippingPlace Inquiry API to the SDK
* [SSA-597] Update SDK about inquiry ordersheet api


#1.0.3

Released date : June, 3, 2019

##Summary

* CFS condition update
* add debugging mode
* update shipping place sample codes

##details

* [SSA-553] add debugging mode to SDK - If you use the SDK to call APIs, you can log request and response messages.
* [SSA-554] update SDK sample codes - Correct the incorrect example related to shipping place.
* [SSA-555] update SDK api response - Fix incorrect definition of shipping place related API.
* [SSA-537] CFS update - Apply modifications to the changed free shipping terms option.
* [SSA-561] Added missing attribute "isAllowedSingleItem" in category meta query api.
* [SSA-562] Update Delivery Company Code list. enum => string

#1.0.2

released date : May, 24, 2019

##Summary

* Add to request header parameter for logging request by SDK

##Details

* [SSA-527] Add to request header parameter for logging request by SDK

# 1.0.1 #

Released date : Apr, 5, 2019

## Summary ##
* remove unused dependencies
* resize sdk.jar from 20mb to 7.5mb

## Details ##
* [SSA-426] remove unused dependencies

-------
# 1.0.0 #

Released date : Mar, 29, 2019

## Summary ##
* change base jdk to java7.
* add revenue history api of settlement.

## Details ##
* [SSA-422] revenue history api add
* [SSA-414] update pom version
* [SSA-414] modify test case
* [SSA-414] change to java 7 compatible code