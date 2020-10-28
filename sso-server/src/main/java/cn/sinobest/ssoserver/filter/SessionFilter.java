package cn.sinobest.ssoserver.filter;

import cn.sinobest.ssoclient.constant.AuthConstant;
import cn.sinobest.ssoserver.storage.ClientStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName SessionFilter
 * @Desc
 * @Author 柯雷
 * @Date 2020/10/28 15:28
 * @Version 1.0
 */
@Component
public class SessionFilter extends HandlerInterceptorAdapter {

    /** 日志打印对象 */
    Logger logger = LoggerFactory.getLogger(SessionFilter.class);

    /**
     * @Description: session拦截器
     * @Params: [request, response, handler]
     * @return: boolean
     * @Author: 柯雷
     * @Date: 2020/10/28 15:30
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("【SessionFilter.preHandle】session拦截器");
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();

        // 注销请求，放行
        if ("/logout".equals(uri)) {
            return true;
        }

        // 已经登录，放行
        if (session.getAttribute(AuthConstant.IS_LOGIN) != null) {
            // 如果是客户端发起的登录请求，跳转回客户端，并附带token
            String clientUrl = request.getParameter(AuthConstant.CLIENT_URL);
            String token = (String) session.getAttribute(AuthConstant.TOKEN);
            if (clientUrl != null && !"".equals(clientUrl)) {
                // 存储，用于注销
                ClientStorage.INSTANCE.set(token, clientUrl);
                response.sendRedirect(clientUrl + "?" + AuthConstant.TOKEN + "=" + token);
                return super.preHandle(request, response, handler);
            }
            if (!"/success".equals(uri)) {
                response.sendRedirect("/success");
            }
            return true;
        }
        // 登录请求，放行
        if ("/".equals(uri) || "/login".equals(uri)) {
            return true;
        }

        // 其他请求，拦截
        response.sendRedirect("/");
        return super.preHandle(request, response, handler);
    }
}
