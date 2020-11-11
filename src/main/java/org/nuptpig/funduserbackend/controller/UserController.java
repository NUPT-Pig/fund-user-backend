package org.nuptpig.funduserbackend.controller;

import org.nuptpig.funduserbackend.service.UserService;
import org.nuptpig.funduserbackend.util.CommonResponse;
import org.nuptpig.funduserbackend.util.CommonResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "")
    public ResponseEntity getUsers(){
        return CommonResponse.ok(userService.getUsers());
    }
}
