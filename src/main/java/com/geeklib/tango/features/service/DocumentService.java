package com.geeklib.tango.features.service;

import java.util.List;

import com.geeklib.tango.features.entity.Document;

public interface DocumentService {
	
	List<Document> listDocument();
	
	void insert(Document document);
	
	/**
	 * 获取Document对象
	 * @return Document对象
	 */
	Document getDocument(long id);
}
