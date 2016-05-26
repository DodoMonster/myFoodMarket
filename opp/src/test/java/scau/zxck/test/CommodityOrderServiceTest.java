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
import scau.zxck.service.admin.ICommodityOrderService;


import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Condition;

/**
 * Created by 追追 on 2016/3/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class CommodityOrderServiceTest {

    private static Logger logger = Logger.getLogger(CommodityOrderServiceTest.class);

    @Before
    public void before() {
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private ICommodityOrderService commodityOrderService;

    @Test
    public void commodityOrderServiceTest() throws BaseException {

        CommodityOrder commodityOrder=new CommodityOrder();
//        插入

//        commodityOrder.setId("333");
//        commodityOrder.setCommodityId("123");
//        commodityOrder.setCount(123);
//        commodityOrder.setOrderId("1234");
//        commodityOrder.setPrice(123.0);
//        String id=commodityOrderService.addCommodityOrder(commodityOrder);




//        更新
//        commodityOrder.setCount(666);
//        Conditions conditions=new Conditions();
//        conditions.eq("id","333");
//        commodityOrderService.update(commodityOrder, conditions);

//        根据ID名更新
//        commodityOrder.setId("333");
//        commodityOrder.setPrice(888.88);
//        commodityOrderService.updateById(commodityOrder);


//        删除
//        Conditions conditions=new Conditions();
//        conditions.eq("id","333");
//        commodityOrderService.delete(conditions);

//        查找
//        Conditions conditions=new Conditions();
//        conditions.eq("id","333");
//        commodityOrder=commodityOrderService.find(conditions);
//        logger.info("==================="+ commodityOrder.getId()+"========================");
//
//        commodityOrderService.findById("333");

//        Conditions conditions=new Conditions();
//        conditions.between("id",0,1000);
//        List<CommodityOrder> test=commodityOrderService.list(conditions);

        Conditions conditions=new Conditions();
        conditions.between("id",0,1000);
        long test=commodityOrderService.count(conditions);
//



        logger.info("===========================================");

        logger.info(JSON.toJSONString(test));
        logger.info("===========================================");

    }

}
