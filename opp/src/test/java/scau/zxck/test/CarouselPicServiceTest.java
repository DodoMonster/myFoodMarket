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
import scau.zxck.entity.admin.CarouselPic;
import scau.zxck.service.admin.ICarouselPicService;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

/**
 * Created by ZZWEI on 2016/3/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class CarouselPicServiceTest {
    private static Logger logger = Logger.getLogger(CarouselPicServiceTest.class);

    @Before
    public void before(){
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Autowired
    private ICarouselPicService carouselPicService;

    @Test
    public void CarouselPicServiceTest() throws BaseException{

//        //添加
//        CarouselPic carouselPic = new CarouselPic();
//        carouselPic.setId("47ab6eeb0c7241bdac5f1f7640f614b3");
//        carouselPic.setCommodityId("0180705eb2eb457b90649e06dc0d0449");
//        carouselPic.setPic("../src/images");
//        carouselPic.setShopId("ac95cfc7f8b0414db49b85865a4c9c18");
//        carouselPic.setTime(new Date());
//
//        carouselPicService.addCarouselPic(carouselPic);
//
//        //查找
//        Conditions conditions = new Conditions();
//        conditions.eq("id", "47ab6eeb0c7241bdac5f1f7640f614b3");
//
//        logger.info("===========================================");
//        logger.info(JSON.toJSONString(carouselPicService.count(conditions)));
//        logger.info(JSON.toJSONString(carouselPicService.findById("47ab6eeb0c7241bdac5f1f7640f614b3")));
//        CarouselPic carouselPic1 = carouselPicService.findById("47ab6eeb0c7241bdac5f1f7640f614b3");
//        logger.info(JSON.toJSONString(carouselPicService.findByEntity(carouselPic1)));
//        logger.info(JSON.toJSONString(carouselPicService.find(conditions)));
//        logger.info(JSON.toJSONString(carouselPicService.findPage(conditions, 1, 1)));
//        logger.info(JSON.toJSONString(carouselPicService.list(conditions)));
//        logger.info(JSON.toJSONString(carouselPicService.listByEntity(carouselPic1)));
//        logger.info("===========================================");


//        //修改
//        Conditions conditions1 = new Conditions();
//        conditions1.eq("id", "47ab6eeb0c7241bdac5f1f7640f614b3");
//        carouselPic.setPic("/d/phos");
//        carouselPicService.update(carouselPic, conditions1);
//        CarouselPic carouselPic2 = carouselPicService.findById("47ab6eeb0c7241bdac5f1f7640f614b3");
//        carouselPic2.setTime(new Date());
//        carouselPicService.updateById(carouselPic2);

        //删除
//        carouselPicService.deleteByIds("47ab6eeb0c7241bdac5f1f7640f614b3");
//        carouselPicService.delete(conditions);
    }
}
