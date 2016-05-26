package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.CommodityPicDao;
import scau.zxck.entity.admin.CommodityPic;
import scau.zxck.service.admin.ICommodityPicService;

import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
@Service
public class CommodityPicServiceImpl implements ICommodityPicService {

    @Autowired
    private CommodityPicDao commodityPicDao;

    @Override
    public String addCommodityPic(CommodityPic commodityPic) throws BaseException {
        return commodityPicDao.add(commodityPic);
    }

    @Override
    public void updateByCommodityId(CommodityPic commodityPic, String commodityId) throws BaseException {
        Conditions conditions=new Conditions();
        conditions.eq("commodity_id",commodityId);
        commodityPicDao.update(commodityPic,conditions);
    }

    @Override
    public void updateById(CommodityPic commodityPic) throws BaseException {
        commodityPicDao.updateById(commodityPic);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        commodityPicDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        commodityPicDao.deleteByIds(ids);
    }

    @Override
    public CommodityPic find(Conditions conditions) throws BaseException {
        return commodityPicDao.find(conditions);
    }

    @Override
    public CommodityPic findById(String id) throws BaseException {
        return commodityPicDao.findById(id);
    }

    @Override
    public List<CommodityPic> listByCommodityId(String commodityId) throws BaseException {
        Conditions conditions=new Conditions();
        conditions.eq("commodity_id",commodityId);
        return commodityPicDao.list(conditions);
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return commodityPicDao.count(conditions);
    }

    @Override
    public Page<CommodityPic> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return commodityPicDao.page(conditions,offset,pageSize);
    }
}
