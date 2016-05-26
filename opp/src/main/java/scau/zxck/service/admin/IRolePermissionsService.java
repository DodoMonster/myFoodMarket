package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.RolePermissions;

import java.util.List;

/**
 * Created by suruijia on 2015/11/8.
 */
public interface IRolePermissionsService {
    String addRolePermissions(RolePermissions rolePermissions) throws BaseException;

    void update(RolePermissions rolePermissions, Conditions conditions) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    void deleteByEntity(RolePermissions rolePermissions) throws BaseException;

    RolePermissions find(Conditions conditions) throws BaseException;

    List<RolePermissions> list(Conditions conditions) throws BaseException;

    List<RolePermissions> listByEntity(RolePermissions rolePermissions, String... propertyName) throws BaseException;

    long count(Conditions conditions) throws BaseException;

}
