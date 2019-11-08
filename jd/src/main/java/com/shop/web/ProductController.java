package com.shop.web;

import com.shop.domain.CustomerVo;
import com.shop.domain.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product")
    public ModelAndView getProducts()
    {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productService.getProductList();
        modelAndView.addObject("productList",productList);
        modelAndView.setViewName("productList");
        return modelAndView;
    }

    @RequestMapping(value = "/itemEdit.action")
    public ModelAndView editProduct(HttpServletRequest request,
                                    HttpServletResponse response, HttpSession session)
    {
        String id = request.getParameter("id");
        Product product = productService.getProductById(Integer.parseInt(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("item",product);
        modelAndView.setViewName("productItem");
        return modelAndView;
    }

    @RequestMapping(value = "/updateitem.action")
    public String submitProduct(Integer id,String name,float price,String detail)
    {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setDetail(detail);
        productService.updateProduct(product);
        return "forward:/product";
    }

    @RequestMapping(value = "/queryitem.action")
    public void selectProduct(CustomerVo customerVo)
    {
        System.out.println(customerVo.getProduct().getName());
    }
}
