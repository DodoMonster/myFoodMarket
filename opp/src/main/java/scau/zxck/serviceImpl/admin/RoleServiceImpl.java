package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.RoleDao;
import scau.zxck.entity.admin.Role;
import scau.zxck.service.admin.IRoleService;

import java.util.List;

/**
 * Created by suruijia on 2015/11/8.
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public String addRole(Role role) throws BaseException {
        return roleDao.add(role);
    }

    @Override
    public void update(Role role, Conditions conditions) throws BaseException {
        roleDao.update(role,conditions);
    }

    @Override
    public void updateById(Role role) throws BaseException {
        roleDao.updateById(role);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        roleDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        roleDao.deleteByIds(ids);
    }

    @Override
    public Role find(Conditions conditions) throws BaseException {
        return roleDao.find(conditions);
    }

    @Override
    public Role findById(String id) throws BaseException {
        return roleDao.findById(id);
    }

    @Override
    public Role findByEntity(Role role) throws BaseException {
        return roleDao.findByEntity(role);
    }

    @Override
    public List<Role> list(Conditions conditions) throws BaseException {
        return roleDao.list(conditions);
    }

    @Override
    public List<Role> listByNameUsingLike(String name) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.like("name","%"+name+"%");
        List<Role> roleList = roleDao.list(conditions);
        return roleList;
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return roleDao.count(conditions);
    }

    @Override
    public Role findRoleFetchRolePermissions(String id) throws BaseException {
        return roleDao.findRoleFetchRolePermissions(id);
    }

    @Override
    public Page<Role> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return roleDao.page(conditions,offset,pageSize);
    }
}
