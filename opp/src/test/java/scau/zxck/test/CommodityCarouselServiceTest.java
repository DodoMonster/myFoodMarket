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
import scau.zxck.entity.admin.CommodityCarousel;
import scau.zxck.service.admin.ICommodityCarouselService;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class CommodityCarouselServiceTest {
    private static Logger logger = Logger.getLogger(CommodityCarouselServiceTest.class);

    @Before
    public void before() {
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Autowired
    private ICommodityCarouselService commodityCarouselService;

    @Test
    public void SubNavServiceTest() throws BaseException{

        CommodityCarousel commodityCarousel =new CommodityCarousel();

//        commodityCarousel.setId("111");
//        commodityCarousel.setCommodity_id("222");
//        commodityCarousel.setPic("333");
//        commodityCarousel.setShop_id("123");
//        commodityCarousel.setTime(new Date());
//        commodityCarouselService.addCommodityCarousel(commodityCarousel);


//        更新
//        commodityCarousel.setPic("myPic");
//        Conditions conditions=new Conditions();
//        conditions.eq("pic","333");
//        commodityCarouselService.update(commodityCarousel, conditions);
//
//        根据ID名更新
//        commodityCarousel.setId("111");
//        commodityCarousel.setPic("yourPic");
//        commodityCarouselService.updateById(commodityCarousel);


//        删除
//        Conditions conditions=new Conditions();
//        conditions.eq("shop_id","123");
//        commodityCarouselService.delete(conditions);

//        查找
//        Conditions conditions=new Conditions();
//        conditions.eq("id","222");
//        commodityCarousel=commodityCarouselService.find(conditions);
//        logger.info("==================="+ commodityCarousel.getPic()+"========================");

//          commodityCarouselService.findById("222");
//
//        Conditions conditions=new Conditions();
//        conditions.between("id",0,10);
//        List<CommodityCarousel> test=commodityCarouselService.list(conditions);
//

        Conditions conditions=new Conditions();
        conditions.between("id",0,1000);
        long l=commodityCarouselService.count(conditions);




        logger.info("===========================================");
        logger.info(JSON.toJSONString(l));
        logger.info("===========================================");

    }




}
