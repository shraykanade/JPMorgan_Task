package com.example.JPM;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GetValidAccount {
    public Boolean accountExists(String url, String accNumber) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, Object> map = new HashMap<>();
        map.put("accountNumber", accNumber);
        // commenting this code for demonstration purpose as data scource url's are not implemented

        // HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
        // ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        // for purpose of demonstration let response contain random true/false
        return Math.random() < 0.5;

    }
}
