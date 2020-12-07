package com.lrm.hospital.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 〈功能概述〉<br>
 *
 * @className: DateUtils
 * @package: com.lrm.hospital.utils
 * @author: mamingcong
 * @date: 2020/12/7 9:49
 */
public class DateUtils {

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
