package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.CarouselPicDao;
import scau.zxck.entity.admin.CarouselPic;
import scau.zxck.service.admin.ICarouselPicService;

import java.util.List;

/**
 * Created by ZZWEI on 2016/3/18.
 */
@Service
public class CarouselPicServiceImpl implements ICarouselPicService{
    @Autowired
    private CarouselPicDao carouselPicDao;

    @Override
    public String addCarouselPic(CarouselPic carouselPic) throws BaseException {
        return carouselPicDao.add(carouselPic);
    }

    @Override
    public void update(CarouselPic carouselPic, Conditions conditions) throws BaseException {
        carouselPicDao.update(carouselPic, conditions);
    }

    @Override
    public void updateById(CarouselPic carouselPic) throws BaseException {
        carouselPicDao.updateById(carouselPic);
    }


    @Override
    public void delete(Conditions conditions) throws BaseException {
        carouselPicDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        carouselPicDao.deleteByIds(ids);
    }

    @Override
    public CarouselPic find(Conditions conditions) throws BaseException {
        return carouselPicDao.find(conditions);
    }

    @Override
    public CarouselPic findById(String id) throws BaseException {
        return carouselPicDao.findById(id);
    }

    @Override
    public CarouselPic findByEntity(CarouselPic carouselPic) throws BaseException {
        return carouselPicDao.findByEntity(carouselPic);
    }

    @Override
    public List<CarouselPic> list(Conditions conditions) throws BaseException {
        return carouselPicDao.list(conditions);
    }

    @Override
    public List<CarouselPic> listByEntity(CarouselPic carouselPic) throws BaseException {
        return carouselPicDao.listByEntity(carouselPic);
    }

    @Override
    public List<CarouselPic> listAll()throws BaseException{
        return carouselPicDao.listAll();
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return carouselPicDao.count(conditions);
    }

    @Override
    public Page<CarouselPic> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return carouselPicDao.page(conditions,offset,pageSize);
    }
}
