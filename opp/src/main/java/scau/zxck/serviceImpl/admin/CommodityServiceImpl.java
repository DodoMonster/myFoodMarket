package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.CommodityDao;
import scau.zxck.entity.admin.Commodity;
import scau.zxck.entity.admin.MainNav;
import scau.zxck.service.admin.ICommodityService;

import java.sql.Connection;
import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
@Service
public class CommodityServiceImpl implements ICommodityService {

    @Autowired
    private CommodityDao commodityDao;

    @Override
    public String addCommodity(Commodity commodity) throws BaseException {
        return commodityDao.add(commodity);
    }

    @Override
    public void update(Commodity commodity, Conditions conditions) throws BaseException {
        commodityDao.update(commodity,conditions);
    }

    @Override
    public void updateById(Commodity commodity) throws BaseException {
        commodityDao.updateById(commodity);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        commodityDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        commodityDao.deleteByIds(ids);
    }

    @Override
    public Commodity find(Conditions conditions) throws BaseException {
        return commodityDao.find(conditions);
    }

    @Override
    public Commodity findById(String id) throws BaseException {
        return commodityDao.findById(id);
    }

    @Override
    public List<Commodity> listBySubNavId(String subNavId) throws BaseException {
        Conditions conditions=new Conditions();
        conditions.eq("sub_nav_id",subNavId);
        return commodityDao.list(conditions);
    }

    @Override
    public List<Commodity> listByShopId(String  ShopId) throws BaseException {
        Conditions conditions=new Conditions();
        conditions.eq("shop_id",ShopId);
        return commodityDao.list(conditions);
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return commodityDao.count(conditions);
    }

    @Override
    public Page<Commodity> findPageByShopId(String shopId, int offset, int pageSize) throws BaseException {
        Conditions conditions=new Conditions();
        conditions.eq("shop_id",shopId);
        return commodityDao.page(conditions,offset,pageSize);
    }


    @Override
    public Page<Commodity> findPageBySubNavId(String subNavId, int offset, int pageSize) throws BaseException {
       Conditions conditions=new Conditions();
       conditions.eq("sub_nav_id",subNavId);
       return commodityDao.page(conditions,offset,pageSize);
    }

    @Override
    public List<Commodity> listAll() throws BaseException {
        return commodityDao.list(null);
    }

    @Override
    public Page<Commodity> findPage(String shopId, String subNavId,int offset, int pageSize) throws BaseException {
        Conditions conditions=new Conditions();
        conditions.eq("shop_id",shopId);
        conditions.and();
        conditions.eq("sub_nav_id",subNavId);
        return commodityDao.page(conditions,offset,pageSize);
    }

    @Override
    public Page<Commodity> findPage(int offset,int pageSize)throws BaseException{
        return commodityDao.page(null,offset,pageSize);
    }
}
