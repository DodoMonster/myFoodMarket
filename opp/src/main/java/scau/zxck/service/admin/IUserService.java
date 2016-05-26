package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.User;

import java.util.List;

/**
 * Created by suruijia on 2015/11/8.
 */
public interface IUserService {
    String addUser(User user) throws BaseException;

    void update(User user, Conditions conditions) throws BaseException;

    void updateById(User user) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    User find(Conditions conditions) throws BaseException;

    User findById(String id) throws BaseException;

    User findByEntity(User user) throws BaseException;

    List<User> list(Conditions conditions) throws BaseException;

    List<User> listByNameUsingLike(String name) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    User findUserFetchUserRole(String username) throws BaseException;

    Page<User> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;

    List<User> listByUserName(String username) throws BaseException;

}
