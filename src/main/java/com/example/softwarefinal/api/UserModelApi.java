package com.example.softwarefinal.api;

import com.example.softwarefinal.model.UserModel;
import com.example.softwarefinal.service.impl.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserModelApi {

    private final MyUserService userService;


    @GetMapping
    public String test() {
        return "test";
    }


    @PostMapping("/register")
    public void register(@RequestBody UserModel userModel) {
        userService.register(userModel);
    }
}
