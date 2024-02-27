package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.UserRoles;

public interface UserRolesRepo extends JpaRepository<UserRoles, Long>{

}
