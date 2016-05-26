package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

import java.util.Date;

/**
 * Created by ZZWEI on 2016/3/18.
 */
@Table(name = "apt_user_message")
public class UserMessage extends Unique {
    @Column(name = "id")
    private String id;

    @Column(name = "pic")
    private String pic;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "realname")
    private String realname;

    @Column(name = "sex")
    private int sex;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "residence")
    private String residence;

    @Column(name = "hometown")
    private String hometown;

    @Column(name = "user_id")
    private String userId;

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }


    public int getSex() {
        return sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
