package com.demo.controllers.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.entities.Nhanvien;
import com.demo.helpers.RandomHelper;

import com.demo.services.AccountService;
import com.demo.services.QuyenService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "account" }) // multi-link
public class AccountController {
	@Autowired
	private AccountService nhanvienService;

	@Autowired
	private QuyenService roleService;

	@Autowired
	private Environment environment;

	@Autowired
	private BCryptPasswordEncoder encoder;


	@RequestMapping(value = { "login" }, method = RequestMethod.GET)
	public String login(@RequestParam(value = "failed", required = false) String failed, ModelMap modelMap) {
		if (failed != null) {
			modelMap.put("msg", "Re-check your information");
		}
		return "account/login";
	}

	
	
}
