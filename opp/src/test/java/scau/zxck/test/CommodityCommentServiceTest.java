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
import scau.zxck.entity.admin.CommodityComment;
import scau.zxck.service.admin.ICommodityCommentService;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Created by ZZWEI on 2016/3/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class CommodityCommentServiceTest {
    private static Logger logger = Logger.getLogger(CommodityCommentServiceTest.class);

    @Before
    public void before(){
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Autowired
    private ICommodityCommentService commodityCommentService;

    @Test
    public void CommodityCommentServiceTest() throws BaseException{
        //添加
        CommodityComment commodityComment = new CommodityComment();
        commodityComment.setId("47ab6eeb0c7241bdac5f1f7640f614b3");
        commodityComment.setTime(new Date());
        commodityComment.setComment("This merchant is so great!");
        commodityComment.setCommodityId("0180705eb2eb457b90649e06dc0d0449");
        commodityComment.setScore(8);
        commodityComment.setSellerReply("Thanks for buy it!Have a good time!");
        commodityComment.setUserId("ac95cfc7f8b0414db49b85865a4c9c18");

        commodityCommentService.addCommodityComment(commodityComment);

        //查找
        Conditions conditions = new Conditions();
        conditions.eq("id", "47ab6eeb0c7241bdac5f1f7640f614b3");

        logger.info("===========================================");
        logger.info(JSON.toJSONString(commodityCommentService.count(conditions)));
        logger.info(JSON.toJSONString(commodityCommentService.findById("47ab6eeb0c7241bdac5f1f7640f614b3")));
        CommodityComment commodityComment1 = commodityCommentService.findById("47ab6eeb0c7241bdac5f1f7640f614b3");
        logger.info(JSON.toJSONString(commodityCommentService.findByEntity(commodityComment1)));
        logger.info(JSON.toJSONString(commodityCommentService.find(conditions)));
        logger.info(JSON.toJSONString(commodityCommentService.findPage(conditions, 1, 1)));
      //  logger.info(JSON.toJSONString(commodityCommentService.list(conditions)));
        logger.info(JSON.toJSONString(commodityCommentService.listByEntity(commodityComment)));
        logger.info("===========================================");


        //修改
        Conditions conditions1 = new Conditions();
        conditions1.eq("id", "47ab6eeb0c7241bdac5f1f7640f614b3");
        commodityComment.setTime(new Date());
        commodityCommentService.update(commodityComment, conditions1);
        CommodityComment commodityComment2 = commodityCommentService.findById("47ab6eeb0c7241bdac5f1f7640f614b3");
        commodityComment2.setTime(new Date());
        commodityCommentService.updateById(commodityComment2);

        //删除
        commodityCommentService.deleteByIds("47ab6eeb0c7241bdac5f1f7640f614b3");
        commodityCommentService.delete(conditions);
    }
}
