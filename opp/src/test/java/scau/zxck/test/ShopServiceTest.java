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
import scau.zxck.entity.admin.Shop;
import scau.zxck.service.admin.IShopService;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Condition;

/**
 * Created by 追追 on 2016/3/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class ShopServiceTest {

    private static Logger logger = Logger.getLogger(ShopServiceTest.class);

    @Before
    public void before() {
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private IShopService shopService;

    @Test
    public void shopServiceTest() throws BaseException {

        Shop shop =new Shop();
//        插入
//        shop.setName("MyShop");
//        shop.setBrief("This is my shop");
//        shop.setContact("send email to:111111@qq.com");
//        shop.setIntroduction("hahahahah");
//        String id=shopService.addShop(shop);

//        更新
//        shop.setName("YourShop");
//        Conditions conditions=new Conditions();
//        conditions.eq("name","MyShop");
//        shopService.update(shop, conditions);
//
//        根据ID名更新
//        shop.setId("5b06b950e8344ec4b2bc926fc166868a");
//        shop.setName("MyShop");
//        shopService.updateById(shop);


//        删除
//        Conditions conditions=new Conditions();
//        conditions.eq("name","MyShop");
//        shopService.delete(conditions);

//        查找
//        Conditions conditions=new Conditions();
//        conditions.eq("id","12345");
//        shop=shopService.find(conditions);
//        logger.info("==================="+ shop.getName()+"========================");

      //  shopService.findById("12345");

//        Conditions conditions=new Conditions();
//        conditions.between("id",0,10);
//        List<Shop> test=shopService.list(conditions);

//        Conditions conditions=new Conditions();
//        conditions.between("id",0,10);
//        long test=shopService.count(conditions);




        logger.info("===========================================");

//        logger.info(JSON.toJSONString(test));
        logger.info("===========================================");

    }

}
