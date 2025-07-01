package com.devrenno.resourceserver.services;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

//    @Autowired
//    private OrderRepository repository;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private OrderItemRepository orderItemRepository;
//
//    @Autowired
//    private AuthService authService;
//
//    @Transactional(readOnly = true)
//    public OrderDTO findByid(Long id){
//        Order order = repository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("Recurso não encontrado"));
//        authService.validateSelfOrAdmin(order.getClient().getId());
//        return new OrderDTO(order);
//    }
//
//    @Transactional
//    public OrderDTO insert(OrderDTO dto){
//        Order order = new Order();
//        order.setMoment(Instant.now());
//        order.setStatus(OrderStatus.WAITING_PAYMENT);
//
//        String username = dto.getClient().getName();
//        User user = userService.loadUserByUsername(username);
//        order.setClient(user);
//
//        for (OrderItemDTO itemDTO : dto.getItems()) {
//            Product product = productRepository.getReferenceById(itemDTO.getProductId());
//            OrderItem orderItem = new OrderItem(order, product, itemDTO.getQuantity(), product.getPrice());
//            order.getOrderItems().add(orderItem);
//        }
//
//        order = repository.save(order);
//        orderItemRepository.saveAll(order.getOrderItems());
//        return new OrderDTO(order);
//    }
}
