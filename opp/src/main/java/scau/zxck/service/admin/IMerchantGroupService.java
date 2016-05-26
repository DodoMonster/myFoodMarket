package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.MerchantGroup;

import java.util.List;

/**
 * Created by ZZWEI on 2016/3/18.
 */
public interface IMerchantGroupService {
    String addMerchantGroup(MerchantGroup merchantGroup)throws BaseException;

    void update(MerchantGroup merchantGroup, Conditions conditions) throws BaseException;

    void updateById(MerchantGroup merchantGroup) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    MerchantGroup find(Conditions conditions) throws BaseException;

    MerchantGroup findById(String id) throws BaseException;

    MerchantGroup findByEntity(MerchantGroup merchantGroup) throws BaseException;

    MerchantGroup findByName(String name) throws BaseException;

    List<MerchantGroup> list(Conditions conditions) throws BaseException;

    List<MerchantGroup> listByEntity(MerchantGroup merchantGroup, String... propertyName) throws BaseException;

    List<MerchantGroup> listByNameUsingLike(String name) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Page<MerchantGroup> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;
}
