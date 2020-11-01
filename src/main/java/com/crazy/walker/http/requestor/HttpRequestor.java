package com.crazy.walker.http.requestor;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * *****************************************
 * **       @author : CrazyWalker         **
 * *****************************************
 * *****************************************
 * **@date: 周日,11/01 2020 10:53 上午GMT+8**
 * *****************************************
 * *****************************************
 * **        用途: 通用http请求器           **
 * *****************************************
 */
public class HttpRequestor {

    private static final RestTemplate restTemplate = new RestTemplate();
    private static final String EMPTY = "";
    private static final String QUESTION = "?";
    private static final Character QUERY_CONNECTOR = '&';
    private static final Character EQUAL = '=';

    public static void http(String url, HttpMethod method, Map<String, String> parameters, Map<String, String> headers,
                            Map<String, Object> body) {
        String uri = url + formatParameters(parameters);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpHeaders.set(header.getKey(), header.getValue());
            }
        }
        Object result = restTemplate.exchange(uri, method, new HttpEntity<>(body, httpHeaders), String.class);
        System.out.println(result);
    }

    public static void main(String[] args) {
        http("http://www.baidu.com", HttpMethod.GET, null, null, null);

        Map<String, String> parameters = new HashMap<>();
        parameters.put("date", "2020-07-23");
        Map<String, String> headers = new HashMap<>();
        headers.put("authorization", "YWRmZ2pnYWhkJjU0N2E5ZjMyNThhZjQwMjg5YmNlYjQxYWFjNWIzM2Zk");
        http("http://116.62.153.95:8080/api/device/pass/record/temperature-date-count", HttpMethod.GET, parameters, headers, null);

        Map<String, Object> body = new HashMap<>();
        body.put("busLineId", 2);
        body.put("startDate", "2020-07-19");
        body.put("endDate", "2020-07-27");
        body.put("startTime", "10:00");
        body.put("endTime", "23:00");
        http("http://116.62.153.95:8080/api/device/pass/record/bus-line-date-count-comparison", HttpMethod.POST, null, headers, body);
    }

//        "busLineId": 2,
//                "startDate": "2020-07-19",
//                "endDate": "2020-07-27",
//                "startTime": "10:00",
//                "endTime": "23:00"

    private static String formatParameters(Map<String, String> parameters) {
        if (parameters == null || parameters.isEmpty()) {
            return EMPTY;
        }
        Set<Map.Entry<String, String>> entrySet = parameters.entrySet();
        StringBuilder stringBuilder = new StringBuilder(QUESTION);
        boolean isFirst = true;
        for (Map.Entry<String, String> element : entrySet) {
            if (!isFirst) {
                stringBuilder.append(QUERY_CONNECTOR);
            }
            stringBuilder.append(element.getKey()).append(EQUAL).append(element.getValue());
            isFirst = false;
        }

        return stringBuilder.toString();
    }
}
