package cn.sinobest.ssoclient.filter;

import cn.sinobest.ssoclient.constant.AuthConstant;
import cn.sinobest.ssoclient.storage.SessionStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

        HttpSession session = request.getSession();

        // 已经登录，放行
        if (session.getAttribute(AuthConstant.IS_LOGIN) != null) {
            return true;
        }
        // 从认证中心回跳的带有token的请求，有效则放行
        String token = request.getParameter(AuthConstant.TOKEN);
        if (token != null) {
            session.setAttribute(AuthConstant.IS_LOGIN, true);
            session.setAttribute(AuthConstant.TOKEN, token);
            // 存储，用于注销
            SessionStorage.INSTANCE.set(token, session);
            return true;
        }

        System.err.println(request.getRequestURL());
        // 重定向至登录页面，并附带当前请求地址
        response.sendRedirect(AuthConstant.LOGIN_URL + "?"
                + AuthConstant.CLIENT_URL + "=" + request.getRequestURL());
        return true;
    }
}
