package scau.zxck.web.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.Permissions;
import scau.zxck.entity.admin.Resources;
import scau.zxck.service.IAccountService;
import scau.zxck.service.admin.IResourcesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by suruijia on 2015/10/25.
 */
@Controller
public class LoginAction {

    @Autowired
    private IResourcesService iResourcesService;

    @Autowired
    private IAccountService iAccountService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
        public String toLogin() throws BaseException {
            return "admin/login";
    }

//    @RequestMapping(value = "LoginAction/login",method = RequestMethod.GET)
//    public String toLoginafterRegister() throws BaseException {
//        return "adminSys/adminSys";
//    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String checkLogin(HttpServletRequest request, Model model) throws BaseException {
        System.out.println("in checkLogin");

        String username = request.getParameter("username");
        String password = request.getParameter("password");


        System.out.println("in:"+username+" "+password);

        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            request.setAttribute("info","用户不存在");
            System.out.println("用户不存在");
            return "admin/login";
        }catch(IncorrectCredentialsException ex){
            request.setAttribute("info","密码错误");
            System.out.println("密码错误");
            return "admin/login";
        }
        HttpSession session = request.getSession();
        //session.setAttribute("username",username);   //把账号保存在session中
        System.out.println("continue");

        String cur_username = (String)SecurityUtils.getSubject().getPrincipal();
        System.out.println("in left cur_username:"+cur_username);
        //通过用户名获取权限对象list
        List<Permissions> permissionsList = iAccountService.listMenuPermissionsObjByUserName(cur_username);
        //排序
        Collections.sort(permissionsList, new MyComparator());
        System.out.println("in left get permissionList");
        List<Map> lists = new ArrayList<Map>();
        for(Permissions permissions:permissionsList){
            //获取对应的菜单资源
            System.out.println("in left get menu: "+permissions.getPermission());
            List<Resources> resourcesList = iAccountService.listMenuResourcesByPermissionId(permissions.getId());
            Map<String,Object> map= new HashMap<String,Object>();
            //菜单首项放入title
            map.put("title",resourcesList.get(0));
            //其余子菜单组成一个新的list放入list_item中
            List<Resources> item = new ArrayList<Resources>();
            for(int i=1;i<resourcesList.size();i++){
                item.add(resourcesList.get(i));
            }
            map.put("list_item",item);
            lists.add(map);
        }
        model.addAttribute("result", lists);

        return "admin/main";
    }


    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        System.out.println("in logout");

        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());

        return "1";
    }


    class MyComparator implements Comparator
    {
        //这里的o1和o2就是list里任意的两个对象
        public int compare(Object o1, Object o2)
        {
            //比较规则
            return ((Permissions) o1).getPermission().compareTo(((Permissions)o2).getPermission());
        }
    }

}
