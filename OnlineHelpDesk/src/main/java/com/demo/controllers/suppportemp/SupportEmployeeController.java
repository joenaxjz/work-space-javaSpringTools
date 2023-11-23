package com.demo.controllers.suppportemp;

import java.text.SimpleDateFormat;
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
@RequestMapping({ "supportemployee" }) // multi-link
public class SupportEmployeeController {

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
	
	@RequestMapping(value = { "profile/index/{username}" }, method = RequestMethod.GET)
	public String profile(Authentication authentication, HttpSession session, ModelMap modelMap, @PathVariable("username") String username) {
		modelMap.put("nhanvien", nhanvienService.findByUsername(authentication.getName()));
		modelMap.put("roles", roleService.findAll());
		return "supportemployee/profile/index";
	}
	
	@RequestMapping(value = { "profile/index" }, method = RequestMethod.POST)
	public String profile(@ModelAttribute("nhanvien") Nhanvien nhanvien, Authentication authentication,
			RedirectAttributes redirectAttribute) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Nhanvien currentAccount = nhanvienService.findByUsername(authentication.getName());
		currentAccount.setHoten(nhanvien.getHoten());
		currentAccount.setKichhoat(nhanvien.getKichhoat());
		currentAccount.setNgaysinh(nhanvien.getNgaysinh());
		currentAccount.setHinhanh(nhanvien.getHinhanh());
		if (nhanvienService.save(currentAccount)) {
			redirectAttribute.addFlashAttribute("msg", "Updated");
			return "redirect:/supportemployee/dashboard";
		} else {
			redirectAttribute.addFlashAttribute("msg", "Failed");
			return "redirect:/supportemployee/dashboard";
		}
	}
	
	@GetMapping({ "requestList/index/{username}"})
	public String requestsList(Authentication authentication, HttpSession session, ModelMap modelMap) {
		modelMap.put("requests", requestService.findByNhanvienXuly(authentication.getName()));
		return "supportemployee/requestList/index";
	}
	
}
