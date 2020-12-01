package com.lrm.hospital.service.impl;

import com.lrm.hospital.config.GlobalVariable;
import com.lrm.hospital.dto.LoginDto;
import com.lrm.hospital.dto.LoginResult;
import com.lrm.hospital.mapper.UserMapper;
import com.lrm.hospital.model.User;
import com.lrm.hospital.model.UserExample;
import com.lrm.hospital.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 〈功能概述〉<br>
 *
 * @className: UserServiceImpl
 * @package: com.lrm.hospital.service.impl
 * @author: mamingcong
 * @date: 2020/12/1 19:09
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private GlobalVariable globalVariable;

    @Override
    public LoginResult login(LoginDto loginDto) {
        LoginResult loginResult = new LoginResult();
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        if (users.size() > 0) {
            User user = users.get(0);
            //加入全局缓存中去
            String token = UUID.randomUUID().toString();
            globalVariable.tokenMap.put(token, user);
            BeanUtils.copyProperties(user, loginResult);
            loginResult.setToken(token);
        }
        return loginResult;
    }

    @Override
    public void logout(String token) {
        globalVariable.tokenMap.remove(token);
    }
}
