package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.Keyword;

import java.util.List;

/**
 * Created by ZZWEI on 2016/3/18.
 */
public interface IKeywordService {
    String addKeyword(Keyword keyword)throws BaseException;

    void update(Keyword keyword, Conditions conditions) throws BaseException;

    void updateById(Keyword keyword) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    Keyword find(Conditions conditions) throws BaseException;

    Keyword findById(String id) throws BaseException;

    Keyword findByEntity(Keyword keyword) throws BaseException;

    Keyword findByName(String name) throws BaseException;

    List<Keyword> list(Conditions conditions) throws BaseException;

    List<Keyword> listByEntity(Keyword keyword, String... propertyName) throws BaseException;

    List<Keyword> listByNameUsingLike(String name) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Page<Keyword> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;
}
