package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.CommodityOrderDao;
import scau.zxck.entity.admin.CommodityOrder;
import scau.zxck.service.admin.ICommodityOrderService;

import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
@Service
public class CommodityOrderServiceImpl implements ICommodityOrderService {

    @Autowired
    private CommodityOrderDao commodityOrderDao;

    @Override
    public String addCommodityOrder(CommodityOrder commodityOrder) throws BaseException {
        return commodityOrderDao.add(commodityOrder);
    }

    @Override
    public void update(CommodityOrder commodityOrder, Conditions conditions) throws BaseException {
        commodityOrderDao.update(commodityOrder,conditions);
    }

    @Override
    public void updateById(CommodityOrder commodityOrder) throws BaseException {
        commodityOrderDao.updateById(commodityOrder);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        commodityOrderDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        commodityOrderDao.deleteByIds(ids);
    }

    @Override
    public CommodityOrder find(Conditions conditions) throws BaseException {
        return commodityOrderDao.find(conditions);
    }

    @Override
    public CommodityOrder findById(String id) throws BaseException {
        return commodityOrderDao.findById(id);
    }

    @Override
    public List<CommodityOrder> list(Conditions conditions) throws BaseException {
        return commodityOrderDao.list(conditions);
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return commodityOrderDao.count(conditions);
    }

    @Override
    public Page<CommodityOrder> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return commodityOrderDao.page(conditions,offset,pageSize);
    }
}
