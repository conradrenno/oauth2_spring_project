package com.devrenno.resourceserver.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

//    @Autowired
//    private OrderService orderService;
//
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
//        OrderDTO orderDTO = orderService.findByid(id);
//        return ResponseEntity.ok(orderDTO);
//    }
//
//    @PreAuthorize("hasAnyRole('ROLE_USER')")
//    @PostMapping
//    public ResponseEntity<OrderDTO>  insert(@Valid @RequestBody OrderDTO orderDTO) {
//        orderDTO = orderService.insert(orderDTO);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(orderDTO.getId()).toUri();
//        return ResponseEntity.created(uri).body(orderDTO);
//    }

}
