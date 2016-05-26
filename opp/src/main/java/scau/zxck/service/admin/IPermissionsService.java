package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.Permissions;

import java.util.List;

/**
 * Created by suruijia on 2015/11/8.
 */
public interface IPermissionsService {
    String addPermissions(Permissions permissions) throws BaseException;

    void update(Permissions permissions, Conditions conditions) throws BaseException;

    void updateById(Permissions permissions) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    Permissions find(Conditions conditions) throws BaseException;

    Permissions findById(String id) throws BaseException;

    Permissions findByEntity(Permissions permissions) throws BaseException;

    List<Permissions> list(Conditions conditions) throws BaseException;

    List<Permissions> listByEntity(Permissions permissions, String... propertyName) throws BaseException;

    List<Permissions> listAscByPermission() throws BaseException;

    List<Permissions> listByNameUsingLike(String name) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Page<Permissions> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;

}
