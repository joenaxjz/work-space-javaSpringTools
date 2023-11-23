package com.demo.controllers.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.entities.Nhanvien;
import com.demo.services.AccountService;
import com.demo.services.DouutienService;
import com.demo.services.QuyenService;
import com.demo.services.RequestService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "admin/requests" }) // multi-link
public class AdminRequestController {
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private DouutienService douutienService;



	
	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		modelMap.put("requests", requestService.findAll());
		modelMap.put("douutiens", douutienService.findAll());
		return "admin/requests/index";
	}

	

	
}
