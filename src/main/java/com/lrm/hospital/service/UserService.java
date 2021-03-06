package com.lrm.hospital.service;

import com.lrm.hospital.dto.EditPasswordDto;
import com.lrm.hospital.dto.LoginDto;
import com.lrm.hospital.dto.LoginResult;
import com.lrm.hospital.dto.RetrievePasswordDto;
import com.lrm.hospital.model.User;

/**
 * 〈功能概述〉<br>
 *
 * @className: UserService
 * @package: com.lrm.hospital.service
 * @author: mamingcong
 * @date: 2020/12/1 19:09
 */
public interface UserService {
    LoginResult login(LoginDto loginDto);

    void logout(String token);

    void register(User user);

    void edit(User user);

    void editPassword(EditPasswordDto editPasswordDto);

    User retrievePassword(RetrievePasswordDto retrievePasswordDto);
}
