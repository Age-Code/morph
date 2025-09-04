package org.example.morph.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import lombok.Setter;
import org.example.morph.dto.AnonCommentDto;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class AnonComment extends AuditingFields{

    Long createUserId;
    Long postId;
    String content;

    protected AnonComment() {}
    private AnonComment(Long createUserId, Long postId, String content) {
        this.createUserId = createUserId;
        this.postId = postId;
        this.content = content;
    }
    public static AnonComment of(Long createUserId, Long postId, String content) {
        return new AnonComment(createUserId, postId, content);
    }

    public AnonCommentDto.CreateResDto toCreateResDto() {
        return AnonCommentDto.CreateResDto.builder().id(getId()).build();
    }
}
