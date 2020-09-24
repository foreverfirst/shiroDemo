package com.lc.mongo.service;

import com.lc.mongo.entity.UserEntity;

/**
 * @author liu_chen
 */
public interface LoginService {

    UserEntity getUserByName(String getMapByName);
}
