package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.News;

import java.util.List;

/**
 * Created by YWY on 2016/3/18.
 */
public interface INewsService {
    String addNews(News news) throws BaseException;

    void update(News news, Conditions conditions) throws BaseException;

    void updateById(News news) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    News find(Conditions conditions) throws BaseException;

    News findById(String id) throws BaseException;

    News findByEntity(News news) throws BaseException;

    List<News> list(Conditions conditions) throws BaseException;
}