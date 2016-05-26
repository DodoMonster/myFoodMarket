package scau.zxck.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.ResourcesDao;
import scau.zxck.entity.admin.*;
import scau.zxck.service.admin.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by suruijia on 2015/11/25.
 */
@Controller
public class MembersAction {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private IUserRoleService iUserRoleService;

    @Autowired
    private IPermissionsService iPermissionsService;

    @Autowired
    private IResourcesService iResourcesService;


    @RequestMapping(value = "/manager-user", method = RequestMethod.GET)
    public String managerUser(HttpServletRequest request, Model model) throws BaseException {

        System.out.println("in member-user");

        String index = request.getParameter("index");
        int pageNumbers = 7;

        if (null == index || "".equals(index)) {
            index = "1";
        }

        Page<User> page = iUserService.findPage(null, (Integer.parseInt(index) - 1) * 10, 10);

        List<User> userList = page.getResults();

        int i = Integer.parseInt(index);
        model.addAttribute("pageCount", page.getPageCount());
        model.addAttribute("result", userList);
        model.addAttribute("index", index);

        if(page.getPageCount() < pageNumbers){
            model.addAttribute("begin", 1);
            model.addAttribute("end", page.getPageCount());
            return "admin/operation/manager-user";
        }

        if (i <= pageNumbers / 2) {
            model.addAttribute("begin", 1);
            model.addAttribute("end", pageNumbers);
        }else if(i > page.getPageCount() - pageNumbers / 2) {
            model.addAttribute("begin", page.getPageCount() - pageNumbers + 1);
            model.addAttribute("end", page.getPageCount());
        }else {
            model.addAttribute("begin", i - pageNumbers / 2);
            model.addAttribute("end", i + pageNumbers / 2);
        }

            return "admin/operation/manager-user";
    }

    @RequestMapping(value = "/manager-role", method = RequestMethod.GET)
    public String managerRole(HttpServletRequest request, Model model) throws BaseException {

        System.out.println("in manager-role");

        String index = request.getParameter("index");
        int pageNumbers = 7;

        if (null == index || "".equals(index)) {
            index = "1";
        }

        Page<Role> page = iRoleService.findPage(null, (Integer.parseInt(index) - 1) * 10, 10);

        List<Role> userList = page.getResults();

        int i = Integer.parseInt(index);
        model.addAttribute("pageCount", page.getPageCount());
        model.addAttribute("result", userList);
        model.addAttribute("index", index);

        if(page.getPageCount() < pageNumbers){
            model.addAttribute("begin", 1);
            model.addAttribute("end", page.getPageCount());
            return "admin/operation/manager-role";
        }

        if (i <= pageNumbers / 2) {
            model.addAttribute("begin", 1);
            model.addAttribute("end", pageNumbers);
        }else if(i > page.getPageCount() - pageNumbers / 2) {
            model.addAttribute("begin", page.getPageCount() - pageNumbers + 1);
            model.addAttribute("end", page.getPageCount());
        }else {
            model.addAttribute("begin", i - pageNumbers / 2);
            model.addAttribute("end", i + pageNumbers / 2);
        }

            return "admin/operation/manager-role";
    }

    @RequestMapping(value = "/manager-permission", method = RequestMethod.GET)
    public String managerPermission(HttpServletRequest request, Model model) throws BaseException {

        System.out.println("in manager-permission");

        String index = request.getParameter("index");
        int pageNumbers = 7;

        if (null == index || "".equals(index)) {
            index = "1";
        }

        Page<Permissions> page = iPermissionsService.findPage(null, (Integer.parseInt(index) - 1) * 10, 10);

        List<Permissions> permissionsList = page.getResults();

        int i = Integer.parseInt(index);
        model.addAttribute("pageCount", page.getPageCount());
        model.addAttribute("result", permissionsList);
        model.addAttribute("index", index);

        if(page.getPageCount() < pageNumbers){
            model.addAttribute("begin", 1);
            model.addAttribute("end", page.getPageCount());
            return "admin/operation/manager-permission";
        }

        if (i <= pageNumbers / 2) {
            model.addAttribute("begin", 1);
            model.addAttribute("end", pageNumbers);
        }else if(i > page.getPageCount() - pageNumbers / 2) {
            model.addAttribute("begin", page.getPageCount() - pageNumbers + 1);
            model.addAttribute("end", page.getPageCount());
        }else {
            model.addAttribute("begin", i - pageNumbers / 2);
            model.addAttribute("end", i + pageNumbers / 2);
        }

            return "admin/operation/manager-permission";
    }

    @RequestMapping(value = "/manager-resource", method = RequestMethod.GET)
    public String managerResource(HttpServletRequest request, Model model) throws BaseException {

        System.out.println("in manager-resource");

        String index = request.getParameter("index");
        int pageNumbers = 7;

        if (null == index || "".equals(index)) {
            index = "1";
        }


        Page<Resources> page = iResourcesService.findPage(null, (Integer.parseInt(index) - 1) * 10, 10);

        List<Resources> userList = page.getResults();

        int i = Integer.parseInt(index);
        model.addAttribute("pageCount", page.getPageCount());
        model.addAttribute("result", userList);
        model.addAttribute("index", index);

        if(page.getPageCount() < pageNumbers){
            model.addAttribute("begin", 1);
            model.addAttribute("end", page.getPageCount());
            return "admin/operation/manager-resource";
        }

        if (i <= pageNumbers / 2) {
            model.addAttribute("begin", 1);
            model.addAttribute("end", pageNumbers);
        }else if(i > page.getPageCount() - pageNumbers / 2) {
            model.addAttribute("begin", page.getPageCount() - pageNumbers + 1);
            model.addAttribute("end", page.getPageCount());
        }else{
            model.addAttribute("begin", i - pageNumbers / 2);
            model.addAttribute("end", i + pageNumbers / 2);
        }

        return "admin/operation/manager-resource";
    }


}
