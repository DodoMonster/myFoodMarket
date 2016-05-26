package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.CommodityAttributeDao;
import scau.zxck.entity.admin.CommodityAttribute;
import scau.zxck.service.admin.ICommodityAttributeService;

import java.util.List;

/**
 * Created by YWY on 2016/3/21.
 */
@Service
public class CommodityAttributeService implements ICommodityAttributeService {

    @Autowired
    private CommodityAttributeDao commodityAttributeDao;

    @Override
    public String addCommodityAttribute(CommodityAttribute commodityAttribute) throws BaseException {
        return commodityAttributeDao.add(commodityAttribute);
    }

    @Override
    public void update(CommodityAttribute commodityAttribute, Conditions conditions) throws BaseException {
        commodityAttributeDao.update(commodityAttribute,conditions);
    }

    @Override
    public void updateById(CommodityAttribute commodityAttribute) throws BaseException {
        commodityAttributeDao.updateById(commodityAttribute);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        commodityAttributeDao.delete(conditions);
    }

    @Override
    public CommodityAttribute find(Conditions conditions) throws BaseException {
        return commodityAttributeDao.find(conditions);
    }

    @Override
    public CommodityAttribute findById(String id) throws BaseException {
        return commodityAttributeDao.findById(id);
    }

    @Override
    public CommodityAttribute findByEntity(CommodityAttribute commodityAttribute) throws BaseException {
        return commodityAttributeDao.findByEntity(commodityAttribute);
    }

    @Override
    public List<CommodityAttribute> list(Conditions conditions) throws BaseException {
        return commodityAttributeDao.list(conditions);
    }
}
