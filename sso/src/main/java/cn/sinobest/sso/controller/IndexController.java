package cn.sinobest.sso.controller;

import cn.sinobest.sso.constant.AuthConstant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

/**
 * 认证中心页面显示控制器
 * 
 * @author sheefee
 * @date 2017年9月12日 下午2:17:19
 *
 */
@Controller
public class IndexController {
	/**
	 * 登录页面
	 * 
	 * @author sheefee
	 * @date 2017年9月12日 下午2:17:51
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String index(HttpServletRequest request, Model model) {
		model.addAttribute(AuthConstant.CLIENT_URL, request.getParameter(AuthConstant.CLIENT_URL));
		return "index";
	}

	/**
	 * 登录成功页面
	 * 
	 * @author sheefee
	 * @date 2017年9月12日 下午2:18:02
	 * @return
	 */
	@RequestMapping("/success")
	public String success() {
		return "success";
	}
}