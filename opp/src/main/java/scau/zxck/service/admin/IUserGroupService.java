package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.UserGroup;

import java.util.List;

/**
 * Created by ZZWEI on 2016/3/18.
 */
public interface IUserGroupService {
    String addUserGroup(UserGroup userGroup)throws BaseException;

    void update(UserGroup userGroup, Conditions conditions) throws BaseException;

    void updateById(UserGroup userGroup) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    UserGroup find(Conditions conditions) throws BaseException;

    UserGroup findById(String id) throws BaseException;

    UserGroup findByEntity(UserGroup userGroup) throws BaseException;

    UserGroup findByName(String name) throws BaseException;

    List<UserGroup> list(Conditions conditions) throws BaseException;

    List<UserGroup> listByEntity(UserGroup userGroup, String... propertyName) throws BaseException;

    List<UserGroup> listByNameUsingLike(String name) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Page<UserGroup> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;
}
