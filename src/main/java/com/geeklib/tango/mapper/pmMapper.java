package com.geeklib.tango.mapper;

import org.apache.ibatis.jdbc.SQL;

public class pmMapper<E> {
	
	public String listPm(){
		return new SQL() {{
			SELECT("*");
			FROM("user");
		}}.toString();
	}
}
