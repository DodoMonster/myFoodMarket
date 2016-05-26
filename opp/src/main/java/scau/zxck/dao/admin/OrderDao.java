package scau.zxck.dao.admin;

import org.springframework.stereotype.Repository;
import scau.zxck.base.constants.ErrorCode;
import scau.zxck.base.dao.BaseDao;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.Order;

/**
 * Created by ZZWEI on 2016/3/17.
 */
@Repository
public class OrderDao extends BaseDao<Order>{
    public Order findByIdentifier(String identifier) throws BaseException{
        try{
            return getSqlSession().selectOne("selectOrderByIdentifier",identifier);
        }catch (Exception e){
            throw new BaseException(e, ErrorCode.DB_STORE_ERROR);
        }
    }
}
