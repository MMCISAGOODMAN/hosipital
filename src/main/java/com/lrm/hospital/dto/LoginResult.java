package com.lrm.hospital.dto;

import com.lrm.hospital.model.User;
import lombok.Data;

/**
 * 〈功能概述〉<br>
 *
 * @className: LoginResult
 * @package: com.lrm.hospital.dto
 * @author: mamingcong
 * @date: 2020/12/1 19:18
 */
@Data
public class LoginResult extends User {
    private String token;
}
