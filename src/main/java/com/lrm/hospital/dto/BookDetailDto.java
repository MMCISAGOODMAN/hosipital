package com.lrm.hospital.dto;

import lombok.Data;

/**
 * 〈功能概述〉<br>
 *
 * @className: BookDetailDto
 * @package: com.lrm.hospital.dto
 * @author: mamingcong
 * @date: 2020/12/4 0:44
 */
@Data
public class BookDetailDto {

    private String id;

    private String username;

    private String telphone;

    private String idCart; //身份证，拼错了，有时间就改idcard
    private String status;

    private String result;

}
