package sif3.hits.rest.consumer.util;

import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientRequestAdapter;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.apache.commons.lang3.StringUtils;
import sif3.common.CommonConstants;
import sif3.common.utils.AuthenticationUtils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.Map;

public class SimpleConsumer {
    private static BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));
    private static final String SESSION_TOKEN = "SESSION_TOKEN";
    private static final String PASSWORD = "PASSWORD";
    private static final String INTENT = "INTENT";
    private static final String INTENT_HMAC = "1";
    private static final String INTENT_EXEC = "2";
    private static final String TIMESTAMP = "TIMESTAMP";
    private static final String AUTHORIZATION_TOKEN = "HMAC_TOKEN";
    private static final String AUTHORIZATION_HEADER = "AUTHORIZATION_HEADER";
    private static final String METHOD_HMAC = "1";
    private static final String METHOD_BASIC = "2";
    private static final String AUTHORIZATION_METHOD = "AUTHORIZATION_METHOD";
    private static DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ISO_DATE_TIME;

    private static void defaults(Map<String, String> configuration) {
        // Setup some options here that I might want to change from time to time.
        if (false) {
            // extended timestamp format (.NET framework produces timestamps like this...)
            TIMESTAMP_FORMAT = (new DateTimeFormatterBuilder()).append(DateTimeFormatter.ISO_LOCAL_DATE_TIME).appendLiteral("9175Z").toFormatter();
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        Map<String, String> configuration = new HashMap<>();
        defaults(configuration);
        collectIntention(configuration);
        collectAuthentication(configuration);
        if (INTENT_EXEC.equals(configuration.get(INTENT))) {
            collectEndpoint(configuration);
            generateAuthenticationToken(configuration);
            executeCall(configuration);
        } else {
            generateAuthenticationToken(configuration);
            outputAuthenticationToken(configuration);
        }
    }

    private static void collectIntention(Map<String, String> configuration) throws IOException {
        write("Welcome to Ben's Simple Consumer Helper");
        write("---");
        write("1. Generate Authorization + Timestamp Headers");
        write("2. Execute a SIF Call");
        write("");
        configuration.put(INTENT, read("What do you want to do? [1]: "));
        write("");
    }

    private static void collectAuthentication(Map<String, String> configuration) throws IOException {
        write("Authentication Methods");
        write("---");
        write("1. HMAC");
        write("2. Basic");
        write("");
        configuration.put(AUTHORIZATION_METHOD, read("What authentication method are you using? [1]: "));
        write("");
        configuration.put(SESSION_TOKEN, read("Enter session token: "));
        configuration.put(PASSWORD, read("Enter password: "));
        write("");
    }

    private static void generateAuthenticationToken(Map<String, String> configuration) {
        ZonedDateTime timestamp = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Z"));
        configuration.put(TIMESTAMP, TIMESTAMP_FORMAT.format(timestamp));
        if (METHOD_BASIC.equals(configuration.get(AUTHORIZATION_METHOD))) {
            String token = AuthenticationUtils.getBasicAuthToken(configuration.get(SESSION_TOKEN), configuration.get(PASSWORD));
            configuration.put(AUTHORIZATION_HEADER, token);
            configuration.put(AUTHORIZATION_TOKEN, StringUtils.substring(token, CommonConstants.AuthenticationType.Basic.name().length() + 1));
        } else {
            String token = AuthenticationUtils.getSIFHMACSHA256AuthToken(configuration.get(SESSION_TOKEN), configuration.get(PASSWORD), configuration.get(TIMESTAMP));
            configuration.put(AUTHORIZATION_HEADER, token);
            configuration.put(AUTHORIZATION_TOKEN, StringUtils.substring(token, CommonConstants.AuthenticationType.SIF_HMACSHA256.name().length() + 1));
        }
    }

    private static void outputAuthenticationToken(Map<String, String> configuration) {
        write("Headers:");
        write("Authorization: " + configuration.get(AUTHORIZATION_HEADER));
        write("Timestamp: " + configuration.get(TIMESTAMP));
    }

    private static void collectEndpoint(Map<String, String> configuration) {
        write("");
    }

    private static void executeCall(Map<String, String> configuration) throws URISyntaxException {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("https://test-eduhub.hostedzone.com/svcs/Sif3Framework/requestProvider/SchoolInfos;zoneId=018800;contextId=ALL?where=[(StateProvinceId=\"01880002\")]");

        ClientRequest.Builder requestBuilder = new ClientRequest.Builder();
        requestBuilder.accept(MediaType.APPLICATION_XML_TYPE);
        requestBuilder.header("Timestamp", configuration.get(TIMESTAMP));
        requestBuilder.header("Authorization", configuration.get(AUTHORIZATION_HEADER));
        requestBuilder.header("serviceType", "OBJECT");
        requestBuilder.header("navigationPage", "1");
        requestBuilder.header( "navigationPageSize", "5");
//        ClientRequest request = requestBuilder.build(new URI("), "GET");

    }

    private static String read(String question) throws IOException {
        output(question);
        return CONSOLE.readLine();
    }

    private static void write(String output) {
        output(output + "\n");
    }

    private static void output(String output) {
        System.out.print(output);
    }



}
