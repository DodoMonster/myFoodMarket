package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.UserGroupDao;
import scau.zxck.entity.admin.UserGroup;
import scau.zxck.service.admin.IUserGroupService;

import java.util.List;

/**
 * Created by ZZWEI on 2016/3/18.
 */
@Service
public class UserGroupServiceImpl implements IUserGroupService{
    @Autowired
    private UserGroupDao userGroupDao;

    @Override
    public String addUserGroup(UserGroup userGroup) throws BaseException {
        return userGroupDao.add(userGroup);
    }

    @Override
    public void update(UserGroup userGroup, Conditions conditions) throws BaseException {
        userGroupDao.update(userGroup, conditions);
    }

    @Override
    public void updateById(UserGroup userGroup) throws BaseException {
        userGroupDao.updateById(userGroup);
    }


    @Override
    public void delete(Conditions conditions) throws BaseException {
        userGroupDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        userGroupDao.deleteByIds(ids);
    }

    @Override
    public UserGroup find(Conditions conditions) throws BaseException {
        return userGroupDao.find(conditions);
    }

    @Override
    public UserGroup findById(String id) throws BaseException {
        return userGroupDao.findById(id);
    }

    @Override
    public UserGroup findByEntity(UserGroup userGroup) throws BaseException {
        return userGroupDao.findByEntity(userGroup);
    }

    @Override
    public UserGroup findByName(String name) throws BaseException{
        return userGroupDao.findByName(name);
    }

    @Override
    public List<UserGroup> list(Conditions conditions) throws BaseException {
        return userGroupDao.list(conditions);
    }

    @Override
    public List<UserGroup> listByEntity(UserGroup userGroup, String... propertyName) throws BaseException {
        return userGroupDao.listByEntity(userGroup, propertyName);
    }


    @Override
    public List<UserGroup> listByNameUsingLike(String name) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.like("name","%"+name+"%");
        List<UserGroup> userGroupList = userGroupDao.list(conditions);
        return userGroupList;
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return userGroupDao.count(conditions);
    }

    @Override
    public Page<UserGroup> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return userGroupDao.page(conditions,offset,pageSize);
    }
}
