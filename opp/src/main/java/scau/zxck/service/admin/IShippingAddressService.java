package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.ShippingAddress;

import java.util.List;

/**
 * Created by YWY on 2016/3/18.
 */
public interface IShippingAddressService {
    String addShippingAddress(ShippingAddress shippingAddress) throws BaseException;

    void update(ShippingAddress shippingAddress, Conditions conditions) throws BaseException;

    void updateById(ShippingAddress shippingAddress) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    ShippingAddress find(Conditions conditions) throws BaseException;

    ShippingAddress findById(String id) throws BaseException;

    ShippingAddress findByEntity(ShippingAddress shippingAddress) throws BaseException;

    List<ShippingAddress> list(Conditions conditions) throws BaseException;
}