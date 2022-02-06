package com.wzy.security.order.controller;

import com.wzy.security.order.model.UserDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @GetMapping(value = "/r1")
    @PreAuthorize("hasAnyAuthority('p1')")
    public String r1() {
        //UserDTO principal = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDTO  userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDTO.getUsername() + "访问资源1";
    }
}