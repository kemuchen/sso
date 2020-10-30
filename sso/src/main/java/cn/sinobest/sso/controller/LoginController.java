package cn.sinobest.sso.controller;

import cn.sinobest.framework.util.sys.CookieUtil;
import cn.sinobest.sso.constant.AuthConstant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 登录和注销控制器
 * 
 * @author sheefee
 * @date 2017年9月12日 下午2:09:47
 *
 */
@Controller
public class LoginController {

	/**
	 * 登录
	 * 
	 * @author sheefee
	 * @date 2017年9月12日 下午2:09:24
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		// 授权
		String token = UUID.randomUUID().toString();

		CookieUtil.setCookie(request, response, AuthConstant.TOKEN, token);

		// 子系统跳转过来的登录请求，授权、存储后，跳转回去
		String clientUrl = request.getParameter(AuthConstant.CLIENT_URL);
		if (clientUrl != null && !"".equals(clientUrl)) {
			return "redirect:" + clientUrl;
		}
		return "redirect:/";
	}

	/**
	 * 注销
	 *
	 * @author sheefee
	 * @date 2017年9月12日 下午2:08:51
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CookieUtil.deleteCookie(request, response, AuthConstant.TOKEN);
		return "redirect:/" + "?" + AuthConstant.CLIENT_URL + "=" + AuthConstant.LOGIN_SUCCESS;
	}
}