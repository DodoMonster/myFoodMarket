package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.CommodityCommentReplyDao;
import scau.zxck.entity.admin.CommodityComment;
import scau.zxck.entity.admin.CommodityCommentReply;
import scau.zxck.service.admin.ICommodityCommentReplyService;

import java.util.List;

/**
 * Created by ZZWEI on 2016/3/18.
 */
@Service
public class CommodityCommentReplyServiceImpl implements ICommodityCommentReplyService{
    @Autowired
    private CommodityCommentReplyDao commodityCommentReplyDao;

    @Override
    public String addCommodityCommentReply(CommodityCommentReply commodityCommentReply) throws BaseException {
        return commodityCommentReplyDao.add(commodityCommentReply);
    }

    @Override
    public void update(CommodityCommentReply commodityCommentReply, Conditions conditions) throws BaseException {
        commodityCommentReplyDao.update(commodityCommentReply, conditions);
    }

    @Override
    public void updateById(CommodityCommentReply commodityCommentReply) throws BaseException {
        commodityCommentReplyDao.updateById(commodityCommentReply);
    }


    @Override
    public void delete(Conditions conditions) throws BaseException {
        commodityCommentReplyDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        commodityCommentReplyDao.deleteByIds(ids);
    }

    @Override
    public CommodityCommentReply find(Conditions conditions) throws BaseException {
        return commodityCommentReplyDao.find(conditions);
    }

    @Override
    public CommodityCommentReply findById(String id) throws BaseException {
        return commodityCommentReplyDao.findById(id);
    }

    @Override
    public CommodityCommentReply findByEntity(CommodityCommentReply commodityCommentReply) throws BaseException {
        return commodityCommentReplyDao.findByEntity(commodityCommentReply);
    }

    @Override
    public List<CommodityCommentReply> list(Conditions conditions) throws BaseException {
        return commodityCommentReplyDao.list(conditions);
    }

    @Override
    public List<CommodityCommentReply> listByEntity(CommodityCommentReply commodityCommentReply) throws BaseException {
        return commodityCommentReplyDao.listByEntity(commodityCommentReply);
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return commodityCommentReplyDao.count(conditions);
    }

    @Override
    public Page<CommodityCommentReply> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return commodityCommentReplyDao.page(conditions,offset,pageSize);
    }
}
