package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.SubNav;

import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
public interface ISubNavService {
    String addSubNav(SubNav subNav) throws BaseException;

    void update(SubNav subNav, Conditions conditions) throws BaseException;

    void updateById(SubNav subNav) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    SubNav findByName(String name) throws BaseException;

    SubNav findById(String id) throws BaseException;

    List<SubNav> listAndSort(String mainNavId) throws BaseException;

    List<SubNav> listAllSubOfMainNav(String mainNavId) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Page<SubNav> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;
}
