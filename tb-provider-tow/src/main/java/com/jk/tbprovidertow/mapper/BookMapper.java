package com.jk.tbprovidertow.mapper;

import com.jk.model.entity.BookBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassNameBookMapper
 * @Description
 * @Author 高鹏翔
 * @Date2020/8/16 20:20
 * @Version V1.0
 **/
@Mapper
public interface BookMapper {

    @Select("select tb.*,tt.name as typeName from t_book tb left join t_type tt on tb.type_id = tt.id")
    List<BookBean> findBookList();
}
