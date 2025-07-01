package com.devrenno.resourceserver.repositories;

import com.devrenno.resourceserver.entities.OrderItem;
import com.devrenno.resourceserver.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {


}
