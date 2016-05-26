package scau.zxck.dao.admin;

import org.springframework.stereotype.Repository;
import scau.zxck.base.constants.ErrorCode;
import scau.zxck.base.dao.BaseDao;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.UserMessage;

/**
 * Created by ZZWEI on 2016/3/18.
 */
@Repository
public class UserMessageDao extends BaseDao<UserMessage>{
    public UserMessage findByNickname(String nickname)throws BaseException{
        try {
            return getSqlSession().selectOne(getMapperId("selectUserMessageByNickname"),nickname);
        } catch (Exception e) {
            throw new BaseException(e, ErrorCode.DB_STORE_ERROR);
        }
    }

    public UserMessage findByNicRealname(String realname) throws BaseException{
        try {
            return getSqlSession().selectOne(getMapperId("selectUserMessageByRealname"),realname);
        } catch (Exception e) {
            throw new BaseException(e, ErrorCode.DB_STORE_ERROR);
        }
    }
}
