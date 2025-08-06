package org.example.morph.repository;

import org.example.morph.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Optional<Permission> findByRoleIdAndPermissionAndFunc(Long roleId, String permission, Integer func);
}
