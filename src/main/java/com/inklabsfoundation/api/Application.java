package com.inklabsfoundation.api;

import com.inklabsfoundation.errors.ApiException;

import java.util.Map;

public class Application {

    private static String KEY = "key";

    private static String SECRET = "secret";

    public static void main(String[] args) {
        try {
            Client client = new Client(KEY, SECRET);
            Map<String,Object> timestamp = client.request(Map.class, null, "GET", "/v1/common/timestamp", null, null, null);
            Map<String,Object> accounts =client.request(Map.class, null, "GET", "/v1/user/accounts", null, null, null);
        } catch (ApiException e) {
            System.err.println("error: " + e.error + ", msg: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
