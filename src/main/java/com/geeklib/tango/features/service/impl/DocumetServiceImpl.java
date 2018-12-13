package com.geeklib.tango.features.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.geeklib.tango.features.entity.Document;
import com.geeklib.tango.features.mapper.DocumentMapper;
import com.geeklib.tango.features.service.DocumentService;

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
