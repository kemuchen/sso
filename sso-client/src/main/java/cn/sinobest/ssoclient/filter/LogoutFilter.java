package cn.sinobest.ssoclient.filter;

import cn.sinobest.framework.util.http.HttpUtil;
import cn.sinobest.ssoclient.constant.AuthConstant;
import cn.sinobest.ssoclient.storage.SessionStorage;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
        logger.info("【LogoutFilter.preHandle】登录拦截器");
        HttpSession session = request.getSession();

        String logoutUrl = request.getParameter(AuthConstant.LOGOUT_URL);
        String token = (String) session.getAttribute(AuthConstant.TOKEN);

        // 主动注销，即子系统提供的注销请求
        if ("/logout".equals(request.getRequestURI())) {
            // 向认证中心发送注销请求
            Map<String, String> params = new HashMap<String, String>();
            params.put(AuthConstant.LOGOUT_REQUEST, token);
            HttpUtil.post(logoutUrl, JSONObject.toJSONString(params), null);
            // 注销后重定向
            response.sendRedirect("/test");
            // 注销本地会话
            session = SessionStorage.INSTANCE.get(token);
            if (session != null) {
                session.invalidate();
            }
            return true;
        }

        // 被动注销，即从认证中心发送的注销请求
        token = request.getParameter(AuthConstant.LOGOUT_REQUEST);
        if (token != null && !"".equals(token)) {
            session = SessionStorage.INSTANCE.get(token);
            if (session != null) {
                session.invalidate();
            }
        }
        return true;
    }
}
