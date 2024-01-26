package org.application.model;

import jakarta.persistence.*;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

@Entity
@Table(name = "products")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="product_id", nullable = false, unique = true)
    private Integer product_id;

    @NotNull(message = "product name is empty")
    @NotEmpty(message = "product name is empty")
    @Length(message = "product name is too long.", max = 255)
    @Column(name = "product_name")
    private String product_name;

    @NotNull(message = "product description is empty")
    @NotEmpty(message = "product description is empty")
    @Column(name = "product_description")
    private String product_description;

    @NotNull(message = "product price is empty")
    @NotEmpty(message = "product price is empty")
    @Column(name = "product_price")
    private String product_price;

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public ProductModel() {
        super();
    }

    public ProductModel(Integer product_id, String product_name, String product_description, String product_price) {
        super();
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_price = product_price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_description='" + product_description + '\'' +
                ", product_price='" + product_price + '\'' +
                '}';
    }
}
