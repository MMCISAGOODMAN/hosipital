package com.lrm.hospital.mapper;

import com.lrm.hospital.model.BookDetail;
import com.lrm.hospital.model.BookDetailExample;
import java.util.List;
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
}