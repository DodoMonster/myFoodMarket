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
import scau.zxck.entity.admin.CommodityGroup;
import scau.zxck.service.admin.ICommodityGroupService;
import scau.zxck.service.admin.IMerchantMessageService;

import java.io.FileNotFoundException;

/**
 * Created by suruijia on 2015/11/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class CommodityGroupServiceTest {
    private static Logger logger = Logger.getLogger(CommodityGroupServiceTest.class);

    @Before
    public void before() {
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private ICommodityGroupService commodityGroupService;

    @Test
    public void CommodityGroupServiceTest() throws BaseException {
//        CommodityGroup commodityGroup = new CommodityGroup();
//        commodityGroup.setCommodityId("11111111");
//        commodityGroup.setFlag(11221);
//        commodityGroup.setName("xxxssssxx");
//        commodityGroup.setSequence(3265456);
//        commodityGroup.setId("447f8b1b6f3a4a13b2cc947667463991");
//        commodityGroupService.updateById(commodityGroup);
//        commodityGroupService.add(commodityGroup);

//        Conditions conditions = new Conditions();
//        conditions.eq("id","447f8b1b6f3a4a13b2cc947667463991");
//        commodityGroupService.delete(conditions);

        logger.info("===========================================");
//         logger.info(JSON.toJSONString(commodityGroupService.findById("447f8b1b6f3a4a13b2cc947667463991")));
//         logger.info(JSON.toJSONString(commodityGroupService.list(null)));

        logger.info("===========================================");
    }

}
