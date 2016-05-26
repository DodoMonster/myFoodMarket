package scau.zxck.test;


import com.alibaba.fastjson.JSON;
import com.sun.tools.javac.util.*;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.Commodity;
import scau.zxck.entity.admin.MainNav;
import scau.zxck.entity.admin.SubNav;
import scau.zxck.service.admin.ICommodityService;
import scau.zxck.service.admin.IMainNavService;
import scau.zxck.service.admin.ISubNavService;
import sun.applet.Main;


import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;
import java.util.concurrent.locks.Condition;

/**
 * Created by 追追 on 2016/3/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class CommodityServiceTest {

    private static Logger logger = Logger.getLogger(CommodityServiceTest.class);

    @Before
    public void before() {
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Autowired
    private IMainNavService mainNavService;
    @Autowired
    private ISubNavService subNavService;
    @Autowired
    private ICommodityService commodityService;




    @Test
    public void commodityServiceTest() throws BaseException {
//        通过大分类和商店名称查找商店售货的分类信息
//        String classify="水果";
//        String shopId="321";
//
//        List<SubNav> subNavlist=new ArrayList<SubNav>();//用于保存最终的查询结果
//        Set<String> subNavId=new HashSet<String>();//用于保存店铺售卖的商品的所有子分类ID
//        String id;//用于迭代对象
//        SubNav subNav;//用于迭代对象
//
//        //通过大分类和商品id找到对应主分类和商店售卖的商品
//        List<MainNav> mainNavs=mainNavService.listMainNavByBelongTo(classify);
//        List<Commodity> commodities=commodityService.listByShopId(shopId);
//
//        //通过商品查找商品对应的子分类，保存在subNavId中
//        Iterator<Commodity> commodityIterator=commodities.iterator();
//        while(commodityIterator.hasNext()){
//            id = commodityIterator.next().getSubNavId();
//            subNavId.add(id);
//        }
//
//        //通过主分类id找到子分类，比较子分类的id和上面找到的id，把相同的保存到subNavlist中
//        Iterator<MainNav> mainIterator=mainNavs.iterator();
//        while(mainIterator.hasNext()){
//            MainNav mainNav=mainIterator.next();
//            logger.info("==================="+ mainNav.getName()+"========================");
//            String mainNavId = mainNav.getId();
//            List<SubNav> subNavs = subNavService.listAndSort(mainNavId);
//            Iterator<SubNav> subIterator=subNavs.iterator();
//            while(subIterator.hasNext()){
//                subNav=subIterator.next();
//                if(subNavId.contains(subNav.getId())){
//                    logger.info("==================="+ subNav.getName()+"========================");
//                    subNavlist.add(subNav);
//                }
//            }
//            mainNav.setSubNavList(subNavlist);
//        }


//        Commodity commodity=new Commodity();
//        Page<Commodity> page=commodityService.findPageBySubNavId("f8ad07c509a145b5b645943a459db681", 0, 10);
//        System.out.println(page.getPageCount());
//        System.out.println(page.getTotal());

//        插入
//
//        Random random=new Random();
//
//        List<MainNav> mainNavList=mainNavService.listAllMainNav();
//        String[] shopId={"111","222","333","444","555","111"};
//        String[] ds={"好吃","不错","赞"};
//        for(int k=0;k<10;k++){
//            for(MainNav s:mainNavList){
//                String mainNavId = s.getId();
//                List<SubNav> subNav = subNavService.listAndSort(mainNavId);
//                for(SubNav x:subNav){
//                    int i=random.nextInt(3);
//                    int j=random.nextInt(6);
//                    int n=random.nextInt(2);
//                    commodity.setId(String.valueOf(random.nextInt(10000)));
//                    commodity.setPic("123");
//                    commodity.setName(x.getName());
//                    commodity.setComment(123);
//                    commodity.setShopId(shopId[j]);
//                    commodity.setDescrip("黝嘿");
//                    commodity.setLabel(ds[i]);
//                    commodity.setNewPirce(random.nextInt(1000));
//                    commodity.setOldPrice(random.nextInt(1500));
//                    commodity.setNumber("DJ-"+random.nextInt(600));
//                    commodity.setBrowsingTimes(random.nextInt(3000));
//                    commodity.setFlag(n);
//                    commodity.setStock(random.nextInt(500));
//                    commodity.setTime(new Date());
//                    commodity.setSale(j);
//                    commodity.setDiscount("9.9");
//                    commodity.setSubNavId(x.getId());
//
//                    commodityService.addCommodity(commodity);
//                }
//            }
//
//        }


////        更新
//        commodity.setName("jie");
//        Conditions conditions=new Conditions();
//        conditions.eq("id","333");
//        commodityService.update(commodity, conditions);
//
//        根据ID名更新
//        commodity.setId("333");
//        commodity.setPic("888");
//        commodityService.updateById(commodity);


//        删除
//        Conditions conditions=new Conditions();
//        conditions.eq("id","333");
//        commodityService.delete(conditions);

//        查找
//        Conditions conditions=new Conditions();
//        conditions.eq("id","333");
//        commodity=commodityService.find(conditions);
//        logger.info("==================="+ commodity.getId()+"========================");
//
//        commodity=commodityService.findById("333");
//        logger.info("==================="+ commodity.getId()+"========================");


//        Conditions conditions=new Conditions();
//        conditions.between("id",0,1000);
//        List<Commodity> test=commodityService.list(conditions);

//        Conditions conditions=new Conditions();
//        conditions.between("id",0,1000);
//        long test=commodityService.count(conditions);
////



        List<Commodity> commodities=commodityService.listAll();
        for(Commodity x:commodities){
            x.setPic("goods-img.jpg");
            commodityService.updateById(x);
        }



        logger.info("===========================================");
//
//        logger.info(JSON.toJSONString(test));
        logger.info("===========================================");

    }

}
