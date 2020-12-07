package com.lrm.hospital.job;

import com.lrm.hospital.enums.UserType;
import com.lrm.hospital.mapper.ScheduleMapper;
import com.lrm.hospital.mapper.UserMapper;
import com.lrm.hospital.model.Schedule;
import com.lrm.hospital.model.ScheduleExample;
import com.lrm.hospital.model.User;
import com.lrm.hospital.model.UserExample;
import com.lrm.hospital.utils.DateUtils;
import com.lrm.hospital.utils.IdUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
        List<Date> next7Days = DateUtils.getNext7Days();
        UserExample example = new UserExample();
        example.createCriteria().andTypeEqualTo(UserType.DOCTOR.getCode());
        List<User> doctors = userMapper.selectByExample(example);
        ScheduleExample example2 = null;
        if (doctors.size() > 0) {
            for (User doctor : doctors) {
                for (Date next7Day : next7Days) {
                    example2 = new ScheduleExample();
                    example2.createCriteria().andScheduleDateEqualTo(next7Day).andDoctorIdEqualTo(doctor.getId());
                    if (scheduleMapper.countByExample(example2) < 0) {
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
    }
}
