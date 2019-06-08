package com.example.springbootmybatisdemo1.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.example.springbootmybatisdemo1.entity.User;
import com.example.springbootmybatisdemo1.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * 登录
	 * 
	 * @return 字符串“login”
	 */
	@RequestMapping(value = "/login")
	public String loginin() {
		return "login";
	}

	/**
	 * 注册
	 * 
	 * @return 字符串“signup”
	 */
	@RequestMapping(value = "/signup")
	public String signup() {
		return "signup";
	}

	/**
	 * 验证username和password在数据库中是否存在，并返回到相对应的结果页面
	 */
	@RequestMapping(value = "/loginResult")
	public String loginResult(User user, Model model) {
		System.out.println("user:" + user);
		User getUser = userService.selectUser(user);
		// System.out.println("getUser:" + getUser);
		// return "fail";
		if (getUser == null) {
			model.addAttribute("msg", "用户名或者密码错误！！");
			return "fail";
		} else {
			model.addAttribute("msg", "登录成功！！！");
			return "success";
		}
	}

	/**
	 * 转换日期格式
	 * @param binder
	 * @param request
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		// 转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
	}

	/**
	 * 调用业务逻辑，将获取到的user对象信息放入user表中
	 */
	@RequestMapping(value = "/signupResult")
	public String signupResult(User user, Model model) {
		System.out.println("user:" + user);
		int insetUser = userService.insertUser(user);
		System.out.println("insetUser:" + insetUser);
		if (insetUser == 1) {
			model.addAttribute("msg", "注册成功！");
			return "success";
		} else {
			model.addAttribute("msg", "注册失败！");
			return "fail";
		}
	}

}
