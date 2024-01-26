package org.application.controller;

import org.application.model.ProductModel;
import org.application.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        System.out.println("productService");
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView getProducts(Model model) {
        List<ProductModel> allProducts = productService.getAllProducts();
        model.addAttribute("products", allProducts);
        return new ModelAndView("product-list");
    }

    @GetMapping("/add_product")
    public ModelAndView getCreationPage(Model model) {
        model.addAttribute("productModel", new ProductModel());
        return new ModelAndView("create-product");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditingPage(@PathVariable int id, final Model model) {
        ProductModel productModel = productService.getProductById(id);
        model.addAttribute("productModel", productModel);
        return new ModelAndView("edit-product");
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ModelAndView("redirect:/products");
    }

    @PostMapping("add_product")
    public ModelAndView addProduct(@ModelAttribute("product") ProductModel productModel) {
        productService.saveProduct(productModel);
        return new ModelAndView("redirect:/products");
    }

    @PostMapping("edit/{id}")
    public ModelAndView editProduct(@ModelAttribute("product") ProductModel productModel) {
        productService.saveProduct(productModel);
        return new ModelAndView("redirect:/products");
    }

}
