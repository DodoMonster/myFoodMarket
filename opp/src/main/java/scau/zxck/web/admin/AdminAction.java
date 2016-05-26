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

import java.util.*;

/**
 * Created by suruijia on 2015/11/22.
 */
@Controller
@RequestMapping("/admin")
public class AdminAction {

    @Autowired
    private IAccountService iAccountService;

    @RequestMapping(value = "/adminSys", method = RequestMethod.GET)
    public String main(Model model) throws BaseException {
        System.out.println("in adminSys");

        String cur_username = (String) SecurityUtils.getSubject().getPrincipal();
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

        return "adminSys/adminSys";
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
