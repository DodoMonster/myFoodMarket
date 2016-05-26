package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.RolePermissionsDao;
import scau.zxck.entity.admin.RolePermissions;
import scau.zxck.service.admin.IRolePermissionsService;

import java.util.List;

/**
 * Created by suruijia on 2015/11/8.
 */
@Service
public class RolePermissionsServiceImpl implements IRolePermissionsService {

    @Autowired
    private RolePermissionsDao rolePermissionsDao;

    @Override
    public String addRolePermissions(RolePermissions rolePermissions) throws BaseException {
        return rolePermissionsDao.add(rolePermissions);
    }

    @Override
    public void update(RolePermissions rolePermissions, Conditions conditions) throws BaseException {
        rolePermissionsDao.update(rolePermissions,conditions);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        rolePermissionsDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        rolePermissionsDao.deleteByIds(ids);
    }

    @Override
    public void deleteByEntity(RolePermissions rolePermissions) throws BaseException {
        rolePermissionsDao.deleteByEntity(rolePermissions);
    }

    @Override
    public RolePermissions find(Conditions conditions) throws BaseException {
        return rolePermissionsDao.find(conditions);
    }

    @Override
    public List<RolePermissions> list(Conditions conditions) throws BaseException {
        return rolePermissionsDao.list(conditions);
    }

    @Override
    public List<RolePermissions> listByEntity(RolePermissions rolePermissions, String... propertyName) throws BaseException {
        return rolePermissionsDao.listByEntity(rolePermissions,propertyName);
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return rolePermissionsDao.count(conditions);
    }
}
