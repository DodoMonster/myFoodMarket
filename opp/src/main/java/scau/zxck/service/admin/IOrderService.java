package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.Order;

import java.util.List;

/**
 * Created by ZZWEI on 2016/3/17.
 */
public interface IOrderService {
    String addOrder(Order order)throws BaseException;

    void update(Order order, Conditions conditions) throws BaseException;

    void updateById(Order order) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    Order find(Conditions conditions) throws BaseException;

    Order findById(String id) throws BaseException;

    Order findByEntity(Order order) throws BaseException;

    Order findByIdentifier(String identifier) throws BaseException;

    List<Order> list(Conditions conditions) throws BaseException;

    List<Order> listByEntity(Order order) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Page<Order> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;

}
