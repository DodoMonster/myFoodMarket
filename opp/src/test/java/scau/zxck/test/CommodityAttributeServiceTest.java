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
import scau.zxck.entity.admin.CommodityAttribute;
import scau.zxck.service.admin.ICommodityAttributeService;
import scau.zxck.service.admin.INewsService;

import java.io.FileNotFoundException;

/**
 * Created by suruijia on 2015/11/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class CommodityAttributeServiceTest {
    private static Logger logger = Logger.getLogger(CommodityAttributeServiceTest.class);

    @Before
    public void before() {
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private ICommodityAttributeService commodityAttributeService;

    @Test
    public void commodityAttributeServiceTest() throws BaseException {
//        CommodityAttribute commodityAttribute = new CommodityAttribute();
//        commodityAttribute.setId("07c43607f978494ea7fe0bf8b0af7c00");
//        commodityAttribute.setAttribute("6666");
//        commodityAttribute.setCommodityId("5555");
//        commodityAttributeService.addCommodityAttribute(commodityAttribute);
//        commodityAttributeService.updateById(commodityAttribute);

//        Conditions conditions = new Conditions();
//        conditions.eq("id", "07c43607f978494ea7fe0bf8b0af7c00");
//        commodityAttributeService.delete(conditions);

        logger.info("===========================================");
//            logger.info(JSON.toJSONString(commodityAttributeService.findById("0cfd1ec160e24fb189d3c55fca98dadc")));
//            logger.info(JSON.toJSONString(commodityAttributeService.list(null)));
        logger.info("===========================================");
    }

}
