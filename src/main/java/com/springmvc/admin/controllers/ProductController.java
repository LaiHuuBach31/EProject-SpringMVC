package com.springmvc.admin.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvc.dao.CategoryDAO;
import com.springmvc.dao.ProductDAO;
import com.springmvc.dto.product.CreateDTO;
import com.springmvc.dto.product.UpdateDTO;
import com.springmvc.model.Category;
import com.springmvc.model.Product;

@Controller
@RequestMapping(value = "/admin/product")
public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "")
	public String index(Model model, @RequestParam(name = "keyWord", required = false) String keyWord,
			 @RequestParam(name = "pageNo", required = false) String pageNo) {
		int pagesize = 10	;
		int count = productDAO.count();
		int totalPage = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
		int pageno = pageNo != null ? Integer.parseInt(pageNo) : 1;	
		List<Product> list = productDAO.pading(pageno, pagesize);
		if(keyWord != null) {
			count = productDAO.countProduct(keyWord);
			totalPage = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
			list = productDAO.searchProduct(keyWord, pageno, pagesize);
		}
		model.addAttribute("list", list);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("count", count);
		return "admin/product/index";	
	}

	@GetMapping(value = "/addProduct")
	public String add(Model model) {
		List<Category> listCategory = categoryDAO.getAll();
		Product product = new Product();
		model.addAttribute("listCategory", listCategory);
		model.addAttribute("product", product);
		return "admin/product/add";
	}

	@PostMapping(value = "/insertProduct")
	public String insert(@Valid @ModelAttribute("product") CreateDTO product, BindingResult result, Model model,
			HttpServletRequest request, RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			List<Category> listCategory = categoryDAO.getAll();
			model.addAttribute("listCategory", listCategory);
			model.addAttribute("product", product);
			return "admin/product/add";
		} else {
			String path = request.getServletContext().getRealPath("uploads/images");
			File f = new File(path);
			String fileName = product.getImage().getOriginalFilename();
			File destination = new File(f.getAbsolutePath() + "/" + fileName);
			System.out.println(destination);
			try {
				if (!destination.exists()) {
					Files.write(destination.toPath(), product.getImage().getBytes(), StandardOpenOption.CREATE);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Product productCreate = modelMapper.map(product, Product.class);

			productCreate.setImage(product.getImage().getOriginalFilename());

			if (productDAO.create(productCreate)) {
				return "redirect:/admin/product";
			} else {
				return "redirect:/admin/addProduct";
			}
		}
	}
	
	@GetMapping(value = "/editProduct/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Product product = productDAO.find(id);
		List<Category> listCategory = categoryDAO.getAll();
		model.addAttribute("product", product);
		model.addAttribute("listCategory",listCategory);
		return "admin/product/edit";
	}
	
	@PostMapping(value = "/updateProduct")
	public String update(@Valid @ModelAttribute("product") UpdateDTO product, BindingResult result, Model model,
			HttpServletRequest request, RedirectAttributes redirectAttrs) {
		if(result.hasErrors()) {
			List<Category> listCategory = categoryDAO.getAll();
			model.addAttribute("product", product);
			model.addAttribute("listCategory",listCategory);
			return "admin/product/edit";
		} else {
			 Product productUpdate = modelMapper.map(product, Product.class);
			 MultipartFile newImage = product.getImage();
			 if(newImage != null && !newImage.isEmpty()) {
				 String path = request.getServletContext().getRealPath("uploads/images");
		            File f = new File(path);
		            String fileName = newImage.getOriginalFilename();
		            File destination = new File(f.getAbsolutePath() + "/" + fileName);
		            try {
		                if (!destination.exists()) {
		                    Files.write(destination.toPath(), newImage.getBytes(), StandardOpenOption.CREATE);
		                }
		                productUpdate.setImage(newImage.getOriginalFilename());
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
			 } else {
				 Product currentProduct = productDAO.find(product.getProductId());
				 productUpdate.setImage(currentProduct.getImage());
			 }
		    

			if (productDAO.update(productUpdate)) {
				return "redirect:/admin/product";
			} else {
				return "redirect:/admin/product";
			}
		}
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String delete(@PathVariable String id,RedirectAttributes redirectAttrs) {
		
		if(productDAO.delete(Integer.parseInt(id))) {
			redirectAttrs.addFlashAttribute("success", "Delete successfuly");
			return "redirect:/admin/product";
		}
		return "redirect:/admin/product";
	}
}
