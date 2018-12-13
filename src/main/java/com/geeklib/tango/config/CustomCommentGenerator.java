package com.geeklib.tango.config;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * 自定义mybatis generator注释生成器
 * TODO 为实体类增加注释，以及mapping文件增加注释信息，同时要处理注释为空的情况，可以生成默认带注解的空注释，或者抛出异常，阻断执行。
 * @author Geek1st
 *
 */
public class CustomCommentGenerator extends DefaultCommentGenerator {

	/**
	 * 添加实体类中字段默认注释
	 */
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

		if (!StringUtils.isEmpty(introspectedColumn.getRemarks())) {
			field.addJavaDocLine("/**");
			field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
			addJavadocTag(field, false);
			field.addJavaDocLine(" */");
		}
	}

	/**
	 * 添加实体类getter方法默认注释
	 */
	@Override
	public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

		if (!StringUtils.isEmpty(introspectedColumn.getRemarks())) {
			method.addJavaDocLine("/**");
			method.addJavaDocLine(" * 获取" + introspectedColumn.getRemarks());
			addJavadocTag(method, false);
			method.addJavaDocLine(" */");
		}
	}

	/**
	 * 添加实体类setter方法默认注释
	 */
	@Override
	public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

		if (!StringUtils.isEmpty(introspectedColumn.getRemarks())) {
			method.addJavaDocLine("/**");
			method.addJavaDocLine(" * 设置" + introspectedColumn.getRemarks());
			addJavadocTag(method, false);
			method.addJavaDocLine(" */");
		}
	}

	/**
	 * 添加mapper接口默认注释
	 */
	@Override
	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
		method.addJavaDocLine("/**");
		addJavadocTag(method, false);
		method.addJavaDocLine(" */");
	}
}
