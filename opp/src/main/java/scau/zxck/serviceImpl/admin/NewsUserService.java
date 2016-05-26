package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.NewsUserDao;
import scau.zxck.entity.admin.NewsUser;
import scau.zxck.service.admin.INewsUserService;

import java.util.List;

/**
 * Created by YWY on 2016/3/18.
 */
@Service
public class NewsUserService implements INewsUserService{
    @Autowired
    NewsUserDao newsUserDao;

    @Override
    public String addNewsUser(NewsUser newsUser) throws BaseException {
        return newsUserDao.add(newsUser);
    }

    @Override
    public void update(NewsUser newsUser, Conditions conditions) throws BaseException {
        newsUserDao.update(newsUser,conditions);
    }

    @Override
    public void updateById(NewsUser newsUser) throws BaseException {
        newsUserDao.updateById(newsUser);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        newsUserDao.delete(conditions);
    }

    @Override
    public NewsUser find(Conditions conditions) throws BaseException {
        return newsUserDao.find(conditions);
    }

    @Override
    public NewsUser findById(String id) throws BaseException {
        return newsUserDao.findById(id);
    }

    @Override
    public NewsUser findByEntity(NewsUser newsUser) throws BaseException {
        return newsUserDao.findByEntity(newsUser);
    }

    @Override
    public List<NewsUser> list(Conditions conditions) throws BaseException {
        return newsUserDao.list(conditions);
    }
}
