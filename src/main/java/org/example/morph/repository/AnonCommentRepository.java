package org.example.morph.repository;

import org.example.morph.domain.AnonComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnonCommentRepository extends JpaRepository<AnonComment, Long> {
}
