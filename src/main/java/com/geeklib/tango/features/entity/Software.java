package com.geeklib.tango.features.entity;

import java.util.Date;

public class Software {
    private Long id;

    private String name;

    private Date gmtCreate;

    private Date gmtModified;

    private String detail;

    private String path;

    private String iconPath;

    private Long softwareTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath == null ? null : iconPath.trim();
    }

    public Long getSoftwareTypeId() {
        return softwareTypeId;
    }

    public void setSoftwareType(Long softwareTypeId) {
        this.softwareTypeId = softwareTypeId;
    }
}