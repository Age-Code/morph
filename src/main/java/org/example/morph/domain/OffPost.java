package org.example.morph.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import lombok.Setter;
import org.example.morph.dto.OffPostDto;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class OffPost extends AuditingFields{

    Long createUserId;
    String content;

    protected OffPost() {}
    private OffPost(Long createUserId, String content) {
        this.createUserId = createUserId;
        this.content = content;
    }
    public static OffPost of(Long createUserId, String content) {
        return new OffPost(createUserId, content);
    }

    public OffPostDto.CreateResDto toCreateResDto() {
        return OffPostDto.CreateResDto.builder().id(getId()).build();
    }
}
