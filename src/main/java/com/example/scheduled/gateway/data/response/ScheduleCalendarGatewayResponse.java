package com.example.scheduled.gateway.data.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleCalendarGatewayResponse {
    private Boolean diaUtil;
}
