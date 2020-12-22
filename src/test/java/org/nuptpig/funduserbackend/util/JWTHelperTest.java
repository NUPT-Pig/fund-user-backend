package org.nuptpig.funduserbackend.util;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JWTHelperTest {

    private String userName = "test";
    private String secret = "secret";
    private static String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDg2NDU2NjksInVzZXJuYW1lIjoidGVzdCJ9.ZCQMYZlh-TN14diC8X9Fe6mwig_vUOed76QC3D9er3Q";

    @Test
    @Order(1)
    void sign() {
        System.out.println("sign---------------");
        token = JWTHelper.sign(userName, secret);
        System.out.println(token);
    }

    @Test
    @Order(2)
    void verify() {
        System.out.println("verify---------------");
        System.out.println(token);
        Boolean result = JWTHelper.verify(token, userName, secret);
        Assertions.assertEquals(result, true);
    }

    @Test
    @Order(3)
    void getUsername() {
        String testUserName = JWTHelper.getUsername(token);
        System.out.println(testUserName);
        Assertions.assertEquals(testUserName, userName);
    }
}