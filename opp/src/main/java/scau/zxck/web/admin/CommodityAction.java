package scau.zxck.web.admin;


import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.*;
import scau.zxck.service.admin.*;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by 追追 on 2016/4/8.
 */

@Controller
@RequestMapping("/admin/CommodityAction")
public class CommodityAction {

    @Autowired
    private IMainNavService mainNavService;
    @Autowired
    private ISubNavService subNavService;
    @Autowired
    private ICommodityService commodityService;
    @Autowired
    private ICommodityCommentService commodityCommentService;
    @Autowired
    private ICommodityPicService commodityPicService;
    @Autowired
    private IUserService userService;


    /**
     * 商品管理的进入页面,通过获取商品分类和商店ID信息，展示对应的商品
     * @param model 用于存放最后的查询结果
     * @param request 请求参数，包含商品的大分类信息和商店ID（非必须）
     * @return 返回商品页面
     * @throws BaseException
     * 完成-------------------------------------------------------------------------------------------
     */
    @RequestMapping(value="/showCommodity",method = RequestMethod.GET)
    public String showCommodity(Model model,HttpServletRequest request) throws BaseException {
//        String shopId=request.getParameter("shopId");
//        String subNavid=request.getParameter("subNavId");
        String index=request.getParameter("index");
//        System.out.println("========="+shopId+"========="+subNavid+"========="+index+"=========");
        Page<Commodity> page;

        if(index==null||"".equals(index)){
            index="1";
        }
//        if(subNavid!=null&&shopId!=null){
//             page=commodityService.findPage(shopId,subNavid,(Integer.parseInt(index)-1)*10,10);
//        }else if(subNavid==null&&shopId!=null){
//             page=commodityService.findPageByShopId(shopId,(Integer.parseInt(index)-1)*10,10);
//        }else if(subNavid!=null&&shopId==null){
//             page=commodityService.findPageBySubNavId(subNavid, (Integer.parseInt(index) - 1) * 10, 10);
////             System.out.println("====================="+page.getTotal()+"======================"+page.getPageCount());
//        }else{
             page=commodityService.findPage((Integer.parseInt(index)-1)*10,10);
//        }
        List<Commodity> commodities=page.getResults();
        ArrayList<String> labels=new ArrayList<String>();
        for(Commodity x:commodities){//获取第一个标签
            labels.add(x.getLabel().split("-")[0]);
        }

        List<MainNav> mainNavs=mainNavService.listMainNavByBelongTo("水果");
        Iterator<MainNav> mainIterator=mainNavs.iterator();
        while(mainIterator.hasNext()){
            MainNav mainNav=mainIterator.next();
            String mainNavId = mainNav.getId();
            List<SubNav> subNav = subNavService.listAndSort(mainNavId);
            mainNav.setSubNavList(subNav);
        }
//        System.out.println("=====================" + page.getTotal() + "======================" + page.getPageCount());
        model.addAttribute("mainNavs",mainNavs);
        model.addAttribute("totelNumber",page.getTotal());
        model.addAttribute("commoditis",commodities);
        model.addAttribute("totlePage",page.getPageCount());
        model.addAttribute("index",index);
        model.addAttribute("label",labels);

//        System.out.println("=====================" +  model.toString() + "======================");
        return "admin/views/goodsAdmin";

    }



    /**
     * 商品管理的分类按钮页面，实现从数据库读取分类信息
     * @param navType
     * @return
     * @throws BaseException
     * 完成----------------------------------------------------------------------------------------------
     */
    @ResponseBody
    @RequestMapping(value="/showClassify", method=RequestMethod.GET)
    public String showClassify(String navType) throws BaseException {

//        System.out.println("=============================" + navType + "=============================");
        List<MainNav> mainNavs=mainNavService.listMainNavByBelongTo(navType);
        Iterator<MainNav> mainIterator=mainNavs.iterator();
        while(mainIterator.hasNext()){
            MainNav mainNav=mainIterator.next();
            String mainNavId = mainNav.getId();
            List<SubNav> subNav = subNavService.listAndSort(mainNavId);
            mainNav.setSubNavList(subNav);
        }
//        System.out.println("=============================" + mainNavs + "=============================");
//        System.out.println("=============================" + JSON.toJSONString(mainNavs) + "=============================");
        return JSON.toJSONString(mainNavs);

    }


