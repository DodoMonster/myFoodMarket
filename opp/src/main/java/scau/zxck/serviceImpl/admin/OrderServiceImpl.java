package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.OrderDao;
import scau.zxck.entity.admin.Order;
import scau.zxck.service.admin.IOrderService;

import java.util.List;

/**
 * Created by ZZWEI on 2016/3/17.
 */
@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private OrderDao orderDao;

    @Override
    public String addOrder(Order order) throws BaseException {
        return orderDao.add(order);
    }

    @Override
    public void update(Order order, Conditions conditions) throws BaseException {
        orderDao.update(order, conditions);
    }

    @Override
    public void updateById(Order order) throws BaseException {
        orderDao.updateById(order);
    }


    @Override
    public void delete(Conditions conditions) throws BaseException {
        orderDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        orderDao.deleteByIds(ids);
    }

    @Override
    public Order find(Conditions conditions) throws BaseException {
        return orderDao.find(conditions);
    }

    @Override
    public Order findById(String id) throws BaseException {
        return orderDao.findById(id);
    }

    @Override
    public Order findByEntity(Order order) throws BaseException {
        return orderDao.findByEntity(order);
    }

    @Override
    public Order findByIdentifier(String identifier) throws BaseException{
        return orderDao.findByIdentifier(identifier);
    }

    @Override
    public List<Order> list(Conditions conditions) throws BaseException {
        return orderDao.list(conditions);
    }

    @Override
    public List<Order> listByEntity(Order order) throws BaseException {
        return orderDao.listByEntity(order);
    }


    @Override
    public long count(Conditions conditions) throws BaseException {
        return orderDao.count(conditions);
    }

    @Override
    public Page<Order> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return orderDao.page(conditions,offset,pageSize);
    }
}
