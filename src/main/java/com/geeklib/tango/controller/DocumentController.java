package com.geeklib.tango.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.geeklib.tango.entity.Document;
import com.geeklib.tango.service.DocumentService;

@Controller
@RequestMapping("/document")
public class DocumentController {
	
	@Resource
	DocumentService documentService;
	
	@RequestMapping("")
	public String document(HttpServletRequest request) {
		
		request.setAttribute("documents", documentService.listDocument());;
		return "document";
	}
	
	@RequestMapping("add.do")
	public String add() {
		return "document_edit";
	}
	
	@RequestMapping("save.do")
	public String saveDocument(HttpServletRequest request,Document document) {
		documentService.insert(document);
		return document(request);
	}
	
	@RequestMapping("{id}")
	public ModelAndView viewDocument(@PathVariable long id) {
		Document document = documentService.getDocument(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("document_view");
		modelAndView.addObject(document);
		return modelAndView;
	}
}