    /**
     * 搜索(包括选择搜索，选择搜索)
     * @param request
     * @return
     * @throws BaseException
     * 待交互+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     */
    @ResponseBody
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public String find( HttpServletRequest request) throws BaseException {
        String name = request.getParameter("name");//搜索关键字
        String subNavId=request.getParameter("subNavId");
        String shopId=request.getParameter("shopId");
//        String imagePath=request.getParameter("imagePath");
        Page<Commodity> commodities;
        System.out.println("========="+shopId+"========="+subNavId+"========="+name+"========");
        if(shopId!=null&&!("".equals(shopId))){
            commodities=commodityService.findPageByShopId(shopId,0,10);
        }

        if(name!=null&&!("".equals(name))){
            SubNav subNav = subNavService.findByName(name);
            if (subNav == null || "".equals(subNav)) {
                return "1";//返回1代表找不到
            }
            subNavId=subNav.getId();
        }
        commodities = commodityService.findPageBySubNavId(subNavId, 0, 10);

        if(subNavId!=null&&shopId!=null){
            commodities=commodityService.findPage(shopId,subNavId,0,10);
        }

        System.out.println("=============================" + JSON.toJSONString(commodities) + "=============================");
        return JSON.toJSONString(commodities);

    }




    /**
     * 通过ID删除商品
     * @param commodityId  商品ID
     * @return
     * @throws BaseException
     * 完成----------------------------------------------------------------------------------------
     */
    @ResponseBody
    @RequestMapping(value="/deleteCommodity",method = RequestMethod.GET)
    public String deleteCommodity(String commodityId) throws BaseException {
        System.out.println("============" + commodityId + "=====================");
        commodityService.deleteByIds(commodityId);
//        return "redirect:/admin/CommodityAction/showCommodity";
        return "1";
    }

    /**
     * 隐藏商品
     * @param commodityId
     * @return
     * 完成-------------------------------------------------------------------------------------------
     */
    @ResponseBody
    @RequestMapping(value="/displayCommodity",method = RequestMethod.GET)
    public String displayCommodity( String commodityId) throws BaseException {
        System.out.println("===============" + commodityId + "====================");
        Commodity commodity=commodityService.findById(commodityId);
        int flag=commodity.getFlag();
        if(flag==0){
            flag=1;
        }else {
            flag=0;
        }
        commodity.setFlag(flag);
        commodityService.updateById(commodity);
        return "1";
    }

    /**
     * 分页
     * @param index    当前页码
     * @param shopId   商店id
     * @param search   搜索的关键字
     * @param subNavId 子分类id
     * @return
     * @throws BaseException
     * 待交互++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     */
    @ResponseBody
    @RequestMapping(value = "/pageControl",method = RequestMethod.GET)
    public  String page(String index,String shopId,
                        String search,String subNavId) throws BaseException {
        Page<Commodity> page;
        int pageIndex;
        if(index==null||"".equals(index)){
            pageIndex=0;
        }else{
            pageIndex=Integer.parseInt(index)-1;
            pageIndex=pageIndex*10;
        }
        System.out.println("======="+pageIndex+"======="+shopId+"======="+search+"======="+subNavId+"======");
        /**
         * 判断查找的条件，根据条件进行查找
         */
        search="苹果";
        if(shopId!=null&&subNavId!=null&&search==null&&"".equals(shopId)&&"".equals(subNavId)&&"".equals(search)){
            page=commodityService.findPage(shopId, subNavId, pageIndex, 10);
        }else if((shopId==null||"".equals(shopId))&&(search==null||"".equals(search))){
            page=commodityService.findPageBySubNavId(subNavId,pageIndex, 10);
        }else if((shopId==null||"".equals(shopId))&&(subNavId==null||"".equals(subNavId))){
            page=commodityService.findPageByShopId(shopId,pageIndex,10);
        }else {
            SubNav subNav=subNavService.findByName(search);
            page=commodityService.findPageBySubNavId(subNav.getId(),pageIndex, 10);
        }

//        List<Commodity> commodities=page.getResults();
//        ArrayList<String> labels=new ArrayList<String>();
//        for(Commodity x:commodities){//获取第一个标签
//            labels.add(x.getLabel().split("-")[0]);
//        }

//        model.addAttribute("totelNumber",page.getTotal());
//        model.addAttribute("commoditis",commodities);
//        model.addAttribute("totlePage",page.getPageCount());
//        model.addAttribute("index",index);
//        model.addAttribute("label",labels);
        System.out.println(JSON.toJSONString(page));
        return JSON.toJSONString(page);
    }


//***********************************************************************************************************

