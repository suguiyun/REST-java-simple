package com.inklabsfoundation.api;

import com.inklabsfoundation.errors.BadRequestException;
import com.inklabsfoundation.response.BusinessOrder;

import java.util.HashMap;
import java.util.Map;

public class Application {

    private static String KEY = "key";

    private static String SECRET = "secret";

    public static void main(String[] args) {
        try {
            Client client = new Client(KEY, SECRET);
            //get currency and symbol   url:GET /v1/common/trades
            Map<String, Object> trades = client.request(Map.class, null, "GET", "/v1/common/trades", null, null, null);

            //get currency  url:GET /v1/common/currencies/{currency}
            Map<String, Object> currency = client.request(Map.class, null, "GET", "/v1/common/currencies/ETH", null, null, null);

            //get symbol  url:GET /v1/common/symbols/{symbol}
            Map<String, Object> symbol = client.request(Map.class, null, "GET", "/v1/common/symbols/BTC_USDT", null, null, null);

            //get timestamp url:GET /v1/common/timestamp
            Map<String, Object> timestamp = client.request(Map.class, null, "GET", "/v1/common/timestamp", null, null, null);

            //get account  url:GET /v1/user/accounts
            Map<String, Object> accounts = client.request(Map.class, null, "GET", "/v1/user/accounts", null, null, null);

            //orders  url:POST /v1/trade/orders
            Map<String, Object> orders = client.request(Map.class, null, "POST", "/v1/trade/orders", null, new BusinessOrder("1.8", "BUY_LIMIT", "1.2", "BTC_USDT"), null);

            //cancel orders  url:POST  /v1/trade/orders/{id}/cancel
            Map<String, Object> ordersCancel = client.request(Map.class, null, "POST", "/v1/trade/orders/165780/cancel", null, null, null);

            //order url:GET /v1/trade/orders/{id}
            Map<String, Object> order = client.request(Map.class, null, "GET", "/v1/trade/orders/165777", null, null, null);

            //match order url:GET  /v1/trade/orders/{id}/matches
            Map<String, Object> orderMatches = client.request(Map.class, null, "GET", "/v1/trade/orders/165777/matches", null, null, null);

            //order list url:GET /v1/trade/orders
            Map<String, String> query = new HashMap<>();
            query.put("symbol","BTC_USDT");
            Map<String, Object> orderList = client.request(Map.class, null, "GET", "/v1/trade/orders", query, null, null);
        } catch (BadRequestException e) {
            System.err.println("error: " + e.error + ", msg: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
