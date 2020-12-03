package com.lrm.hospital.dto;

import lombok.Data;

/**
 * 〈功能概述〉<br>
 *
 * @className: EditPasswordDto
 * @package: com.lrm.hospital.dto
 * @author: mamingcong
 * @date: 2020/12/3 23:56
 */
@Data
public class EditPasswordDto {

    private String oldPassword;

    private String newPassword;

    private String userId;
}
