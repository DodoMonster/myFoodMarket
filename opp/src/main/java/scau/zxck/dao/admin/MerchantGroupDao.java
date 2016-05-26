package scau.zxck.dao.admin;

import org.springframework.stereotype.Repository;
import scau.zxck.base.constants.ErrorCode;
import scau.zxck.base.dao.BaseDao;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.MerchantGroup;

/**
 * Created by ZZWEI on 2016/3/18.
 */
@Repository
public class MerchantGroupDao extends BaseDao<MerchantGroup>{
    public MerchantGroup findByName(String name) throws BaseException{
        try {
            return getSqlSession().selectOne(getMapperId("selectMerchantByName"),name);
        } catch (Exception e) {
            throw new BaseException(e, ErrorCode.DB_STORE_ERROR);
        }
    }
}
