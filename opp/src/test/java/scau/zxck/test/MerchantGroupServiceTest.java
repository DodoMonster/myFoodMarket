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
import scau.zxck.entity.admin.MerchantGroup;
import scau.zxck.service.admin.IMerchantGroupService;

import java.io.FileNotFoundException;

/**
 * Created by ZZWEI on 2016/3/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class MerchantGroupServiceTest {
    private static Logger logger = Logger.getLogger(MerchantGroupServiceTest.class);

    @Before
    public void before(){
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Autowired
    private IMerchantGroupService merchantGroupService;

    @Test
    public void MerchantGroupServiceTest() throws BaseException{
        //添加
        MerchantGroup merchantGroup = new MerchantGroup();
//        merchantGroup.setId("47ab6eeb0c7241bdac5f1f7640f614b3");
//        merchantGroup.setSequence(2);
//        merchantGroup.setName("bird");
//        merchantGroup.setFlag(0);
//        merchantGroup.setMerchantId("46ab6eeb0c7241bdac5f1f7640f614b3");

//        merchantGroupService.addMerchantGroup(merchantGroup);

        //查找
//        Conditions conditions = new Conditions();
//        conditions.eq("id", "47ab6eeb0c7241bdac5f1f7640f614b3");
//
//        logger.info("===========================================");
//        logger.info(JSON.toJSONString(merchantGroupService.count(conditions)));
//        logger.info(JSON.toJSONString(merchantGroupService.findById("47ab6eeb0c7241bdac5f1f7640f614b3")));
//
//        MerchantGroup merchantGroup1 = merchantGroupService.findById("47ab6eeb0c7241bdac5f1f7640f614b3");
//        logger.info(JSON.toJSONString(merchantGroupService.findByEntity(merchantGroup1)));
//        logger.info(JSON.toJSONString(merchantGroupService.find(conditions)));
//
//        String name = "bird";
//        logger.info(JSON.toJSONString(merchantGroupService.findByName(name)));
//
//        logger.info(JSON.toJSONString(merchantGroupService.findPage(conditions, 1, 1)));
//        logger.info(JSON.toJSONString(merchantGroupService.list(conditions)));
//
//        logger.info(JSON.toJSONString(merchantGroupService.listByEntity(merchantGroup, "name")));
//        logger.info(JSON.toJSONString(merchantGroupService.listByNameUsingLike("be")));
//        logger.info("===========================================");


        //修改
//        Conditions conditions1 = new Conditions();
//        conditions1.eq("id", "47ab6eeb0c7241bdac5f1f7640f614b3");
//        merchantGroup.setName("mutton");
//        merchantGroupService.update(merchantGroup, conditions1);
//        MerchantGroup merchantGroup2 = merchantGroupService.findById("47ab6eeb0c7241bdac5f1f7640f614b3");
//        merchantGroup2.setName("pork");
//        merchantGroupService.updateById(merchantGroup2);
//
//        //删除
//        merchantGroupService.deleteByIds("47ab6eeb0c7241bdac5f1f7640f614b3");
//        merchantGroupService.delete(conditions);
    }
}
