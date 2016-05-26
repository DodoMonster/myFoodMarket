package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.SpecialOfferDao;
import scau.zxck.entity.admin.SpecialOffer;
import scau.zxck.service.admin.ISpecialOfferService;

import java.util.List;

/**
 * Created by YWY on 2016/3/21.
 */
@Service
public class SpecialOfferService implements ISpecialOfferService {
    @Autowired
    SpecialOfferDao specialOfferDao;

    @Override
    public String addSpecialOffer(SpecialOffer specialOffer) throws BaseException {
        return specialOfferDao.add(specialOffer);
    }

    @Override
    public void update(SpecialOffer specialOffer, Conditions conditions) throws BaseException {
        specialOfferDao.update(specialOffer,conditions);
    }

    @Override
    public void updateById(SpecialOffer specialOffer) throws BaseException {
        specialOfferDao.updateById(specialOffer);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        specialOfferDao.delete(conditions);
    }

    @Override
    public SpecialOffer find(Conditions conditions) throws BaseException {
        return specialOfferDao.find(conditions);
    }

    @Override
    public SpecialOffer findById(String id) throws BaseException {
        return specialOfferDao.findById(id);
    }

    @Override
    public SpecialOffer findByEntity(SpecialOffer specialOffer) throws BaseException {
        return specialOfferDao.findByEntity(specialOffer);
    }

    @Override
    public List<SpecialOffer> list(Conditions conditions) throws BaseException {
        return specialOfferDao.list(conditions);
    }
}
