package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.NewsDao;
import scau.zxck.entity.admin.News;
import scau.zxck.service.admin.INewsService;

import java.util.List;

/**
 * Created by YWY on 2016/3/18.
 */

@Service
public class NewsService implements INewsService{

    @Autowired
    NewsDao newsDao;

    @Override
    public String addNews(News news) throws BaseException {
        return newsDao.add(news);
    }

    @Override
    public void update(News news, Conditions conditions) throws BaseException {
        newsDao.update(news,conditions);
    }

    @Override
    public void updateById(News news) throws BaseException {
        newsDao.updateById(news);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        newsDao.delete(conditions);
    }

    @Override
    public News find(Conditions conditions) throws BaseException {
        return newsDao.find(conditions);
    }

    @Override
    public News findById(String id) throws BaseException {
        return newsDao.findById(id);
    }

    @Override
    public News findByEntity(News news) throws BaseException {
        return newsDao.findByEntity(news);
    }

    @Override
    public List<News> list(Conditions conditions) throws BaseException {
        return newsDao.list(conditions);
    }
}
