package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.MerchantMessageDao;
import scau.zxck.entity.admin.MerchantMessage;
import scau.zxck.service.admin.IMerchantMessageService;

import java.util.List;

/**
 * Created by YWY on 2016/3/18.
 */

@Service
public class MerchantMessageService implements IMerchantMessageService{

    @Autowired
    MerchantMessageDao merchantMessageDao;

    @Override
    public String add(MerchantMessage merchantMessage) throws BaseException {
        return merchantMessageDao.add(merchantMessage);
    }

    @Override
    public void update(MerchantMessage merchantMessage, Conditions conditions) throws BaseException {
        merchantMessageDao.update(merchantMessage,conditions);
    }

    @Override
    public void updateById(MerchantMessage merchantMessage) throws BaseException {
        merchantMessageDao.updateById(merchantMessage);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        merchantMessageDao.delete(conditions);
    }

    @Override
    public MerchantMessage find(Conditions conditions) throws BaseException {
        return merchantMessageDao.find(conditions);
    }

    @Override
    public MerchantMessage findById(String id) throws BaseException {
        return merchantMessageDao.findById(id);
    }

    @Override
    public MerchantMessage findByEntity(MerchantMessage merchantMessage) throws BaseException {
        return merchantMessageDao.findByEntity(merchantMessage);
    }

    @Override
    public List<MerchantMessage> list(Conditions conditions) throws BaseException {
        return merchantMessageDao.list(conditions);
    }
}
