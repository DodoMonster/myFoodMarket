package scau.zxck.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.Permissions;
import scau.zxck.service.IAccountService;
import scau.zxck.service.admin.IResourcesService;

import java.util.Comparator;

/**
 * Created by lishunpeng on 2015/10/27.
 */
@Controller
public class ForwardAction {

    @Autowired
    private IResourcesService iResourcesService;

    @Autowired
    private IAccountService iAccountService;

    @RequestMapping(value = "/manage",method = RequestMethod.GET)
    public String toManage(){
        return "admin/adminSys";
    }

    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public String top() throws BaseException {
        return "admin/top";
    }

    @RequestMapping(value = "/left", method = RequestMethod.GET)
    public String left() throws BaseException{
        System.out.println("in left");
        return "admin/left";
    }

    @RequestMapping(value = "/footer", method = RequestMethod.GET)
    public String footer() throws BaseException{
        return "admin/footer";
    }

}
