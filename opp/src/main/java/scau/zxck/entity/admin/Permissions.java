package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

/**
 * Created by suruijia on 2015/11/2.
 */
@Table(name="apt_permission")
public class Permissions extends Unique {

    @Column(name="permission")
    private String permission;

    @Column(name="description")
    private String description;

    @Column(name = "available")
    private Integer available;

    @Column(name = "remark")
    private String remark;

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAvailable() {
        return available;
    }

    public String getRemark() {
        return remark;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
