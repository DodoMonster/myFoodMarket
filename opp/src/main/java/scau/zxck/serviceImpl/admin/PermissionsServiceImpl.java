package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.PermissionsDao;
import scau.zxck.entity.admin.Permissions;
import scau.zxck.service.admin.IPermissionsService;

import java.util.List;

/**
 * Created by suruijia on 2015/11/8.
 */
@Service
public class PermissionsServiceImpl implements IPermissionsService {

    @Autowired
    private PermissionsDao permissionsDao;

    @Override
    public String addPermissions(Permissions permissions) throws BaseException {
        return permissionsDao.add(permissions);
    }

    @Override
    public void update(Permissions permissions, Conditions conditions) throws BaseException {
        permissionsDao.update(permissions,conditions);
    }

    @Override
    public void updateById(Permissions permissions) throws BaseException {
        permissionsDao.updateById(permissions);
    }


    @Override
    public void delete(Conditions conditions) throws BaseException {
        permissionsDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        permissionsDao.deleteByIds(ids);
    }

    @Override
    public Permissions find(Conditions conditions) throws BaseException {
        return permissionsDao.find(conditions);
    }

    @Override
    public Permissions findById(String id) throws BaseException {
        return permissionsDao.findById(id);
    }

    @Override
    public Permissions findByEntity(Permissions permissions) throws BaseException {
        return permissionsDao.findByEntity(permissions);
    }

    @Override
    public List<Permissions> list(Conditions conditions) throws BaseException {
        return permissionsDao.list(conditions);
    }

    @Override
    public List<Permissions> listByEntity(Permissions permissions, String... propertyName) throws BaseException {
        return permissionsDao.listByEntity(permissions,propertyName);
    }

    @Override
    public List<Permissions> listAscByPermission() throws BaseException {
        return permissionsDao.list(new Conditions().asc("permission"));
    }

    @Override
    public List<Permissions> listByNameUsingLike(String name) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.like("permission","%"+name+"%");
        List<Permissions> permissionsList = permissionsDao.list(conditions);
        return permissionsList;
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return permissionsDao.count(conditions);
    }

    @Override
    public Page<Permissions> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return permissionsDao.page(conditions,offset,pageSize);
    }
}
