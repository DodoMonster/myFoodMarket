package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.Advertisement;

import java.util.List;

/**
 * Created by YWY on 2016/3/18.
 */
public interface IAdvertisementService {
    String addAdvertisement(Advertisement advertisement) throws BaseException;

    void update(Advertisement advertisement, Conditions conditions) throws BaseException;

    void updateById(Advertisement advertisement) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    Advertisement find(Conditions conditions) throws BaseException;

    Advertisement findById(String id) throws BaseException;

    Advertisement findByEntity(Advertisement advertisement) throws BaseException;

    List<Advertisement> list(Conditions conditions) throws BaseException;
}