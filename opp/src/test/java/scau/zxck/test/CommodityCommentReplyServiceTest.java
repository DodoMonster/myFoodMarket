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
import scau.zxck.entity.admin.CommodityCommentReply;
import scau.zxck.service.admin.ICommodityCommentReplyService;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Created by ZZWEI on 2016/3/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class CommodityCommentReplyServiceTest {
    private static Logger logger = Logger.getLogger(CommodityCommentReplyServiceTest.class);

    @Before
    public void before(){
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Autowired
    private ICommodityCommentReplyService commodityCommentReplyService;

    @Test
    public void CommodityCommentReplyServiceTest() throws BaseException{
        //添加
        CommodityCommentReply commodityCommentReply = new CommodityCommentReply();
//        commodityCommentReply.setId("47ab6eeb0c7241bdac5f1f7640f614b3");
//        commodityCommentReply.setTime(new Date());
//        commodityCommentReply.setUserId("46ab6eeb0c7241bdac5f1f7640f614b3");
//        commodityCommentReply.setComment("This shopping is so happy!");
//        commodityCommentReply.setCommodityCommentId("45ab6eeb0c7241bdac5f1f7640f614b3");
//
//        commodityCommentReplyService.addCommodityCommentReply(commodityCommentReply);

        //查找
//        Conditions conditions = new Conditions();
//        conditions.eq("id", "47ab6eeb0c7241bdac5f1f7640f614b3");
//
//        logger.info("===========================================");
//        logger.info(JSON.toJSONString(commodityCommentReplyService.count(conditions)));
//        logger.info(JSON.toJSONString(commodityCommentReplyService.findById("47ab6eeb0c7241bdac5f1f7640f614b3")));
//
//        CommodityCommentReply commodityCommentReply1 = commodityCommentReplyService.findById("47ab6eeb0c7241bdac5f1f7640f614b3");
//        logger.info(JSON.toJSONString(commodityCommentReplyService.findByEntity(commodityCommentReply1)));
//        logger.info(JSON.toJSONString(commodityCommentReplyService.find(conditions)));
//        logger.info(JSON.toJSONString(commodityCommentReplyService.findPage(conditions, 1, 1)));
//        logger.info(JSON.toJSONString(commodityCommentReplyService.list(conditions)));
//        logger.info(JSON.toJSONString(commodityCommentReplyService.listByEntity(commodityCommentReply1)));
//        logger.info("===========================================");


        //修改
//        Conditions conditions1 = new Conditions();
//        conditions1.eq("id", "47ab6eeb0c7241bdac5f1f7640f614b3");
//        commodityCommentReply.setComment("Mutton taste good!");
//        commodityCommentReplyService.update(commodityCommentReply, conditions1);
//        CommodityCommentReply commodityCommentReply2 = commodityCommentReplyService.findById("47ab6eeb0c7241bdac5f1f7640f614b3");
//        commodityCommentReply2.setComment("Pork taste great!");
//        commodityCommentReplyService.updateById(commodityCommentReply2);
//
//        //删除
//        commodityCommentReplyService.deleteByIds("47ab6eeb0c7241bdac5f1f7640f614b3");
//        commodityCommentReplyService.delete(conditions);
    }
}
