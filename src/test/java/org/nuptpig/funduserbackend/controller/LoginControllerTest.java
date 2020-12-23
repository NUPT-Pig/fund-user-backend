package org.nuptpig.funduserbackend.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nuptpig.funduserbackend.FundUserBackendApplicationTests;
import org.nuptpig.funduserbackend.util.JWTHelper;
import org.nuptpig.funduserbackend.vo.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest extends FundUserBackendApplicationTests {
    @Autowired
    private LoginController loginController;

    @Test
    void login() {
        String userName = "admin";
        String password = "21232f297a57a5a743894a0e4a801fc3";
        ResponseEntity responseEntity = loginController.Login(userName, password);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        LoginResponse loginResponse = getVo(responseEntity);
        Assertions.assertEquals(userName, JWTHelper.getUsername(loginResponse.getToken()));
    }
}