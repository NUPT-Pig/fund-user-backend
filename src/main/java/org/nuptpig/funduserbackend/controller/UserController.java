package org.nuptpig.funduserbackend.controller;

import org.nuptpig.funduserbackend.service.UserService;
import org.nuptpig.funduserbackend.util.CommonResponse;
import org.nuptpig.funduserbackend.util.CommonResult;
import org.nuptpig.funduserbackend.util.ResultCode;
import org.nuptpig.funduserbackend.vo.UserCreateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "")
    public ResponseEntity addUsers(@RequestBody UserCreateRequest userCreateRequest){
        userService.addUser(userCreateRequest);
        return CommonResponse.ok(HttpStatus.CREATED);
    }
}
