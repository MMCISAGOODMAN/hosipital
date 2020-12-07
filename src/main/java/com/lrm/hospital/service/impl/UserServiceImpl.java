package com.lrm.hospital.service.impl;

import com.lrm.hospital.config.GlobalVariable;
import com.lrm.hospital.dto.EditPasswordDto;
import com.lrm.hospital.dto.LoginDto;
import com.lrm.hospital.dto.LoginResult;
import com.lrm.hospital.dto.RetrievePasswordDto;
import com.lrm.hospital.enums.UserType;
import com.lrm.hospital.exception.HospitalException;
import com.lrm.hospital.mapper.ScheduleMapper;
import com.lrm.hospital.mapper.UserMapper;
import com.lrm.hospital.model.Schedule;
import com.lrm.hospital.model.User;
import com.lrm.hospital.model.UserExample;
import com.lrm.hospital.service.UserService;
import com.lrm.hospital.utils.DateUtils;
import com.lrm.hospital.utils.IdUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
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

    @Resource
    private ScheduleMapper scheduleMapper;

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

    @Override
    public void register(User user) {
        user.setId(IdUtil.getStringId());
        if (user.getType() == null || "".equals(user.getType())) {
            user.setType(UserType.NORMAL.getCode());
        }
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername());
        if (userMapper.countByExample(example) > 0) {
            throw new HospitalException(100, "用户名重复");
        }
        //增加医生的预约记录
        if (UserType.DOCTOR.getCode().equals(user.getType())) {
            List<Date> next7Days = DateUtils.getNext7Days();
            for (Date next7Day : next7Days) {
                Schedule schedule = new Schedule();
                schedule.setId(IdUtil.getStringId());
                schedule.setDoctorId(user.getId());
                schedule.setScheduleDate(next7Day);
                schedule.setTotalQuota(20);
                scheduleMapper.insert(schedule);
            }
        }
        userMapper.insert(user);
    }

    @Override
    public void edit(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername()).andIdNotEqualTo(user.getId());
        if (userMapper.countByExample(example) < 0) {
            userMapper.updateByPrimaryKeySelective(user);
        }
    }

    @Override
    public void editPassword(EditPasswordDto editPasswordDto) {
        String userId = editPasswordDto.getUserId();
        String oldPassword = editPasswordDto.getOldPassword();
        String newPassword = editPasswordDto.getNewPassword();
        User user = userMapper.selectByPrimaryKey(userId);
        if (!oldPassword.equals(user.getPassword())) {
            throw new HospitalException(100, "旧密码错误！");
        }
        user.setPassword(newPassword);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User retrievePassword(RetrievePasswordDto retrievePasswordDto) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(retrievePasswordDto.getUserName());
        criteria.andTelphoneEqualTo(retrievePasswordDto.getMobile());
        List<User> userList = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userList)) {
            throw new HospitalException(100, "无当前用户！");
        } else {
            return userList.get(0);
        }
    }
}
