package com.lrm.hospital.controller;

import com.lrm.hospital.dto.BookDetailDto;
import com.lrm.hospital.exception.HospitalException;
import com.lrm.hospital.model.BookDetail;
import com.lrm.hospital.service.BookService;
import com.lrm.hospital.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * 〈功能概述〉<br>
 *
 * @className: BookController
 * @package: com.lrm.hospital.controller
 * @author: mamingcong
 * @date: 2020/12/3 23:15
 */
@Api(tags = "预约中心")
@RestController
public class BookController {

    @Resource
    private BookService bookServiceImpl;


    @GetMapping("/getIdleDoctorList")
    @ApiOperation(value = "查询可预约医生列表")
    public Result getIdleDoctorList(@RequestParam(name = "username") @ApiParam(value = "医生名字") String username,@RequestHeader("token") String token) {

        return Result.ok().setData(bookServiceImpl.getIdleDoctorList(username,token));
    }


    @PostMapping("/book")
    @ApiOperation(value = "新增预约")
    public Result book(@RequestBody BookDetail bookDetail) {
        try {
            bookServiceImpl.book(bookDetail);
        } catch (HospitalException hospitalException) {
            return Result.failure(100, hospitalException.getMessage());
        }
        return Result.ok().setData(new ArrayList<>());
    }

    @GetMapping("/cancelBook")
    @ApiOperation(value = "取消预约")
    public Result cancelBook(@RequestParam(name = "bookId") @ApiParam(value = "预约记录的ID") String bookId) {

        bookServiceImpl.cancelBook(bookId);
        return Result.ok().setData(new ArrayList<>());
    }

    @GetMapping("/getMyBookList")
    @ApiOperation(value = "查询我的预约")
    public Result getMyBookList(@RequestParam(name = "username") @ApiParam(value = "医生姓名") String username,
                                @RequestHeader("token") String token) {

        return Result.ok().setData(bookServiceImpl.getMyBookList(username,token));
    }

    @GetMapping("/getBookList")
    @ApiOperation(value = "医院员工查询预约信息列表")
    public Result getBookList(@RequestParam(name = "username") @ApiParam(value = "医生姓名") String username,
                              @RequestParam(name = "telphone") @ApiParam(value = "电话号码") String telphone,
                              @RequestParam(name = "status") @ApiParam(value = "预约状态") String status) {
        return Result.ok().setData(bookServiceImpl.getBookList(username, telphone, status));
    }

    @GetMapping("/getBookDetail")
    @ApiOperation(value = "医院员工查询预约详情")
    public Result getBookDetail(@RequestParam(name = "id") @ApiParam(value = "id") String id) {
        BookDetailDto bookDetailDto= bookServiceImpl.getBookDetail(id);
        return Result.ok().setData(bookDetailDto==null?new ArrayList<>():bookDetailDto);
    }

    @PostMapping("/editBookDetail")
    @ApiOperation(value = "医生就诊")
    public Result editBookDetail(@RequestBody BookDetail bookDetail) {
        bookServiceImpl.editBookDetail(bookDetail);
        return Result.ok().setData(new ArrayList<>());
    }

}
