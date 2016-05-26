package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

import java.util.List;

/**
 * Created by suruijia on 2015/11/2.
 */

@Table(name="apt_role")
public class Role extends Unique {

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    private List<RolePermissions> rolePermissionsList;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRolePermissionsList(List<RolePermissions> rolePermissionsList) {
        this.rolePermissionsList = rolePermissionsList;
    }

    public List<RolePermissions> getRolePermissionsList() {
        return rolePermissionsList;
    }
}
