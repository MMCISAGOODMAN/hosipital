package com.lrm.hospital.service;

import com.lrm.hospital.dto.BookDetailDto;
import com.lrm.hospital.dto.BookListDto;
import com.lrm.hospital.dto.IdleDoctorDto;
import com.lrm.hospital.dto.MyBookDto;
import com.lrm.hospital.model.BookDetail;

import java.util.List;

/**
 * 〈功能概述〉<br>
 *
 * @className: BookService
 * @package: com.lrm.hospital.service
 * @author: mamingcong
 * @date: 2020/12/3 23:16
 */
public interface BookService {
    List<IdleDoctorDto> getIdleDoctorList(String username,String token);

    void book(BookDetail bookDetail);

    void cancelBook(String bookId);

    List<MyBookDto> getMyBookList(String username);

    List<BookListDto> getBookList(String username, String telphone, String status);

    BookDetailDto getBookDetail(String id);

    void editBookDetail(BookDetail bookDetail);
}
