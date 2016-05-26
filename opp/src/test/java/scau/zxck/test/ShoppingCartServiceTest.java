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
import scau.zxck.entity.admin.ShoppingCart;
import scau.zxck.entity.admin.User;
import scau.zxck.service.admin.IShoppingCartService;
import scau.zxck.service.admin.IUserService;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Created by suruijia on 2015/11/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class ShoppingCartServiceTest {
    private static Logger logger = Logger.getLogger(ShoppingCartServiceTest.class);

    @Before
    public void before() {
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private IShoppingCartService shoppingCartService;

    @Test
    public void shoppingCartServiceTest() throws BaseException {
//        ShoppingCart shoppingCart = new ShoppingCart();
//        shoppingCart.setUserId("1111");
//        shoppingCart.setTime(new Date());
//        shoppingCart.setStatus(111);
//        shoppingCart.setShopId("4444");
//        shoppingCart.setCommodityId("3335553");
//        shoppingCart.setCommodityCount(2222);
//        shoppingCartService.addShoppingCart(shoppingCart);


//        Conditions conditions = new Conditions();
//        conditions.eq("id", "9e06931cf88045c696f1b8478480ba16");
//        shoppingCartService.delete(conditions);

//        Set<String> permissionCodes = userService.listPermissionCodes(id);
        logger.info("===========================================");
//          logger.info(JSON.toJSONString(shoppingCartService.list(null)));
        logger.info("===========================================");
    }

}
