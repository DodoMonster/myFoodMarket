package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.ResourcesDao;
import scau.zxck.entity.admin.Resources;
import scau.zxck.service.admin.IResourcesService;

import java.util.List;

/**
 * Created by suruijia on 2015/11/8.
 */
@Service
public class ResourcesServiceImpl implements IResourcesService {

    @Autowired
    private ResourcesDao resourcesDao;

    @Override
    public String addResources(Resources resources) throws BaseException {
        return resourcesDao.add(resources);
    }

    @Override
    public void update(Resources resources, Conditions conditions) throws BaseException {
        resourcesDao.update(resources,conditions);
    }

    @Override
    public void updateById(Resources resources) throws BaseException {
        resourcesDao.updateById(resources);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        resourcesDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        resourcesDao.deleteByIds(ids);
    }

    @Override
    public Resources find(Conditions conditions) throws BaseException {
        return resourcesDao.find(conditions);
    }

    @Override
    public Resources findById(String id) throws BaseException {
        return resourcesDao.findById(id);
    }

    @Override
    public Resources findByEntity(Resources resources) throws BaseException {
        return resourcesDao.findByEntity(resources);
    }

    @Override
    public Resources findPermissionByUrl(String url) throws BaseException {
        return resourcesDao.findPermissionByUrl(url);
    }


    @Override
    public List<Resources> list(Conditions conditions) throws BaseException {
        return resourcesDao.list(conditions);
    }

    @Override
    public List<Resources> listByEntity(Resources resources, String... propertyName) throws BaseException {
        return resourcesDao.listByEntity(resources,propertyName);
    }

    @Override
    public List<Resources> listAscByParentIdAndPriority() throws BaseException {
        Conditions conditions = new Conditions();
        conditions.asc("parent_id","priority");
        return resourcesDao.list(conditions);
    }

    @Override
    public List<Resources> listByNameUsingLike(String name) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.like("name","%"+name+"%");
        List<Resources> resourcesList = resourcesDao.list(conditions);
        return resourcesList;
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return resourcesDao.count(conditions);
    }

    @Override
    public Page<Resources> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return resourcesDao.page(conditions,offset,pageSize);
    }
}
