package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

/**
 * Created by 追追 on 2016/3/16.
 */
@Table(name="apt_sub_nav")
public class SubNav extends Unique {

    @Column(name="id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="sequence")
    private Integer sequence;

    @Column(name="main_nav_id")
    private String mainNavId;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getMainNavId() {
        return mainNavId;
    }

    public void setMainNavId(String mainNavId) {
        this.mainNavId = mainNavId;
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

}
