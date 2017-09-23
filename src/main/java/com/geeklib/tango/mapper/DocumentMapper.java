package com.geeklib.tango.mapper;

import com.geeklib.tango.entity.Document;
import com.geeklib.tango.entity.DocumentExample;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DocumentMapper {
    long countByExample(DocumentExample example);

    int deleteByExample(DocumentExample example);

    int deleteByPrimaryKey(Long id);

    @Insert("INSERT INTO document (gmt_create, gmt_modified, title, content, author) VALUES (now(), now(), #{title}, #{content}, 1);")
    int insert(Document record);

    int insertSelective(Document record);

    List<Document> selectByExampleWithBLOBs(DocumentExample example);

    List<Document> selectByExample(DocumentExample example);
    
    @Select("select * from document order by id desc")
    List<Document> listDocument();
    
    @Select("SELECT * FROM document WHERE ID = #{id}")
    Document getDocument(long id);

    Document selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByExampleWithBLOBs(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByExample(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKeyWithBLOBs(Document record);

    int updateByPrimaryKey(Document record);
}