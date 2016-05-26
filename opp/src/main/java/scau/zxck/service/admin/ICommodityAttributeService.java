package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.CommodityAttribute;

import java.util.List;

/**
 * Created by YWY on 2016/3/18.
 */
public interface ICommodityAttributeService {
    String addCommodityAttribute(CommodityAttribute commodityAttribute) throws BaseException;

    void update(CommodityAttribute commodityAttribute, Conditions conditions) throws BaseException;

    void updateById(CommodityAttribute commodityAttribute) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    CommodityAttribute find(Conditions conditions) throws BaseException;

    CommodityAttribute findById(String id) throws BaseException;

    CommodityAttribute findByEntity(CommodityAttribute commodityAttribute) throws BaseException;

    List<CommodityAttribute> list(Conditions conditions) throws BaseException;
}