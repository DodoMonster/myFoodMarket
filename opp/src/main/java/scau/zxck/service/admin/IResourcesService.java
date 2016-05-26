package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.Resources;

import java.util.List;

/**
 * Created by suruijia on 2015/11/8.
 */
public interface IResourcesService {
    String addResources(Resources resources) throws BaseException;

    void update(Resources resources, Conditions conditions) throws BaseException;

    void updateById(Resources resources) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    Resources find(Conditions conditions) throws BaseException;

    Resources findById(String id) throws BaseException;

    Resources findByEntity(Resources resources) throws BaseException;

    Resources findPermissionByUrl(String url) throws BaseException;

    List<Resources> list(Conditions conditions) throws BaseException;

    List<Resources> listByEntity(Resources resources, String... propertyName) throws BaseException;

    List<Resources> listAscByParentIdAndPriority() throws BaseException;

    List<Resources> listByNameUsingLike(String name) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Page<Resources> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;

}
