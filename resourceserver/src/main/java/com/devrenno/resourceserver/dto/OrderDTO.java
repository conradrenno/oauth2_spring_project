package com.devrenno.resourceserver.dto;

import com.devrenno.resourceserver.entities.Order;
import com.devrenno.resourceserver.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus status;
    private ClientMinDTO client;
    private PaymentDTO payment;

    @NotEmpty(message = "At least one item is required")
    private List<OrderItemDTO> items = new ArrayList<>();

    public OrderDTO() {}

    public OrderDTO(Order order) {
        id = order.getId();
        moment = order.getMoment();
        status = order.getStatus();
        client = new ClientMinDTO(order.getClient());
        payment = order.getPayment() == null ? null : new PaymentDTO(order.getPayment());
        order.getOrderItems().forEach(item -> items.add(new OrderItemDTO(item)));
    }

    public OrderDTO(Long id, Instant moment, OrderStatus status, ClientMinDTO client, PaymentDTO payment, List<OrderItemDTO> items) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public ClientMinDTO getClient() {
        return client;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public Double getTotal() {
        double sum = 0.0;
        for (OrderItemDTO item : items) {
            sum += item.getSubTotal();
        }
        return sum;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDTO orderDTO)) return false;

        return Objects.equals(id, orderDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
