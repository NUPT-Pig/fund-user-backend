package org.nuptpig.funduserbackend.controller;

import org.nuptpig.funduserbackend.entity.Users;
import org.nuptpig.funduserbackend.service.UserService;
import org.nuptpig.funduserbackend.util.HashHelper;
import org.nuptpig.funduserbackend.util.CommonResponse;
import org.nuptpig.funduserbackend.util.JWTHelper;
import org.nuptpig.funduserbackend.vo.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity Login(@RequestParam("user_name") String userName,
                                @RequestParam("password") String password) {
        Users loginUser = userService.getUserByUserName(userName);
        String checkPassword = HashHelper.sha512Hash(password, loginUser.getSalt());
        if (loginUser.getPassword().equals(checkPassword)){
            String token = JWTHelper.sign(userName, loginUser.getSalt());
            return CommonResponse.ok(new LoginResponse(token));
        }
        return CommonResponse.fail(HttpStatus.UNAUTHORIZED);
    }
}
