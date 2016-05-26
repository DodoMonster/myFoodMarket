package scau.zxck.web.admin;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.*;
import scau.zxck.service.IAccountService;
import scau.zxck.service.admin.*;
import scau.zxck.web.shiro.PasswordHelper;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by suruijia on 2015/11/15.
 */
@Controller
@RequestMapping("/UrpAction")
public class UrpAction {

    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IUserRoleService iUserRoleService;

    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private IRolePermissionsService iRolePermissionsService;

    @Autowired
    private IPermissionsService iPermissionsService;

    @Autowired
    private IResourcesService iResourcesService;


    @RequestMapping(value = "/showUserMsg", method = RequestMethod.GET)
    public String showUserMsg(String userId,String type,Model model) throws BaseException {
        System.out.println("in usermsg:"+userId);
        System.out.println("type:"+type);
        if(type.equals("1")) {
            User user = iUserService.findById(userId);
            model.addAttribute("user", user);
        }else{
            model.addAttribute("type", type);
        }
        return "admin/layer/UserMsg";
    }

    @RequestMapping(value = "/showRoleMsg", method = RequestMethod.GET)
    public String showRoleMsg(String roleId,String type,Model model) throws BaseException {
        System.out.println("in showRoleMsg:"+roleId);
        if(type.equals("1")) {
            Role role = iRoleService.findById(roleId);
            model.addAttribute("role",role);
        }else{
            model.addAttribute("type", type);
        }

        return "admin/layer/RoleMsg";
    }

    @RequestMapping(value = "/showPermissionMsg", method = RequestMethod.GET)
    public String showPermissionMsg(String permissionId,String type,Model model) throws BaseException {
        System.out.println("in showPermissionMsg:"+permissionId);

        if(type.equals("1")) {
            Permissions permissions = iPermissionsService.findById(permissionId);
            model.addAttribute("permission",permissions);
        }else{
            model.addAttribute("type", type);
        }

        return "admin/layer/PermissionMsg";
    }

    @RequestMapping(value = "/showResourceMsg", method = RequestMethod.GET)
    public String showResourceMsg(String resourceId,String type,Model model) throws BaseException {
        System.out.println("in showResourceMsg:"+resourceId);

        if(type.equals("1")) {
            Resources resources = iResourcesService.findById(resourceId);
            model.addAttribute("resource",resources);
        }else{
            model.addAttribute("type", type);
        }

        return "admin/layer/ResourceMsg";
    }

    @RequestMapping(value = "/showUserRole", method = RequestMethod.GET)
    public String showUserRole(String userId,String type,Model model) throws BaseException {
        System.out.println("in UserRole:"+userId);
        model.addAttribute("userId",userId);
        switch (type){
            case "has":
                System.out.println("in has:");
                UserRole ur = new UserRole();
                ur.setUserId(userId);
                List<UserRole> userRoleList = iUserRoleService.listByEntity(ur);
                List<Role> roleList = new ArrayList<Role>();
                for(UserRole userRole:userRoleList){
                    roleList.add(iRoleService.findById(userRole.getRoleId()));
                }
                model.addAttribute("type",type);
                model.addAttribute("result",roleList);
                break;
            case "add":
                System.out.println("in add:");
                List<Role> roleList1 = iRoleService.list(null);
                model.addAttribute("result",roleList1);
                break;
        }


        return "admin/layer/UserRole";
    }

    @RequestMapping(value = "/showRolePermission", method = RequestMethod.GET)
    public String showRolePermission(String roleId,String type,Model model) throws BaseException {
        System.out.println("in showRolePermission:"+roleId);
        model.addAttribute("roleId",roleId);
        switch (type){
            case "has":
                System.out.println("in has:");
                RolePermissions rp = new RolePermissions();
                rp.setRoleId(roleId);
                List<RolePermissions> rolePermissionsList = iRolePermissionsService.listByEntity(rp);
                List<Permissions> permissionsList = new ArrayList<Permissions>();
                for(RolePermissions rolePermissions:rolePermissionsList){
                    permissionsList.add(iPermissionsService.findById(rolePermissions.getPermissionId()));
                }
                model.addAttribute("type",type);
                model.addAttribute("result",permissionsList);
                break;
            case "add":
                System.out.println("in add:");
                List<Permissions> permissionsList1 = iPermissionsService.list(null);
                model.addAttribute("result",permissionsList1);
                break;
        }


        return "admin/layer/RolePermission";
    }


