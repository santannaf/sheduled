package com.example.scheduled.gateway.impl;

import com.example.scheduled.gateway.ScheduleGateway;
import com.example.scheduled.gateway.data.response.ScheduleCalendarGatewayResponse;
import com.example.scheduled.usecase.ScheduleUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class ScheduleGatewayImpl implements ScheduleGateway {

    private final RestTemplate restTemplate;

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        return headers;
    }

    @Override
    public ScheduleCalendarGatewayResponse callDiaUtil(String hoje) throws Exception {
        try {
            ResponseEntity<ScheduleCalendarGatewayResponse> response = restTemplate.exchange("https://swapi.co/api/planets/",
                    HttpMethod.GET,
                    new HttpEntity<>("", getHeaders()),
                    ScheduleCalendarGatewayResponse.class);

            return response.getBody();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
