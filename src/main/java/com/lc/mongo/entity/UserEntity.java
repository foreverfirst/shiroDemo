package com.lc.mongo.entity;

import lombok.Data;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
public class UserEntity {

    @Id
    private String id;
    private String userName;
    private String password;
    private String salt;

    public UserEntity(String id, String userName, String password, Set<RoleEntity> roles) {
        this.id = id;
        this.userName = userName;
        //生成盐
        this.salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        //MD5加密
        this.password = new SimpleHash("MD5",password,salt).toString();
        this.roles = roles;
    }

    /**
     * 用户对应的角色集合
     */
    private Set<RoleEntity> roles;


}
