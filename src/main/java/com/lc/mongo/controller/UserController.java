package com.lc.mongo.controller;

import com.lc.mongo.entity.UserEntity;
import com.lc.mongo.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequiresPermissions("query")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    UserEntity findUserById(@PathVariable Integer id){
        return userService.findUserById(id);
    }

    @GetMapping
    List<UserEntity> findAllUser(){
        return userService.findAllUser();
    }

//    @GetMapping("/name/{name}/{age1}/{age2}")
//    List<UserEntity> findAllByNameLike(@PathVariable String name,
//                                       @PathVariable Integer age1,
//                                       @PathVariable Integer age2){
//        return userService.findAllByNameLike(name, age1, age2);
//    }

//    @PostMapping("/name")
//    List<UserEntity> findAllByNameIn(@RequestBody List<String> names){
//        return userService.findAllByNameIn(names);
//    }

    @PostMapping("/adduser")
    UserEntity addUser(@RequestBody UserEntity userEntity){
        return userService.save(userEntity);
    }

    @PostMapping("/addusers")
    List<UserEntity> addUsers(@RequestBody List<UserEntity> userEntity){
        return userService.save(userEntity);
    }

}
