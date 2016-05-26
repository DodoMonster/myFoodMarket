package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.CommodityDao;
import scau.zxck.dao.admin.CommodityGroupDao;
import scau.zxck.entity.admin.CommodityGroup;
import scau.zxck.service.admin.ICommodityGroupService;

import java.util.List;

/**
 * Created by YWY on 2016/3/18.
 */

@Service
public class CommodityGroupService implements ICommodityGroupService{

    @Autowired
    CommodityGroupDao commodityGroupDao;

    @Override
    public String add(CommodityGroup commodityGroup) throws BaseException {
        return commodityGroupDao.add(commodityGroup);
    }

    @Override
    public void update(CommodityGroup commodityGroup, Conditions conditions) throws BaseException {
        commodityGroupDao.update(commodityGroup,conditions);
    }

    @Override
    public void updateById(CommodityGroup commodityGroup) throws BaseException {
        commodityGroupDao.updateById(commodityGroup);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        commodityGroupDao.delete(conditions);
    }

    @Override
    public CommodityGroup find(Conditions conditions) throws BaseException {
        return commodityGroupDao.find(conditions);
    }

    @Override
    public CommodityGroup findById(String id) throws BaseException {
        return commodityGroupDao.findById(id);
    }

    @Override
    public CommodityGroup findByEntity(CommodityGroup commodityGroup) throws BaseException {
        return commodityGroupDao.findByEntity(commodityGroup);
    }

    @Override
    public List<CommodityGroup> list(Conditions conditions) throws BaseException {
        return commodityGroupDao.list(conditions);
    }
}
