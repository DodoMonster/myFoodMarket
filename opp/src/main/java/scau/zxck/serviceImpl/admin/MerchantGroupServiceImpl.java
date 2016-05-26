package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.MerchantGroupDao;
import scau.zxck.entity.admin.MerchantGroup;
import scau.zxck.service.admin.IMerchantGroupService;

import java.util.List;

/**
 * Created by ZZWEI on 2016/3/18.
 */
@Service
public class MerchantGroupServiceImpl implements IMerchantGroupService{
    @Autowired
    private MerchantGroupDao merchantGroupDao;

    @Override
    public String addMerchantGroup(MerchantGroup merchantGroup) throws BaseException {
        return merchantGroupDao.add(merchantGroup);
    }

    @Override
    public void update(MerchantGroup merchantGroup, Conditions conditions) throws BaseException {
        merchantGroupDao.update(merchantGroup, conditions);
    }

    @Override
    public void updateById(MerchantGroup merchantGroup) throws BaseException {
        merchantGroupDao.updateById(merchantGroup);
    }


    @Override
    public void delete(Conditions conditions) throws BaseException {
        merchantGroupDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        merchantGroupDao.deleteByIds(ids);
    }

    @Override
    public MerchantGroup find(Conditions conditions) throws BaseException {
        return merchantGroupDao.find(conditions);
    }

    @Override
    public MerchantGroup findById(String id) throws BaseException {
        return merchantGroupDao.findById(id);
    }

    @Override
    public MerchantGroup findByEntity(MerchantGroup merchantGroup) throws BaseException {
        return merchantGroupDao.findByEntity(merchantGroup);
    }

    @Override
    public MerchantGroup findByName(String name) throws BaseException{
        return merchantGroupDao.findByName(name);
    }

    @Override
    public List<MerchantGroup> list(Conditions conditions) throws BaseException {
        return merchantGroupDao.list(conditions);
    }

    @Override
    public List<MerchantGroup> listByEntity(MerchantGroup merchantGroup, String... propertyName) throws BaseException {
        return merchantGroupDao.listByEntity(merchantGroup, propertyName);
    }


    @Override
    public List<MerchantGroup> listByNameUsingLike(String name) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.like("name","%"+name+"%");
        List<MerchantGroup> merchantGroupList = merchantGroupDao.list(conditions);
        return merchantGroupList;
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return merchantGroupDao.count(conditions);
    }

    @Override
    public Page<MerchantGroup> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return merchantGroupDao.page(conditions,offset,pageSize);
    }
}
