package com.lrm.hospital.mapper;

import com.lrm.hospital.dto.BookDetailDto;
import com.lrm.hospital.dto.BookListDto;
import com.lrm.hospital.dto.MyBookDto;

import java.util.List;

import com.lrm.hospital.model.BookDetail;
import com.lrm.hospital.model.BookDetailExample;
import org.apache.ibatis.annotations.Param;

public interface BookDetailMapper {
    long countByExample(BookDetailExample example);

    int deleteByExample(BookDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(BookDetail record);

    int insertSelective(BookDetail record);

    List<BookDetail> selectByExample(BookDetailExample example);

    BookDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BookDetail record, @Param("example") BookDetailExample example);

    int updateByExample(@Param("record") BookDetail record, @Param("example") BookDetailExample example);

    int updateByPrimaryKeySelective(BookDetail record);

    int updateByPrimaryKey(BookDetail record);

    List<MyBookDto> getMyBookList(String username);

    List<BookListDto> getBookList(@Param("username")String username, @Param("telphone")String telphone, @Param("status")String status);

    BookDetailDto getBookDetail(String id);
}
