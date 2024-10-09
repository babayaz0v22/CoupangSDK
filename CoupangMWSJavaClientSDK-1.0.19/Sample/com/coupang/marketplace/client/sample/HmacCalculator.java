package com.coupang.marketplace.client.sample;

import org.apache.http.client.utils.URIBuilder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.TimeZone;

public class HmacCalculator {

    private static final String HMAC_SHA256 = "HmacSHA256";
    private static final String DATE_FORMAT = "yyMMdd'T'HHmmss'Z'";


    public static void main(String[] args) {
        // Example usage
        String secretKey = "263b14921be9fd7f4db2e211d6afc7e5f26d1f806e9db6ccf8120d1804fd2f02";
        String method = "POST";
        String uri = "/api/v1/jsonrpc";
        String requestBody = "{\"jsonrpc\": \"2.0\",\"id\": 1,\"method\": \"transfer.create\",\"params\": {\"ext_id\": \"12361\",\"number\": \"8600312905180812\",\"amount\": 100000,\"currency\": 643}}";

        try {
            String headerSign = generateHmacSignature(method, uri, requestBody, secretKey);
            System.out.println("Header-Sign: " + headerSign);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    public static String generateHmacSignature(String method, String uri, String body, String secretKey) throws GeneralSecurityException {
        String datetime = getCurrentDatetime();
        String message = datetime +
                method + uri + body;
        String hmacDigest = hmacSha256(message, secretKey);
        return Base64.getEncoder().encodeToString(hmacDigest.getBytes(StandardCharsets.UTF_8));
    }

    private static String getCurrentDatetime() {
        SimpleDateFormat dateFormatGmt = new SimpleDateFormat(DATE_FORMAT);
        dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormatGmt.format(new Date());
    }

    private static String hmacSha256(String message, String secretKey) throws GeneralSecurityException {
        Mac mac = Mac.getInstance(HMAC_SHA256);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), HMAC_SHA256);
        mac.init(secretKeySpec);
        byte[] rawHmac = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return new String(Base64.getEncoder().encode(rawHmac), StandardCharsets.UTF_8);
    }
}

