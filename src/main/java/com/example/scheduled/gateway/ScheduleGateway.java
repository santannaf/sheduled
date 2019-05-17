package com.example.scheduled.gateway;

import com.example.scheduled.gateway.data.response.ScheduleCalendarGatewayResponse;

public interface ScheduleGateway {
    ScheduleCalendarGatewayResponse callDiaUtil(String hoje) throws Exception;
}
