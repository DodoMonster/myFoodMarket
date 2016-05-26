package scau.zxck.test;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.SubNav;
import scau.zxck.service.admin.ISubNavService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class SubNavServiceTest {
    private static Logger logger = Logger.getLogger(SubNavServiceTest.class);

    @Before
    public void before() {
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Autowired
    private ISubNavService subNavService;

    @Test
    public void SubNavServiceTest() throws BaseException {

        SubNav subNav=new SubNav();

//        List<SubNav> list=subNavService.listAllSubOfMainNav();
//        List<SubNav> list=subNavService.listAndSort("c98b4d524e6743d49d45450872ad8180");
//
//
//        Iterator<SubNav> iterator=list.iterator();
//        while(iterator.hasNext()){
//            subNav=iterator.next();
//            System.out.println("=========================="+subNav.getSequence()+"=============================");
//        }


//        SubNav subNav=new SubNav();
//        Conditions conditions=new Conditions();
//        conditions.isNotNull(subNav.getId());
//        List<SubNav> list=subNavService.list(conditions);
//        Iterator<SubNav> iterator=list.iterator();
//        while(iterator.hasNext()){
//            logger.info("================="+iterator.next()+"================");
//        }

//        subNav.setId("188");
//        subNav.setName("222");
//        subNav.setMainNavId("333");
//        subNav.setSequence(123);
//        subNavService.addSubNav(subNav);
//        logger.info("===========================================");

//        更新
//        subNav.setName("myName");
//        Conditions conditions=new Conditions();
//        conditions.eq("name","222");
//        subNavService.update(subNav, conditions);
//
//        根据ID名更新
//        SubNav subNav = new SubNav();
//        subNav.setId("01297f2b71b44f5f83f2e022a6033fb3");
//        subNav.setName("yourShop");
//        subNavService.updateById(subNav);
    }

//        删除
//        Conditions conditions=new Conditions();
//        conditions.eq("name","yourName");
//        subNavService.delete(conditions);

//        查找
//        Conditions conditions=new Conditions();
//        conditions.eq("id","222");
//        subNav=subNavService.find(conditions);
//        logger.info("==================="+ subNav.getName()+"========================");

//          subNavService.findById("222");

//        Conditions conditions=new Conditions();
//        conditions.between("id",0,10);
//        List<SubNav> test=subNavService.list(conditions);


//        Conditions conditions=new Conditions();
//        conditions.between("id",0,1000);
//        long test=subNavService.count(conditions);

//        String[] mainNavIds = {"0e488df5754d4ca7af4f1f029f1357ea",
//                                "7a8a1dc6aa824921897fc69d46d56a40",
//                                "c98b4d524e6743d49d45450872ad8180"};
//        String[][] subNavs = {{"苹果","梨","西瓜","哈密瓜","猕猴桃","桃桔","柑橙","草莓","山竹","杨桃","杨梅","木瓜","石榴","冬枣","枇杷"},
//                {"柚","柠檬","李杏","香蕉","圣女果","葡萄","提子","无花果","黄金瓜","板栗","菱角","山楂","番石榴","蛇果","鸡蛋果","罗汉果"},
//                {"樱桃","车厘子","火龙果","芒果","荔枝","龙眼","甘蔗","菠萝","榴莲","柿子","人参果","橄榄","香瓜","椰子","莲雾"}};
//
//        for(int i = 0 ;i < 3 ; i++){
//            for(int j = 0;j < subNavs[i].length;j++){
//                SubNav subNav=new SubNav();
//                subNav.setName(subNavs[i][j]);
//                subNav.setMainNavId(mainNavIds[i]);
//                subNav.setSequence(j+1);
//                subNavService.addSubNav(subNav);
//            }
//        }
//
//        logger.info("===========================================");
//
////        logger.info(JSON.toJSONString(l));
//        logger.info("===========================================");
//
//    }
//



}
