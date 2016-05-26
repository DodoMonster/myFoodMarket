package scau.zxck.service.admin;

import com.fasterxml.jackson.databind.deser.Deserializers;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.Commodity;

import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
public interface ICommodityService {

    String addCommodity(Commodity commodity) throws BaseException;

    void update(Commodity commodity, Conditions conditions) throws BaseException;

    void updateById(Commodity commodity) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    Commodity find(Conditions conditions) throws BaseException;

    Commodity findById(String id) throws BaseException;

    List<Commodity> listAll()throws BaseException;

    List<Commodity> listByShopId(String shopId) throws BaseException;

    List<Commodity> listBySubNavId(String subNavId) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Page<Commodity> findPage(int offset,int pageSize)throws BaseException;

    Page<Commodity> findPage(String shopId, String subNavId,int offset,int pageSize) throws BaseException;

    Page<Commodity> findPageByShopId(String shopId,int offset,int pageSize) throws BaseException;

    Page<Commodity> findPageBySubNavId(String subNavId,int offset,int pageSize) throws BaseException;
}
