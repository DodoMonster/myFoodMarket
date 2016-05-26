package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.ShoppingCart;

import java.util.List;

/**
 * Created by YWY on 2016/3/18.
 */
public interface IShoppingCartService {
    String addShoppingCart(ShoppingCart shoppingCart) throws BaseException;

    void update(ShoppingCart shoppingCart, Conditions conditions) throws BaseException;

    void updateById(ShoppingCart shoppingCart) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    ShoppingCart find(Conditions conditions) throws BaseException;

    ShoppingCart findById(String id) throws BaseException;

    ShoppingCart findByEntity(ShoppingCart shoppingCart) throws BaseException;

    List<ShoppingCart> list(Conditions conditions) throws BaseException;
}