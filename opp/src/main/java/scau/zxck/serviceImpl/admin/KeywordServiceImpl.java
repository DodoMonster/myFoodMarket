package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.KeywordDao;
import scau.zxck.entity.admin.Keyword;
import scau.zxck.service.admin.IKeywordService;

import java.util.List;

/**
 * Created by ZZWEI on 2016/3/18.
 */
@Service
public class KeywordServiceImpl implements IKeywordService{
    @Autowired
    private KeywordDao keywordDao;

    @Override
    public String addKeyword(Keyword keyword) throws BaseException {
        return keywordDao.add(keyword);
    }

    @Override
    public void update(Keyword keyword, Conditions conditions) throws BaseException {
        keywordDao.update(keyword, conditions);
    }

    @Override
    public void updateById(Keyword keyword) throws BaseException {
        keywordDao.updateById(keyword);
    }


    @Override
    public void delete(Conditions conditions) throws BaseException {
        keywordDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        keywordDao.deleteByIds(ids);
    }

    @Override
    public Keyword find(Conditions conditions) throws BaseException {
        return keywordDao.find(conditions);
    }

    @Override
    public Keyword findById(String id) throws BaseException {
        return keywordDao.findById(id);
    }

    @Override
    public Keyword findByEntity(Keyword keyword) throws BaseException {
        return keywordDao.findByEntity(keyword);
    }

    @Override
    public Keyword findByName(String name) throws BaseException{
        return keywordDao.findByName(name);
    }

    @Override
    public List<Keyword> list(Conditions conditions) throws BaseException {
        return keywordDao.list(conditions);
    }

    @Override
    public List<Keyword> listByEntity(Keyword keyword, String... propertyName) throws BaseException {
        return keywordDao.listByEntity(keyword, propertyName);
    }


    @Override
    public List<Keyword> listByNameUsingLike(String name) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.like("name","%"+name+"%");
        List<Keyword> keywordList = keywordDao.list(conditions);
        return keywordList;
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return keywordDao.count(conditions);
    }

    @Override
    public Page<Keyword> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return keywordDao.page(conditions,offset,pageSize);
    }
}
