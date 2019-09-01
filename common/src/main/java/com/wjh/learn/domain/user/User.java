package com.wjh.learn.domain.user;

import java.io.Serializable;
import java.time.Instant;

/**
 * 用户注册
 * @author wjh
 * @date 2019/8/28 20:58
 */
public class User implements Serializable {
    private static final long serialVersionUID = 20190828210113L;

    private Integer id;
    private String username;
    private String pwd;
    private String tellphone;    //手机号
    private String nickname;    //昵称
    private String selfIntroduction;   //自我介绍
    private String image;        //头像地址
    private Instant createTime;  //注册时间
    private Instant updateTime;  //修改时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTellphone() {
        return tellphone;
    }

    public void setTellphone(String tellphone) {
        this.tellphone = tellphone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", tellphone='" + tellphone + '\'' +
                ", nickname='" + nickname + '\'' +
                ", selfIntroduction='" + selfIntroduction + '\'' +
                ", image='" + image + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
