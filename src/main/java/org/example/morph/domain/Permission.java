package org.example.morph.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.morph.dto.PermissionDto;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Table(
      indexes = {
              @Index(columnList = "roleId"),
              @Index(columnList = "permissionId"),
              @Index(columnList = "func")
      }
      ,uniqueConstraints = {
              @UniqueConstraint(
                      name = "UQ_permission_permissionId_roleId_func",
                      columnNames = {"roleId", "permission", "func"}
              )
      }
)
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Permission extends AuditingFields{

    Long roleId;
    String permission;
    Integer func;

    protected Permission() {}
    private Permission(Long roleId, String permission, Integer func) {
        this.roleId = roleId;
        this.permission = permission;
        this.func = func;
    }
    public static Permission of(Long roleId, String permission, Integer func) {
        return new Permission(roleId, permission, func);
    }

    public PermissionDto.ToggleResDto toToggleResDto() {return PermissionDto.ToggleResDto.builder().id(getId()).build();}
}
