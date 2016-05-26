package scau.zxck.test;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.IADD;
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
import scau.zxck.entity.admin.Advertisement;
import scau.zxck.service.admin.IAdvertisementService;
import scau.zxck.service.admin.INewsService;

import java.io.FileNotFoundException;

/**
 * Created by suruijia on 2015/11/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class AdvertisementServiceTestsServiceTest {
    private static Logger logger = Logger.getLogger(AdvertisementServiceTestsServiceTest.class);

    @Before
    public void before() {
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private IAdvertisementService advertisementService;

    @Test
    public void advertisementServiceServiceTest() throws BaseException {
//        Advertisement advertisement = new Advertisement();
//        advertisement.setId("8a433dc90fc7494ab35aaa746c9ed742");
//        advertisement.setCommodityId("6666");
//        advertisement.setPic("aaa.jpg");
//        advertisement.setShopId("7777");
//        advertisement.setPosition(222);
//        advertisementService.updateById(advertisement);
//        advertisementService.addAdvertisement(advertisement);

        Conditions conditions = new Conditions();
        conditions.eq("id", "8a433dc90fc7494ab35aaa746c9ed742");
        advertisementService.delete(conditions);


        logger.info("===========================================");
//            logger.info(JSON.toJSONString(advertisementService.findById("8a433dc90fc7494ab35aaa746c9ed742")));
//            logger.info(JSON.toJSONString(advertisementService.list(null)));
        logger.info("===========================================");
    }

}
