package scau.zxck.dao.admin;

import org.springframework.stereotype.Repository;
import scau.zxck.base.constants.ErrorCode;
import scau.zxck.base.dao.BaseDao;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.Resources;

/**
 * Created by suruijia on 2015/10/22.
 */
@Repository
public class ResourcesDao extends BaseDao<Resources> {
    public Resources findPermissionByUrl(String url) throws BaseException {
        try {
            return getSqlSession().selectOne(getMapperId("findPermissionByUrl"), url);
        } catch (Exception e) {
            throw new BaseException(e, ErrorCode.DB_STORE_ERROR);
        }
    }
}
