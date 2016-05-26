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
import scau.zxck.entity.admin.UserGroup;
import scau.zxck.service.admin.IUserGroupService;

import java.io.FileNotFoundException;

/**
 * Created by ZZWEI on 2016/3/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class UserGroupServiceTest {
    private static Logger logger = Logger.getLogger(UserGroupServiceTest.class);

    @Before
    public void before(){
        try {
            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Autowired
    private IUserGroupService userGroupService;

    @Test
    public void UserGroupServiceTest() throws BaseException{

        //添加
        UserGroup userGroup = new UserGroup();
//        userGroup.setId("47ab6eeb0c7241bdac5f1f7640f614b3");
//        userGroup.setName("rhiro");
//        userGroup.setFlag(0);
//        userGroup.setSequence(2);
//        userGroup.setUserId("46ab6eeb0c7241bdac5f1f7640f614b3");
//
//        userGroupService.addUserGroup(userGroup);

        //查找
//        Conditions conditions = new Conditions();
//        conditions.eq("id", "47ab6eeb0c7241bdac5f1f7640f614b3");
//
//        logger.info("===========================================");
//        logger.info(JSON.toJSONString(userGroupService.count(conditions)));
//        logger.info(JSON.toJSONString(userGroupService.findById("47ab6eeb0c7241bdac5f1f7640f614b3")));
//
//        UserGroup userGroup1 = userGroupService.findById("47ab6eeb0c7241bdac5f1f7640f614b3");
//        logger.info(JSON.toJSONString(userGroupService.findByEntity(userGroup1)));
//        logger.info(JSON.toJSONString(userGroupService.find(conditions)));
//
//        String name = "rhiro";
//        logger.info(JSON.toJSONString(userGroupService.findByName(name)));
//
//        logger.info(JSON.toJSONString(userGroupService.findPage(conditions, 1, 1)));
//        logger.info(JSON.toJSONString(userGroupService.list(conditions)));
//
//        logger.info(JSON.toJSONString(userGroupService.listByEntity(userGroup, "name")));
//        logger.info(JSON.toJSONString(userGroupService.listByNameUsingLike("be")));
//        logger.info("===========================================");


        //修改
//        Conditions conditions1 = new Conditions();
//        conditions1.eq("id", "47ab6eeb0c7241bdac5f1f7640f614b3");
//        userGroup.setName("mutton");
//        userGroupService.update(userGroup, conditions1);
//        UserGroup userGroup2 = userGroupService.findById("47ab6eeb0c7241bdac5f1f7640f614b3");
//        userGroup2.setName("pork");
//        userGroupService.updateById(userGroup2);
//
//        //删除
//        userGroupService.deleteByIds("47ab6eeb0c7241bdac5f1f7640f614b3");
//        userGroupService.delete(conditions);
    }
}
