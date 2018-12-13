package com.geeklib.tango.features.mapper;

import com.geeklib.tango.features.entity.Document;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DocumentMapper {

    int deleteByPrimaryKey(Long id);

    @Insert("INSERT INTO document (gmt_create, gmt_modified, title, content, author) VALUES (now(), now(), #{title}, #{content}, 1);")
    int insert(Document record);

    
    @Select("select * from document order by id desc")
    List<Document> listDocument();
    
    @Select("SELECT * FROM document WHERE ID = #{id}")
    Document getDocument(long id);

    Document selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKeyWithBLOBs(Document record);

    int updateByPrimaryKey(Document record);
}