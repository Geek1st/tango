package com.geeklib.tango.system.entity;

import java.util.Date;

public class User {
    private Long id;

    /**
     * 创建时间
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    private Date gmtCreate;

    /**
     * 修改时间
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    private Date gmtModify;

    /**
     * 用户名
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    private String username;

    /**
     * 密码
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    private String password;

    /**
     * 昵称
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    private String nickname;

    /**
     * 移动电话
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    private String mobilePhone;

    /**
     * 电子邮件
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    private String email;

    /**
     * 锁定状态
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    private Boolean locking;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取创建时间
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取修改时间
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * 设置修改时间
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * 获取用户名
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取昵称
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取移动电话
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置移动电话
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * 获取电子邮件
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮件
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取锁定状态
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    public Boolean getLocking() {
        return locking;
    }

    /**
     * 设置锁定状态
     *
     * @mbg.generated Sun Dec 02 23:20:50 CST 2018
     */
    public void setLocking(Boolean locking) {
        this.locking = locking;
    }
}