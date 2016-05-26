package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.Shop;

import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
public interface IShopService {

    String addShop(Shop shop) throws BaseException;

    void update(Shop shop, Conditions conditions) throws BaseException;

    void updateById(Shop shop) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    Shop find(Conditions conditions) throws BaseException;

    Shop findById(String id) throws BaseException;

    List<Shop> list(Conditions conditions) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Page<Shop> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;

}
