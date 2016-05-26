package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.UserMessage;

import java.util.List;

/**
 * Created by ZZWEI on 2016/3/18.
 */
public interface IUserMessageService {
    String addUserMessage(UserMessage userMessage)throws BaseException;

    void update(UserMessage userMessage, Conditions conditions) throws BaseException;

    void updateById(UserMessage userMessage) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    UserMessage find(Conditions conditions) throws BaseException;

    UserMessage findById(String id) throws BaseException;

    UserMessage findByEntity(UserMessage userMessage) throws BaseException;

    UserMessage findByNickname(String nickname) throws BaseException;

    UserMessage findByRealname(String realname) throws BaseException;

    List<UserMessage> list(Conditions conditions) throws BaseException;

    List<UserMessage> listByEntity(UserMessage userMessage, String... propertyName) throws BaseException;

    List<UserMessage> listByNameUsingLike(String name) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Page<UserMessage> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;
}
