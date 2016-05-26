package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

/**
 * Created by suruijia on 2015/11/13.
 */
@Table(name = "apt_resource")
public class Resources extends Unique {

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "url")
    private String url;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "permission_id")
    private String permissionId;

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

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {

        return type;
    }


    public String getPermissionId() {
        return permissionId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }
}
