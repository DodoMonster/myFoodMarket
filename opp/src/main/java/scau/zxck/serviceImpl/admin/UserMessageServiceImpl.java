package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.UserMessageDao;
import scau.zxck.entity.admin.UserMessage;
import scau.zxck.service.admin.IUserMessageService;

import java.util.List;

/**
 * Created by ZZWEI on 2016/3/18.
 */
@Service
public class UserMessageServiceImpl implements IUserMessageService{
    @Autowired
    private UserMessageDao userMessageDao;

    @Override
    public String addUserMessage(UserMessage userMessage) throws BaseException {
        return userMessageDao.add(userMessage);
    }

    @Override
    public void update(UserMessage userMessage, Conditions conditions) throws BaseException {
        userMessageDao.update(userMessage, conditions);
    }

    @Override
    public void updateById(UserMessage userMessage) throws BaseException {
        userMessageDao.updateById(userMessage);
    }


    @Override
    public void delete(Conditions conditions) throws BaseException {
        userMessageDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        userMessageDao.deleteByIds(ids);
    }

    @Override
    public UserMessage find(Conditions conditions) throws BaseException {
        return userMessageDao.find(conditions);
    }

    @Override
    public UserMessage findById(String id) throws BaseException {
        return userMessageDao.findById(id);
    }

    @Override
    public UserMessage findByEntity(UserMessage userMessage) throws BaseException {
        return userMessageDao.findByEntity(userMessage);
    }

    @Override
    public UserMessage findByNickname(String nickname) throws BaseException{
        return userMessageDao.findByNickname(nickname);
    }

    @Override
    public UserMessage findByRealname(String realname) throws BaseException{
        return userMessageDao.findByNicRealname(realname);
    }

    @Override
    public List<UserMessage> list(Conditions conditions) throws BaseException {
        return userMessageDao.list(conditions);
    }

    @Override
    public List<UserMessage> listByEntity(UserMessage userMessage, String... propertyName) throws BaseException {
        return userMessageDao.listByEntity(userMessage, propertyName);
    }


    @Override
    public List<UserMessage> listByNameUsingLike(String name) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.like("nickname","%"+name+"%");
        List<UserMessage> userMessageList = userMessageDao.list(conditions);
        return userMessageList;
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return userMessageDao.count(conditions);
    }

    @Override
    public Page<UserMessage> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return userMessageDao.page(conditions,offset,pageSize);
    }
}
