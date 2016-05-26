package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.CommodityCommentDao;
import scau.zxck.entity.admin.CommodityComment;
import scau.zxck.service.admin.ICommodityCommentService;

import java.util.List;

/**
 * Created by ZZWEI on 2016/3/18.
 */
@Service
public class CommodityCommentServiceImpl implements ICommodityCommentService{
    @Autowired
    private CommodityCommentDao commodityCommentDao;

    @Override
    public String addCommodityComment(CommodityComment commodityComment) throws BaseException {
        return commodityCommentDao.add(commodityComment);
    }

    @Override
    public void update(CommodityComment commodityComment, Conditions conditions) throws BaseException {
        commodityCommentDao.update(commodityComment, conditions);
    }

    @Override
    public void updateById(CommodityComment commodityComment) throws BaseException {
        commodityCommentDao.updateById(commodityComment);
    }


    @Override
    public void delete(Conditions conditions) throws BaseException {
        commodityCommentDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        commodityCommentDao.deleteByIds(ids);
    }

    @Override
    public CommodityComment find(Conditions conditions) throws BaseException {
        return commodityCommentDao.find(conditions);
    }

    @Override
    public CommodityComment findById(String id) throws BaseException {
        return commodityCommentDao.findById(id);
    }

    @Override
    public CommodityComment findByEntity(CommodityComment commodityComment) throws BaseException {
        return commodityCommentDao.findByEntity(commodityComment);
    }

    @Override
    public List<CommodityComment> listByCommodityId(String commodityId) throws BaseException {
        Conditions conditions=new Conditions();
        conditions.eq("commodity_id",commodityId);
        return commodityCommentDao.list(conditions);
    }

    @Override
    public List<CommodityComment> listByEntity(CommodityComment commodityComment) throws BaseException {
        return commodityCommentDao.listByEntity(commodityComment);
    }


    @Override
    public long count(Conditions conditions) throws BaseException {
        return commodityCommentDao.count(conditions);
    }

    @Override
    public Page<CommodityComment> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return commodityCommentDao.page(conditions,offset,pageSize);
    }
}
