package scau.zxck.web.admin;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.MainNav;
import scau.zxck.entity.admin.SubNav;
import scau.zxck.service.admin.IMainNavService;
import scau.zxck.service.admin.ISubNavService;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 追追 on 2016/3/19.
 */

@Controller

@RequestMapping("/admin/NavAction")
public class NavAction {

    @Autowired
    private IMainNavService mainNavService;

    @Autowired
    private ISubNavService subNavService;

    /**
     * 增加主栏目和相应子栏目
     * @param mainNavName
     * @param belongTo
     * @param subNavName
     * @return
     * @throws BaseException
     */

    @RequestMapping(value = "/addMainNav", method = RequestMethod.GET)
    @ResponseBody
    public String addMainNav(String mainNavName,String belongTo,String[] subNavName) throws BaseException {
        boolean falg=false;
        MainNav mainNav=new MainNav();
        List<MainNav> mainNavList=mainNavService.listAllMainNav();
        Iterator<MainNav> iterator=mainNavList.iterator();
        while(iterator.hasNext()){
            MainNav tmp=iterator.next();
            if(mainNavName.equals(tmp.getName())){
                falg=true;
                mainNav=tmp;
                break;
            }
        }
        if(!falg){
            int sequence=mainNavList.size();
            mainNav.setSequence(sequence);
            mainNav.setName(mainNavName);
            mainNav.setBelongTo(belongTo);
            mainNavService.addMainNav(mainNav);
        }
        if(!(subNavName==null||subNavName.length==0)){
            for(int i=0;i<subNavName.length;i++){
                SubNav subNav=new SubNav();
                String tmpSubName=subNavName[i].substring(1, subNavName[i].length()- 1);
                while(tmpSubName.indexOf("\"")>-1){
                    tmpSubName=tmpSubName.replace("\"","");
                }
                subNav.setName(tmpSubName);
                subNav.setMainNavId(mainNav.getId());
                subNavService.addSubNav(subNav);
            }
        }
        return "1";
    }

    /**
     * 新增子栏目  完成
     * @param name  新增子栏目的名称
     * @param mainNavId  对应主栏目的ID
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/addSubNav",method=RequestMethod.GET)
    @ResponseBody
    public String addSubNav(String name,String mainNavId) throws BaseException {
        SubNav subNav=new SubNav();
        subNav.setName(name);
        subNav.setMainNavId(mainNavId);
        subNavService.addSubNav(subNav);
        return JSON.toJSONString(subNav.getId());
    }

    /**
     * 通过ID删除主栏目 完成
     * @param id
     * @return
     * @throws BaseException
     */
    @ResponseBody
    @RequestMapping(value = "/deleteMainNav", method=RequestMethod.GET)
    public String deleteMainNav(String id) throws BaseException {
        MainNav mainNav=mainNavService.findById(id);  //删除主栏目
        mainNavService.deleteByIds(id);

        SubNav subNav=new SubNav();                 //删除对应子栏目
        List<SubNav> subNavs=subNavService.listAllSubOfMainNav(id);

        Iterator<SubNav> iterator=subNavs.iterator();
        while(iterator.hasNext()){
            subNavService.deleteByIds(iterator.next().getId());
        }
        return "1";
    }

    /**
     * 通过ID删除子栏目，完成
     * @param id
     * @return 字符串“1”
     * @throws BaseException
     */
    @ResponseBody
    @RequestMapping(value = "/deleteSubNav" ,method = RequestMethod.GET)
    public String deleteSubNav (String id) throws BaseException {
        subNavService.deleteByIds(id);
        return "1";
    }

    /**
     * 修改主栏目及子栏目，完成
     * @param id 主栏目ID
     * @param name 修改后的新名称
     * @param subId 对应子栏目的ID数组
     * @param subName 对应修改后的子栏目的新名称
     * @return
     * @throws BaseException
     */
    @ResponseBody
    @RequestMapping(value ="/modifyMainNav",method = RequestMethod.GET)
    public String modifyMainNav(String id,String name,String[] subId,String[] subName) throws BaseException {
        System.out.println(id);
        MainNav mainNav=new MainNav();
        mainNav.setId(id);
        mainNav.setName(name);
        mainNavService.updateById(mainNav);
        if(!(subId==null||subId.length==0)){
           for(int i=0;i<subId.length;i++){
               SubNav subNav=new SubNav();
               String tmpSubId=subId[i].substring(1,subId[i].length()-1);
               String tmpSubName=subName[i].substring(1, subName[i].length()- 1);
              while(tmpSubId.indexOf("\"")>-1||tmpSubName.indexOf("\"")>-1){
                  tmpSubId=tmpSubId.replace("\"","");
                  tmpSubName=tmpSubName.replace("\"","");
               }
               subNav.setId(tmpSubId);
               subNav.setName(tmpSubName);
               subNav.setSequence(i);
               subNavService.updateById(subNav);
           }
        }
        return "1";
    }


    /**
     * 修改主栏目排列顺序  完成
     * @param mainNavId  一个数组，数组中的内容为主栏目的ID，对应下标为顺序
     * @return
     * @throws BaseException
     */
     @ResponseBody
     @RequestMapping(value="/modifyMainSequence",method = RequestMethod.GET)
     public String modifyMainSquence(String[] mainNavId) throws BaseException {
         for(int i=0;i<mainNavId.length-1;i++){
             String tmpMainId=mainNavId[i].substring(1,mainNavId[i].length()-1);
             while(tmpMainId.indexOf("\"")>-1){
                 tmpMainId=tmpMainId.replace("\"", "");
             }
             MainNav mainNav=mainNavService.findById(tmpMainId);
             mainNav.setSequence(i);
             mainNavService.updateById(mainNav);
         }
         return "1";
     }


    /**
     * 初始化界面
     * @param model
     * @param request
     * @return
     * @throws BaseException
     */
   @RequestMapping(value = "/classify ",method = RequestMethod.GET)
    public String showNav(Model model,HttpServletRequest request) throws BaseException {
       String classify=request.getParameter("classify");
       List<MainNav> mainNavs=mainNavService.listMainNavByBelongTo(classify);
       Iterator<MainNav> mainIterator=mainNavs.iterator();
       while(mainIterator.hasNext()){
           MainNav mainNav=mainIterator.next();
           String mainNavId = mainNav.getId();
           List<SubNav> subNav = subNavService.listAndSort(mainNavId);
           mainNav.setSubNavList(subNav);
       }
       model.addAttribute("mainNavs",mainNavs);
       return "admin/views/classify";
   }

    @RequestMapping(value = "/asider",method = RequestMethod.GET)
    public String returnToAsider(){
        return "admin/block/asider";
    }

    @RequestMapping(value = "/header",method = RequestMethod.GET)
    public String returnToHeader(){
        return "admin/block/header";
    }

    @RequestMapping(value="/addClassify",method=RequestMethod.GET)
    public String returnTOAddClassify(){
        return "admin/views/addClassify";
    }

    @RequestMapping(value = "/index" ,method = RequestMethod.GET)
    public String returnToIndex(){
        return "admin/index";
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String returnToHome(){
        return "admin/views/home";
    }

}
