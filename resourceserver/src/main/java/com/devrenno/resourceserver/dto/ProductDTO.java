package com.devrenno.resourceserver.dto;

import com.devrenno.resourceserver.entities.Category;
import com.devrenno.resourceserver.entities.Product;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

    private Long id;

    @Size(min = 3, max = 80, message = "Must be at least 3 characters and max of 80 characters long")
    @NotBlank(message = "Required field")
    private String name;

    @Size(min = 10, message = "Must be at least 10 characters long")
    @NotBlank(message = "Required field")
    private String description;

    @NotNull(message = "Required field")
    @Positive(message = "Price must be positive")
    private Double price;
    private String imgUrl;


    @NotEmpty(message = "At least one category is required")
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(){

    }

    public ProductDTO(Long id, String name, Double price, String description, String imgUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        description = product.getDescription();
        imgUrl = product.getImgUrl();
        for (Category cat : product.getCategories()) {
            categories.add(new CategoryDTO(cat));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
