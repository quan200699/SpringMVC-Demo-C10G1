package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
//    public ModelAndView getAll(@PageableDefault(size = 15) Pageable pageable) {
    public ModelAndView getAll(@RequestParam("search") Optional<String> name) {
//        Page<Product> products = productService.findALl(pageable);
        List<Product> products;
        if (name.isPresent()) {
            products = productService.findProductName(name.get());
        } else {
            products = productService.findALl();
        }
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }
}
