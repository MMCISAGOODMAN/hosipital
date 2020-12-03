package com.lrm.hospital.dto;

import lombok.Data;

import java.util.Date;

/**
 * 〈功能概述〉<br>
 *
 * @className: IdleDoctorDto
 * @package: com.lrm.hospital.dto
 * @author: mamingcong
 * @date: 2020/12/3 23:23
 */
@Data
public class IdleDoctorDto {

    private String userId;
    private String scheduleId;
    private String username;
    private Date scheduleDate;
    private int totalQuota;
    private int currentQuota;

}
