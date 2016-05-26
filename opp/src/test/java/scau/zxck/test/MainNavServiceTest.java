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
import scau.zxck.entity.admin.MainNav;
import scau.zxck.entity.admin.SubNav;
import scau.zxck.service.admin.IMainNavService;
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
public class MainNavServiceTest {
    private static Logger logger = Logger.getLogger(MainNavServiceTest.class);

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

    @Test
    public void mainNavServiceTest() throws BaseException {

//            MainNav mainNav=mainNavService.findById("0e488df5754d4ca7af4f1f029f1357ea");  //删除主栏目
//            mainNavService.deleteByIds("0e488df5754d4ca7af4f1f029f1357ea");
//
//            SubNav subNav=new SubNav();                 //删除对应子栏目
//            List<SubNav> subNavs=subNavService.listAllSubOfMainNav("0e488df5754d4ca7af4f1f029f1357ea");
//
//            Iterator<SubNav> iterator=subNavs.iterator();
//            while(iterator.hasNext()){
//                subNavService.deleteByIds(iterator.next().getId());
//            }




//        List<MainNav> mainNav=mainNavService.listAllMainNav();
//        ArrayList<List> list=new ArrayList<List>();
//
//        Iterator<MainNav> mainIterator=mainNav.iterator();
//        while(mainIterator.hasNext()){
//            MainNav subNavOfMain=mainIterator.next();
//            String mainNavId=subNavOfMain.getId();
//            List<SubNav> subNav=subNavService.listAllSubOfMainNav(mainNavId);
//            list.add(subNav);
//        }

//        String[] mainNavs = {"酸性","亚酸性","甜性"};
//
//        for(int i=0;i<3;i++){
//            MainNav mainNav=new MainNav();
//            mainNav.setName(mainNavs[i]);
//            mainNav.setBelongTo("水果");
//            mainNav.setSequence(i+1);
//            mainNavService.addMainNav(mainNav);
//        }



    }


//        MainNav mainNav=new MainNav();
//        mainNav.setId("111");
//        mainNav.setName("222");
//        mainNav.setBelong_to(123);
//        mainNav.setSequence(123);
//        mainNavService.addMainNav(mainNav);


//        更新
//        mainNav.setName("myName");
//        Conditions conditions=new Conditions();
//        conditions.eq("name","222");
//        mainNavService.update(mainNav, conditions);
//
//        根据ID名更新
//        mainNav.setId("111");
//        mainNav.setName("yourName");
//        mainNavService.updateById(mainNav);


//        删除
//        Conditions conditions=new Conditions();
//        conditions.eq("name","yourName");
//        mainNavService.delete(conditions);

//        查找
//        Conditions conditions=new Conditions();
//        conditions.eq("id","222");
//        mainNav=mainNavService.find(conditions);
//        logger.info("==================="+ mainNav.getName()+"========================");

//          mainNavService.findById("222");

//        Conditions conditions=new Conditions();
//        conditions.between("id",0,10);
//        List<MainNav> test=mainNavService.list(conditions);


//        Conditions conditions=new Conditions();
//        conditions.between("id",0,1000);
//        long l=mainNavService.count(conditions);
//
//
//
//
//        logger.info("===========================================");
//
//        logger.info(JSON.toJSONString(l));
//        logger.info("===========================================");
//


    }





