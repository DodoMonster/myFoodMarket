package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.Role;

import java.util.List;

/**
 * Created by suruijia on 2015/11/8.
 */
public interface IRoleService {
    String addRole(Role role) throws BaseException;

    void update(Role role, Conditions conditions) throws BaseException;

    void updateById(Role role) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    Role find(Conditions conditions) throws BaseException;

    Role findById(String id) throws BaseException;

    Role findByEntity(Role role) throws BaseException;

    List<Role> list(Conditions conditions) throws BaseException;

    List<Role> listByNameUsingLike(String name) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Role findRoleFetchRolePermissions(String id) throws BaseException;

    Page<Role> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;
}
