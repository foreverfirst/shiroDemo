package com.lc.mongo.service;

import com.lc.mongo.dao.UserRepository;
import com.lc.mongo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserEntity findUserById(Integer id){
        return userRepository.findById(id).get();
    }

//    public List<UserEntity> findAllByNameLike(String name, Integer age1, Integer age2) {
//
//        return userRepository.findAllByNameLikeAndAgeBetween(name, age1, age2);
//    }

//    public List<UserEntity> findAllByNameIn(List<String> names){
//        return userRepository.findAllByNameIn(names);
//    }

    public List<UserEntity> findAllUser(){
        return userRepository.findAll();
    }

    public UserEntity save(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    public List<UserEntity> save(List<UserEntity> userEntity){
        return userRepository.saveAll(userEntity);
    }

}
