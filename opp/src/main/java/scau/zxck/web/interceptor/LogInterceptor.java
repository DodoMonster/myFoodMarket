package scau.zxck.web.interceptor;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.entity.admin.Permissions;
import scau.zxck.entity.admin.Resources;
import scau.zxck.service.IAccountService;
import scau.zxck.service.admin.IPermissionsService;
import scau.zxck.service.admin.IResourcesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by leeshunpeng on 2015/6/17.
 */
/* 自定义拦截器需要实现 HandlerInterceptor接口 或者 扩展 HandlerInterceptorAdapter类 */
public class LogInterceptor implements HandlerInterceptor{/*extends HandlerInterceptorAdapter*/
    private static Logger logger = Logger.getLogger(scau.zxck.web.interceptor.LogInterceptor.class);

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IResourcesService iResourcesService;

    @Autowired
    private IPermissionsService iPermissionsService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object obj) throws Exception {
        if(obj != null){
            logger.info("preHandle:" + JSON.toJSONString(obj));
            logger.info("===========================================in LogInterceptor===============================================================");
            logger.info("===========================================in LogInterceptor===============================================================");
            logger.info("===========================================in LogInterceptor===============================================================");
            logger.info("===========================================in LogInterceptor===============================================================");
            logger.info("===========================================in LogInterceptor===============================================================");

            logger.info(httpServletRequest.getServletPath());
            String[] servletPath = httpServletRequest.getServletPath().split("/");

            Resources resources = iResourcesService.findPermissionByUrl(servletPath[servletPath.length-2]+"/"+servletPath[servletPath.length-1]);
            if(resources == null){
                logger.info("找不到资源");
                return false;
            }
            logger.info("resources:" + JSON.toJSONString(resources));
            Permissions permissions = iPermissionsService.findById(resources.getPermissionId());

            if(null == permissions){
                logger.info("找不到权限");
                return false;
            }

            if(!SecurityUtils.getSubject().isPermitted(permissions.getPermission())){//test.do
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object obj, ModelAndView modelAndView) throws Exception {
        if(obj != null && modelAndView != null){
            logger.info("postHandle:" + JSON.toJSONString(obj));
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object obj, Exception e) throws Exception {
        if(obj != null){
            logger.info("afterCompletion:" + JSON.toJSONString(obj));
        }
    }
}
