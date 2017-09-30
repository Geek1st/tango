package com.geeklib.tango.mapper;

import org.apache.ibatis.jdbc.SQL;

public class BaseMapperSqlProvider {

	/**
	 * 通用方法，获取所有对象
	 * @param clazz 需要获取的对象的Class对象
	 * @return 指定类型的所有对象
	 */
	public String listObjects(Class clazz) {
		String tableName = clazz.getName();
		System.out.println(tableName);
		tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
		tableName = convertCamelCase(tableName);
		System.out.println(tableName);
		return new SQL().SELECT("*").FROM(tableName).toString();
	}
	
	public String listObject() {
		return new SQL().SELECT("*").FROM("").toString();
	}
	
	
	private String convertCamelCase(String tableName){
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < tableName.length(); i++) {
			char character = tableName.charAt(i);
			
			if(Character.isUpperCase(character) && i > 0) {
				sb.append("_").append(Character.toLowerCase(character));
			}else {
				sb.append(character);
			}
		}
		
		return sb.toString();
	}
}
