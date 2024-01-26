package org.application.dao;

import org.application.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsDAO extends JpaRepository<ProductModel, Integer> {
}
