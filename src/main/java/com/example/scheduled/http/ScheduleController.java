package com.example.scheduled.http;

import com.example.scheduled.usecase.ScheduleUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class ScheduleController {

    private static final String TIME_ZONE = "America/Sao_Paulo";
    private final ScheduleUsecase useCase;
    private Boolean diaUtil;

    @Scheduled(cron = "0 25 21 * * *", zone = TIME_ZONE)
    public void consultaDiaUtil() throws Exception {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new Date());

        log.info("A data de chamada é > " + date);
        diaUtil = useCase.callCalendarioDiaUtil(date);
        log.info("Retorno do calendar > " + diaUtil);
    }

    @Scheduled(cron = "0 30 9 ? * MON-FRI", zone = TIME_ZONE)
    public void callEndPoint() {

        if (diaUtil) {
            System.out.println(diaUtil);
        } else {

        }


    }




}
