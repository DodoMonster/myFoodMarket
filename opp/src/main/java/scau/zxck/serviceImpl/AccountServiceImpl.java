package scau.zxck.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.PermissionsDao;
import scau.zxck.dao.admin.ResourcesDao;
import scau.zxck.dao.admin.RoleDao;
import scau.zxck.dao.admin.UserDao;
import scau.zxck.entity.admin.*;
import scau.zxck.service.IAccountService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by suruijia on 2015/11/2.
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionsDao permissionDao;

    @Autowired
    private ResourcesDao resourcesDao;

    @Override
    public User findUserByUserName(String username) throws BaseException {
        User user = userDao.findFetchUserRole(username);
        return user;
    }

    @Override
    public Set<String> listRolesByUsername(String username) throws BaseException {
        User user = findUserByUserName(username);
        Set<String> set = new HashSet<String>() ;
        for(UserRole userRole:user.getUserRoles()){
            Role role = roleDao.findRoleFetchRolePermissions(userRole.getRoleId());
            set.add(role.getName());
        }
        return set;
    }

    @Override
    public List<String> listPermissionsByUserName(String username) throws BaseException {
        User user = findUserByUserName(username);
        if(user == null){
            return null;
        }
        List<String> list = new ArrayList<String>();
        for(UserRole userRole:user.getUserRoles()){

            Role role = roleDao.findRoleFetchRolePermissions(userRole.getRoleId());

            for(RolePermissions rolePermissions:role.getRolePermissionsList()){
                Conditions conditionsP = new Conditions();
                conditionsP.eq("id", rolePermissions.getPermissionId());
                Permissions permissions = permissionDao.find(conditionsP);
                if(null != permissions)
                    list.add(permissions.getPermission());
            }
        }
        return list;
    }

    @Override
    public List<Permissions> listMenuPermissionsObjByUserName(String username) throws BaseException {
        User user = findUserByUserName(username);
        if(user == null){
            return null;
        }
        List<Permissions> list = new ArrayList<Permissions>();
        for(UserRole userRole:user.getUserRoles()){

            Role role = roleDao.findRoleFetchRolePermissions(userRole.getRoleId());

            for(RolePermissions rolePermissions:role.getRolePermissionsList()){
                Conditions conditionsP = new Conditions();
                conditionsP.eq("id", rolePermissions.getPermissionId());
                conditionsP.and();
                conditionsP.like("permission", "menu%");
                Permissions permissions = permissionDao.find(conditionsP);
                if(null != permissions)
                    list.add(permissions);
            }
        }
        return list;
    }

    @Override
    public List<Resources> listResourcesByUsername(String username) throws BaseException {
        User user = findUserByUserName(username);
        if(user == null){
            return null;
        }
        List<Resources> list = new ArrayList<Resources>();
        for(UserRole userRole:user.getUserRoles()){

            Role role = roleDao.findRoleFetchRolePermissions(userRole.getRoleId());

            for(RolePermissions rolePermissions:role.getRolePermissionsList()){
                Conditions conditionsP = new Conditions();
                conditionsP.eq("id", rolePermissions.getPermissionId());
                Permissions permissions = permissionDao.find(conditionsP);
                Conditions conditionsE = new Conditions();
                conditionsE.eq("permission_id", permissions.getId());
                List<Resources> resourcesList = resourcesDao.list(conditionsE);
                for(Resources resources:resourcesList){
                    list.add(resources);
                }
            }
        }
        return list;
    }

    @Override
    public List<String> listAvailableRequest() throws BaseException {
        List<String> list = new ArrayList<String>();
        Conditions conditions = new Conditions();
        conditions.eq("available",0);
        List<Resources> resourcesList = resourcesDao.list(conditions);
        for(Resources resources:resourcesList){
            list.add(resources.getUrl());
        }
        return list;
    }

    @Override
    public List<Resources> listMenuResourcesByPermissionId(String permissionId) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.eq("permission_id",permissionId);
        conditions.asc("parent_id","priority");
        List<Resources> resourcesList = resourcesDao.list(conditions);
        return resourcesList;
    }
}
