package cn.sinobest.ssoclient.constant;

/**
 * @ClassName AuthConstant
 * @Desc
 * @Author 柯雷
 * @Date 2020/10/28 14:06
 * @Version 1.0
 */
public interface AuthConstant {

    /** 会话是否授权标志 */
    String IS_LOGIN = "isLogin";

    /** 登录中心url */
    String LOGIN_URL = "http://localhost:8080";

    /** 注销url */
    String LOGOUT_URL = "http://localhost:8080/logout";

    /** 客户端url */
    String CLIENT_URL = "clientUrl";

    /** 授权令牌 */
    String TOKEN = "token";

    /** 注销请求 */
    String LOGOUT_REQUEST = "logoutRequest";
}
