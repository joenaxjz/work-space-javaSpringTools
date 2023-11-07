package com.demo.controllers.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.Invoice;
import com.demo.entities.InvoiceDetails;
import com.demo.entities.InvoiceDetailsId;
import com.demo.entities.Item;
import com.demo.entities.Product;
import com.demo.services.AccountService;
import com.demo.services.CartService;
import com.demo.services.InvoiceDetailService;
import com.demo.services.InvoiceService;
import com.demo.services.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "cart" }) // multi-link
public class CartController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CartService cartService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private InvoiceDetailService invoiceDetailsService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String login(ModelMap modelMap, HttpSession session) {
		if (session.getAttribute("cart") != null) {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			modelMap.put("cart", cart);
			modelMap.put("total", cartService.total(cart));
		}
		return "cart/index";
	}

	@RequestMapping(value = { "addToCart/{id}" }, method = RequestMethod.GET)
	public String addToCart(@PathVariable("id") int id, HttpSession session) {
		Product product = productService.find(id);
		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<>();
			cart.add(new Item(product, 1));
			session.setAttribute("cart", cart);
		} else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = cartService.exist(id, cart);
			if (index == -1) {
				cart.add(new Item(product, 1));
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cart);
		}
		return "redirect:/cart/index";
	}

	@RequestMapping(value = { "remove/{id}" }, method = RequestMethod.GET)
	public String remove(@PathVariable("id") int index, HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "redirect:/cart/index";
	}
	
	@RequestMapping(value = { "update" }, method = RequestMethod.POST)
	public String update(@RequestParam("quantities") int quantities[], HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		for(int i = 0; i < cart.size(); i++) {
			cart.get(i).setQuantity(quantities[i]);
		}
		session.setAttribute("cart", cart);
		return "redirect:/cart/index";
	}

	@RequestMapping(value = { "checkout" }, method = RequestMethod.GET)
	public String checkout(HttpSession session) {
		if (session.getAttribute("username") == null) {
			return "redirect:/account/login";
		} else {
			String username = session.getAttribute("username").toString();
			//lưu hóa đơn
				Invoice invoice = new Invoice();
				invoice.setAccount(accountService.findByUsername(username));
				invoice.setCreated(new Date());
				invoice.setName("name");
				invoice.setPayment("cash");
				invoice.setStatus("new");
				invoice = invoiceService.save(invoice);
			//lưu chi tiết
				List<Item> cart = (List<Item>) session.getAttribute("cart");
				for(Item item : cart ) {
					InvoiceDetails invoiceDetails = new InvoiceDetails();
					invoiceDetails.setId(new InvoiceDetailsId(invoice.getId(), item.getProduct().getId()));
					invoiceDetails.setQuantity(item.getQuantity());
					invoiceDetails.setPrice(item.getProduct().getPrice());
					invoiceDetailsService.save(invoiceDetails);
				}
			///xóa giỏ hàng
			session.removeAttribute("cart");
			return "redirect:/account/history";
		}
		
	}
}
