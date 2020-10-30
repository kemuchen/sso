package cn.sinobest.sso.constant;

/**
 * @ClassName AuthConstant
 * @Desc
 * @Author 柯雷
 * @Date 2020/10/28 14:06
 * @Version 1.0
 */
public interface AuthConstant {

    /** 登录中心url */
    String LOGIN_URL = "http://localhost:8080";

    /** 注销url */
    String LOGOUT_URL = "http://localhost:8080/logout";

    /** 客户端url */
    String CLIENT_URL = "clientUrl";

    /** 授权令牌 */
    String TOKEN = "token";

    /** 退出登录uri */
    String LOGUOUT_URI = "/logout";

    /** 默认登录成功界面 */
    String LOGIN_SUCCESS = "http://localhost:8080/success";
}
