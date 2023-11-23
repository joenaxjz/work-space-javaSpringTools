package com.demo.controllers.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.services.AccountService;
import com.demo.services.RequestService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "employee/dashboard" }) // multi-link
public class DashboardSupportEmployeeController {

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private AccountService nhanvienService;
	
	@GetMapping({ "index", "", "/"})
	public String index(Authentication authentication, HttpSession session, ModelMap modelMap) {
		modelMap.put("nhanvien", nhanvienService.findByUsername(authentication.getName()));
		return "employee/dashboard/index";
	}

	
}
