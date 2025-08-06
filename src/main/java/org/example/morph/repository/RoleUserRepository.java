package org.example.morph.repository;

import org.example.morph.domain.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {
    Optional<RoleUser> findByRoleIdAndUserId(Long roleId, Long userId);
}
