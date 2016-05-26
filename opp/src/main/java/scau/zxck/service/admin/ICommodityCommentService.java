package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.CommodityComment;

import java.util.List;

/**
 * Created by ZZWEI on 2016/3/18.
 */
public interface ICommodityCommentService {
    String addCommodityComment(CommodityComment commodityComment)throws BaseException;

    void update(CommodityComment commodityComment, Conditions conditions) throws BaseException;

    void updateById(CommodityComment commodityComment) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    CommodityComment find(Conditions conditions) throws BaseException;

    CommodityComment findById(String id) throws BaseException;

    CommodityComment findByEntity(CommodityComment commodityComment) throws BaseException;

    List<CommodityComment> listByCommodityId(String commodityId) throws BaseException;

    List<CommodityComment> listByEntity(CommodityComment commodityComment) throws BaseException;



    long count(Conditions conditions) throws BaseException;

    Page<CommodityComment> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;
}
