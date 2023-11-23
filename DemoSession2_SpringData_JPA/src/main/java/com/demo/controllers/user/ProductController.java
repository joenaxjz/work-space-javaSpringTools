package com.demo.controllers.user;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.demo.entities.Category;
import com.demo.entities.Product;
import com.demo.helpers.FileHelper;
import com.demo.services.CategoryService;
import com.demo.services.ProductService;

@Controller
@RequestMapping({ "product" }) // multi-link
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private Environment environment;
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("products", productService.findAll());
		return "product/index";
	}
	
	@RequestMapping(value = { "index2" }, method = RequestMethod.GET)
	public String index2(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,ModelMap modelMap) {
		int pageSize = Integer.parseInt(environment.getProperty("pageSize"));
		Page<Product> page = productService.findPagingnation(pageNo, pageSize);
		modelMap.put("currentPage", pageNo);
		modelMap.put("totalPages", page.getTotalPages());
		modelMap.put("totalItems", page.getTotalElements());
		modelMap.put("products", page.getContent());
		return "product/index2";
	}

	@RequestMapping(value = { "add" }, method = RequestMethod.POST)
	public String add(@ModelAttribute("product") Product product, @RequestParam("file") MultipartFile file,
			RedirectAttributesModelMap redirectAttribute) {
		if (file != null && file.getSize() > 0) {
			try {
				File folderImage = new File(new ClassPathResource(".").getFile().getPath() + "/static/images");

				String fileName = FileHelper.generateFileName(file.getOriginalFilename());

				Path path = Paths.get(folderImage.getAbsolutePath() + File.separator + fileName);

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

				product.setPhoto(fileName);
			} catch (Exception e) {
				e.printStackTrace();
				product.setPhoto("noimg.jpg");
			}
		} else {
			product.setPhoto("noimg.jpg");
		}
		if (productService.save(product)) {
			redirectAttribute.addFlashAttribute("msg", "them thanh cong");
		} else {
			redirectAttribute.addFlashAttribute("msg", "them khong thanh cong");
		}

		return "redirect:/product/index";
	}

	@RequestMapping(value = { "add1" }, method = RequestMethod.GET)
	public String add1(ModelMap modelMap) {
		Product product = new Product();
		product.setCreated(new Date());
		modelMap.put("product", product);
		modelMap.put("categories", categoryService.findAll());
		return "product/add";
	}

	@RequestMapping(value = { "edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.put("product", productService.find(id));
		modelMap.put("categories", categoryService.findAll());
		return "product/edit";
	}

	@RequestMapping(value = { "edit1" }, method = RequestMethod.POST)
	public String edit(ModelMap modelMap, @ModelAttribute("product") Product product,
			@RequestParam("file") MultipartFile file, RedirectAttributesModelMap redirectAttribute) {
		if (file != null && file.getSize() > 0) {
			try {
				File folderImage = new File(new ClassPathResource(".").getFile().getPath() + "/static/images");

				String fileName = FileHelper.generateFileName(file.getOriginalFilename());

				Path path = Paths.get(folderImage.getAbsolutePath() + File.separator + fileName);

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

				product.setPhoto(fileName);
			} catch (Exception e) {
				e.printStackTrace();
				product.setPhoto("noimg.jpg");
			}
		}
		if (productService.save(product)) {
			redirectAttribute.addFlashAttribute("msg", "cap nhat thanh cong");
		} else {
			redirectAttribute.addFlashAttribute("msg", "cap nhat khong thanh cong");
		}
		return "redirect:/product/index";
	}

	@RequestMapping(value = { "searchByKeyword" }, method = RequestMethod.GET)
	public String searchByKeyword(@RequestParam("keyword") String keyword, ModelMap modelMap) {
		modelMap.put("products", productService.findByKeyword(keyword));
		modelMap.put("keyword", keyword);
		return "product/index";
	}

	@RequestMapping(value = { "searchByPrices" }, method = RequestMethod.GET)
	public String searchByPrices(@RequestParam("min") double min, @RequestParam("max") double max, ModelMap modelMap) {
		modelMap.put("products", productService.findByPrice(min, max));
		modelMap.put("min", min);
		return "product/index";
	}

}
