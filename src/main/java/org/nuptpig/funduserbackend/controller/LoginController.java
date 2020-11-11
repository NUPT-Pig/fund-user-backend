package org.nuptpig.funduserbackend.controller;

import org.nuptpig.funduserbackend.util.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
    @GetMapping(name = "")
    public String Login(){
        return "successlogi";
    }
}
