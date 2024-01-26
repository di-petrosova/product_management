package org.application.service;

import org.application.model.ProductModel;

import java.util.List;

public interface ProductService {
    List<ProductModel> getAllProducts();

    ProductModel getProductById(int id);

    void deleteProduct(int id);

    void saveProduct(ProductModel productModel);
}
