package org.example.morph.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import lombok.Setter;
import org.example.morph.dto.AnonPostDto;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class AnonPost extends AuditingFields{

    Long createUserId;
    String content;

    protected AnonPost() {}
    private AnonPost(Long createUserId, String content) {
        this.createUserId = createUserId;
        this.content = content;
    }
    public static AnonPost of(Long createUserId, String content) {
        return new AnonPost(createUserId, content);
    }

    public AnonPostDto.CreateResDto toCreateResDto() {
        return AnonPostDto.CreateResDto.builder().id(getId()).build();
    }
}
