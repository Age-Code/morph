package org.example.morph.repository;

import org.example.morph.domain.OffPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffPostRepository extends JpaRepository<OffPost, Long> {
}
