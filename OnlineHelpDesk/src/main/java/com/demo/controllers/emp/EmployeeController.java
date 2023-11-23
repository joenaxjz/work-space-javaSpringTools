package com.demo.controllers.emp;

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
import com.demo.entities.Yeucau;
import com.demo.services.AccountService;
import com.demo.services.DouutienService;
import com.demo.services.QuyenService;
import com.demo.services.RequestService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "employee" }) // multi-link
public class EmployeeController {

	@Autowired
	private RequestService requestService;

	@Autowired
	private DouutienService douutienService;
	
	@Autowired
	private AccountService nhanvienService;
	
	@Autowired
	private QuyenService roleService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	
	@GetMapping({ "requests/create", "", "/"})
	public String index( Authentication authentication, HttpSession session, ModelMap modelMap) {
		Yeucau request = new Yeucau();
		modelMap.put("request", request);
		modelMap.put("douutiens", douutienService.findAll());
		return "employee/requests/create";
	}
	
	@RequestMapping(value = { "profile/index/{username}" }, method = RequestMethod.GET)
	public String profile(Authentication authentication, HttpSession session, ModelMap modelMap, @PathVariable("username") String username) {
		modelMap.put("nhanvien", nhanvienService.findByUsername(authentication.getName()));
		modelMap.put("roles", roleService.findAll());
		return "employee/profile/index";
	}
	
	@RequestMapping(value = { "profile/index" }, method = RequestMethod.POST)
	public String profile(@ModelAttribute("nhanvien") Nhanvien nhanvien, Authentication authentication,
			RedirectAttributes redirectAttribute) {
		Nhanvien currentAccount = nhanvienService.findByUsername(authentication.getName());
		currentAccount.setHoten(nhanvien.getHoten());
		currentAccount.setNgaysinh(nhanvien.getNgaysinh());
		if (nhanvienService.save(currentAccount)) {
			redirectAttribute.addFlashAttribute("msg", "Updated");
			return "redirect:/employee/dashboard";
		} else {
			redirectAttribute.addFlashAttribute("msg", "Failed");
			return "redirect:/employee/dashboard";
		}
	}
	
	@GetMapping({ "requestList/index/{username}"})
	public String requestsList(Authentication authentication, HttpSession session, ModelMap modelMap) {
		modelMap.put("requests", requestService.findByNhanvienGui(authentication.getName()));
		return "employee/requestList/index";
	}

	@RequestMapping(value = { "requests/create"}, method = RequestMethod.POST)
	public String register(Authentication authentication, @ModelAttribute("request") Yeucau request, RedirectAttributes redirectAttribute) {
		request.setNhanvienByManvGui(nhanvienService.findByUsername(authentication.getName()));
		request.setNhanvienByManvXuly(nhanvienService.findByUsername("chuagiao"));
		request.setNgaygui(new Date());
		System.out.println(request);
		if (requestService.save(request)) {
			redirectAttribute.addFlashAttribute("msg", "Gui Thanh Cong");
			return "redirect:create";
		} else {
			redirectAttribute.addFlashAttribute("msg", "Gui That Bai");
			return "redirect:create";
		}

	}
	
}
