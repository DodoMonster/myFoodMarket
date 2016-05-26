package scau.zxck.serviceImpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.dao.admin.AdvertisementDao;
import scau.zxck.entity.admin.Advertisement;
import scau.zxck.service.admin.IAdvertisementService;

import java.util.List;

/**
 * Created by YWY on 2016/3/21.
 */

@Service
public class AdvertisementService implements IAdvertisementService {
    @Autowired
    AdvertisementDao advertisementDao;

    @Override
    public String addAdvertisement(Advertisement advertisement) throws BaseException {
        return advertisementDao.add(advertisement);
    }

    @Override
    public void update(Advertisement advertisement, Conditions conditions) throws BaseException {
        advertisementDao.update(advertisement,conditions);
    }

    @Override
    public void updateById(Advertisement advertisement) throws BaseException {
        advertisementDao.updateById(advertisement);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        advertisementDao.delete(conditions);
    }

    @Override
    public Advertisement find(Conditions conditions) throws BaseException {
        return advertisementDao.find(conditions);
    }

    @Override
    public Advertisement findById(String id) throws BaseException {
        return advertisementDao.findById(id);
    }

    @Override
    public Advertisement findByEntity(Advertisement advertisement) throws BaseException {
        return advertisementDao.findByEntity(advertisement);
    }

    @Override
    public List<Advertisement> list(Conditions conditions) throws BaseException {
        return advertisementDao.list(conditions);
    }
}
