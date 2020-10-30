package cn.sinobest.sso.filter;

import cn.sinobest.framework.util.sys.CookieUtil;
import cn.sinobest.framework.util.sys.SysUtil;
import cn.sinobest.sso.constant.AuthConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @ClassName LogoutFilter
 * @Desc
 * @Author 柯雷
 * @Date 2020/10/28 15:20
 * @Version 1.0
 */
@Component
public class LogoutFilter extends HandlerInterceptorAdapter {

    /** 日志打印对象 */
    Logger logger = LoggerFactory.getLogger(LogoutFilter.class);

    /**
     * @Description: 退出拦截器
     * @Params: [request, response, handler]
     * @return: boolean
     * @Author: 柯雷
     * @Date: 2020/10/28 15:06
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("【LogoutFilter.preHandle】退出拦截器");

        String cookie = CookieUtil.getCookieValue(request, AuthConstant.TOKEN);
        System.err.println(request.getRequestURI());
        if (!SysUtil.isEmpty(cookie) && AuthConstant.LOGUOUT_URI.equals(request.getRequestURI())) {
            // 重定向到认证中心的退出
            response.sendRedirect(AuthConstant.LOGOUT_URL);
        }
        return false;
    }
}
