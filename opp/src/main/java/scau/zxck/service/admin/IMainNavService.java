package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.MainNav;

import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
public interface IMainNavService {
    String addMainNav(MainNav mainNav) throws BaseException;

    void update(MainNav mainNav, Conditions conditions) throws BaseException;

    void updateById(MainNav mainNav) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    MainNav find(Conditions conditions) throws BaseException;

    MainNav findById(String id) throws BaseException;

    List<MainNav> listAllMainNav()throws BaseException;

    List<MainNav> listMainNavByBelongTo(String belongTo) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Page<MainNav> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;

}
