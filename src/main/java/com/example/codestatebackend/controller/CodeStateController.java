package com.example.codestatebackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CodeStateController {
    final static String serverUrl1 = "https://gist.githubusercontent.com/PhantomGrin/a1e8ad30915ecd9d2659400d496d1ed6/raw/8b0dbb93521f5d6889502305335104218454c2bf/states_hash.json";

    final static String serverUrl2 = "https://gist.githubusercontent.com/PhantomGrin/a1e8ad30915ecd9d2659400d496d1ed6/raw/8b0dbb93521f5d6889502305335104218454c2bf/states_titlecase.json";

    @GetMapping("/")
    public String hello() {
        return "Hello this is Data reader";
    }

    @GetMapping("/readDataForState")
    public String requestStateData() {
        return requestProcessedDate("2");
    }

    @GetMapping("/readDataForCode")
    public String requestCodeData() {
        return requestProcessedDate("1");
    }

    private String requestProcessedDate(String urlId) {

        String serverUrl = null;

        if(urlId.equals("1")) {
            serverUrl = serverUrl1;
        } else if(urlId.equals("2")) {
            serverUrl = serverUrl2;
        } else {
            return "ERROR";
        }

        RestTemplate request = new RestTemplate();
        String result = request.getForObject(serverUrl, String.class);
        System.out.println(serverUrl);

        return result;
    }

}
