package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.CarouselPic;

import java.util.List;

/**
 * Created by ZZWEI on 2016/3/18.
 */
public interface ICarouselPicService {
    String addCarouselPic(CarouselPic carouselPic)throws BaseException;

    void update(CarouselPic carouselPic, Conditions conditions) throws BaseException;

    void updateById(CarouselPic carouselPic) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    CarouselPic find(Conditions conditions) throws BaseException;

    CarouselPic findById(String id) throws BaseException;

    CarouselPic findByEntity(CarouselPic carouselPic) throws BaseException;

    List<CarouselPic> list(Conditions conditions) throws BaseException;

    List<CarouselPic> listByEntity(CarouselPic carouselPic) throws BaseException;

    List<CarouselPic> listAll()throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Page<CarouselPic> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;
}
