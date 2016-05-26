package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.ShopDao;
import scau.zxck.entity.admin.Shop;
import scau.zxck.service.admin.IShopService;

import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
@Service
public class ShopServiceImpl implements IShopService{

    @Autowired
    private ShopDao shopDao;

    @Override
    public String addShop(Shop shop) throws BaseException {
        return shopDao.add(shop);
    }

    @Override
    public void update(Shop shop, Conditions conditions) throws BaseException {
        shopDao.update(shop, conditions);
    }

    @Override
    public void updateById(Shop shop) throws BaseException {
        shopDao.updateById(shop);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        shopDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        shopDao.deleteByIds(ids);
    }

    @Override
    public Shop find(Conditions conditions) throws BaseException {
        return shopDao.find(conditions);
    }

    @Override
    public Shop findById(String id) throws BaseException {
        return shopDao.findById(id);
    }

    @Override
    public List<Shop> list(Conditions conditions) throws BaseException {
        return shopDao.list(conditions);
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return shopDao.count(conditions);
    }

    @Override
    public Page<Shop> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return shopDao.page(conditions,offset,pageSize);
    }
}
