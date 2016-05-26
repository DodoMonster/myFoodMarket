package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.ShoppingCartDao;
import scau.zxck.entity.admin.ShoppingCart;
import scau.zxck.service.admin.IShoppingCartService;

import java.util.List;

/**
 * Created by YWY on 2016/3/18.
 */
@Service
public class ShoppingCartImpl implements IShoppingCartService {

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Override
    public String addShoppingCart(ShoppingCart shoppingCart) throws BaseException {
        return shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void update(ShoppingCart shoppingCart, Conditions conditions) throws BaseException {
        shoppingCartDao.update(shoppingCart,conditions);
    }

    @Override
    public void updateById(ShoppingCart shoppingCart) throws BaseException {
        shoppingCartDao.updateById(shoppingCart);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        shoppingCartDao.delete(conditions);
    }

    @Override
    public ShoppingCart find(Conditions conditions) throws BaseException {
        return shoppingCartDao.find(conditions);
    }

    @Override
    public ShoppingCart findById(String id) throws BaseException {
        return shoppingCartDao.findById(id);
    }

    @Override
    public ShoppingCart findByEntity(ShoppingCart shoppingCart) throws BaseException {
        return shoppingCartDao.findByEntity(shoppingCart);
    }

    @Override
    public List<ShoppingCart> list(Conditions conditions) throws BaseException {
        return shoppingCartDao.list(conditions);
    }
}