package com.geeklib.tango.mapper;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

public interface BaseMapper<E> {
	
	@SelectProvider(method = "listObjects", type = BaseMapperSqlProvider.class)
	List<E> listObjects(Class<E> clazz);
	
	@SelectProvider(method = "listObject", type = BaseMapperSqlProvider.class)
	List<E> listObject();
	
	default List<E> listObj(){
		
		Class clazz = BaseMapper.class;
		Method method = null;
		try {
			method = clazz.getMethod("listObjects", null);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//method.invoke(, args)
		return listObjects(null);
	}
}
