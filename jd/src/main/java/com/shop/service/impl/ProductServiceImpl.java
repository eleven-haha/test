package com.shop.service.impl;

import com.shop.dao.ProductMapper;
import com.shop.domain.Product;
import com.shop.domain.ProductExample;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    public List<Product> getProductList() {
        List<Product> productList = productMapper.selectByExample(null);
        return productList;

    }

    public Product getProductById(Integer id) {
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }

    public void updateProduct(Product product) {
        productMapper.updateByPrimaryKeySelective(product);

    }
}
