package sif3.hits.rest.consumer.util;

import org.apache.commons.lang3.StringUtils;
import sif3.common.CommonConstants;
import sif3.common.utils.AuthenticationUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class HmacGenerator {

    public static void main(String[] args) throws IOException {
        DateTimeFormatter isoFormat = DateTimeFormatter.ISO_DATE_TIME;
        ZonedDateTime timestamp = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Z"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Generating Authorization Token with timestamp : " + isoFormat.format(timestamp));
        System.out.print("Enter Session Token:");
        String applicationKey = reader.readLine();
        System.out.print("Enter password:");
        String password = reader.readLine();
        System.out.println("Generating token...");
        String token = AuthenticationUtils.getSIFHMACSHA256AuthToken(applicationKey, password, isoFormat.format(timestamp));
        System.out.println(StringUtils.substring(token, CommonConstants.AuthenticationType.SIF_HMACSHA256.name().length() + 1));

        System.out.println("\n\nHeaders:");
        System.out.println("Authorization: " + token);
        System.out.println("Timestamp: " + timestamp);
    }
}
