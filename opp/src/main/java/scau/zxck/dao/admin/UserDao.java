package scau.zxck.dao.admin;

import org.springframework.stereotype.Repository;
import scau.zxck.base.constants.ErrorCode;
import scau.zxck.base.dao.BaseDao;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.User;

import java.util.List;

/**
 * Created by suruijia on 2015/10/22.
 */
@Repository
public class UserDao extends BaseDao<User> {
    public User findFetchUserRole(String username) throws BaseException {
        try {
            return getSqlSession().selectOne(getMapperId("selectUserFetchUserRole"),username);
        } catch (Exception e) {
            throw new BaseException(e, ErrorCode.DB_STORE_ERROR);
        }
    }


}
