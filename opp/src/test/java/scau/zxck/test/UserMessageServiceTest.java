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
import scau.zxck.entity.admin.UserMessage;
import scau.zxck.service.admin.IUserMessageService;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Created by ZZWEI on 2016/3/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class UserMessageServiceTest {
    private static Logger logger = Logger.getLogger(UserMessageServiceTest.class);

    @Before
    public void before(){
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Autowired
    private IUserMessageService userMessageService;

    @Test
    public void UserMessageServiceTest() throws BaseException{
//        //添加
        UserMessage userMessage = new UserMessage();
//        userMessage.setId("47ab6eeb0c7241bdac5f1f7640f614b3");
//        userMessage.setPic("../src/images");
//        userMessage.setUserId("46ab6eeb0c7241bdac5f1f7640f614b3");
//        userMessage.setBirthday(new Date());
//        userMessage.setHometown("Guangzhou Guangdong China");
//        userMessage.setNickname("jerry");
//        userMessage.setRealname("hash");
//        userMessage.setResidence("residence");
//        userMessage.setSex(1);
//
//        userMessageService.addUserMessage(userMessage);

//        //查找
//        Conditions conditions = new Conditions();
//        conditions.eq("id", "47ab6eeb0c7241bdac5f1f7640f614b3");
//
//        logger.info("===========================================");
//        logger.info(JSON.toJSONString(userMessageService.count(conditions)));
//        logger.info(JSON.toJSONString(userMessageService.findById("47ab6eeb0c7241bdac5f1f7640f614b3")));
//
//        UserMessage userMessage1 = userMessageService.findById("47ab6eeb0c7241bdac5f1f7640f614b3");
//        logger.info(JSON.toJSONString(userMessageService.findByEntity(userMessage1)));
//        logger.info(JSON.toJSONString(userMessageService.find(conditions)));
//
//        String nickname = "jerry";
//        logger.info(JSON.toJSONString(userMessageService.findByNickname(nickname)));
//
//        String realname = "hash";
//        logger.info(JSON.toJSONString(userMessageService.findByRealname(realname)));
//
//        logger.info(JSON.toJSONString(userMessageService.findPage(conditions, 1, 1)));
//        logger.info(JSON.toJSONString(userMessageService.list(conditions)));
//
//        logger.info(JSON.toJSONString(userMessageService.listByEntity(userMessage, "nickname")));
//        logger.info(JSON.toJSONString(userMessageService.listByNameUsingLike("je")));
//        logger.info("===========================================");


//        //修改
//        Conditions conditions1 = new Conditions();
//        conditions1.eq("id", "47ab6eeb0c7241bdac5f1f7640f614b3");
//        userMessage.setNickname("mutton");
//        userMessageService.update(userMessage, conditions1);
//        UserMessage userMessage2 = userMessageService.findById("47ab6eeb0c7241bdac5f1f7640f614b3");
//        userMessage2.setNickname("pork");
//        userMessageService.updateById(userMessage2);
//
//        //删除
//        userMessageService.deleteByIds("47ab6eeb0c7241bdac5f1f7640f614b3");
//        userMessageService.delete(conditions);
    }
}
