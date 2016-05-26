package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.CommodityCarousel;

import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
public interface ICommodityCarouselService {
    String addCommodityCarousel(CommodityCarousel commodityCarousel) throws BaseException;

    void update(CommodityCarousel commodityCarousel, Conditions conditions) throws BaseException;

    void updateById(CommodityCarousel commodityCarousel) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    void deleteByIds(Object... ids) throws BaseException;

    CommodityCarousel find(Conditions conditions) throws BaseException;

    CommodityCarousel findById(String id) throws BaseException;

    List<CommodityCarousel> list(Conditions conditions) throws BaseException;

    long count(Conditions conditions) throws BaseException;

    Page<CommodityCarousel> findPage(Conditions conditions,int offset,int pageSize) throws BaseException;
}
