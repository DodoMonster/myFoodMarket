package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.CommodityGroup;

import java.util.List;

/**
 * Created by YWY on 2016/3/18.
 */
public interface ICommodityGroupService {
    String add(CommodityGroup commodityGroup) throws BaseException;

    void update(CommodityGroup commodityGroup, Conditions conditions) throws BaseException;

    void updateById(CommodityGroup commodityGroup) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    CommodityGroup find(Conditions conditions) throws BaseException;

    CommodityGroup findById(String id) throws BaseException;

    CommodityGroup findByEntity(CommodityGroup commodityGroup) throws BaseException;

    List<CommodityGroup> list(Conditions conditions) throws BaseException;
}