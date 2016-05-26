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
import scau.zxck.entity.admin.CommodityOrder;
import scau.zxck.entity.admin.CommodityPic;
import scau.zxck.service.admin.ICommodityOrderService;
import scau.zxck.service.admin.ICommodityPicService;


import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Condition;

/**
 * Created by 追追 on 2016/3/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class CommodityPicServiceTest {

    private static Logger logger = Logger.getLogger(CommodityPicServiceTest.class);

    @Before
    public void before() {
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private ICommodityPicService commodityPicService;

    @Test
    public void commodityPicServiceTest() throws BaseException {

        CommodityPic commodityPic=new CommodityPic();
//        插入

//        commodityPic.setId("333");
//        commodityPic.setPic("123");
//        commodityPic.setCommodityId("123");
//        commodityPic.setSequence(123);
//        String id=commodityPicService.addCommodityPic(commodityPic);




//        更新
//        commodityPic.setSequence(666);
//        Conditions conditions=new Conditions();
//        conditions.eq("id","333");
//        commodityPicService.update(commodityPic, conditions);
//
////        根据ID名更新
//        commodityPic.setId("333");
//        commodityPic.setCommodityId("888");
//        commodityPicService.updateById(commodityPic);


//        删除
//        Conditions conditions=new Conditions();
//        conditions.eq("id","333");
//        commodityPicService.delete(conditions);

//        查找
//        Conditions conditions=new Conditions();
//        conditions.eq("id","33");
//        commodityPic=commodityPicService.find(conditions);
//        logger.info("==================="+ commodityPic.getId()+"========================");
//
//        commodityPic=commodityPicService.findById("33");
//        logger.info("==================="+ commodityPic.getId()+"========================");


//        Conditions conditions=new Conditions();
//        conditions.between("id",0,1000);
//        List<CommodityPic> test=commodityPicService.list(conditions);

        Conditions conditions=new Conditions();
        conditions.between("id",0,1000);
        long test=commodityPicService.count(conditions);
//



        logger.info("===========================================");

        logger.info(JSON.toJSONString(test));
        logger.info("===========================================");

    }

}
