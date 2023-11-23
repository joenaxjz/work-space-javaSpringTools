package com.demo.controllers.admin;

import java.text.SimpleDateFormat;
import java.util.*;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.demo.entities.Nhanvien;
import com.demo.entities.Yeucau;
import com.demo.services.AccountService;
import com.demo.services.QuyenService;
import com.demo.services.RequestService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "requestEmployee" }) // multi-link
public class EmployeeRequestController {
	
	@Autowired
	private RequestService requestService;

	@Autowired
	private AccountService nhanvienService;

	@RequestMapping(value = { "list/{username}" }, method = RequestMethod.GET)
	public String list(ModelMap modelMap, @PathVariable("username") String username) {
		modelMap.put("requests", requestService.findByUsername(username));
		return "requestEmployee/list";
	}

	@RequestMapping(value = { "edit/{mayeucau}" }, method = RequestMethod.GET)
	public String edit(ModelMap modelMap, @PathVariable("mayeucau") int mayeucau) {
		modelMap.put("request", requestService.findById(mayeucau));
		modelMap.put("nhanviens", nhanvienService.findSupportEmp());
		return "requestEmployee/edit";
	}
	
	@RequestMapping(value = { "searchByDouutien" }, method = RequestMethod.GET)
	public String searchByDouutien(@RequestParam("madouutien") int madouutien, ModelMap modelMap) {
		modelMap.put("requests", requestService.findByDouutien(madouutien));
		return "admin/requests/index";
	}
	
	@RequestMapping(value = { "searchByDates" }, method = RequestMethod.GET)
	public String searchByPrices(@RequestParam("from") Date from, @RequestParam("to") Date to, ModelMap modelMap) {
		modelMap.put("requests", requestService.findByDates(from, to));
		modelMap.put("from", from);
		modelMap.put("to", to);
		return "admin/requests/index";
	}
	
	@RequestMapping(value = { "edit" }, method = RequestMethod.POST)
	public String edit(ModelMap modelMap, @ModelAttribute("request") Yeucau request, RedirectAttributesModelMap redirectAttribute) {
		Yeucau currentRequest = requestService.findById(request.getMayeucau());
		request.setNgaygui(currentRequest.getNgaygui());
		if(requestService.save(request)) {
			redirectAttribute.addFlashAttribute("msg", "cap nhat thanh cong");
		} else {
			redirectAttribute.addFlashAttribute("msg", "cap nhat khong thanh cong");
		}
		return "redirect:/admin/requests/index";
		
	}
	

	
}
