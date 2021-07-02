package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.service.InitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("init")
@AllArgsConstructor
public class InitController {

    private final InitService initService;

    @PostMapping()
    public void initProducts() {
        initService.initProducts();
    }
}
