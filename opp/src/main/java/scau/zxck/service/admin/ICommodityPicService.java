package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.CommodityPic;

import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
public interface ICommodityPicService {

    String addCommodityPic(CommodityPic commodityPic) throws BaseException;

    void updateByCommodityId(CommodityPic commodityPic, String commodityId) throws BaseException;

    void updateById(CommodityPic commodityPic) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    CommodityPic find(Conditions conditions) throws BaseException;

    CommodityPic findById(String id) throws BaseException;

    List<CommodityPic> listByCommodityId(String commodityId) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Page<CommodityPic> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;

}
