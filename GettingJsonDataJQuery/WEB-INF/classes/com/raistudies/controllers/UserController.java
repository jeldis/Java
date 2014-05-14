package com.raistudies.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raistudies.domain.JsonResponse;
import com.raistudies.domain.User;

@Controller
public class UserController {
	private List<User> userList = new ArrayList<User>(); 
	
	@RequestMapping(value="/AddUser.htm",method=RequestMethod.GET)
	public String showForm(){
		return "AddUser";
	}
	
	@RequestMapping(value="/AddUser.htm",method=RequestMethod.POST)
	public @ResponseBody JsonResponse addUser(@ModelAttribute(value="user") User user, BindingResult result ){
		JsonResponse res = new JsonResponse();
		if(!result.hasErrors()){
			userList.add(user);
			res.setStatus("SUCCESS");
		}else{
			res.setStatus("FAIL");
		}
		res.setResult(user);
		return res;
	}

	@RequestMapping(value="/ShowUsers.htm")
	public String showUsers(ModelMap model){
		model.addAttribute("Users", userList);
		return "ShowUsers";
	}
}
