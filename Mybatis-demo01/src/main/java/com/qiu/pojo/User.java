package com.qiu.pojo;

import org.apache.ibatis.type.Alias;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//@Alias("User")
public class User {
    private int    id;
    private String name;
    private String pwd;
    private Date   createTime;
    private Date   modifyTime;

    public User() {
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public User(int id, String name, String pwd, Date createTime, Date modifyTime) {

        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", createTime=" + DateFormat.getDateTimeInstance().format(createTime) +
                ", modifyTime=" + DateFormat.getDateTimeInstance().format(modifyTime) +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);
    }
}
