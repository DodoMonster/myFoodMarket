package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.SpecialOffer;

import java.util.List;

/**
 * Created by YWY on 2016/3/18.
 */
public interface ISpecialOfferService {
    String addSpecialOffer(SpecialOffer specialOffer) throws BaseException;

    void update(SpecialOffer specialOffer, Conditions conditions) throws BaseException;

    void updateById(SpecialOffer specialOffer) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    SpecialOffer find(Conditions conditions) throws BaseException;

    SpecialOffer findById(String id) throws BaseException;

    SpecialOffer findByEntity(SpecialOffer specialOffer) throws BaseException;

    List<SpecialOffer> list(Conditions conditions) throws BaseException;
}