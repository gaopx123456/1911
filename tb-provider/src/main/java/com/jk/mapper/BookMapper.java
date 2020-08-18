package com.jk.mapper;

import com.jk.model.entity.BookBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("select tb.*,tt.name as typeName from t_book tb left join t_type tt on tb.type_id = tt.id")
    List<BookBean> findBookList();

}
