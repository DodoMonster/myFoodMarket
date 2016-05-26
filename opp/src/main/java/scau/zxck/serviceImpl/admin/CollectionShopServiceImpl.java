package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.CollectionShopDao;
import scau.zxck.entity.admin.CollectionShop;
import scau.zxck.service.admin.ICollectionShopService;

import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
@Service
public class CollectionShopServiceImpl implements ICollectionShopService {

    @Autowired
    private CollectionShopDao collectionShopDao;

    @Override
    public String addCollectionShop(CollectionShop collectionShop) throws BaseException {
        return collectionShopDao.add(collectionShop);
    }

    @Override
    public void update(CollectionShop collectionShop, Conditions conditions) throws BaseException {
        collectionShopDao.update(collectionShop,conditions);
    }

    @Override
    public void updateById(CollectionShop collectionShop) throws BaseException {
        collectionShopDao.updateById(collectionShop);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        collectionShopDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        collectionShopDao.deleteByIds(ids);
    }

    @Override
    public CollectionShop find(Conditions conditions) throws BaseException {
        return collectionShopDao.find(conditions);
    }

    @Override
    public CollectionShop findById(String id) throws BaseException {
        return collectionShopDao.findById(id);
    }

    @Override
    public List<CollectionShop> list(Conditions conditions) throws BaseException {
        return collectionShopDao.list(conditions);
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return collectionShopDao.count(conditions);
    }

    @Override
    public Page<CollectionShop> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return collectionShopDao.page(conditions,offset,pageSize);
    }
}
