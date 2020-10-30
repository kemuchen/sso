package cn.sinobest.subsysa.config;

import cn.sinobest.sso.filter.LoginFilter;
import cn.sinobest.sso.filter.LogoutFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName WebMvcConfig
 * @Desc
 * @Author 柯雷
 * @Date 2019/12/26 12:36
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /** 登录拦截器 */
    @Autowired
    LoginFilter loginFilter;

    /** 退出拦截器 */
    @Autowired
    LogoutFilter logoutFilter;

    /**
     * @param ：@param registry
     * @return ：void
     * @throws
     * @Title：addInterceptors
     * @Description：添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginFilter).addPathPatterns("/*").excludePathPatterns("/logout");  // 拦截所有
        registry.addInterceptor(logoutFilter).addPathPatterns("/logout");  // 拦截logout
        super.addInterceptors(registry);
    }

    /**
     * <p>Title：addResourceHandlers</p>
     * <p>Description：配置静态资源访问 </p>
     *
     * @param registry
     * @see #addResourceHandlers(ResourceHandlerRegistry)
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }
}
