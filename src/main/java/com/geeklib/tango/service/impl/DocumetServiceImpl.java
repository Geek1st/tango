package com.geeklib.tango.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.geeklib.tango.entity.Document;
import com.geeklib.tango.mapper.DocumentMapper;
import com.geeklib.tango.service.DocumentService;

@Component
public class DocumetServiceImpl implements DocumentService {

	@Resource
	DocumentMapper documentMapper;
	
	public List<Document> listDocument(){
		return documentMapper.listDocument();
	}

	@Override
	public void insert(Document document) {
		documentMapper.insert(document);
	}

	@Override
	public Document getDocument(long id) {
		return documentMapper.getDocument(id);
	}
}
