package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.dao.utils.Page;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.CommodityCarouselDao;
import scau.zxck.entity.admin.CommodityCarousel;
import scau.zxck.service.admin.ICommodityCarouselService;

import java.util.List;

/**
 * Created by 追追 on 2016/3/17.
 */
@Service
public class CommodityCarouselServiceImpl implements ICommodityCarouselService {

    @Autowired
    private CommodityCarouselDao commodityCarouselDao;

    @Override
    public String addCommodityCarousel(CommodityCarousel commodityCarousel) throws BaseException {
        return commodityCarouselDao.add(commodityCarousel);
    }

    @Override
    public void update(CommodityCarousel commodityCarousel, Conditions conditions) throws BaseException {
        commodityCarouselDao.update(commodityCarousel,conditions);
    }

    @Override
    public void updateById(CommodityCarousel commodityCarousel) throws BaseException {
        commodityCarouselDao.updateById(commodityCarousel);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        commodityCarouselDao.delete(conditions);
    }

    @Override
    public void deleteByIds(Object... ids) throws BaseException {
        commodityCarouselDao.deleteByIds(ids);
    }

    @Override
    public CommodityCarousel find(Conditions conditions) throws BaseException {
        return commodityCarouselDao.find(conditions);
    }

    @Override
    public CommodityCarousel findById(String id) throws BaseException {
        return commodityCarouselDao.findById(id);
    }

    @Override
    public List<CommodityCarousel> list(Conditions conditions) throws BaseException {
        return commodityCarouselDao.list(conditions);
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return commodityCarouselDao.count(conditions);
    }

    @Override
    public Page<CommodityCarousel> findPage(Conditions conditions, int offset, int pageSize) throws BaseException {
        return commodityCarouselDao.page(conditions,offset,pageSize);
    }
}
