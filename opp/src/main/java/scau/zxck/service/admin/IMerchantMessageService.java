package scau.zxck.service.admin;

import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.MerchantMessage;

import java.util.List;

/**
 * Created by YWY on 2016/3/18.
 */
public interface IMerchantMessageService {
    String add(MerchantMessage merchantMessage) throws BaseException;

    void update(MerchantMessage merchantMessage, Conditions conditions) throws BaseException;

    void updateById(MerchantMessage merchantMessage) throws BaseException;

    void delete(Conditions conditions) throws BaseException;

    MerchantMessage find(Conditions conditions) throws BaseException;

    MerchantMessage findById(String id) throws BaseException;

    MerchantMessage findByEntity(MerchantMessage merchantMessage) throws BaseException;

    List<MerchantMessage> list(Conditions conditions) throws BaseException;
}