package com.coupang.marketplace.client.sample;


import com.coupang.openapi.sdk.Hmac;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HmacOrderCancel {

    private static final String HOST = "api-gateway.coupang.com";
    private static final int PORT = 443;
    private static final String SCHEMA = "https";
    //replace with your own accessKey
    private static final String ACCESS_KEY = "021a3195-23c7-4967-b14c-523bad54162e";
    //replace with your own secretKey
    private static final String SECRET_KEY = "f13b31a12a1b1969cb6314075fa6b48d5050dda0";

    public void test() {
        //params
        String method = "POST";
        String path = "/v2/providers/openapi/apis/api/v5/vendors/A00462959/orders/10100051011459/cancel";

        //replace with your own product registration json data
        String strjson="\"{\"\n" +
                "                + \"\\\"orderId\\\": 10100051011459,\"\n" +
                "                + \"\\\"vendorItemIds\\\": [86395166101],\"\n" +
                "                + \"\\\"receiptCounts\\\": [1],\"\n" +
                "                + \"\\\"bigCancelCode\\\": \\\"CANERR\\\",\"\n" +
                "                + \"\\\"middleCancelCode\\\": \\\"CCTTER\\\",\"\n" +
                "                + \"\\\"userId\\\": \\\"bozoraka\\\",\"\n" +
                "                + \"\\\"vendorId\\\": \\\"A00462959\\\"\"\n" +
                "                + \"}\";";

        CloseableHttpClient client = null;
        try {
            //create client
            client = HttpClients.createDefault();
            //build uri
            URIBuilder uriBuilder = new URIBuilder()
                    .setPath(path);
//                    .addParameter("createdAtFrom", "2024-05-01")
//                    .addParameter("createdAtTo", "2024-05-19")
//                    .addParameter("maxPerPage", "50")
//                    .addParameter("status", "FINAL_DELIVERY");

            /********************************************************/
            //authorize, demonstrate how to generate hmac signature here
            String authorization = Hmac.generate(method, uriBuilder.build().toString(), SECRET_KEY, ACCESS_KEY);
            //print out the hmac key
            System.out.println(authorization);
            /********************************************************/

            uriBuilder.setScheme(SCHEMA).setHost(HOST).setPort(PORT);
            HttpPost requestPost = new HttpPost(uriBuilder.build().toString());

            StringEntity stringEntity = new StringEntity(strjson,"UTF-8");
            requestPost.setEntity(stringEntity);

            /********************************************************/
            // set header, demonstarte how to use hmac signature here
            requestPost.addHeader("Authorization", authorization);
            /********************************************************/
            requestPost.addHeader("content-type", "application/json");
            CloseableHttpResponse response = null;
            try {
                //execute post request
                response = client.execute(requestPost);
                //print result
                System.out.println("status code:" + response.getStatusLine().getStatusCode());
                System.out.println("status message:" + response.getStatusLine().getReasonPhrase());
                HttpEntity entity = response.getEntity();
                System.out.println("result:" + EntityUtils.toString(entity));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (response != null) {
                    try {
                        response.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        HmacOrderCancel hmacTest = new HmacOrderCancel();
        hmacTest.test();
    }
}