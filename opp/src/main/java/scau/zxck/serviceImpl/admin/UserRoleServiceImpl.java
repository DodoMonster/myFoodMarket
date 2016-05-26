package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.UserRoleDao;
import scau.zxck.entity.admin.UserRole;
import scau.zxck.service.admin.IUserRoleService;

import java.util.List;

/**
 * Created by suruijia on 2015/11/8.
 */
@Service
public class UserRoleServiceImpl implements IUserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public String addUserRole(UserRole userRole) throws BaseException {
        return userRoleDao.add(userRole);
    }

    @Override
    public void update(UserRole userRole, Conditions conditions) throws BaseException {
        userRoleDao.update(userRole,conditions);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        userRoleDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        userRoleDao.deleteByIds(ids);
    }

    @Override
    public void deleteByEntity(UserRole userRole) throws BaseException {
        userRoleDao.deleteByEntity(userRole);
    }

    @Override
    public UserRole find(Conditions conditions) throws BaseException {
        return userRoleDao.find(conditions);
    }

    @Override
    public List<UserRole> list(Conditions conditions) throws BaseException {
        return userRoleDao.list(conditions);
    }

    @Override
    public List<UserRole> listByEntity(UserRole userRole, String... propertyName) throws BaseException {
        return userRoleDao.listByEntity(userRole,propertyName);
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return userRoleDao.count(conditions);
    }

}
