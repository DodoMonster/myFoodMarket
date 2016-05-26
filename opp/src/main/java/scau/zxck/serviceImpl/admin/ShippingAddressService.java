package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.ShippingAddressDao;
import scau.zxck.entity.admin.ShippingAddress;
import scau.zxck.service.admin.IShippingAddressService;

import java.util.List;

/**
 * Created by YWY on 2016/3/18.
 */

@Service
public class ShippingAddressService implements IShippingAddressService {

    @Autowired
    ShippingAddressDao shippingAddressDao;

    @Override
    public String addShippingAddress(ShippingAddress shippingAddress) throws BaseException {
        return shippingAddressDao.add(shippingAddress);
    }

    @Override
    public void update(ShippingAddress shippingAddress, Conditions conditions) throws BaseException {
        shippingAddressDao.update(shippingAddress,conditions);
    }

    @Override
    public void updateById(ShippingAddress shippingAddress) throws BaseException {
        shippingAddressDao.updateById(shippingAddress);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        shippingAddressDao.delete(conditions);
    }

    @Override
    public ShippingAddress find(Conditions conditions) throws BaseException {
        return shippingAddressDao.find(conditions);
    }

    @Override
    public ShippingAddress findById(String id) throws BaseException {
        return shippingAddressDao.findById(id);
    }

    @Override
    public ShippingAddress findByEntity(ShippingAddress shippingAddress) throws BaseException {
        return shippingAddressDao.findByEntity(shippingAddress);
    }

    @Override
    public List<ShippingAddress> list(Conditions conditions) throws BaseException {
        return shippingAddressDao.list(conditions);
    }
}
