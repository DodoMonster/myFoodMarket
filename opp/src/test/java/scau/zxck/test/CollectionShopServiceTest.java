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
import scau.zxck.entity.admin.CollectionShop;
import scau.zxck.entity.admin.Shop;
import scau.zxck.service.admin.ICollectionShopService;
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
public class CollectionShopServiceTest {

    private static Logger logger = Logger.getLogger(CollectionShopServiceTest.class);

    @Before
    public void before() {
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private ICollectionShopService collectionShopService;

    @Test
    public void collectionShopServiceTest() throws BaseException {

        CollectionShop collectionShop=new CollectionShop();
//        插入
//        collectionShop.setShopId("333");
//        collectionShop.setClassification("33");
//        collectionShop.setId("333");
//        collectionShop.setUserId("333");
//        String id=collectionShopService.addCollectionShop(collectionShop);

//        更新
//        collectionShop.setUser_id("666");
//        Conditions conditions=new Conditions();
//        conditions.eq("id","222");
//        collectionShopService.update(collectionShop, conditions);
//
//        根据ID名更新
//        collectionShop.setId("222");
//        collectionShop.setShopId("888");
//        collectionShopService.updateById(collectionShop);


//        删除
//        Conditions conditions=new Conditions();
//        conditions.eq("id","222");
//        collectionShopService.delete(conditions);

//        查找
//             Conditions conditions=new Conditions();
//        conditions.eq("id","333");
//        collectionShop=collectionShopService.find(conditions);
//        logger.info("==================="+ collectionShop.getId()+"========================");

//        collectionShopService.findById("333");

//        Conditions conditions=new Conditions();
//        conditions.between("id",0,1000);
//        List<CollectionShop> test=collectionShopService.list(conditions);

        Conditions conditions=new Conditions();
        conditions.between("id",0,1000);
        long test=collectionShopService.count(conditions);




        logger.info("===========================================");

        logger.info(JSON.toJSONString(test));
        logger.info("===========================================");

    }

}
