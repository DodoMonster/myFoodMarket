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
import scau.zxck.entity.admin.Order;
import scau.zxck.service.admin.IOrderService;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Created by ZZWEI on 2016/3/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class OrderServiceTest {
    private static Logger logger = Logger.getLogger(KeywordServiceTest.class);

    @Before
    public void before(){
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Autowired
    private IOrderService orderService;

    @Test
    public void OrderServiceTest() throws BaseException{
        //添加
        Order order = new Order();
//        order.setId("47ab6eeb0c7241bdac5f1f7640f614b3");
//        order.setUserId("46ab6eeb0c7241bdac5f1f7640f614b3");
//        order.setBuyerMessage("Your merchant is perfect!");
//        order.setCommodityId("45ab6eeb0c7241bdac5f1f7640f614b3");
//        order.setCreateTime(new Date());
//        order.setIdentifier("duck");
//        order.setShippingAddress("Guangzhou Guangdong China");
//        order.setStatus(2);
//        order.setSum(788.80);
//
//        orderService.addOrder(order);

        //查找
//        Conditions conditions = new Conditions();
//        conditions.eq("id", "47ab6eeb0c7241bdac5f1f7640f614b3");
//
//        logger.info("===========================================");
//        logger.info(JSON.toJSONString(orderService.count(conditions)));
//        logger.info(JSON.toJSONString(orderService.findById("47ab6eeb0c7241bdac5f1f7640f614b3")));
//
//        Order order1 = orderService.findById("47ab6eeb0c7241bdac5f1f7640f614b3");
//        logger.info(JSON.toJSONString(orderService.findByEntity(order1)));
//        logger.info(JSON.toJSONString(orderService.find(conditions)));
//
//        String identifier = "duck";
//        logger.info(JSON.toJSONString(orderService.findByIdentifier(identifier)));
//
//        logger.info(JSON.toJSONString(orderService.findPage(conditions, 1, 1)));
//        logger.info(JSON.toJSONString(orderService.list(conditions)));
//        logger.info(JSON.toJSONString(orderService.listByEntity(order)));
//        logger.info("===========================================");


        //修改
//        Conditions conditions1 = new Conditions();
//        conditions1.eq("id", "47ab6eeb0c7241bdac5f1f7640f614b3");
//        order.setIdentifier("mutton");
//        orderService.update(order, conditions1);
//        Order order2 = orderService.findById("47ab6eeb0c7241bdac5f1f7640f614b3");
//        order2.setIdentifier("pork");
//        orderService.updateById(order2);
//
//        //删除
//        orderService.deleteByIds("47ab6eeb0c7241bdac5f1f7640f614b3");
//        orderService.delete(conditions);
    }
}
