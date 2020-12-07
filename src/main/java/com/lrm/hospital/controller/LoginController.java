package com.lrm.hospital.controller;

import com.lrm.hospital.dto.EditPasswordDto;
import com.lrm.hospital.dto.LoginDto;
import com.lrm.hospital.dto.LoginResult;
import com.lrm.hospital.dto.RetrievePasswordDto;
import com.lrm.hospital.exception.HospitalException;
import com.lrm.hospital.model.User;
import com.lrm.hospital.service.UserService;
import com.lrm.hospital.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * 〈功能概述〉<br>
 *
 * @className: LoginController
 * @package: com.lrm.hospital.controller
 * @author: mamingcong
 * @date: 2020/12/1 9:38
 */
@Api(tags = "用户中心")
@RestController
public class LoginController {


    @Resource
    private UserService userServiceImpl;

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public Result login(@RequestBody LoginDto loginDto) {
        LoginResult loginResult = userServiceImpl.login(loginDto);
        if (loginResult.getToken() == null || "".equals(loginResult.getToken())) {
            //用户名或密码错误
            return Result.failure("用户名或密码错误");
        }
        return Result.ok().setData(loginResult);
    }

    @GetMapping("/logout")
    @ApiOperation(value = "退出")
    public Result logout(@RequestHeader("token") String token) {
        userServiceImpl.logout(token);
        return Result.ok().setData(new ArrayList<>());
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public Result register(@RequestBody User user) {
        try {
            userServiceImpl.register(user);
        } catch (HospitalException e) {
            Result.failure(100, e.getMessage());
        }
        return Result.ok().setData(new ArrayList<>());
    }

    @PostMapping("/edit")
    @ApiOperation(value = "编辑用户")
    public Result edit(@RequestBody User user) {
        try {
            userServiceImpl.edit(user);
        } catch (HospitalException e) {
            Result.failure(100, e.getMessage());
        }
        return Result.ok().setData(new ArrayList<>());
    }

    @PostMapping("/editPassword")
    @ApiOperation(value = "修改密码")
    public Result editPassword(@RequestBody EditPasswordDto editPasswordDto) {

        try {
            userServiceImpl.editPassword(editPasswordDto);
        } catch (HospitalException hospitalException) {
            return Result.failure(100, hospitalException.getMessage());
        }
        return Result.ok().setData(new ArrayList<>());
    }

    @PostMapping("/retrievePassword")
    @ApiOperation(value = "找回密码")
    public Result retrievePassword(@RequestBody RetrievePasswordDto retrievePasswordDto) {
        User user = null;
        try {
            user = userServiceImpl.retrievePassword(retrievePasswordDto);
        } catch (HospitalException e) {
            return Result.failure(100, e.getMessage());
        }
        return Result.ok().setData(user.getPassword());
    }
}
