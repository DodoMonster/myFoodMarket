package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.CommodityOrder;

import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
public interface ICommodityOrderService {
    String addCommodityOrder(CommodityOrder commodityOrder) throws BaseException;

    void update(CommodityOrder commodityOrder, Conditions conditions) throws BaseException;

    void updateById(CommodityOrder commodityOrder) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    CommodityOrder find(Conditions conditions) throws BaseException;

    CommodityOrder findById(String id) throws BaseException;

    List<CommodityOrder> list(Conditions conditions) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Page<CommodityOrder> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;

}
