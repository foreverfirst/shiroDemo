package com.lc.mongo.service.impl;



import com.lc.mongo.entity.PermissionsEntity;
import com.lc.mongo.entity.RoleEntity;
import com.lc.mongo.entity.UserEntity;
import com.lc.mongo.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public UserEntity getUserByName(String getMapByName) {
        return getMapByName(getMapByName);
    }

    /**
     * 模拟数据库查询
     *
     * @param userName 用户名
     * @return UserEntity
     */
    private UserEntity getMapByName(String userName) {
        //查询和添加的权限
        PermissionsEntity permissions1 = new PermissionsEntity("1", "query");
        PermissionsEntity permissions2 = new PermissionsEntity("2", "add");
        //创建管理员角色
        Set<PermissionsEntity> adminPermissions = new HashSet<>();
        adminPermissions.add(permissions1);
        adminPermissions.add(permissions2);
        RoleEntity adminRole = new RoleEntity("1", "admin", adminPermissions);
        //创建普通用户角色
        Set<PermissionsEntity> userPermissions = new HashSet<>();
        userPermissions.add(permissions1);
        RoleEntity userRole = new RoleEntity("2", "user", userPermissions);

        Set<RoleEntity> roleSet = new HashSet<>();
        roleSet.add(adminRole);
        UserEntity user = new UserEntity("1", "lc", "123456", roleSet);
        Map<String, UserEntity> map = new HashMap<>();
        map.put(user.getUserName(), user);

        Set<RoleEntity> roleSet1 = new HashSet<>();
        roleSet1.add(userRole);
        UserEntity user1 = new UserEntity("2", "aa", "123456", roleSet1);
        map.put(user1.getUserName(), user1);

        Set<RoleEntity> roleSet2 = new HashSet<>();
        roleSet1.add(userRole);
        UserEntity user2 = new UserEntity("3", "bb", "123456", roleSet1);
        map.put(user2.getUserName(), user2);

        return map.get(userName);
    }
}

