package com.devrenno.resourceserver.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

//    @Autowired
//    private UserService userService;
//
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
//    @GetMapping(value = "/me")
//    public ResponseEntity<UserDTO> getMe() {
//       UserDTO userDTO = userService.getMe();
//        return ResponseEntity.ok(userDTO);
//    }

}