    /**
     * 商品评论页面
     * @return
     */
    @RequestMapping(value="/IntoCommodityComments",method = RequestMethod.GET)
    public String intoCommodiyyComments(String commodityId,Model model) throws BaseException {

        CommodityComment commodityComment;
        List<CommodityComment> commodityComments=commodityCommentService.listByCommodityId("1253");
        ArrayList<String> username=new ArrayList<>();
        String label=commodityService.findById("1253").getLabel();
        String[] labels=label.split("-");

        float sum=commodityService.findById("1253").getComment();//总评论数
        float highPraise=0;                                    //好评数
        Iterator<CommodityComment> iterator=commodityComments.iterator();
        while(iterator.hasNext()){
            commodityComment=iterator.next();
           // String name=userService.findById(commodityComment.getUserId()).getUsername();
            if((userService.findById(commodityComment.getUserId()).getUsername())!=null){
                username.add(userService.findById(commodityComment.getUserId()).getUsername());
            }
            int score=commodityComment.getScore();

            if(score>=4)
                highPraise++;
        }
        float percent=highPraise/sum*100;
        DecimalFormat df2 = new DecimalFormat("###.0");//结果保留1位小数
        String result=df2.format(percent)+"%";

        model.addAttribute("commodityId",commodityId);
        model.addAttribute("percent",result);
        model.addAttribute("commodityComments",commodityComments);
        model.addAttribute("username",username);
        model.addAttribute("labels",labels);

        return "admin/views/commentsAdmin";
    }


    /**
     * 商品评论管理页面，根据不同的条件（好评、中评、差评）返回不同的商品评论列表
     * @param commodityId 商品ID
     * @param score       好评度（1星为差评，2、3星为中评，4、5星好评）
     * @param model       用于参数返回
     * @return            返回页面地址
     * @throws BaseException
     */
    @RequestMapping(value="/commodityComment",method=RequestMethod.GET)
    public String commodityComment(String commodityId,int score,Model model) throws BaseException {

//        System.out.println("========" + commodityId + "========="+score+"==============");

        List<CommodityComment> commodityComments=commodityCommentService.listByCommodityId(commodityId);
        float sum=commodityService.findById(commodityId).getComment();//总评论数
        float highPraise=0;                                    //好评数
        Iterator<CommodityComment> iterator=commodityComments.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getScore()>=4)
                highPraise++;
        }
        float percent=highPraise/sum*100;
        DecimalFormat df2 = new DecimalFormat("###.0");//结果保留1位小数
        String result=df2.format(percent)+"%";

        iterator=commodityComments.iterator();
        CommodityComment commentIterator;
        if(score>0&&score<=5){
            switch(score){
                case 5:
                case 4:while(iterator.hasNext()){
                    commentIterator=iterator.next();
                    if(!(commentIterator.getScore()==4||commentIterator.getScore()==5)){
                        commodityComments.remove(commentIterator);
                    }
                };break;

                case 3:
                case 2:while(iterator.hasNext()){
                    commentIterator=iterator.next();
                    if(!(commentIterator.getScore()==2||commentIterator.getScore()==3)){
                        commodityComments.remove(commentIterator);
                    }
                };break;

                case 1:while(iterator.hasNext()){
                    commentIterator=iterator.next();
                    if(!(commentIterator.getScore()==1)){
                        commodityComments.remove(commentIterator);
                    }
                };break;

            }
        }
        model.addAttribute("percent",result);
        model.addAttribute("commodityComments",commodityComments);
        return "URL";
    }



    /**
     * 通过商品评论ID删除评论
     * @param CommentId 商品评论ID
     * @return
     * @throws BaseException
     */
    @ResponseBody
    @RequestMapping(value = "/deleteComment",method = RequestMethod.GET)
    public String deleteComment(String CommentId) throws BaseException {
        commodityCommentService.deleteByIds(CommentId);
        return "1";
    }


    /**
     * 计算好评度
     * @param commodityId 商品ID
     * @param model       用于返回参数
     * @return
     * @throws BaseException
     */
    @ResponseBody
    @RequestMapping(value="/scorePercent",method = RequestMethod.GET)
    public String scorePercent(String commodityId,Model model) throws BaseException {
//        System.out.println("===============" + commodityId + "====================");
        List<CommodityComment> commodityComments=commodityCommentService.listByCommodityId(commodityId);
        float sum=commodityService.findById(commodityId).getComment();//总评论数
        float highPraise=0;                                    //好评数
        Iterator<CommodityComment> iterator=commodityComments.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getScore()>=4)
                highPraise++;
        }
        float percent=highPraise/sum*100;

        DecimalFormat df2 = new DecimalFormat("###.0");//结果保留1位小数
        String result=df2.format(percent)+"%";

        model.addAttribute("percent",result);
        return "1";
    }




