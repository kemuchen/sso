package cn.sinobest.ssoserver.controller;

import cn.sinobest.framework.util.http.HttpUtil;
import cn.sinobest.ssoclient.constant.AuthConstant;
import cn.sinobest.ssoclient.storage.SessionStorage;
import cn.sinobest.ssoserver.storage.ClientStorage;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	public String login(HttpServletRequest request, Model model) {
		// 授权
		String token = UUID.randomUUID().toString();
		request.getSession().setAttribute(AuthConstant.IS_LOGIN, true);
		request.getSession().setAttribute(AuthConstant.TOKEN, token);
		
		// 存储，用于注销
		SessionStorage.INSTANCE.set(token, request.getSession());

		// 子系统跳转过来的登录请求，授权、存储后，跳转回去
		String clientUrl = request.getParameter(AuthConstant.CLIENT_URL);
		if (clientUrl != null && !"".equals(clientUrl)) {
			// 存储，用于注销
			ClientStorage.INSTANCE.set(token, clientUrl);
			return "redirect:" + clientUrl + "?" + AuthConstant.TOKEN + "=" + token;
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
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String token = request.getParameter(AuthConstant.LOGOUT_REQUEST);
		
		// token存在于请求中，表示从客户端发起的注销；token存在于会话中，表示从认证中心发起的注销
		if (token != null && !"".equals(token)) {
			session = SessionStorage.INSTANCE.get(token);
		} else {
			token = (String) session.getAttribute(AuthConstant.TOKEN);
		}
		
		if (session != null) {
			session.invalidate();
		}
		
		// 注销子系统
		List<String> list = ClientStorage.INSTANCE.get(token);
		if (list != null && list.size() > 0) {
			Map<String, String> params = new HashMap<String, String>();
			params.put(AuthConstant.LOGOUT_REQUEST, token);
			for (String url : list) {
				HttpUtil.post(url, JSONObject.toJSONString(params), null);
			}
		}
		
		return "redirect:/";
	}
}