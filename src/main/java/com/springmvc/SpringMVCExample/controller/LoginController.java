package com.springmvc.SpringMVCExample.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.SpringMVCExample.model.BlogPost;
import com.springmvc.SpringMVCExample.model.Login;
import com.springmvc.SpringMVCExample.model.User;
import com.springmvc.SpringMVCExample.service.UserServiceImpl;

@Controller
public class LoginController {
	@Autowired
	UserServiceImpl userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)

	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Login login) {
		ModelAndView mav = null;
		List<BlogPost> blogs = userService.validateUser(login);
		if (null != blogs) {
			mav = new ModelAndView("welcome");
			// mav.addObject("Username", user.getUsername());
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}
}