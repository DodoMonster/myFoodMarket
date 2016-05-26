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
import scau.zxck.entity.admin.Keyword;
import scau.zxck.service.admin.IKeywordService;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Created by ZZWEI on 2016/3/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class KeywordServiceTest {
    private static Logger logger = Logger.getLogger(KeywordServiceTest.class);

    @Before
    public void before(){
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Autowired
    private IKeywordService keywordService;

    @Test
    public void KeywordServiceTest() throws BaseException{
         //添加
        Keyword keyword = new Keyword();
        keyword.setId("47ab6eeb0c7241bdac5f1f7640f614b3");
        keyword.setName("beef");
        keyword.setSequence(2);
        keyword.setHightlight(5);

        keywordService.addKeyword(keyword);

        //查找
        Conditions conditions = new Conditions();
        conditions.eq("id", "47ab6eeb0c7241bdac5f1f7640f614b3");

        logger.info("===========================================");
        logger.info(JSON.toJSONString(keywordService.count(conditions)));
        logger.info(JSON.toJSONString(keywordService.findById("47ab6eeb0c7241bdac5f1f7640f614b3")));

        Keyword keyword1 = keywordService.findById("47ab6eeb0c7241bdac5f1f7640f614b3");
        logger.info(JSON.toJSONString(keywordService.findByEntity(keyword1)));
        logger.info(JSON.toJSONString(keywordService.find(conditions)));

        String name = "beef";
        logger.info(JSON.toJSONString(keywordService.findByName(name)));

        logger.info(JSON.toJSONString(keywordService.findPage(conditions, 1, 1)));
        logger.info(JSON.toJSONString(keywordService.list(conditions)));

        logger.info(JSON.toJSONString(keywordService.listByEntity(keyword, "name")));
        logger.info(JSON.toJSONString(keywordService.listByNameUsingLike("be")));
        logger.info("===========================================");


        //修改
        Conditions conditions1 = new Conditions();
        conditions1.eq("id", "47ab6eeb0c7241bdac5f1f7640f614b3");
        keyword.setName("mutton");
        keywordService.update(keyword, conditions1);
        Keyword keyword2 = keywordService.findById("47ab6eeb0c7241bdac5f1f7640f614b3");
        keyword2.setName("pork");
        keywordService.updateById(keyword2);

        //删除
        keywordService.deleteByIds("47ab6eeb0c7241bdac5f1f7640f614b3");
        keywordService.delete(conditions);
    }
}
