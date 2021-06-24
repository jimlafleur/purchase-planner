package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("init")
public class InitController {

    @Autowired
    InitService initService;

    @PostMapping()
    public void initProducts(){
        initService.initProducts();
    }
}
