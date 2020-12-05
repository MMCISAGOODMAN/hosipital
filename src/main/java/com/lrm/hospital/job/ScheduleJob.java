package com.lrm.hospital.job;

import com.lrm.hospital.enums.UserType;
import com.lrm.hospital.mapper.ScheduleMapper;
import com.lrm.hospital.mapper.UserMapper;
import com.lrm.hospital.model.Schedule;
import com.lrm.hospital.model.User;
import com.lrm.hospital.model.UserExample;
import com.lrm.hospital.utils.IdUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 添加预约<br>
 *
 * @className: ScheduleJob
 * @package: com.lrm.hospital.job
 * @author: mamingcong
 * @date: 2020/12/1 20:03
 */
@Component
public class ScheduleJob {


    @Resource
    private ScheduleMapper scheduleMapper;

    @Resource
    private UserMapper userMapper;

    //每周一生成本周的预约
    @Scheduled(cron = "0 0 0 ? * MON")
    //@Scheduled(cron = "0 0/1 * * * ?")
    public void configureTasks() {
        List<Date> next7Days = getNext7Days();
        UserExample example = new UserExample();
        example.createCriteria().andTypeEqualTo(UserType.DOCTOR.getCode());
        List<User> doctors = userMapper.selectByExample(example);
        if (doctors.size() > 0) {
            for (User doctor : doctors) {
                for (Date next7Day : next7Days) {
                    Schedule schedule = new Schedule();
                    schedule.setId(IdUtil.getStringId());
                    schedule.setDoctorId(doctor.getId());
                    schedule.setScheduleDate(next7Day);
                    schedule.setTotalQuota(20);
                    scheduleMapper.insert(schedule);
                }
            }
        }
    }


    public static List<Date> getNext7Days() {
        List<Date> dateList = new ArrayList<>();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        Date time = cal.getTime();
        dateList.add(time);
        for (int i = 0; i < 6; i++) {
            cal.add(java.util.Calendar.DATE, 1);
            dateList.add(cal.getTime());
        }
        return dateList;
    }
}
