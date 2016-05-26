package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.UserDao;
import scau.zxck.entity.admin.User;
import scau.zxck.service.admin.IUserService;

import java.util.List;

/**
 * Created by suruijia on 2015/11/8.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public String addUser(User user) throws BaseException {
        return userDao.add(user);
    }

    @Override
    public void update(User user, Conditions conditions) throws BaseException {
        userDao.update(user, conditions);
    }

    @Override
    public void updateById(User user) throws BaseException {
        userDao.updateById(user);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        userDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        userDao.deleteByIds(ids);
    }

    @Override
    public User find(Conditions conditions) throws BaseException {
        return userDao.find(conditions);
    }

    @Override
    public User findById(String id) throws BaseException {
        return userDao.findById(id);
    }

    @Override
    public User findByEntity(User user) throws BaseException {
        return userDao.findByEntity(user);
    }


    @Override
    public List<User> list(Conditions conditions) throws BaseException {
        return userDao.list(conditions);
    }

    @Override
    public List<User> listByNameUsingLike(String name) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.like("username","%"+name+"%");
        List<User> userList = userDao.list(conditions);
        return userList;
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return userDao.count(conditions);
    }

    @Override
    public User findUserFetchUserRole(String username) throws BaseException {
        return userDao.findFetchUserRole(username);
    }

    @Override
    public Page<User> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return userDao.page(conditions, offset, pageSize);
    }

    public List<User> listByUserName(String username) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.eq("username", username);
        return userDao.list(conditions);
    }

}
