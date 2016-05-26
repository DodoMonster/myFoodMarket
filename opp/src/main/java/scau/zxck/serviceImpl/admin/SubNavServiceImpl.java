package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.SubNavDao;
import scau.zxck.entity.admin.SubNav;
import scau.zxck.service.admin.ISubNavService;

import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
@Service
public class SubNavServiceImpl implements ISubNavService {

    @Autowired
    private SubNavDao subNavDao;

    @Override
    public String addSubNav(SubNav subNav) throws BaseException {
        return subNavDao.add(subNav);
    }

    @Override
    public void update(SubNav subNav, Conditions conditions) throws BaseException {
        subNavDao.update(subNav,conditions);
    }

    @Override
    public void updateById(SubNav subNav) throws BaseException {
        subNavDao.updateById(subNav);
       // System.out.println();
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        subNavDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        subNavDao.deleteByIds(ids);
    }

    @Override
    public SubNav findByName(String name) throws BaseException {
        Conditions conditions=new Conditions();
        conditions.eq("name",name);
        return subNavDao.find(conditions);
    }

    @Override
    public SubNav findById(String id) throws BaseException {
        return subNavDao.findById(id);
    }

    @Override
    public List<SubNav> listAndSort(String mainNavId) throws BaseException {
        Conditions conditions=new Conditions();
        conditions.eq("main_nav_id",mainNavId);
        conditions.asc("sequence");
        return subNavDao.list(conditions);
    }

//    @Override
//    public List<SubNav> sortAllSubOfMainNav(String mainNavId) throws BaseException {
//        Conditions conditions=new Conditions();
//        conditions.eq("main_nav_id",mainNavId);
//        conditions.asc("sequence");
//        return subNavDao.list(conditions);
//    }

    @Override
    public List<SubNav> listAllSubOfMainNav(String mainNavId) throws BaseException {
        Conditions conditions=new Conditions();
        conditions.eq("main_nav_id",mainNavId);
        return subNavDao.list(conditions);
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return subNavDao.count(conditions);
    }

    @Override
    public Page<SubNav> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return subNavDao.page(conditions,offset,pageSize);
    }
}
