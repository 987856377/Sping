package com.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.model.User;
import com.ssm.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("result")
	public String getResult(Model model){
		User user = userService.getUserById(4);
		model.addAttribute("message", "User info: "+user);
		return "result";
	}
	
	@RequestMapping("toInsert")
	public String toInsert(){
		return "insert";
	}
	
	@RequestMapping("insertResult")
	public String insertResult(Model model,@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("age") int age){
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setAge(age);
		userService.addUser(user);
		model.addAttribute("message","ok");
		return "result";
	}
	
	@RequestMapping("updateUser")
	public String updateResult(Model model){
		User user = new User();
		user.setId(4);
		user.setUsername("frank");
		user.setPassword("123");
		user.setAge(25);
		userService.updateUser(user);
		model.addAttribute("message", "update success");
		return "result";
	}
	
	@RequestMapping("deleteUser")
	public String deleteResult(Model model){
		userService.deleteUser(4);
		model.addAttribute("message", "delete success");
		return "result";
	}
	
	@RequestMapping("allUser")
	public String getAllResult(Model model){
		List<User> userList = userService.getAllUser();
		model.addAttribute("message", userList);
		return "result";
	}
	
	@RequestMapping("toMV")
	public ModelAndView getView(){
		ModelAndView mv = new ModelAndView("result");
		mv.addObject("message", "Hello ModelAndView");
		return mv;
	}
	
}
