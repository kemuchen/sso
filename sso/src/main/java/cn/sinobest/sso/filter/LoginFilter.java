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
 * @ClassName LoginFilter
 * @Desc
 * @Author 柯雷
 * @Date 2020/10/28 15:02
 * @Version 1.0
 */
@Component
public class LoginFilter extends HandlerInterceptorAdapter {

    /**
     * 日志输出对象
     */
    Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    /**
     * @Description: 登录拦截器
     * @Params: [request, response, handler]
     * @return: boolean
     * @Author: 柯雷
     * @Date: 2020/10/28 15:06
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        logger.info("【LoginFilter.preHandle】登录拦截器");

        String cookie = CookieUtil.getCookieValue(request, AuthConstant.TOKEN);

        System.err.println(cookie);

        // 判断如果cookie不为空，则放行，否则跳转到登录界面
        if (SysUtil.isEmpty(cookie)) {
            // 重定向至登录页面，并附带当前请求地址
            response.sendRedirect(AuthConstant.LOGIN_URL + "?"
                    + AuthConstant.CLIENT_URL + "=" + request.getRequestURL());
        }
        return true;
    }
}
