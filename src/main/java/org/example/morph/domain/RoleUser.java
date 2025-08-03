package org.example.morph.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.morph.dto.RoleUserDto;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Table(
      indexes = {
              @Index(columnList = "deleted"),
              @Index(columnList = "roleId"),
              @Index(columnList = "userId")
      }
      ,uniqueConstraints = {
              @UniqueConstraint(
                      name = "UQ_roleUser_roleId_userId_",
                      columnNames = {"roleId", "userId"}
              )
      }
)
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class RoleUser extends AuditingFields{

    Long roleId;
    Long userId;

    protected RoleUser() {}
    private RoleUser(Long roleId, Long userId) {
        this.roleId = roleId;
        this.userId = userId;
    }
    public static RoleUser of(Long roleId, Long userId) {
        return new RoleUser(roleId, userId);
    }

    public RoleUserDto.AddResDto toAddResDto() {return RoleUserDto.AddResDto.builder().id(getId()).build();}
}