//*****************************************************************************************************************
    /**
     * 商品编辑页面
     * @param
     * @return
     */

    @RequestMapping(value="/commodityModify",method = RequestMethod.GET)
    public String commodityModify(String commodityId,Model model) throws BaseException {
        System.out.println("===============" + commodityId + "====================");
        Commodity commodity=commodityService.findById(commodityId);
        String label=commodity.getLabel();
        String[] labels=label.split("-");
        List<CommodityPic> commodityPics=commodityPicService.listByCommodityId(commodityId);
//        System.out.println("===============" + labels.length + "====================");
//        System.out.println("===============" + labels[0] + "=========="+labels[1]+"==========");
        model.addAttribute("commodityPics",commodityPics);
        model.addAttribute("commodity",commodity);
        model.addAttribute("labels",labels);

        return "admin/views/editGoods";
    }

    /**
     * 商品保存
     * @param request
     * @param file
     * @return
     * @throws BaseException
     */
    @RequestMapping(value="/saveCommodity")
    public String saveCommodty(HttpServletRequest request,
                               @RequestParam(value = "file", required = false) MultipartFile file) throws BaseException {
        Commodity commodity=new Commodity();
        commodity.setId(request.getParameter("id"));
        System.out.println("==============================="+request.getParameter("id")+"=========================");
        commodity.setName(request.getParameter("goodsName"));
        commodity.setNumber(request.getParameter("goodsID"));
        commodity.setNewPirce(Double.parseDouble(request.getParameter("goodsPrice")));
        commodity.setDiscount(request.getParameter("goodsDiscount"));
        commodity.setStock(Integer.parseInt(request.getParameter("goodsStock")));
        commodity.setDescrip(request.getParameter("goodsDis"));
//        commodity.setLabel(request.getParameter("label"));
        commodity.setMinAmount(Integer.parseInt(request.getParameter("minAmount")));

        List<String> fileNames=new ArrayList<String>();
//        if(null!=file&&file.length>0){
//            for(int i=0;i<file.length;i++){
                String filename=file.getOriginalFilename();//获得初始文件名
                fileNames.add(filename);
                File imageFile=new File(request.getServletContext().getRealPath("static/admin/images"),filename);
                try{
                    file.transferTo(imageFile);
                }catch (IOException e){
                    e.printStackTrace();
                }
                CommodityPic commodityPic=new CommodityPic();
                commodityPic.setCommodityId("123");
                commodityPic.setPic(filename);
                commodityPicService.addCommodityPic(commodityPic);
//                if(i==0){
//                    commodity.setPic(request.getServletContext().getRealPath("/static/admin/images")+filename);
//                }
//        }
        commodityService.updateById(commodity);
//        }
        return "url";
    }

    //处理上传图片
//    @ResponseBody
//    @RequestMapping(value = "/uploadPhoto",method = RequestMethod.POST)
//    public String uploadPhoto(String commodityId,
//                              @RequestParam(value = "pic", required = false) MultipartFile file1,
//                              HttpServletRequest request,Model model) throws BaseException, IOException {
//        if(!file1.isEmpty()){
//            ServletContext sc = request.getSession().getServletContext();
//            String dir = sc.getRealPath("/static/photo");
//            String filename = file1.getOriginalFilename();
//
//            long _lTime = System.currentTimeMillis();
//            String _ext = filename.substring(filename.lastIndexOf("."));
//            filename = _lTime + _ext;
//
//            CommodityPic commodityPic=new CommodityPic();
//            FileUtils.writeByteArrayToFile(new File(dir, filename), file1.getBytes());
//            commodityPic.setPic(dir+"/"+filename);//图片URL
//            commodityPic.setCommodityId(commodityId);
//            commodityPicService.addCommodityPic(commodityPic);
//            model.addAttribute("filename", filename);
//        }
//        return "1";
//    }

//    @ResponseBody
//    @RequestMapping(value = "/test")
//    public String upload(@RequestParam(value = "file", required = false) MultipartFile file,
//                         HttpServletRequest request, ModelMap model) {
//        System.out.println("开始");
//        String path = request.getSession().getServletContext().getRealPath("static/admin/images");
//        String fileName = file.getOriginalFilename();
////        String fileName = new Date().getTime()+".jpg";
//        System.out.println(path);
//        File targetFile = new File(path, fileName);
//        if(!targetFile.exists()){
//            targetFile.mkdirs();
//        }
//
//        //保存
//        try {
//            file.transferTo(targetFile);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);
//        System.out.println(request.getContextPath()+"/upload/"+fileName);
//        return "1";
//    }


}
