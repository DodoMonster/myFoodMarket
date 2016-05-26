package scau.zxck.test;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.ShippingAddress;
import scau.zxck.service.admin.IShippingAddressService;

import java.io.FileNotFoundException;

/**
 * Created by suruijia on 2015/11/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class ShippingAddressServiceTest {
    private static Logger logger = Logger.getLogger(ShippingAddressServiceTest.class);

    @Before
    public void before() {
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private IShippingAddressService shippingAddressService;

    @Test
    public void shoppingAddressServiceTest() throws BaseException {
        ShippingAddress shippingAddress = new ShippingAddress();
//        shoppingAddress.setId("90d07f50de77469c9317c53342b661c4");
        shippingAddress.setUserId("1111");
        shippingAddress.setCellphone("12345678");
        shippingAddress.setCity("oiuoiu");
        shippingAddress.setTelephone("87654321");
        shippingAddress.setConsigneeName("xxxxx");
        shippingAddress.setFlag(12345);
        shippingAddress.setStreet("uoiu");
        shippingAddress.setCountry("xxx");
        shippingAddress.setCounty("xxxxxx");
        shippingAddress.setDetailAddress("xxxxxxxxxxxxxxxxx");
        shippingAddress.setPostcode("xx");
        shippingAddress.setProvince("xx");
//        shippingAddressService.updateById(shippingAddress);
        shippingAddressService.addShippingAddress(shippingAddress);

//        Conditions conditions = new Conditions();
//        conditions.eq("id", "90d07f50de77469c9317c53342b661c4");
//        shippingAddressService.delete(conditions);

        logger.info("===========================================");
//            logger.info(JSON.toJSONString(shippingAddressService.list(null)));
//            logger.info(JSON.toJSONString(shippingAddressService.findById("90d07f50de77469c9317c53342b661c4")));
        logger.info("===========================================");
    }

}
