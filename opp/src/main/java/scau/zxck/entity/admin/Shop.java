package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

/**
 * Created by 追追 on 2016/3/16.
 */
@Table(name="apt_shop")
public class Shop extends Unique {
    @Column(name="id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="brief")
    private String brief;

    @Column(name="introduction")
    private String introduction;

    @Column(name="contact")
    private String contact;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
