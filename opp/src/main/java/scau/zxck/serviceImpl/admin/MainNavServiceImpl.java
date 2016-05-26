package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.MainNavDao;
import scau.zxck.dao.admin.SubNavDao;
import scau.zxck.entity.admin.MainNav;
import scau.zxck.entity.admin.SubNav;
import scau.zxck.service.admin.IMainNavService;

import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
@Service
public class MainNavServiceImpl implements IMainNavService {

    @Autowired
    private MainNavDao mainNavDao;

    @Autowired
    private SubNavDao subNavDao;

    @Override
    public String addMainNav(MainNav mainNav) throws BaseException {
        return mainNavDao.add(mainNav);
    }

    @Override
    public void update(MainNav mainNav, Conditions conditions) throws BaseException {
        mainNavDao.update(mainNav,conditions);
    }

    @Override
    public void updateById(MainNav mainNav) throws BaseException {
        mainNavDao.updateById(mainNav);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        mainNavDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        mainNavDao.deleteByIds(ids);
    }

    @Override
    public MainNav find(Conditions conditions) throws BaseException {
        return mainNavDao.find(conditions);
    }

    @Override
    public MainNav findById(String id) throws BaseException {
        return mainNavDao.findById(id);
    }


    @Override
    public List<MainNav> listMainNavByBelongTo(String belongTo) throws BaseException {
//        List<MainNav> mainNavList = mainNavDao.list(null);//找出所有的mainNav
        Conditions conditions=new Conditions();
        conditions.eq("belong_to",belongTo);
        List<MainNav> mainNavList=mainNavDao.list(conditions);
        return mainNavList;
    }

    @Override
    public List<MainNav> listAllMainNav()throws BaseException{
        List<MainNav> mainNavList=mainNavDao.list(null);
        return mainNavList;
    }


    @Override
    public long count(Conditions conditions) throws BaseException {
        return mainNavDao.count(conditions);
    }

    @Override
    public Page<MainNav> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return mainNavDao.page(conditions,offset,pageSize);
    }
}
