package com.geeklib.tango.features.entity;

import java.util.Date;

import org.pegdown.Extensions;
import org.pegdown.PegDownProcessor;

public class Document {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String title;

    private String content;
    
    private String author;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMarkdownStyleContent() {
		return new PegDownProcessor(Extensions.FENCED_CODE_BLOCKS).markdownToHtml(content);
	}
	
}