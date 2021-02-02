package net.gondr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.gondr.dao.UserDAO;
import net.gondr.domain.UserVO;
import net.gondr.domain.YYSampleVO;

@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserDAO dao;
	
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
			return "redirect:/";//메인페이지로 이동
		}else {
			return "redirect:/user/login"; 
		}
	}
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logoutProcess(UserVO user, HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/"; 
	}
	@RequestMapping(value="info",method=RequestMethod.GET)
	public String viewInfoPage(HttpSession session) {
		return "user/info";
	}
	@RequestMapping(value="data",method=RequestMethod.GET)
	public @ResponseBody UserVO getUserData() {
		UserVO temp = new UserVO();
		temp.setUserid("gondr");
		temp.setPassword("1234");
		temp.setUsername("김찬영");
		return temp;
	}
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String viewRegisterPage() {
		return "user/register";
	}
	@RequestMapping(value="register", method=RequestMethod.POST)
	public UserVO registerProcess(UserVO user) {
		UserVO temp = new UserVO();
		temp.setUserid(user.getUserid());
		temp.setPassword(user.getPassword());
		temp.setUsername(user.getUsername());
		dao.insertUser(temp);
		return temp;
	}
	@RequestMapping(value="data/{userid}", method=RequestMethod.GET)
	public @ResponseBody UserVO select(Model model,@PathVariable String userid) {
		UserVO userDATA = dao.selectUser(userid);
		return userDATA;
	}
	
	
}

