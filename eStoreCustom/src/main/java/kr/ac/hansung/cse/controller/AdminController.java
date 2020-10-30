package kr.ac.hansung.cse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.cse.model.Product;
import kr.ac.hansung.cse.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProductService productService;

	@RequestMapping
	public String adminPage() {

		return "admin";
	}

	@RequestMapping("/productInventory")
	public String getProducts(Model model) {
		List<Product> products = productService.getProducts();

		model.addAttribute("products", products);

		return "productInventory"; // view's logical name
	}

	@RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.GET)
	public String addProduct(Model model) {

		Product product = new Product();

		product.setCategory("컴퓨터");

		model.addAttribute("product", product);

		return "addProduct";
	}

	// web form data -> object(filled with form data)
	@RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.POST)
	public String addProductPost(@Valid Product product, BindingResult result) { // controller -> service -> dao

		if (result.hasErrors()) {
			System.out.println("==== Web Form data has some errors ===");
			List<ObjectError> errors = result.getAllErrors();

			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}

			return "addProduct";
		}

		productService.addProduct(product);
		System.out.println("Adding Product cannot be done");

		return "redirect:/admin/productInventory";
	}

	// web form data -> object(filled with form data)
	@RequestMapping(value = "/productInventory/deleteProduct/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable int id) { // controller -> service -> dao

		Product product = productService.getProductById(id);

		productService.deleteProduct(product);
		System.out.println("Delete Product cannot be done");

		return "redirect:/admin/productInventory";
	}

	// web form data -> object(filled with form data)
	@RequestMapping(value = "/productInventory/updateProduct/{id}", method = RequestMethod.GET)
	public String updateProduct(@PathVariable int id, Model model) { // controller -> service -> dao

		Product product = productService.getProductById(id);

		model.addAttribute("product", product);

		return "updateProduct";
	}

	// web form data -> object(filled with form data)
	@RequestMapping(value = "/productInventory/updateProduct", method = RequestMethod.POST)
	public String updateProductPost(@Valid Product product, BindingResult result) { // controller -> service -> dao

		if (result.hasErrors()) {
			System.out.println("==== Web Form data has some errors ===");
			List<ObjectError> errors = result.getAllErrors();

			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}

			return "updateProduct";
		}

		productService.updateProduct(product);
		System.out.println("Updating Product cannot be done");

		return "redirect:/admin/productInventory";
	}
}
