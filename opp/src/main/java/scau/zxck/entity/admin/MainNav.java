package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

import java.util.List;

/**
 * Created by 追追 on 2016/3/16.
 */
@Table(name="apt_main_nav")
public class MainNav extends Unique{

    @Column(name="id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name = "sequence")
    private Integer sequence;

    @Column(name = "belong_to")
    private String belongTo;

    private List<SubNav> subNavList;

    public List<SubNav> getSubNavList() {
        return subNavList;
    }

    public void setSubNavList(List<SubNav> subNavList) {
        this.subNavList = subNavList;
    }

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

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }
}
