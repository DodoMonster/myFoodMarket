package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.UserRole;

import java.util.List;

/**
 * Created by suruijia on 2015/11/8.
 */
public interface IUserRoleService {
    String addUserRole(UserRole userRole) throws BaseException;

    void update(UserRole userRole, Conditions conditions) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    void deleteByEntity(UserRole userRole) throws BaseException;

    UserRole find(Conditions conditions) throws BaseException;

    List<UserRole> list(Conditions conditions) throws BaseException;

    List<UserRole> listByEntity(UserRole userRole, String... propertyName) throws BaseException;

    long count(Conditions conditions) throws BaseException;

}
