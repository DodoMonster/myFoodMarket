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
import scau.zxck.entity.admin.NewsUser;
import scau.zxck.service.admin.INewsUserService;
import scau.zxck.service.admin.IShoppingCartService;

import java.io.FileNotFoundException;

/**
 * Created by suruijia on 2015/11/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class NewsUserServiceTest {
    private static Logger logger = Logger.getLogger(NewsUserServiceTest.class);

    @Before
    public void before() {
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private INewsUserService newsUserService;

    @Test
    public void newsUserServiceTest() throws BaseException {
//        NewsUser newsUser = new NewsUser();
//        newsUser.setUserId("22222");
//        newsUser.setNewsId("33333");
//        newsUserService.addNewsUser(newsUser);

//        Conditions conditions = new Conditions();
//        conditions.eq("id","6a1577a777604c56b3c71cfda37e5ac3");
//        newsUserService.delete(conditions);


        logger.info("===========================================");
//         logger.info(JSON.toJSONString(newsUserService.findById("6a1577a777604c56b3c71cfda37e5ac3")));
//         logger.info(JSON.toJSONString(newsUserService.list(null)));

        logger.info("===========================================");
    }

}
