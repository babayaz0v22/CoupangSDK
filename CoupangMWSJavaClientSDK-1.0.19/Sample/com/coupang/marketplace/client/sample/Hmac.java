package com.coupang.marketplace.client.sample;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Hmac {
    private static final String HMAC_SHA_256 = "HmacSHA256";
    private static final String DATE_FORMAT = "yyMMdd'T'HHmmss'Z'";

    public Hmac() {
    }

    public static String generate(String method, String uri, String secretKey, String accessKey) {
        String[] parts = uri.split("\\?");
        if (parts.length > 2) {
            throw new IllegalArgumentException("Incorrect URI format");
        }

        String path = parts[0];
        String query = parts.length == 2 ? parts[1] : "";

        String datetime = getCurrentDatetime();
        String message = datetime +
                method +
                path +
                query;

        String signature = hmacSha256(message, secretKey);

        return String.format("CEA algorithm=%s, access-key=%s, signed-date=%s, signature=%s",
                HMAC_SHA_256, accessKey, datetime, signature);
    }

    private static String getCurrentDatetime() {
        SimpleDateFormat dateFormatGmt = new SimpleDateFormat(DATE_FORMAT);
        dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormatGmt.format(new Date());
    }

    private static String hmacSha256(String message, String secretKey) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), HMAC_SHA_256);
            Mac mac = Mac.getInstance(HMAC_SHA_256);
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(rawHmac);
        } catch (GeneralSecurityException e) {
            throw new IllegalArgumentException("Unexpected error while creating hash: " + e.getMessage(), e);
        }
    }
}
