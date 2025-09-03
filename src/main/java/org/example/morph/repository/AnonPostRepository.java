package org.example.morph.repository;

import org.example.morph.domain.AnonPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnonPostRepository extends JpaRepository<AnonPost, Long> {
}
