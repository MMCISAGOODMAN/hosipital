package com.lrm.hospital.service.impl;

import com.lrm.hospital.dto.BookDetailDto;
import com.lrm.hospital.dto.BookListDto;
import com.lrm.hospital.dto.IdleDoctorDto;
import com.lrm.hospital.dto.MyBookDto;
import com.lrm.hospital.enums.BookDetailStatus;
import com.lrm.hospital.exception.HospitalException;
import com.lrm.hospital.mapper.BookDetailMapper;
import com.lrm.hospital.mapper.ScheduleMapper;
import com.lrm.hospital.model.BookDetail;
import com.lrm.hospital.model.BookDetailExample;
import com.lrm.hospital.model.Schedule;
import com.lrm.hospital.service.BookService;
import com.lrm.hospital.utils.IdUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈功能概述〉<br>
 *
 * @className: BookServiceImpl
 * @package: com.lrm.hospital.service.impl
 * @author: mamingcong
 * @date: 2020/12/3 23:16
 */
@Service
public class BookServiceImpl implements BookService {


    @Resource
    private BookDetailMapper bookDetailMapper;

    @Resource
    private ScheduleMapper scheduleMapper;


    @Override
    public List<IdleDoctorDto> getIdleDoctorList(String username) {

        return scheduleMapper.getIdleDoctorList(username);
    }


    @Override
    public void book(BookDetail bookDetail) {
        String scheduleId = bookDetail.getScheduleId();
        String userId = bookDetail.getUserId();

        //判断当前医生是否已经到达最大可预约人数
        Schedule schedule = scheduleMapper.selectByPrimaryKey(scheduleId);
        int totalQuota = schedule.getTotalQuota();
        int currentQuota = schedule.getCurrentQuota();
        if (totalQuota == currentQuota) {
            throw new HospitalException(100, "预约已满！");
        }

        //判断是否已经预约过
        BookDetailExample example = new BookDetailExample();
        example.createCriteria().andScheduleIdEqualTo(scheduleId).andUserIdEqualTo(userId);
        if (bookDetailMapper.countByExample(example) > 0) {
            throw new HospitalException(100, "不可重复预约！");
        }

        //新增预约记录
        bookDetail.setId(IdUtil.getStringId());
        bookDetail.setScheduleNumber(currentQuota + 1);
        bookDetail.setStatus(BookDetailStatus.WAITING.getCode());
        bookDetailMapper.insert(bookDetail);
        //改变医生的预约人数
        schedule.setCurrentQuota(currentQuota + 1);
        scheduleMapper.updateByPrimaryKey(schedule);
    }

    @Override
    public void cancelBook(String bookId) {
        BookDetail bookDetail = bookDetailMapper.selectByPrimaryKey(bookId);

        String scheduleId = bookDetail.getScheduleId();
        Schedule schedule = scheduleMapper.selectByPrimaryKey(scheduleId);
        schedule.setCurrentQuota(schedule.getTotalQuota() - 1);
        scheduleMapper.updateByPrimaryKey(schedule);
        bookDetailMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    public List<MyBookDto> getMyBookList(String username) {

        return bookDetailMapper.getMyBookList(username);
    }

    @Override
    public List<BookListDto> getBookList(String username, String telphone, String status) {

        return bookDetailMapper.getBookList(username, telphone, status);
    }

    @Override
    public BookDetailDto getBookDetail(String id) {


        return bookDetailMapper.getBookDetail(id);
    }

    @Override
    public void editBookDetail(BookDetail bookDetail) {
        BookDetail bookDetail1 = bookDetailMapper.selectByPrimaryKey(bookDetail.getId());
        String scheduleId = bookDetail1.getScheduleId();

        Schedule schedule = scheduleMapper.selectByPrimaryKey(scheduleId);
        schedule.setCurrentNumber(schedule.getCurrentNumber() + 1);
        scheduleMapper.updateByPrimaryKey(schedule);

        bookDetail.setStatus(BookDetailStatus.HAS.getCode());
        bookDetailMapper.updateByPrimaryKeySelective(bookDetail);
    }
}