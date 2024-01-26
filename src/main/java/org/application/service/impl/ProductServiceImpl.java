package org.application.service.impl;

import org.application.dao.ProductsDAO;
import org.application.model.ProductModel;
import org.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductsDAO productsDAO;

    public ProductServiceImpl(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    @Override
    public List<ProductModel> getAllProducts() {
        return productsDAO.findAll();
    }

    @Override
    public ProductModel getProductById(int id) {
        return productsDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(int id) {
        productsDAO.deleteById(id);
    }

    @Override
    public void saveProduct(ProductModel productModel) {
        productsDAO.save(productModel);
    }
}
