package scau.zxck.web.shiro;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.User;
import scau.zxck.service.IAccountService;


/**
 * Created by lishunpeng on 2015/10/28.
 */
public class UserRealm extends AuthorizingRealm {
    private static Logger logger = Logger.getLogger(UserRealm.class);

    @Autowired
    private IAccountService accountService;

    /**
     * 授权
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录时输入的用户名
        String username = (String) principalCollection.fromRealm(getName()).iterator().next();
        try {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.setRoles(accountService.listRolesByUsername(username));
            simpleAuthorizationInfo.addStringPermissions(accountService.listPermissionsByUserName(username));
            return simpleAuthorizationInfo;
        } catch (BaseException e) {
            e.printStackTrace();
            logger.error("Shiro 授权错误。", e);
        }
        return null;
    }

    /**
     * 认证
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //UsernamePasswordToken对象用于存放提交的登录信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        //查出是否有此用户
        try {
            User user = accountService.findUserByUserName(username);
            if (null == user) {

                throw new UnknownAccountException();//没找到帐号
            }
            //若存在，将此用户存放到登录认证info中
            return new SimpleAuthenticationInfo(
                    user.getUsername(), //用户名
                    user.getPassword(), //密码
                    ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                    getName()  //realm name
            );
        } catch (BaseException e) {
            logger.error("Shiro 认证错误。", e);
        }
        return null;
    }
}
