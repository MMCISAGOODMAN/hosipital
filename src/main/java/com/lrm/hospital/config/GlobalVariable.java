package com.lrm.hospital.config;

import com.lrm.hospital.model.User;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能概述〉<br>
 *
 * @className: GlobalVariable
 * @package: com.lrm.hospital.config
 * @author: mamingcong
 * @date: 2020/12/1 19:07
 */
@Configuration
@Data
public class GlobalVariable {

    public static Map<String, User> tokenMap = new HashMap<>();
}
