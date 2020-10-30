package cn.sinobest.subsysb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {
	@RequestMapping("/test")
	public String test(HttpServletRequest request, Model model) {
		return "test";
	}
	@RequestMapping("/subsysb")
	public String success(HttpServletRequest request, Model model) {
		return "success";
	}
}