package com.lc.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
@AllArgsConstructor
public class RoleEntity {

    @Id
    private String id;
    private String roleName;
    /**
     * 角色对应权限集合
     */
    private Set<PermissionsEntity> permissions;

}


