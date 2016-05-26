package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.CollectionShop;

import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
public interface ICollectionShopService {

    String addCollectionShop(CollectionShop collectionShop) throws BaseException;

    void update(CollectionShop collectionShop, Conditions conditions) throws BaseException;

    void updateById(CollectionShop collectionShop) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    CollectionShop find(Conditions conditions) throws BaseException;

    CollectionShop findById(String id) throws BaseException;

    List<CollectionShop> list(Conditions conditions) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Page<CollectionShop> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;

}
