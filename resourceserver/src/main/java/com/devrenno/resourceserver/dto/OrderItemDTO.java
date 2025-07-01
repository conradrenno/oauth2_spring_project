package com.devrenno.resourceserver.dto;

import com.devrenno.resourceserver.entities.OrderItem;

public class OrderItemDTO {

    private Long productId;
    private String name;
    private Integer quantity;
    private Double price;
    private String imgUrl;

    public OrderItemDTO(Long productId, String name, Integer quantity, Double price, String imgUrl) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public OrderItemDTO() {}

    public OrderItemDTO(OrderItem orderItem) {
        productId = orderItem.getProduct().getId();
        name = orderItem.getProduct().getName();
        quantity = orderItem.getQuantity();
        price = orderItem.getPrice();
        imgUrl = orderItem.getProduct().getImgUrl();
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Double getSubTotal() {
        return price * quantity;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
