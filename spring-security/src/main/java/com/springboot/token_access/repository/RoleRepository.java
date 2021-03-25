package com.springboot.token_access.repository;

import java.util.Optional;

import com.springboot.token_access.models.ERole;
import com.springboot.token_access.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
