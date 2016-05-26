package scau.zxck.entity.admin;

import scau.zxck.base.dao.annotation.Column;
import scau.zxck.base.dao.annotation.Table;
import scau.zxck.base.dao.entity.Unique;

import java.util.Date;
import java.util.List;

/**
 * Created by suruijia on 2015/10/22.
 */
@Table(name = "apt_user")
public class User extends Unique {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @Column(name="create_date")
    private Date createDate;

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

    private List<UserRole> userRoles;

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSalt() {
        return salt;
    }

    public String getCredentialsSalt(){
        return username+salt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

}
