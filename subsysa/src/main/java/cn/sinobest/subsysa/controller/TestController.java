package cn.sinobest.subsysa.controller;

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
	@RequestMapping("/subsysa")
	public String success(HttpServletRequest request, Model model) {
		return "success";
	}
}