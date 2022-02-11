package org.challenge.util;

import org.springframework.http.HttpHeaders;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ControllerHelper {

    private ControllerHelper() {
    }

    public static String hostname = "unknownHostname";
    public static String serviceName = "unknownService";
    public static String version = "unknownVersion";

    public static final String X_PROCESSTIME = "X-ProcessTime";
    public static final String X_INIT_TIMESTAMP = "X-Timestamp";
    public static final String X_REQUESTHOST = "X-RequestHost";
    public static final String X_SERVICENAME = "X-ServiceName";
    public static final String X_VERSION = "X-Version";

    public static final String PRICE_CONTROLLER_PATH = "/1.0/prices";

    public static HttpHeaders buildHeaders(LocalDateTime processingStartTime) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(X_INIT_TIMESTAMP, processingStartTime.toString());
        httpHeaders.set(X_REQUESTHOST, hostname);
        httpHeaders.set(X_SERVICENAME, serviceName);
        httpHeaders.set(X_VERSION, version);
        httpHeaders.set(X_PROCESSTIME, Long.toString(ChronoUnit.MILLIS.between(processingStartTime, LocalDateTime.now())));
        return httpHeaders;
    }
}
