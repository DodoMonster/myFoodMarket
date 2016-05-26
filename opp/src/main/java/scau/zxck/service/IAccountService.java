package scau.zxck.service;

import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.Permissions;
import scau.zxck.entity.admin.Resources;
import scau.zxck.entity.admin.User;

import java.util.List;
import java.util.Set;

/**
 * Created by suruijia on 2015/11/2.
 */
public interface IAccountService {

    public User findUserByUserName(String username) throws BaseException;

    public Set<String> listRolesByUsername(String username) throws BaseException;

    public List<String> listPermissionsByUserName(String username) throws BaseException;

    public List<Permissions> listMenuPermissionsObjByUserName(String username) throws BaseException;

    public List<Resources> listResourcesByUsername(String username) throws BaseException;

    public List<String> listAvailableRequest() throws BaseException;

    public List<Resources> listMenuResourcesByPermissionId(String username) throws BaseException;
}
