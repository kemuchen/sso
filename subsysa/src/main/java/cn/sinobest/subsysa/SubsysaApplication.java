package cn.sinobest.subsysa;

import cn.sinobest.framework.util.sys.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication(scanBasePackages = "cn.sinobest.**")
@MapperScan(basePackages = "cn.sinobest.**.dao.**")
//@EnableEurekaClient 和 @EnableDiscoveryClient 都是让eureka发现该服务并注册到eureka上的注解
//相同点：都能让注册中心Eureka发现，并将该服务注册到注册中心上；
//不同点：@EnableEurekaClient只适用于Eureka作为注册中心，而@EnableDiscoveryClient可以是其他注册中心；
@EnableEurekaClient
//表示开启Fegin客户端
@EnableFeignClients
public class SubsysaApplication extends SpringBootServletInitializer {

    /**
     * @Description: 入口main方法
     * @Params: [args]
     * @return: void
     * @Author: 柯雷
     * @Date: 2019/12/25 9:35
     */
    public static void main(String[] args) {
        // 启动时设置spring上下文
        SpringUtil.setApplication(SpringApplication.run(SubsysaApplication.class, args));
    }

    /**
     * @Description: 打成war包时需要修改启动类
     * @Params: [builder]
     * @return: org.springframework.boot.builder.SpringApplicationBuilder
     * @Author: 柯雷
     * @Date: 2020-05-09 15:17
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SubsysaApplication.class);
    }

    /**
     * @Description: 修改启动类后重新设置spring上下文
     * @Params: [servletContext]
     * @return: void
     * @Author: 柯雷
     * @Date: 2020-05-09 15:18
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        SpringUtil.setApplication(WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext));
    }

}