package net.gondr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.gondr.domain.UserVO;
import net.gondr.domain.YYSampleVO;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@RequestMapping(value="regist", method=RequestMethod.GET)
	public String viewRegistPage() {
		return "user/regist";
	}
	@RequestMapping(value="regist", method=RequestMethod.POST)
	public String registProcess(YYSampleVO user) {
		return "redirect:/world/" + user.getUserid();
	}
	
	@RequestMapping(value="regist2", method=RequestMethod.GET)
	public String viewRegist2Page() {
		return "user/regist2";
	}
	@RequestMapping(value="regist2", method=RequestMethod.POST)
	public String regist2Process(YYSampleVO user,Model model) {
		return "redirect:/world/" + user.getUserid();
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String viewLoginPage() {
		return "user/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String loginProcess(UserVO user, HttpSession session) {
		if(user.getUserid().equals("gondr") && user.getPassword().equals("1234")) {
			session.setAttribute("user", user);
			return "redirect:/main";//메인페이지로 이동
		}else {
			return "redirect:/user/login"; 
		}
		
		
	}
}

