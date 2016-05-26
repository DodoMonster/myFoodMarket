package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.NewsUser;
import java.util.List;

/**
 * Created by YWY on 2016/3/18.
 */
public interface INewsUserService {
    String addNewsUser(NewsUser newsUser) throws BaseException;

    void update(NewsUser newsUser, Conditions conditions) throws BaseException;

    void updateById(NewsUser newsUser) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    NewsUser find(Conditions conditions) throws BaseException;

    NewsUser findById(String id) throws BaseException;

    NewsUser findByEntity(NewsUser newsUser) throws BaseException;

    List<NewsUser> list(Conditions conditions) throws BaseException;
}