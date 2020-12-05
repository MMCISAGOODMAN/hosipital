package com.lrm.hospital;

import com.lrm.hospital.job.ScheduleJob;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class HospitalApplicationTests {



    @Test
    void contextLoads() throws IOException {

        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.configureTasks();

    }
}
