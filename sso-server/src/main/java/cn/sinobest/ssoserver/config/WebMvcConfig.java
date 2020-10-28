package cn.sinobest.ssoserver.config;

import cn.sinobest.ssoclient.filter.LoginFilter;
import cn.sinobest.ssoclient.filter.LogoutFilter;
import cn.sinobest.ssoserver.filter.SessionFilter;
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
    SessionFilter sessionFilter;

    /**
     * @param ：@param registry
     * @return ：void
     * @throws
     * @Title：addInterceptors
     * @Description：添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionFilter).addPathPatterns("/**");  // 拦截所有
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
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
}
