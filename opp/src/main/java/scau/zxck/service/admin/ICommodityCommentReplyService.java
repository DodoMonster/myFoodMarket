package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.CommodityCommentReply;

import java.util.List;

/**
 * Created by ZZWEI on 2016/3/18.
 */
public interface ICommodityCommentReplyService {
    String addCommodityCommentReply(CommodityCommentReply commodityCommentReply)throws BaseException;

    void update(CommodityCommentReply commodityCommentReply, Conditions conditions) throws BaseException;

    void updateById(CommodityCommentReply commodityCommentReply) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    CommodityCommentReply find(Conditions conditions) throws BaseException;

    CommodityCommentReply findById(String id) throws BaseException;

    CommodityCommentReply findByEntity(CommodityCommentReply commodityCommentReply) throws BaseException;

    List<CommodityCommentReply> list(Conditions conditions) throws BaseException;

    List<CommodityCommentReply> listByEntity(CommodityCommentReply commodityCommentReply) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Page<CommodityCommentReply> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;
}
