package org.nuptpig.funduserbackend.controller;

import org.nuptpig.funduserbackend.entity.Users;
import org.nuptpig.funduserbackend.service.UserService;
import org.nuptpig.funduserbackend.util.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity Login(@RequestParam("user_name") String userName,
                                @RequestParam("password") String password){
        Users loginUser = userService.getUserByUserName(userName);
        if (loginUser.getPassword().equals(password)){
            return CommonResponse.ok(HttpStatus.OK);
        }
        return CommonResponse.fail(HttpStatus.UNAUTHORIZED);
    }
}
