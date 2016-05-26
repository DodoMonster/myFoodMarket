package scau.zxck.web.admin;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.Permissions;
import scau.zxck.entity.admin.Resources;
import scau.zxck.service.IAccountService;
import scau.zxck.service.admin.IResourcesService;

import java.util.*;

/**
 * Created by lishunpeng on 2015/10/27.
 */
@Controller
@RequestMapping("/admin/MainAction")
public class MainAction {

    @Autowired
    private IResourcesService iResourcesService;

    @Autowired
    private IAccountService iAccountService;

    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public String top() throws BaseException {
        return "admin/top";
    }

    @RequestMapping(value = "/left", method = RequestMethod.GET)
    public String left(Model model) throws BaseException{
        System.out.println("in left");
//        //获取当前用户名
//        String username = (String)SecurityUtils.getSubject().getPrincipal();
//        System.out.println("in left username:"+username);
//        //通过用户名获取权限对象list
//        List<Permissions> permissionsList = iAccountService.listMenuPermissionsObjByUserName(username);
//        //排序
//        Collections.sort(permissionsList, new MyComparator());
//        System.out.println("in left get permissionList");
//        List<Map> lists = new ArrayList<Map>();
//        for(Permissions permissions:permissionsList){
//            //获取对应的菜单资源
//            System.out.println("in left get menu: "+permissions.getPermission());
//            List<Resources> resourcesList = iAccountService.listMenuResourcesByPermissionId(permissions.getId());
//            Map<String,Object> map= new HashMap<String,Object>();
//            //菜单首项放入title
//            map.put("title",resourcesList.get(0));
//            //其余子菜单组成一个新的list放入list_item中
//            List<Resources> item = new ArrayList<Resources>();
//            for(int i=1;i<resourcesList.size();i++){
//                item.add(resourcesList.get(i));
//            }
//            map.put("list_item",item);
//            lists.add(map);
//        }
//        model.addAttribute("result",lists);
        return "admin/left";
    }

    @RequestMapping(value = "/footer", method = RequestMethod.GET)
    public String footer() throws BaseException{
        return "admin/footer";
    }

    @RequestMapping(value = "/index-person", method = RequestMethod.GET)
    public String index() throws BaseException{
        return "admin/operation/index-person";
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