    @RequestMapping(value = "/showPermissionResource", method = RequestMethod.GET)
    public String showPermissionResource(String permissionId,String type,Model model) throws BaseException {
        System.out.println("in showPermissionResource:"+permissionId);
        model.addAttribute("permissionId",permissionId);
        switch (type){
            case "has":
                System.out.println("in has:");
                Resources resources = new Resources();
                resources.setPermissionId(permissionId);
                List<Resources> resourcesList = iResourcesService.listByEntity(resources, new String[0]);
                model.addAttribute("type",type);
                model.addAttribute("result",resourcesList);
                break;
            case "add":
                System.out.println("in add:");
                List<Resources> resourcesList1 = iResourcesService.list(null);
                model.addAttribute("result",resourcesList1);
                break;
        }


        return "admin/layer/PermissionResource";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(HttpServletRequest request) throws BaseException {

        System.out.println("in addUser");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String available = request.getParameter("available");
        String remark = request.getParameter("remark");

        User forsearch = new User();
        forsearch.setUsername(username);
        User same = iUserService.findByEntity(forsearch);

        //是否存在
        if(same == null){
            //不存在则新建
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            if(!available.equals(""))
                user.setAvailable(Integer.parseInt(available));
            user.setRemark(remark);
            PasswordHelper passwordHelper = new PasswordHelper();
            passwordHelper.encryptPassword(user);
            iUserService.addUser(user);

            //分配普通用户角色
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleId("3c6fd9e0c4cc41f7be8c907ad60d742e");
            iUserRoleService.addUserRole(userRole);

            return JSON.toJSONString(user);

        }else{
            return "1";
        }
    }

    @RequestMapping("/addRole")
    @ResponseBody
    public String addRole(HttpServletRequest request) throws BaseException {

        System.out.println("in addRole");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String available = request.getParameter("available");
        String remark = request.getParameter("remark");

        Role forsearch = new Role();
        forsearch.setName(name);
        forsearch.setDescription(description);
        Role same = iRoleService.findByEntity(forsearch);

        //是否存在
        if(same == null){
            //不存在则新建
            Role role = new Role();
            role.setName(name);
            role.setDescription(description);
            if(!available.equals(""))
                role.setAvailable(Integer.parseInt(available));
            role.setRemark(remark);
            iRoleService.addRole(role);
            return JSON.toJSONString(role);
        }else{
            return "1";
        }
    }

    @RequestMapping("/addPermission")
    @ResponseBody
    public String addPermission(HttpServletRequest request) throws BaseException {

        System.out.println("in addPermission");
        String permission = request.getParameter("permission");
        String description = request.getParameter("description");
        String available = request.getParameter("available");
        String remark = request.getParameter("remark");

        Permissions forsearch = new Permissions();
        forsearch.setPermission(permission);
        forsearch.setDescription(description);
        Permissions same = iPermissionsService.findByEntity(forsearch);

        if(same == null){
            Permissions permissions = new Permissions();
            permissions.setPermission(permission);
            permissions.setDescription(description);
            if(!available.equals(""))
                permissions.setAvailable(Integer.parseInt(available));
            permissions.setRemark(remark);
            iPermissionsService.addPermissions(permissions);

            RolePermissions rolePermissions = new RolePermissions();
            rolePermissions.setRoleId("1255454fb1c5400a80b77e17cbd59607");
            rolePermissions.setPermissionId(permissions.getId());
            iRolePermissionsService.addRolePermissions(rolePermissions);


            return JSON.toJSONString(permissions);
        }else{
            return "1";
        }
    }

    @RequestMapping("/addResource")
    @ResponseBody
    public String addResource(HttpServletRequest request) throws BaseException {

        System.out.println("in addResource");
        String name = request.getParameter("name");
        String url = request.getParameter("url");
        String type = request.getParameter("type");
        String priority = request.getParameter("priority");
        String parentId = request.getParameter("parentId");
        String available = request.getParameter("available");
        String remark = request.getParameter("remark");

        Resources forsearch = new Resources();
        forsearch.setName(name);
        forsearch.setUrl(url);
        forsearch.setType(type);
        if(!priority.equals(""))
            forsearch.setPriority(Integer.parseInt(priority));
        if(!parentId.equals(""))
            forsearch.setParentId(Integer.parseInt(parentId));

        Resources same = iResourcesService.findByEntity(forsearch);

        if(same == null){
            Resources resources = new Resources();
            if(!name.equals(""))
                resources.setName(name);

            resources.setUrl(url);

            if(!type.equals(""))
                resources.setType(type);
            if(!priority.equals(""))
                resources.setPriority(Integer.parseInt(priority));
            if(!parentId.equals(""))
                resources.setParentId(Integer.parseInt(parentId));
            if(!available.equals(""))
                resources.setAvailable(Integer.parseInt(available));
            resources.setRemark(remark);

            resources.setPermissionId("0");
            iResourcesService.addResources(resources);
            return JSON.toJSONString(resources);
        }else{
            return "1";
        }
    }




    @RequestMapping("/modifyUser")
    @ResponseBody
    public String modifyUser(String id,String username,String password,String available,String remark) throws BaseException {

        System.out.println("in modifyUser");

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setAvailable(Integer.parseInt(available));
        user.setRemark(remark);
        PasswordHelper passwordHelper = new PasswordHelper();
        passwordHelper.encryptPassword(user);

        iUserService.updateById(user);

        return "1";
    }

    @RequestMapping("/modifyRole")
    @ResponseBody
    public String modifyRole(String id,String name,String description,String available,String remark) throws BaseException {

        System.out.println("in modifyRole");

        Role role = new Role();
        role.setId(id);
        role.setName(name);
        role.setDescription(description);
        role.setAvailable(Integer.parseInt(available));
        role.setRemark(remark);

        iRoleService.updateById(role);

        return "1";
    }

    @RequestMapping("/modifyPermission")
    @ResponseBody
    public String modifyPermission(String id,String permission,String description,String available,String remark) throws BaseException {

        System.out.println("in modifyPermission");

        Permissions permissions = new Permissions();
        permissions.setId(id);
        permissions.setPermission(permission);
        permissions.setDescription(description);
        permissions.setAvailable(Integer.parseInt(available));
        permissions.setRemark(remark);

        iPermissionsService.updateById(permissions);

        return "1";
    }

    @RequestMapping("/modifyResource")
    @ResponseBody
    public String modifyResource(String id,String name,String url,String type,String priority,String parentId,String available,String remark) throws BaseException {

        System.out.println("in modifyResource");

        Resources resources = new Resources();
        resources.setId(id);
        resources.setName(name);
        resources.setUrl(url);
        resources.setType(type);
        resources.setPriority(Integer.parseInt(priority));
        resources.setParentId(Integer.parseInt(parentId));
        resources.setAvailable(Integer.parseInt(available));
        resources.setRemark(remark);

        iResourcesService.updateById(resources);

        return "1";
    }


    @RequestMapping("/UserBindRole")
    @ResponseBody
    public String UserBindRole(String userId,String id) throws BaseException {

        System.out.println("in UserBindRole");

        if(userId == null || userId.equals("") || userId.equals("f6e17df4e82b4e35b31130b543ae97af") ||  id == null || id.equals(""))
            return "1";

        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(id);
        iUserRoleService.addUserRole(userRole);

        Role role = iRoleService.findById(id);

        return JSON.toJSONString(role);
    }

    @RequestMapping("/RoleBindPermission")
    @ResponseBody
    public String RoleBindPermission(String roleId,String id) throws BaseException {

        System.out.println("in RoleBindPermission");

        if(roleId == null || roleId.equals("") ||  id == null || id.equals(""))
            return "1";

        RolePermissions rolePermissions = new RolePermissions();
        rolePermissions.setRoleId(roleId);
        rolePermissions.setPermissionId(id);
        iRolePermissionsService.addRolePermissions(rolePermissions);

        Permissions permissions = iPermissionsService.findById(id);

        return JSON.toJSONString(permissions);
    }

    @RequestMapping("/PermissionBindResource")
    @ResponseBody
    public String PermissionBindResource(String permissionId,String id) throws BaseException {

        System.out.println("in PermissionBindResource");
        System.out.println("Permission: "+permissionId+" Resource: "+id);

        if(permissionId == null || permissionId.equals("") ||  id == null || id.equals(""))
            return "1";

        Resources resources = iResourcesService.findById(id);
        resources.setPermissionId(permissionId);
        iResourcesService.updateById(resources);

        return JSON.toJSONString(resources);
    }




    @RequestMapping("/UserUnBindRole")
    @ResponseBody
    public String UserUnBindRole(String userId,String id) throws BaseException {

        System.out.println("in UserUnBindRole");

            if(userId == null || userId.equals("") || userId.equals("f6e17df4e82b4e35b31130b543ae97af") ||  id == null || id.equals(""))
            return "1";


        UserRole userRole = new UserRole();
        userRole.setRoleId(id);
        userRole.setUserId(userId);
        iUserRoleService.deleteByEntity(userRole);

        return "1";
    }

    @RequestMapping("/RoleUnBindPermission")
    @ResponseBody
    public String RoleUnBindPermission(String roleId,String id) throws BaseException {

        System.out.println("in RoleUnBindPermission");

        RolePermissions rolePermissions = new RolePermissions();
        rolePermissions.setPermissionId(id);
        rolePermissions.setRoleId(roleId);
        iRolePermissionsService.deleteByEntity(rolePermissions);

        return "1";
    }

    @RequestMapping("/PermissionUnBindResource")
    @ResponseBody
    public String PermissionUnBindResource(String id) throws BaseException {

        System.out.println("in PermissionUnBindResource");

        Resources resources = iResourcesService.findById(id);
        resources.setPermissionId("0");
        iResourcesService.updateById(resources);

        return "1";
    }


    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(String id) throws BaseException {

        System.out.println("in deleteUser");
        iUserService.deleteByIds(id);
        UserRole userRole = new UserRole();
        userRole.setUserId(id);
        iUserRoleService.deleteByEntity(userRole);
        return "1";
    }

    @RequestMapping("/deleteRole")
    @ResponseBody
    public String deleteRole(String id) throws BaseException {

        System.out.println("in deleteRole");

        iRoleService.deleteByIds(id);
        UserRole userRole = new UserRole();
        userRole.setRoleId(id);
        iUserRoleService.deleteByEntity(userRole);
        RolePermissions rolePermissions = new RolePermissions();
        rolePermissions.setRoleId(id);
        iRolePermissionsService.deleteByEntity(rolePermissions);

        return "1";
    }

    @RequestMapping("/deletePermission")
    @ResponseBody
    public String deletePermission(String id) throws BaseException {

        System.out.println("in deletePermission");

        iPermissionsService.deleteByIds(id);
        RolePermissions rolePermissions = new RolePermissions();
        rolePermissions.setPermissionId(id);
        iRolePermissionsService.deleteByEntity(rolePermissions);

        Resources resourcesResult = new Resources();
        resourcesResult.setPermissionId(id);
        List<Resources> resourcesList = iResourcesService.listByEntity(resourcesResult);
        for(Resources resources:resourcesList){
            resources.setPermissionId("0");
            iResourcesService.updateById(resources);
        }


        return "1";
    }

    @RequestMapping("/deleteResource")
    @ResponseBody
    public String deleteResource(String id) throws BaseException {

        System.out.println("in deleteResource");

        iResourcesService.deleteByIds(id);

        return "1";
    }

    @RequestMapping("/searchResource")
    @ResponseBody
    public String searchResource(String resourceName) throws BaseException {

        System.out.println("in searchResource");

        List<Resources> resourcesList = iResourcesService.listByNameUsingLike(resourceName);

        return JSON.toJSONString(resourcesList);
    }


    @RequestMapping("/searchPermission")
    @ResponseBody
    public String searchPermission(String permissionName) throws BaseException {

        System.out.println("in searchPermission");

        List<Permissions> permissionsList = iPermissionsService.listByNameUsingLike(permissionName);

        return JSON.toJSONString(permissionsList);
    }

    @RequestMapping("/searchRole")
    @ResponseBody
    public String searchRole(String roleName) throws BaseException {

        System.out.println("in searchRole");

        List<Role> roleList = iRoleService.listByNameUsingLike(roleName);

        return JSON.toJSONString(roleList);
    }

    @RequestMapping("/searchUser")
    @ResponseBody
    public String searchUser(String userName) throws BaseException {

        System.out.println("in searchUser");

        List<User> userList = iUserService.listByNameUsingLike(userName);

        return JSON.toJSONString(userList);
    }

}
