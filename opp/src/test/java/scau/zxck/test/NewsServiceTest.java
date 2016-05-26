package scau.zxck.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.JSONToken;
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
import scau.zxck.entity.admin.News;
import scau.zxck.service.admin.INewsService;
import scau.zxck.service.admin.INewsUserService;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Created by suruijia on 2015/11/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class NewsServiceTest {
    private static Logger logger = Logger.getLogger(NewsServiceTest.class);

    @Before
    public void before() {
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private INewsService newsService;

    @Test
    public void newsServiceTest() throws BaseException {
//        News news = new News();
//        news.setId("47ab6eeb0c7241bdac5f1f7640f614b3");
//        news.setTime(new Date());
//        news.setContent("sdlhaslkdjalsljlsd");
//        newsService.addNews(news);
//        newsService.updateById(news);

//        Conditions conditions = new Conditions();
//        conditions.eq("id", "0180705eb2eb457b90649e06dc0d0449");
//        newsService.delete(conditions);



        logger.info("===========================================");
//            logger.info(JSON.toJSONString(newsService.findById("0180705eb2eb457b90649e06dc0d0449")));
//            logger.info(JSON.toJSONString(newsService.list(null)));
        logger.info("===========================================");
    }

}
