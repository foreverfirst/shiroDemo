package com.lc.mongo.dao;

import com.lc.mongo.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserEntity,Integer> {

//    //    @Query(value = "{\"age\":{$gt:20}")
//    List<UserEntity> findAllByNameLikeAndAgeBetween(String name, Integer age1, Integer age2);
//
//    List<UserEntity> findAllByNameIn(List<String> name);


}
