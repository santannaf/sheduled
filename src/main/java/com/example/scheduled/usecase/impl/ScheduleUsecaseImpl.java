package com.example.scheduled.usecase.impl;

import com.example.scheduled.gateway.ScheduleGateway;
import com.example.scheduled.usecase.ScheduleUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduleUsecaseImpl implements ScheduleUsecase {

    private final ScheduleGateway gateway;

    @Override
    public Boolean callCalendarioDiaUtil(String hoje) {
        return true;
    }
}
