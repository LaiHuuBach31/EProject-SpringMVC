package com.springmvc.admin.controllers;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvc.dao.CategoryDAO;
import com.springmvc.dto.category.CreateDTO;
import com.springmvc.model.Category;
	
@Controller
@RequestMapping("/admin/category")
public class CategoryController {

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "")
	public String index(Model model, @RequestParam(name = "keyWord", required = false) String keyWord,
			@RequestParam(name = "pageNo", required = false, defaultValue = "1") String pageNo) {
		int pagesize = 5;
		int count = categoryDAO.count();
		int totalPage = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
		int pageno = pageNo != null ? Integer.parseInt(pageNo) : 1;	
		List<Category> list = categoryDAO.pading(pageno, pagesize);
		if(keyWord != null) {
			count = categoryDAO.countCategory(keyWord);
			totalPage = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
			list = categoryDAO.searchCategory(keyWord, pageno, pagesize);
		}
		model.addAttribute("list", list);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("count", count);
		return "admin/category/index";
	}

	@GetMapping(value = "/addCategory")
	public String add(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "admin/category/add";
	}

	@PostMapping(value = "/insertCategory")
	public String insert(@Valid @ModelAttribute("category") CreateDTO category, BindingResult result, Model model,
			RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			model.addAttribute("category", category);
			return "admin/category/add";
//			return "redirect:/category/addCategory";
		} else {
			Category cate = modelMapper.map(category, Category.class);
			boolean check = categoryDAO.create(cate);
			if (check) {
				redirectAttrs.addFlashAttribute("success", "Add new successfuly");
				return "redirect:/admin/category";
			} else {
				return "admin/category/add";
			}
		}
	}

	@GetMapping(value = "/editCategory/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Category category = categoryDAO.find(id);
		model.addAttribute("category", category);
		return "admin/category/edit";
	}

	@PostMapping(value = "/updateCategory")
	public String update(@Valid @ModelAttribute("category") CreateDTO category, BindingResult result, Model model,
			RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			model.addAttribute("category", category);
			return "admin/category/edit";
		} else {
			Category cate = modelMapper.map(category, Category.class);
			boolean check = categoryDAO.update(cate);
			if (check) {
				redirectAttrs.addFlashAttribute("success", "Update successfuly");
				return "redirect:/admin/category";
			} else {
				return "admin/category/edit";
			}
		}
	}

	@GetMapping("/deleteCategory/{id}")
	public String delete(@PathVariable String id, RedirectAttributes redirectAttrs) {
		if (categoryDAO.delete(Integer.parseInt(id))) {
			redirectAttrs.addFlashAttribute("success", "Delete successfuly");
			return "redirect:/admin/category";
		}

		return "redirect:/admin/category";

	}

}
