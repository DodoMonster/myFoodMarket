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
import scau.zxck.entity.admin.MerchantMessage;
import scau.zxck.service.admin.IMerchantMessageService;
import scau.zxck.service.admin.IShoppingCartService;

import java.io.FileNotFoundException;

/**
 * Created by suruijia on 2015/11/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class MerchantMessageServiceTest {
    private static Logger logger = Logger.getLogger(MerchantMessageServiceTest.class);

    @Before
    public void before() {
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private IMerchantMessageService merchantMessageService;

    @Test
    public void shoppingCartServiceTest() throws BaseException {
//        MerchantMessage merchantMessage = new MerchantMessage();
//        merchantMessage.setId("af20c79cffd84c719e8ef477fa9ae427");
//        merchantMessage.setProvince("xxxxxx");
//        merchantMessage.setCounty("xxx");
//        merchantMessage.setCity("ssss");
//        merchantMessage.setCompanyName("rrrxxxxrr");
//        merchantMessageService.add(merchantMessage);
//        merchantMessageService.updateById(merchantMessage);

//        Conditions conditions = new Conditions();
//        conditions.eq("id", "af20c79cffd84c719e8ef477fa9ae427");
//        merchantMessageService.delete(conditions);

        logger.info("===========================================");
//          logger.info(JSON.toJSONString(merchantMessageService.findById("af20c79cffd84c719e8ef477fa9ae427")));
//          logger.info(JSON.toJSONString(merchantMessageService.list(null)));
        logger.info("===========================================");
    }

}
