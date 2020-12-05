package com.lrm.hospital.dto;

import lombok.Data;

import java.util.Date;

/**
 * 〈功能概述〉<br>
 *
 * @className: MyBookDto
 * @package: com.lrm.hospital.dto
 * @author: mamingcong
 * @date: 2020/12/4 0:22
 */
@Data
public class MyBookDto {

    private String bookdetailId;

    private String username;

    private Date scheduleDate;

    private int scheduleNumber;

    private int currentNumber;

    private String state;
}
